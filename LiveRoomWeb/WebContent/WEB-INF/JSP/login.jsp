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
<link rel="stylesheet" href="user.css" type="text/css" />

<body>
<%
	if(session.getAttribute("username")!=null){
	String username=session.getAttribute("username").toString();
	out.println("Hello "+username+" !");
	out.println("<a href='http://localhost:8080/LiveRoomWeb/logout'>Logout</a>");
	}
%>
<form action="login" method="post">
<table>
<tr><td><label for="username">Username:</label></td><td><input type="text" id="username" name="username" /></td></tr>
<tr><td><label for="password">Password:</label></td><td><input type="text" id="password" name="password" /></td></tr>
<tr><td colspan="2"><input class="btn btn-primary btn-block" type="submit" value="login" /></td></tr>
</table>
</form>

<a href="http://localhost:8080/LiveRoomWeb/updateUserInfo">updateUserInfo</a>
</body>
</html>