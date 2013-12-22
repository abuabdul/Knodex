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
import org.springframework.stereotype.Service;

import com.abuabdul.knodex.domain.KnodexDoc;

@Service
public class KxDocumentServiceImpl implements KxDocumentService<KnodexDoc> {

	// Define a static logger variable so that it references the
	// Logger instance named "KxDocumentServiceImpl".
	private static final Logger log = LogManager.getLogger(KxDocumentServiceImpl.class.getName());

	public static final SortedMap<String, List<KnodexDoc>> mapKnodex = new TreeMap<String, List<KnodexDoc>>();

	public boolean indexASentence(String key, KnodexDoc t) {
		log.debug("Entered KxDocumentServiceImpl.indexASentence method");
		log.debug("Added the sentence with the key " + key);
		List<KnodexDoc> listKnodexForKey = null;
		if (mapKnodex != null) {
			if (!mapKnodex.isEmpty() && mapKnodex.containsKey(key)) {
				listKnodexForKey = mapKnodex.get(key);
				if (listKnodexForKey == null) {
					listKnodexForKey = new ArrayList<KnodexDoc>();
				}
				listKnodexForKey.add(t);
			} else {
				listKnodexForKey = new ArrayList<KnodexDoc>();
				listKnodexForKey.add(t);
				mapKnodex.put(key.toUpperCase(), listKnodexForKey);
			}
			return true;
		}
		return false;
	}

	public boolean removeASentence(String key) {
		log.debug("Entered KxDocumentServiceImpl.removeASentence method");
		if (mapKnodex != null && !mapKnodex.isEmpty() && mapKnodex.containsKey(key)) {
			log.debug("Removed the sentence with the key " + key);
			mapKnodex.remove(key);
		} else {
			log.debug("Cannot Remove the sentence with the key " + key);
			return false;
		}
		return true;
	}

	public List<KnodexDoc> listSentencesByIndexer(String index) {
		log.debug("Entered KxDocumentServiceImpl.listSentencesByIndexer method");
		List<KnodexDoc> listByIndex = null;
		if (mapKnodex != null && !mapKnodex.isEmpty() && mapKnodex.containsKey(index)) {
			listByIndex = mapKnodex.get(index);
		}
		return listByIndex;
	}

	public SortedMap<String, List<KnodexDoc>> listAllSentences() {
		log.debug("Entered KxDocumentServiceImpl.listAllSentences method");
		SortedMap<String, List<KnodexDoc>> fullListOfSentences = mapKnodex;
		return fullListOfSentences;
	}
}
