package com.niit.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *Edit by @Teemo
 *
 *2017-10-25
 *
 *用于处理userInfo请求。
 * 
 */


@Controller

@RequestMapping("/userInfo")
public class UserInfoController {
	
	@RequestMapping()
	public String userInfo() {
		return "userInfo";
	}
	
}
