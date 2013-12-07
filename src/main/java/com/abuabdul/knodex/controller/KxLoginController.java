package com.abuabdul.knodex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KxLoginController {
	
	@RequestMapping("/KnodexApp")
    public ModelAndView landingPage() {
        return new ModelAndView("index");
    }
	
}
