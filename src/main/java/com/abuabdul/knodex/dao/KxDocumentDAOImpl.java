package com.abuabdul.knodex.dao;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.abuabdul.knodex.domain.KnodexDoc;

@Repository
public class KxDocumentDAOImpl implements KxDocumentDAO<KnodexDoc> {

	// Define a static logger variable so that it references the
	// Logger instance named "KnodexDAOImpl".
	private static final Logger log = LogManager.getLogger(KxDocumentDAOImpl.class.getName());

	@Autowired
	private MongoTemplate mongoTemplate;

	//MongoTemplate uses default collection name that is by default, Class Name or specified at @Document(collection="<collectionName>") 
	public KnodexDoc save(KnodexDoc entity) {
		mongoTemplate.save(entity);
		return entity;
	}

	public KnodexDoc findOne(String id) {
		KnodexDoc knodexDoc = mongoTemplate.findById(id, KnodexDoc.class);
		return knodexDoc;
	}

	public List<KnodexDoc> findAll() {
		List<KnodexDoc> listKnodex = mongoTemplate.findAll(KnodexDoc.class);
		return listKnodex;
	}

	public List<KnodexDoc> findByKey(String key) {
		List<KnodexDoc> listKnodex = mongoTemplate.find(query(where("key").is(key)), KnodexDoc.class);
		return listKnodex;
	}

	public boolean exists(String key) {
		boolean existing = mongoTemplate.exists(query(where("key").is(key)), KnodexDoc.class);
		return existing;
	}

	public Long count() {
		long count = mongoTemplate.count(query(where("id").ne(null)), KnodexDoc.class);
		return count;
	}

	public void delete(KnodexDoc entity) {
		mongoTemplate.remove(query(where("key").is(entity.getKey())), KnodexDoc.class);
	}

	public boolean deleteById(String id) {
		mongoTemplate.remove(query(where("id").is(id)), KnodexDoc.class);
		return true;
	}

}