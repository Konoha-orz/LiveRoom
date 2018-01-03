package com.niit.org.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.org.bean.User;
import com.niit.org.mapper.IUser;
import com.niit.org.util.MD5Util;

/*
 *Edit by @Teemo
 *
 *2017-10-31

 * 
 */




@Controller

@RequestMapping("/resetPassword")
public class ResetPasswordController {
	
	@Resource
	private IUser iuser;
	
	@RequestMapping(method = RequestMethod.POST)
	public String resetPassword(HttpServletRequest request,HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String username=String.valueOf(session.getAttribute("username"));
		String password=request.getParameter("password");
		User user=(User)iuser.getUser(username).get(0);
		user.setPassword(MD5Util.md5Encode(password));
		iuser.updateUser(user);
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void init() {}
}

