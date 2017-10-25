package com.niit.org.controller;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.org.mapper.IUser;

/*
 *Edit by @Teemo
 *
 *2017-10-25
 *
 *用于处理login请求，通过获取数据库数据判断用户输入的密码是否与数据库密码相匹配，根据匹配与否将跳转到成功或错误页面。
 * 
 */

@Controller

@RequestMapping("/login")
public class LoginController {

	@Resource
	private IUser iuser;

	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session) {
		String username_enter = request.getParameter("username");
		String password_enter = request.getParameter("password");
		try {
			String password_db = iuser.getUser(username_enter).get(0).getPassword();
			String dscp_db=iuser.getUser(username_enter).get(0).getDscp();
			String email=iuser.getUser(username_enter).get(0).getEmail();
			if (password_enter.equals(password_db)) {
				session.setAttribute("username", username_enter);
				session.setAttribute("password", password_db);
				session.setAttribute("email", email);
				session.setAttribute("dscp", dscp_db);
				return "LoginSuccess";
			} else {
				return "LoginFail";
			}
		} catch (Exception e) {
			return "LoginFail";
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public void login(HttpSession session) {}
	}
