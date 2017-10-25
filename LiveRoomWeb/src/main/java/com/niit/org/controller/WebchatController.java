package com.niit.org.controller;



import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.org.bean.Account;

@Controller
public class WebchatController {
	

	
	@RequestMapping("/webchat")
	public String gochat(HttpSession httpSession,ModelMap modelMap) {
		Account user=(Account) httpSession.getAttribute("user");
		if(user==null) {
		   
			modelMap.remove("loginmessage");
			modelMap.addAttribute("loginmessage","Login First!!!");
			return "login";
		}
		else
			return "webchat";
	}
	
	
	/*@RequestMapping("/logout")
	public void logout(HttpSession httpSession,HttpServletResponse response) throws IOException {
		httpSession.removeAttribute("user");
		
		response.sendRedirect("login");
		
	}*/

}
