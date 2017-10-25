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

/*
 *Edit by @Teemo
 *
 *2017-10-25
 *
 *用于处理UpdateUserInfo请求，通过获取数据库数据显示在页面上并最后将用户最终修改完成的信息存入数据库中。
 *
 *Line39 验证尚未完成。
 * 
 */

@Controller

@RequestMapping("/updateUserInfo")
public class UpdateUserInfoController {

	@Resource
	private IUser iuser;
	int id;
	
	@RequestMapping(method = RequestMethod.POST)
	public String updateUserInfo(HttpServletRequest request,ModelMap map,HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");// confirm password 的验证没有完成。
		String dscp = request.getParameter("dscp");
		
		User u = new User();
		u.setId(id);
		u.setUsername(username);
		u.setPassword(password);
		u.setEmail(email);
		u.setDscp(dscp);
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		session.setAttribute("email", email);
		session.setAttribute("dscp", dscp);
		/*map.remove("username");
		map.remove("password");
		map.remove("email");
		map.remove("dscp");
		map.addAttribute("username", username);
		map.addAttribute("password", password);
		map.addAttribute("email", email);
		map.addAttribute("dscp", dscp);*/
		try {
			iuser.updateUser(u);
			return "updateSuccess";
		} catch (Exception e) {
			return "updateFail";
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String updateUserInfo(HttpSession session, ModelMap map) {
		String username = session.getAttribute("username").toString();
		id = iuser.getUser(username).get(0).getId();
		String password = iuser.getUser(username).get(0).getPassword();
		String email = iuser.getUser(username).get(0).getEmail();
		String dscp = iuser.getUser(username).get(0).getDscp();
		map.addAttribute("username", username);
		map.addAttribute("password", password);
		map.addAttribute("email", email);
		map.addAttribute("dscp", dscp);
		return "updateUserInfo";
	}
}
