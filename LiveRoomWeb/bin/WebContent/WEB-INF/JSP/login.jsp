<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
Edit by Teemo

2017-10-24

用户登录界面
-->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>


<body>
<%
	if(session.getAttribute("username")!=null){
	String username=session.getAttribute("username").toString();
	out.println("Hello "+username+" !");
	out.println("<a href='http://localhost:8080/LiveRoomWeb/logout'>Logout</a>");
	}
%>
<form action="login" method="post">
<label for="username">Username:</label><input type="text" id="username" name="username" />
<label for="password">Password:</label><input type="text" id="password" name="password" />
<input type="submit" value="login" />
</form>

<a href="http://localhost:8080/LiveRoomWeb/updateUserInfo">updateUserInfo</a>
</body>
</html>