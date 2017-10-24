package com.niit.org.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.org.bean.User;
import com.niit.org.mapper.IUser;

@Controller

@RequestMapping("/updateUserInfo")
public class UpdateUserInfoController {

	@Resource
	private IUser iuser;
	
	@RequestMapping(method = RequestMethod.POST)
	public String updateUserInfo(HttpServletRequest request) {	
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String dscp=request.getParameter("dscp");
		int id=iuser.getUser(username).get(0).getId();
		User u = new User();
		u.setId(id);
		u.setPassword(password);
		u.setUsername(username);
		u.setDscp(dscp);
		iuser.updateUser(u);
		return "updateSuccess";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String updateUserInfo(HttpSession session,ModelMap map) {
		String username=session.getAttribute("username").toString();
		int id=iuser.getUser(username).get(0).getId();
		String password=iuser.getUser(username).get(0).getPassword();
		String dscp=iuser.getUser(username).get(0).getDscp();
		map.addAttribute("username", username);
		map.addAttribute("password",password);
		map.addAttribute("dscp",dscp);
		return "updateUserInfo";
	}
}
