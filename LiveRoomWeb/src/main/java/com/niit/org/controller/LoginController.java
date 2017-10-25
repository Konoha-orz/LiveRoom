package com.niit.org.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.org.bean.Account;
import com.niit.org.bean.Role;
import com.niit.org.mapper.IAccountService;
import com.niit.org.mapper.IRoleService;
import com.niit.org.service.IAccount;
import com.niit.org.util.JschUtil;

@Controller

public class LoginController {

	
	@Resource
	private IAccountService iac;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(HttpSession session) {
        Account user=(Account) session.getAttribute("user");
		
        if(user==null)
		   return "login";
		else
			return "webchat";

	}
    @RequestMapping(value = "/logout")
    @ResponseBody
    public Map<String, String> logout(HttpSession httpSession, HttpServletResponse httpServletResponse) throws IOException {
        httpSession.removeAttribute("username");
        Map<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> processAddUser (HttpSession httpSession,@RequestBody Map<String,Object> params) {
        String username=params.get("username").toString();
        Map<String, String> map = new HashMap<>();
        // session.invalidate() 是用来清空session会话的
        // 一般使用session.removeAttribute()
        if (username.length() > 0) {
            httpSession.setAttribute("username",username);
            map.put("status", "success");
        } else {
            // 否则直接返回
            map.put("status", "error");
        }
        return map;
    }
    
	@RequestMapping(method=RequestMethod.POST)
	public String submit(ModelMap resultMap,HttpServletRequest request,HttpSession session) {
		

//		//此处通过SSH外部访问远程mysql服务器需要用到JSCH,服务器端上不需要
//		JschUtil sshutil=new JschUtil();
//		
//		//*************SSH端口转接开启
//		sshutil.open();

		
		
		
		
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		Account loginuser=new Account();
		loginuser.setUsername(account);
		
		Account user=iac.getUser(loginuser);


		//**************SSH端口转接关闭
//		sshutil.close();
		
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