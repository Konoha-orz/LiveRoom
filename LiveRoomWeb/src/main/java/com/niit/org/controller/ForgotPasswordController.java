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
 *鐢ㄤ簬澶勭悊forgotPassword璇锋眰锛屽悜鐢ㄦ埛閭鍙戦�佹惡甯﹂獙璇佺爜鐨勯偖浠讹紝鎻愪緵鏈汉楠岃瘉锛屾鏌ョ敤鎴峰悕鏄惁瀛樺湪锛屼互鍙婇獙璇佺爜鏄惁姝ｇ‘锛屼互鍑忓皯璇搷浣滃甫鏉ョ殑鍐椾綑鎿嶄綔銆�
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
			return "forgotPassowrd/resetPassword";
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
			String subject = "Liveroom正在为您找回密码";
			int radomInt = new Random().nextInt(999999);
			this.random = Integer.toString(radomInt);
			StringBuilder builder = new StringBuilder();
			builder.append("您好：" + username + "，我们正在尝试为您找回密码。");
			builder.append("<br>");
			builder.append("这是您的验证码:<br>" + random);
			builder.append("<br>");
			builder.append("请勿回复官方邮件。唯一官方邮箱：liveroom_admin@yeah.net。");
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
	
	@RequestMapping(method = RequestMethod.POST,value="/resetPassword")
	public String resetPassword(HttpServletRequest request,HttpSession session) {
		String username=String.valueOf(session.getAttribute("username"));
		String password=request.getParameter("password");
		User user=(User)iuser.getUser(username).get(0);
		user.setPassword(password);
		iuser.updateUser(user);
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/resetPassword")
	public void init() {}
}
