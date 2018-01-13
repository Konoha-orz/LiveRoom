package com.niit.org.util;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper; 

/*
 *Edit by @Teemo
 *
 *2017-10-31
 *发送邮件的类设置邮件的发送地址，收件地址，发件服务器，发件用户名和密码。
 *
 * 
 */

public class MailUtil {
	private String emailHost;  
	private String emailFrom;  
	private String emailUsername;
	private String emailPassword;
	private String emailTo;
	private String subject;
	private String content;
	public String getEmailHost() {
		return emailHost;
	}
	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	
	public String getEmailUsername() {
		return emailUsername;
	}
	public void setEmailUsername(String emailUsername) {
		this.emailUsername = emailUsername;
	}
	public String getEmailPassword() {
		return emailPassword;
	}
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}	
	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getSubject() {
		if(subject=="") {
			subject="Null Subject";
		}
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public void sendEmail() throws Exception{
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setHost("smtp.yeah.net");
		//建立邮件消息
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = null;
		messageHelper = new MimeMessageHelper(mailMessage,true,"UTF-8");
		//设置发件人邮箱
		messageHelper.setFrom(emailFrom);
		//设置收件人
		messageHelper.setTo(emailTo);
		//设置主题
		messageHelper.setSubject(subject);
		
		//启动html格式的邮件  
        messageHelper.setText(content, true);
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.timeout", "25000");
        prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.smtp.socketFactory.fallback", "false");
        prop.setProperty("mail.smtp.socketFactory.port", "25");

      final String smtpPort = "25";
        prop.setProperty("mail.smtp.port", smtpPort);
        //添加验证
        this.setEmailUsername("liveroom_admin@yeah.net");
        this.setEmailPassword("liveroom_123123");
        MyAuthenticator auth = new MyAuthenticator(emailUsername,emailPassword);
        Session session = Session.getInstance(prop,auth);
        senderImpl.setSession(session);
        //发送邮件
        senderImpl.send(mailMessage);
        
	}
	
	
}
