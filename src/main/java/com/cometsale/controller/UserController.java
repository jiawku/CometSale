package com.cometsale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value="/addUser",method = RequestMethod.GET)
	public String addNewUser(ModelMap model) {
		System.out.println("entered add user page");
		return "welcome-page1";
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		System.out.println("entered normal");
		return "welcome-page";
	}

}
