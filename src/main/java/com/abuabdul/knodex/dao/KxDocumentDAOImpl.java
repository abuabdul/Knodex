/*
 * Copyright 2013-2014 abuabdul.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

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

/**
 * @author abuabdul
 * 
 *         Main Repository class for interacting with MongoDB. It extends the
 *         contract KxDocumentDAO with the type KnodexDoc. It uses MongoTemplate
 *         to have its finder methods. The default collection name is specified
 *         in the document type level.
 * 
 */
@Repository
public class KxDocumentDAOImpl implements KxDocumentDAO<KnodexDoc> {

	// Define a static logger variable so that it references the
	// Logger instance named "KxDocumentDAOImpl".
	private static final Logger log = LogManager.getLogger(KxDocumentDAOImpl.class.getName());

	@Autowired
	private MongoTemplate mongoTemplate;

	// MongoTemplate uses default collection name that is by default, Class Name
	// or specified at @Document(collection="<collectionName>")
	public KnodexDoc save(KnodexDoc entity) {
		log.debug("Entering save() in the KxDocumentDAOImpl");
		mongoTemplate.save(entity);
		return entity;
	}

	public KnodexDoc findOne(String id) {
		log.debug("Entering findOne() in the KxDocumentDAOImpl");
		KnodexDoc knodexDoc = mongoTemplate.findById(id, KnodexDoc.class);
		return knodexDoc;
	}

	public List<KnodexDoc> findAll() {
		log.debug("Entering findAll() in the KxDocumentDAOImpl");
		List<KnodexDoc> listKnodex = mongoTemplate.findAll(KnodexDoc.class);
		return listKnodex;
	}

	public List<KnodexDoc> findByKey(String key) {
		log.debug("Entering findByKey() in the KxDocumentDAOImpl");
		List<KnodexDoc> listKnodex = mongoTemplate.find(query(where("key").is(key)), KnodexDoc.class);
		return listKnodex;
	}

	public boolean exists(String key) {
		log.debug("Entering exists() in the KxDocumentDAOImpl");
		boolean existing = mongoTemplate.exists(query(where("key").is(key)), KnodexDoc.class);
		return existing;
	}

	public Long count() {
		log.debug("Entering count() in the KxDocumentDAOImpl");
		long count = mongoTemplate.count(query(where("id").ne(null)), KnodexDoc.class);
		return count;
	}

	public void delete(KnodexDoc entity) {
		log.debug("Entering delete() in the KxDocumentDAOImpl");
		mongoTemplate.remove(query(where("key").is(entity.getKey())), KnodexDoc.class);
	}

	public boolean deleteById(String id) {
		log.debug("Entering deleteById() in the KxDocumentDAOImpl");
		mongoTemplate.remove(query(where("id").is(id)), KnodexDoc.class);
		return true;
	}

}
