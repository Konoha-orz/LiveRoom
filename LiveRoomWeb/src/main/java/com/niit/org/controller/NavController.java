package com.niit.org.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nav")
public class NavController {

	@RequestMapping()
	public String nav(HttpSession session) {
		try {
			if (session.getAttribute("username") != null) {
				session.setAttribute("msg", "���  " + session.getAttribute("username") + " !");
				session.setAttribute("logout", "<a href='http://localhost:8080/LiveRoomWeb/logout' target='_parent'>�ǳ�</a>");
			} else {
				session.setAttribute("msg", "��δ��¼");
				session.setAttribute("logout", " ");
			}
		} catch (Exception e) {
			session.setAttribute("msg", "��δ��¼");
			session.setAttribute("logout", " ");
		}
		return "nav";
	}
}
@Controller

@RequestMapping("/userInfo")
class UserInfoController {
	
	@RequestMapping()
	public String userInfo() {
		return "userInfo";
	}
	
}