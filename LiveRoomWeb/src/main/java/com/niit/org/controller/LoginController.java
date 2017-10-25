package com.niit.org.controller;

<<<<<<< HEAD
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

=======
>>>>>>> origin/teemo
import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
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

=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.niit.org.bean.User;
import com.niit.org.mapper.IUser;

/*
 *Edit by Teemo
 *
 *2017-10-24
 *
 *用于处理login请求，通过获取数据库数据判断用户输入的密码是否与数据库密码相匹配，根据匹配与否将跳转到成功或错误页面。
 * 
 */

@Controller

@RequestMapping("/login")
>>>>>>> origin/teemo
public class LoginController {

	@Resource
<<<<<<< HEAD
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
=======
	private IUser iuser;

	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session) {
		String username_enter = request.getParameter("username");
		String password_enter = request.getParameter("password");
		try {
			String password_db = iuser.getUser(username_enter).get(0).getPassword();
			if (password_enter.equals(password_db)) {
				session.setAttribute("username", username_enter);
				return "LoginSuccess";
			} else {
				return "LoginFail";
			}
		} catch (Exception e) {
			return "LoginFail";
>>>>>>> origin/teemo
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public void login(HttpSession session) {}
	
	
	
	}
