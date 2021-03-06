package com.niit.org.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.org.bean.User;
import com.niit.org.mapper.IUser;
import com.niit.org.util.MD5Util;
// import com.niit.org.util.MD5Util;

/*
 *Edit by @Teemo
 *
 *2017-10-25
 *
 *用于处理login请求，通过获取数据库数据判断用户输入的密码是否与数据库密码相匹配，根据匹配与否将跳转到成功或错误页面。
 * 
 */

@Controller

@RequestMapping("/login")
public class LoginController {

	@Resource
	private IUser iuser;

	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String username_enter = request.getParameter("username");
		String password_enter = request.getParameter("password");
		String codedPassword=MD5Util.Encode(password_enter);
		try {
			String password_db = iuser.getUser(username_enter).get(0).getPassword();
			String dscp_db=iuser.getUser(username_enter).get(0).getDscp();
			String email=iuser.getUser(username_enter).get(0).getEmail();
			int userId=iuser.getUser(username_enter).get(0).getId();
//			if (codedPassword.equals(password_db)) {
			if (codedPassword.equals(password_db)) {
				User user=iuser.getUser(username_enter).get(0);
				session.setAttribute("user", user);
				session.setAttribute("username", username_enter);
//				session.setAttribute("password", password_db);
				session.setAttribute("email", email);
				session.setAttribute("dscp", dscp_db);
				session.setAttribute("userId", String.valueOf(userId));
				return "redirect:/index";
			} else {
				return "LoginFail";
			}
		} catch (Exception e) {
			return "LoginFail";
		}

	}

	@RequestMapping(method = RequestMethod.GET)
    public String login(HttpSession session) {
		try {
		if(session.getAttribute("username")!=null) {
//			session.setAttribute("msg", "你好  "+session.getAttribute("username")+" !");
//			session.setAttribute("logout", "<a href='http://localhost:8080/LiveRoomWeb/logout'>登出</a>");
			return "userInfo";
		}else {
//			session.setAttribute("msg", "尚未登录");
//			session.setAttribute("logout", " ");
			return "login";
		}
		}catch(Exception e) {
//			session.setAttribute("logout", " ");
			return "login";
		}
//	}
		
	}
	

}
	
@Controller
@RequestMapping("/logout")
class LogoutController {

	@RequestMapping()
	public String logout() {
		return "logout";
	}
	
}		
