package com.niit.org.util;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


//Jsch SSH转接
public class JschUtil {
   
	static int lport=5555;//本地端口
	static String rhost="127.0.0.1" ; //mysql地址
	static int rport=3306;//mysql端口
	
	static String user="root";//SSH服务器用户名
	static String password="yangjian233,./";//SSH服务器密码
	static String host="120.78.81.233";//SSH服务器地址
	static int port=22;//SSH服务器默认端口
	
	static JSch jsch=new JSch();
    static Session session;
	
	public static void open() {
	
	try {

		session=jsch.getSession(user, host, port);
		session.setPassword(password);
		session.setConfig("StrictHostKeyChecking","no");
		session.connect();
		System.out.println("===JSch connect===");
		System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息 
		int assinged_port=session.setPortForwardingL(lport, rhost, rport); //端口映射
		System.out.println("localhost:"+assinged_port+"->"+rhost +":"+rport);
        
	}catch(Exception e){
		e.printStackTrace();
	}
	
	}
	
	public static void close() {
		session.disconnect();
		System.out.println("===JSch disconnect===");
	}
	
}
