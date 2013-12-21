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
		KnodexDoc knodexDoc = null;
		if (knodexForm != null) {
			knodexDoc = new KnodexDoc();
			if (knodexForm.getIndexSentence() != null && !knodexForm.getIndexSentence().isEmpty()) {
				knodexDoc.setIndexSentence(knodexForm.getIndexSentence());
				if (knodexForm.getIndexBy() != null && !knodexForm.getIndexBy().isEmpty()) {
					knodexDoc.setIndexBy(knodexForm.getIndexBy());
				} else {
					String index = knodexDoc.getIndexSentence().split(" ")[0];
					knodexDoc.setIndexBy(index);
				}
			}

			if (StringUtils.isEmpty(knodexDoc.getIndexSentence()) || StringUtils.isEmpty(knodexDoc.getIndexBy())) {
				knodexDoc = null;
			}
		}
		return knodexDoc;
	}
}
