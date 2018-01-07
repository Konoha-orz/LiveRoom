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
	
	@RequestMapping(method= RequestMethod.POST, value="/updatePassword")
	public String updatePassword(HttpServletRequest request, HttpSession session) {
		String username = String.valueOf(session.getAttribute("username"));
		String password=request.getParameter("password");
		User user=(User)iuser.getUser(username).get(0);
		user.setPassword(password);
		iuser.updateUser(user);
		session.removeAttribute("password");
		session.setAttribute("password", password);
		return "updatePassword";
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/userUpdate")
	public String initUpdatePsd() {
		return "updatePassword";
	}
	
}

