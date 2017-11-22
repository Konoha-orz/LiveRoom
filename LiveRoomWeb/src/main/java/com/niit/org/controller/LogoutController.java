package com.niit.org.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 *Edit by @Teemo
 *
 *2017-10-25
 *
 *用于处理lougot请求，实现登出。
 * 
 */

@Controller

@RequestMapping("/logout")
public class LogoutController {
	@RequestMapping()
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "logout";
	}
}
