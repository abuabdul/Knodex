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

package com.abuabdul.knodex.controller;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abuabdul.knodex.domain.KnodexDoc;
import com.abuabdul.knodex.model.KnodexForm;
import com.abuabdul.knodex.service.KxDocumentService;
import com.abuabdul.knodex.utils.KnodexUtil;

/**
 * @author abuabdul
 * 
 *         This is the main controller that handles web requests for KNOdex
 *         application
 * 
 */
@Controller
public class KxLandingController {

	// Define a static logger variable so that it references the
	// Logger instance named "KxLandingController".
	private static final Logger log = LogManager.getLogger(KxLandingController.class.getName());

	@Autowired
	private KxDocumentService<KnodexDoc> kxDocumentService;

	public void setKxDocumentService(KxDocumentService<KnodexDoc> kxDocumentService) {
		this.kxDocumentService = kxDocumentService;
	}

	@RequestMapping("/")
	public String landingPage(Model model) {
		log.debug("Entering landingPage() in the KxLandingController");
		// Create new KnodexForm object and set it in the model
		model.addAttribute("knodexForm", new KnodexForm());
		return "landingPage";
	}

	@RequestMapping("/add/knodexSentenceToIndex")
	public ModelAndView addIndexInformation(@ModelAttribute("knodexForm") KnodexForm knodex) {
		log.debug("Entering addIndexInformation() in the KxLandingController");
		long totalSize = 0;
		String existingIndexKey = null;
		KnodexDoc knodexDoc = null;
		List<KnodexDoc> listKnodexDoc = null;
		SortedMap<String, List<KnodexDoc>> fullListOfSentences = null;
		ModelAndView mav = new ModelAndView("landingPage");
		if (knodex != null) {
			if (knodex.getIndexKey() != null && !knodex.getIndexKey().isEmpty()) {
				// Gather if the index is already clicked
				existingIndexKey = knodex.getIndexKey();
			}
			// reset the index since new addition does not require indexBy value
			knodex.setIndexKey("");
			log.debug("Printing knodex sentence... " + knodex.getIndexSentence());
			knodexDoc = KnodexUtil.convertFormToDocObject(knodex);
			if (knodexDoc != null) {
				boolean success = kxDocumentService.indexASentence(knodexDoc);
				mav.addObject("operation", success);
			}

			// Gather the list of elements for the index already clicked
			if (existingIndexKey != null && !existingIndexKey.isEmpty()) {
				if (!existingIndexKey.equalsIgnoreCase("All")) {
					log.debug("Printing knodex key... " + existingIndexKey.toUpperCase());
					listKnodexDoc = kxDocumentService.listSentencesByIndexer(existingIndexKey.toUpperCase());
					mav.addObject("indexByResults", listKnodexDoc);
					if (listKnodexDoc != null) {
						mav.addObject("totalIndexes", listKnodexDoc.size());
					}
				} else {
					fullListOfSentences = kxDocumentService.listAllSentences();
					totalSize = kxDocumentService.getTotalRecordsSize();
					mav.addObject("indexByResults", fullListOfSentences);
					mav.addObject("totalIndexes", totalSize);
				}
				mav.setViewName("viewResults");
				knodex.setIndexKey(existingIndexKey);
			}
			// Reset the sentence since value should be reset after addition
			knodex.setIndexSentence("");
		}
		return mav;
	}

	@RequestMapping("/remove/knodexSentenceToIndex")
	@ResponseBody
	public String removeIndexInformation(@ModelAttribute("knodexForm") KnodexForm knodex, String knodexId) {
		log.debug("Entering removeIndexInformation() in the KxLandingController");
		String parsedId = "";
		boolean deleted = false;
		if (!StringUtils.isEmpty(knodexId)) {
			log.debug("Parse the knodex Id in the KxLandingController "+ knodexId);
			String[] idArray = knodexId.split("_");
			if (idArray != null && idArray.length != 0) {
				parsedId = idArray[idArray.length - 1];
				log.debug("Id of the record to be deleted - " + parsedId);
				deleted = kxDocumentService.removeASentence(parsedId);
			}

		}
		return String.valueOf(deleted);
	}

	@RequestMapping("/list/knodexSentenceByIndex")
	public ModelAndView listIndexInformation(@ModelAttribute("knodexForm") KnodexForm knodex) {
		log.debug("Entering listIndexInformation() in the KxLandingController");
		List<KnodexDoc> listKnodexDoc = null;
		ModelAndView mav = new ModelAndView("viewResults");
		if (knodex != null) {
			log.debug("Printing knodex index key... " + knodex.getIndexKey());
			if (knodex.getIndexKey() != null && !knodex.getIndexKey().isEmpty()) {
				listKnodexDoc = kxDocumentService.listSentencesByIndexer(knodex.getIndexKey().toUpperCase());
				if (listKnodexDoc != null) {
					mav.addObject("totalIndexes", listKnodexDoc.size());
				}
			}
			mav.addObject("indexByResults", listKnodexDoc);
			// Reset the sentence since value should be reset after listing by Index
			knodex.setIndexSentence("");
		}
		return mav;
	}

	@RequestMapping("/list/all/knodexSentenceByIndex")
	public ModelAndView listAllIndexInformation(@ModelAttribute("knodexForm") KnodexForm knodex) {
		log.debug("Entering listAllIndexInformation() in the KxLandingController");
		long totalSize = 0;
		SortedMap<String, List<KnodexDoc>> fullListOfSentences = new TreeMap<String, List<KnodexDoc>>();
		ModelAndView mav = new ModelAndView("viewResults");
		if (knodex != null) {
			log.debug("Printing knodex index key... " + knodex.getIndexKey());
			fullListOfSentences = kxDocumentService.listAllSentences();
			totalSize = kxDocumentService.getTotalRecordsSize();
		}
		mav.addObject("indexByResults", fullListOfSentences);
		mav.addObject("totalIndexes", totalSize);
		// Reset the sentence since value should be reset after listing by Index
		knodex.setIndexSentence("");
		return mav;
	}
}
