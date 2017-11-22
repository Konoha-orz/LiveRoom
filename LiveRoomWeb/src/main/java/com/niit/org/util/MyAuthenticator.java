package com.niit.org.util;

import javax.mail.Authenticator;

/*
 *Edit by @Teemo
 *
 *2017-10-31
 *用于验证发件邮箱的用户名和密码的正确性。
 *
 * 
 */
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator{
	private String username;
	private String password;
	
	public MyAuthenticator(String username,String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username,password);
	}
	
}
