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

package com.abuabdul.knodex.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import com.abuabdul.knodex.domain.KnodexDoc;
import com.abuabdul.knodex.model.KnodexForm;

public class KnodexUtil {

	// Define a static logger variable so that it references the
	// Logger instance named "KnodexUtil".
	private static final Logger log = LogManager.getLogger(KnodexUtil.class.getName());

	public static KnodexDoc convertFormToDocObject(KnodexForm knodexForm) {
		log.debug("Entered KnodexUtil.convertFormToDocObject method");
		String sentenceKey = "";
		KnodexDoc knodexDoc = null;
		if (knodexForm != null) {
			knodexDoc = new KnodexDoc();
			if (!StringUtils.isEmpty(knodexForm.getIndexSentence())) {
				knodexDoc.setIndexSentence(knodexForm.getIndexSentence().trim());
				char indexKey = knodexDoc.getIndexSentence().charAt(0);
				sentenceKey = String.valueOf(indexKey).toUpperCase();
				knodexDoc.setKey(sentenceKey);
				String[] index = knodexDoc.getIndexSentence().split("-");
				if (index.length > 1) {
					knodexDoc.setIndexBy(index[0].trim());
				} else {
					knodexDoc.setIndexBy(sentenceKey);
				}
			}

			if (StringUtils.isEmpty(knodexDoc.getIndexSentence()) || StringUtils.isEmpty(knodexDoc.getIndexBy())) {
				knodexDoc = null;
			}
		}
		return knodexDoc;
	}
}
