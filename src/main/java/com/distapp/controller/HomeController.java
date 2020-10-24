package com.distapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//localhost:9898
	/*
	 usuario: admin
	 pass:admin
	 */
	@RequestMapping(value = "/index")
	public String index() {
		return "index"; //llama a la vista "index"
	}
	
	@RequestMapping(value = "/home")
	public String home() {
		return "home";
	}
}
