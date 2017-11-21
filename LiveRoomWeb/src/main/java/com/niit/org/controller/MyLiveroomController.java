package com.niit.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myLiveroom")
public class MyLiveroomController {

	@RequestMapping()
	public String myLiveroom() {
		return "myLiveroom";
	}
	
}
