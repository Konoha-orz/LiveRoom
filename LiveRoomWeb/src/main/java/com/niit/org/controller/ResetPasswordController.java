package com.niit.org.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.org.bean.User;
import com.niit.org.mapper.IUser;

/*
 *Edit by @Teemo
 *
 *2017-10-31
 *
 *用于处理resetPassword请求，经过验证通过的用户可以重置密码。
 * 
 */




@Controller

@RequestMapping("/resetPassword")
public class ResetPasswordController {
	
	@Resource
	private IUser iuser;
	
	@RequestMapping(method = RequestMethod.POST)
	public String resetPassword(HttpServletRequest request,HttpSession session) {
		String username=String.valueOf(session.getAttribute("username"));
		String password=request.getParameter("password");
		User user=(User)iuser.getUser(username).get(0);
		user.setPassword(password);
		iuser.updateUser(user);
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void init() {}
}

