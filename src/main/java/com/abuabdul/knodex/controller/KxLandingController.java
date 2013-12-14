package com.abuabdul.knodex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KxLandingController {

	@RequestMapping("/KnodexApp")
	public String landingPage() {
		return "landingPage";
	}

}
