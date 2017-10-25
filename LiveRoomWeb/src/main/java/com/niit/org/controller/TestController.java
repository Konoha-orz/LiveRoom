package com.niit.org.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.org.bean.User;
import com.niit.org.mapper.IUser;

@Controller

@RequestMapping("/test")
public class TestController {
	@Resource
	private IUser iuser;
	
	
	@RequestMapping
	public String test(ModelMap resultMap) {
		
		List<User> list=iuser.getAll();
		
		
		resultMap.addAttribute("list",list);
		
		return "test";
	}
}
