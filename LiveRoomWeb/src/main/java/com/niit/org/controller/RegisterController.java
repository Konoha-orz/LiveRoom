package com.niit.org.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.org.bean.User;
import com.niit.org.mapper.IUser;

/*
 *Edit by @Teemo
 *
 *2017-10-25
 *用于处理register请求，实现register.jsp页面中的用户键入的数据的获取，并完成数据向数据库的插入
 *
 *2017-10-27
 *完成了用于接受前台数据并在后台进行验证用户名的重复性的方法
 * 
 */

@Controller

@RequestMapping("/register")
public class RegisterController {
	
	@Resource
	private IUser iuser;
	
	@RequestMapping(method=RequestMethod.POST)
	public String register(HttpServletRequest request) {
		
		try {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		String email=request.getParameter("email");
		String dscp=request.getParameter("dscp");
		User user= new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setDscp(dscp);
		user.setEmail(email);
		iuser.registerUser(user);
		return "registerSuccess";
		}catch(Exception e) {
			return "registerFail";
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void register() {}
	
	@ResponseBody
	@RequestMapping("/check")
	public String checkUsername(String username) {
		List<User> userList=iuser.getAll();
		int size=userList.size();
		String flag="success";
		for(int i=0;i<size;i++) {
			if(userList.get(i).getUsername().equals(username)) {
				flag="wrong";
				break;
			}
		}
		return flag;
	}
	
	
}
