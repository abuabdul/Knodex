/*
 * Copyright 2013 abuabdul.com
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

package com.abuabdul.knodex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.abuabdul.knodex.dao.KnodexDAO;
import com.abuabdul.knodex.domain.KnodexDoc;

@Service
public class KxDocumentServiceImpl implements KxDocumentService<KnodexDoc> {

	// Define a static logger variable so that it references the
	// Logger instance named "KxDocumentServiceImpl".
	private static final Logger log = LogManager.getLogger(KxDocumentServiceImpl.class.getName());

	@Autowired
	private KnodexDAO<KnodexDoc> knodexDAO;

	public static final SortedMap<String, List<KnodexDoc>> mapKnodex = new TreeMap<String, List<KnodexDoc>>();

	public boolean indexASentence(KnodexDoc entity) {
		log.debug("Entered KxDocumentServiceImpl.indexASentence method");
		KnodexDoc dbKnodexDoc = knodexDAO.save(entity);
		if (dbKnodexDoc != null && !StringUtils.isEmpty(dbKnodexDoc.getId())) {
			log.debug("Added the sentence with the key=" + dbKnodexDoc.getKey() + " ,indexBy = " + dbKnodexDoc.getIndexBy());
			return true;
		}
		return false;
	}

	public boolean removeASentence(String id) {
		log.debug("Entered KxDocumentServiceImpl.removeASentence method");
		boolean deleted = knodexDAO.deleteById(id);
		if (deleted) {
			log.debug("Removed the sentence with the id " + id);
		} else {
			log.debug("Cannot Remove the sentence with the id " + id);
		}
		return deleted;
	}

	public List<KnodexDoc> listSentencesByIndexer(String key) {
		log.debug("Entered KxDocumentServiceImpl.listSentencesByIndexer method");
		List<KnodexDoc> listByIndex = knodexDAO.findByKey(key);
		return listByIndex;
	}

	public SortedMap<String, List<KnodexDoc>> listAllSentences() {
		log.debug("Entered KxDocumentServiceImpl.listAllSentences method");
		String indexKey = "";
		List<KnodexDoc> indexKnodexList = null;
		SortedMap<String, List<KnodexDoc>> fullListOfSentences = null;

		List<KnodexDoc> listAllKnodex = knodexDAO.findAll();

		if (listAllKnodex != null && !listAllKnodex.isEmpty()) {
			fullListOfSentences = new TreeMap<String, List<KnodexDoc>>();
			for (KnodexDoc knodexDoc : listAllKnodex) {
				if (knodexDoc != null && !StringUtils.isEmpty(knodexDoc.getKey())) {
					indexKey = knodexDoc.getKey();
					if (!fullListOfSentences.isEmpty() && fullListOfSentences.containsKey(indexKey)) {
						indexKnodexList = fullListOfSentences.get(indexKey);
						if (indexKnodexList == null) {
							// Ideally this code will not execute
							indexKnodexList = new ArrayList<KnodexDoc>();
						}
						indexKnodexList.add(knodexDoc);
					} else {
						indexKnodexList = new ArrayList<KnodexDoc>();
						indexKnodexList.add(knodexDoc);
						fullListOfSentences.put(indexKey, indexKnodexList);
					}
				}
			}
		}
		return fullListOfSentences;
	}

}
