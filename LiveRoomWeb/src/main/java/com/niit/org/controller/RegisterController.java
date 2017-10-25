package com.niit.org.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.org.bean.User;
import com.niit.org.mapper.IUser;

/*
 *Edit by @Teemo
 *
 *2017-10-25
 *
 *用于处理、register请求，实现register.jsp页面中的用户键入的数据的获取，并完成数据向数据库的插入
 *Line46 尚未完成。。
 * 
 */

@Controller

@RequestMapping("/register")
public class RegisterController {
	
	@Resource
	private IUser iuser;
	
	@RequestMapping(method=RequestMethod.POST)
	public String register(HttpServletRequest request) {
		
		try {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		String email=request.getParameter("email");
		String dscp=request.getParameter("dscp");
		User user= new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setDscp(dscp);
		user.setEmail(email);
		iuser.registerUser(user);
		//后续可完善验证错误部分
		return "registerSuccess";
		}catch(Exception e) {
			return "registerFail";
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void register() {}
	
}
