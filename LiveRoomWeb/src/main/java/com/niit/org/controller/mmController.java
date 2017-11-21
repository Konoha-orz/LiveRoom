package com.niit.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mm")
public class mmController {
	
	@RequestMapping()
	public String mm() {
		return "mm";
	}
	
}
