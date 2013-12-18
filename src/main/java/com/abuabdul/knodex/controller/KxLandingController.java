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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/landingPage")
	public void landingPage() {
		log.debug("Entering landingPage() in the KxLandingController");
		//return "landingPage";
	}
	
	@RequestMapping("/indexInfo")
	public ModelAndView indexInformation(Model model,String indexer) {
		log.debug("Entering indexInformation() in the KxLandingController");
		ModelAndView mav = new ModelAndView("viewResults");
		mav.addObject("model", model);
		return mav;
	}

}
