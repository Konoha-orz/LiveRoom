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
import com.niit.org.util.MD5Util;
import com.niit.org.util.MailUtil;

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
	String random;
	String username;
	
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
		user.setPassword(MD5Util.Encode((password)));
//		user.setPassword(password);
		user.setDscp(dscp);
		user.setEmail(email);
		iuser.registerUser(user);
		return "registerSuccess";
		}catch(Exception e) {
			e.printStackTrace();
			return "registerFail";
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void register() {
		
	}
	
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
	
	@ResponseBody
	@RequestMapping("/sendEmail")
	public String checkUsername(String username, String email) throws Exception {
		String flag = "success";
     		this.username = username;
			MailUtil mu = new MailUtil();
			String subject = "Liveroom正在确认您的邮箱";
			int radomInt = new Random().nextInt(999999);
			this.random = Integer.toString(radomInt);
			StringBuilder builder = new StringBuilder();
			builder.append("您好： " + username + "，我们正在努力确认此邮箱是否为您本人使用，请获取验证码。");
			builder.append("<br>");
			builder.append("您的验证码为:<br>" + random);
			builder.append("<br>");
			builder.append("请勿回复官方邮件。唯一官方邮箱：liveroom_admin@yeah.net");
			builder.append("<br>");
			builder.append("Liveroom Administrator");
			String content = builder.toString();
			mu.setEmailFrom("liveroom_admin@yeah.net");
			mu.setEmailTo(email);
			mu.setSubject(subject);
			mu.setContent(content);
			mu.sendEmail();
			return flag;

	}
	
	@ResponseBody
	@RequestMapping("/checkVer")
	public String checkVer(String ver) {
		if (ver.equals(random)) {
			return "success";
		} else {
			return "fail";
		}
	}
	
}
