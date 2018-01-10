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
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUser iuser;
	@RequestMapping(method = RequestMethod.POST,value="/login")
	public String login(HttpServletRequest request, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String username_enter = request.getParameter("username");
		String password_enter = MD5Util.Encode(request.getParameter("password"));
		try {
			String password_db = iuser.getUser(username_enter).get(0).getPassword();
			String dscp_db=iuser.getUser(username_enter).get(0).getDscp();
			String email=iuser.getUser(username_enter).get(0).getEmail();
			if (password_enter.equals(password_db)) {
				User user=iuser.getUser(username_enter).get(0);
				session.setAttribute("user", user);
				session.setAttribute("username", username_enter);
				session.setAttribute("password", password_db);
				session.setAttribute("email", email);
				session.setAttribute("dscp", dscp_db);
				return "redirect:/user/login";
			} else {
				return "LoginFail";
			}
		} catch (Exception e) {
			return "LoginFail";
		}

	}

	@RequestMapping(method = RequestMethod.GET,value="/login")
    public String login(HttpSession session) {
		try {
		if(session.getAttribute("username")!=null) {
			session.setAttribute("msg",session.getAttribute("username")+" | ");
			session.setAttribute("logout", "<a href='/LiveRoomWeb/user/logout'>×¢Ïú</a>");
			return "userInfo";
		}else {
			session.setAttribute("msg", "ÉÐÎ´µÇÂ¼");
			session.setAttribute("logout", " ");
			return "login";
		}
		}catch(Exception e) {
			session.setAttribute("logout", " ");			
			return "login";
		}

	}
	
	@RequestMapping(method = RequestMethod.GET,value="/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("password");
		session.removeAttribute("email");
		session.removeAttribute("dscp");
		return "login";
	}
	
	@RequestMapping(value="/userInfo")
	public String userInfo() {
		return "userInfo";
	}
}
