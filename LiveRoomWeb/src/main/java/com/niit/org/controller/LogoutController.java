package com.niit.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *Edit by @Teemo
 *
 *2017-10-25
 *
 *���ڴ���logout����ʵ���û��ǳ�
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
