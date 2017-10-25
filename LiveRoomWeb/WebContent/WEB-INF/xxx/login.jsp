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
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css" type="text/css" /> 

<body>
<%
	if(session.getAttribute("username")!=null){
	String username=session.getAttribute("username").toString();
	out.println("Hello "+username+" !");
	out.println("<a href='http://localhost:8080/LiveRoomWeb/logout'>Logout</a>");
	}
%>
<div class="loginFrame">
<form action="login" method="post">

<div class="auth-form-header p-0">
<h1>User Login</h1>
</div>
<div class="auth-form-body">
<label for="username">Username:</label>
<input type="text" class="form-control input-block" id="username" name="username" autofocus="autofocus"/>
<label for="password">Password:</label><input type="text" id="password" name="password" />
<input class="btn btn-primary btn-block" type="submit" value="login" />
</div>
</form>
</div>

<a href="http://localhost:8080/LiveRoomWeb/updateUserInfo">updateUserInfo</a>
</body>
</html>