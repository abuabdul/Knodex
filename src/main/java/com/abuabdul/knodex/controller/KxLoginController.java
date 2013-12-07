package com.abuabdul.knodex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KxLoginController {
	
	@RequestMapping("/Knodex")
    public ModelAndView landingPage() {
        String message = "<br><div align='center'><h1>Hello from HelloWorld controller.<h1>this is from method 1st<br>";
        return new ModelAndView("index", "message1", message);
    }
    
}
