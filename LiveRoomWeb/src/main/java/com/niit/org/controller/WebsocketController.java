package com.niit.org.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/websocket")
public class WebsocketController {
	
	
	@RequestMapping()
	public String insert() {
		
		
		return "websocket";
	}

}
