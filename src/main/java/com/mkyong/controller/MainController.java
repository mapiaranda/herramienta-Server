package com.mkyong.controller;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class MainController {
	
	private static final Logger logger = Logger.getLogger(MainController.class);

	
	public MainController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/")
	public String helloWorld(){
		return "Hello World!";
	}
}
