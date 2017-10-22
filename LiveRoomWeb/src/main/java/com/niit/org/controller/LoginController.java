package com.niit.org.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.org.bean.Account;
import com.niit.org.bean.Role;
import com.niit.org.mapper.IAccountService;
import com.niit.org.mapper.IRoleService;
import com.niit.org.service.IAccount;
import com.niit.org.util.JschUtil;

@Controller

@RequestMapping("/login")

public class LoginController {

	
	@Resource
	private IAccountService iac;

	@RequestMapping(method=RequestMethod.GET)

	public String login(HttpSession session) {
        Account user=(Account) session.getAttribute("user");
		
        if(user==null)
		   return "login";
		else
			return "webchat";

	}
	
	@RequestMapping(method=RequestMethod.POST)

	public String submit(ModelMap resultMap,HttpServletRequest request,HttpSession session) {
		
		//姝ゅ閫氳繃SSH澶栭儴璁块棶杩滅▼mysql鏈嶅姟鍣ㄩ渶瑕佺敤鍒癑SCH,鏈嶅姟鍣ㄧ涓婁笉闇�瑕�
		JschUtil sshutil=new JschUtil();
		
		//*************SSH绔彛杞帴寮�鍚�
		sshutil.open();
		
		
		
		
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		Account loginuser=new Account();
		loginuser.setUsername(account);
		
		Account user=iac.getUser(loginuser);

		//**************SSH绔彛杞帴鍏抽棴
		sshutil.close();
		
		if(user.getPassword().equals(password)) {
			session.setAttribute("user", user);
			return "webchat";
		}
		else {
			resultMap.remove("loginmessage");
			resultMap.addAttribute("loginmessage","Error!!!");
			return "login";	
		}
		
		
		

	}

}