package com.niit.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *Edit by @Teemo
 *
 *2017-10-25
 *
 *用于处理logout请求，实现用户登出
 * 
 */


@Controller
@RequestMapping("/logout")
public class LogoutController {

	@RequestMapping()
	public String logout() {
		return "logout";
	}
	
}
