package com.niit.org.controller;

import java.util.List;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.org.bean.User;
import com.niit.org.mapper.IUser;
import com.niit.org.util.MailUtil;


/*
 *Edit by @Teemo
 *
 *2017-10-31
 *
 *用于处理forgotPassword请求，向用户邮箱发送携带验证码的邮件，提供本人验证，检查用户名是否存在，以及验证码是否正确，以减少误操作带来的冗余操作。
 * 
 */



@Controller

@RequestMapping("/forgotPassword")
public class ForgotPasswordController {
	@Resource
	private IUser iuser;
	String random;
	String username;

	@RequestMapping(method = RequestMethod.POST)
	public String forgotPassword(HttpServletRequest request, HttpSession session) {
		String ver_enter = request.getParameter("verificationCode");
		if (ver_enter.equals(random)) {
			session.setAttribute("username", username);
			return "resetPassword";
		} else {
			return "verError";
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public void login() {
	}

	@ResponseBody
	@RequestMapping("/sendEmail")
	public String checkUsername(String username, String email) throws Exception {
		String flag = "success";
		String email_db = iuser.getUser(username).get(0).getEmail();
		if (email_db.equals(email)) {
			this.username = username;
			MailUtil mu = new MailUtil();
			String subject = "Verification Code for Retrieving Password";
			int radomInt = new Random().nextInt(999999);
			this.random = Integer.toString(radomInt);
			StringBuilder builder = new StringBuilder();
			builder.append("Hello: " + username + ",We Are Trying Retrieving Your Password.");
			builder.append("<br>");
			builder.append("This is Your Verification Code:<br>" + random);
			builder.append("<br>");
			builder.append("No Need to reply this offical Email.");
			builder.append("<br>");
			builder.append("Liveroom Administrator");
			String content = builder.toString();
			mu.setEmailFrom("liveroom_admin@yeah.net");
			mu.setEmailTo(email);
			mu.setSubject(subject);
			mu.setContent(content);
			mu.sendEmail();
			return flag;
		} else {
			flag = "fail";
			return flag;
		}
	}

	@ResponseBody
	@RequestMapping("/check")
	public String checkUsername(String username) {
		List<User> userList = iuser.getAll();
		int size = userList.size();
		String flag = "success";
		for (int i = 0; i < size; i++) {
			if (userList.get(i).getUsername().equals(username)) {
				flag = "wrong";
				break;
			}
		}
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
