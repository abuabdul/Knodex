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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abuabdul.knodex.model.KnodexForm;

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

	@RequestMapping("/")
	public String landingPage(Model model) {
		log.debug("Entering landingPage() in the KxLandingController");
		// Create new KnodexForm object and set it in the model
		model.addAttribute("knodexForm", new KnodexForm());
		return "landingPage";
	}

	@RequestMapping("/add/knodexSentenceToIndex")
	public ModelAndView indexInformation(@ModelAttribute("knodexForm") KnodexForm knodex) {
		log.debug("Entering indexInformation() in the KxLandingController");
		log.debug("Printing knodex sentence... "+knodex.getIndexSentence());
		ModelAndView mav = new ModelAndView("viewResults");
		mav.addObject("knodexForm", new KnodexForm());
		return mav;
	}

}
