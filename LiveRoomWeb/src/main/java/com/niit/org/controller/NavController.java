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
				session.setAttribute("msg", "ÄãºÃ  " + session.getAttribute("username") + " !");
				session.setAttribute("logout", "<a href='http://localhost:8080/LiveRoomWeb/logout' target='_parent'>µÇ³ö</a>");
			} else {
				session.setAttribute("msg", "ÉÐÎ´µÇÂ¼");
				session.setAttribute("logout", " ");
			}
		} catch (Exception e) {
			session.setAttribute("msg", "ÉÐÎ´µÇÂ¼");
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