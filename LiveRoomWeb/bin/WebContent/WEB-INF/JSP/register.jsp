<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
Edit by Teemo

2017-10-24

用户注册界面
-->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register</title>
<head>
<body>
<form action="register" method="post">

	<table>
	<tr><td><label for="username">Username:</label></td><td><input type="text" id="username" name="username" /></td></tr>
	<tr><td><label for="password">Password:</label></td><td><input type="password" id="password" name="password" /></td></tr>
	<tr><td><label for="dscp">Description:</label></td><td><input type="text" id="dscp" name="dscp" /></td></tr>
	</table>
	<input type="submit" value="register" />

</form>
</body>
</html>