package com.niit.org.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.org.bean.User;
import com.niit.org.mapper.IUser;

/*
 *Edit by Teemo
 *
 *2017-10-24
 *
 *用于处理、register请求，实现register.jsp页面中的用户键入的数据的获取，并完成数据向数据库的插入
 * 
 */

@Controller

@RequestMapping("/register")
public class RegisterController {
	
	@Resource
	private IUser iuser;
	
	@RequestMapping(method=RequestMethod.POST)
	public String register(HttpServletRequest request) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String dscp=request.getParameter("dscp");
		User user= new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setDscp(dscp);
		iuser.registerUser(user);
		
		return "registerSuccess";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void register() {}
	
}
