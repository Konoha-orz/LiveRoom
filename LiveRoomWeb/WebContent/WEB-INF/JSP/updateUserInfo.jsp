<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Update User Information</title>
</head>
<body>

<form action="updateUserInfo" method="post">

<table>
<tr><td><label for="username">Username:</label></td><td><input type="text" id="username" name="username" value="${username}"/></td></tr>
<tr><td><label for="password">Password:</label></td><td><input type="text" id="password" name="password" value="${password}"/></td></tr>
<tr><td><label for="dscp">Description:</label></td><td><input type="text" id="dscp" name="dscp" value="${dscp}"/></td></tr>
<tr><td><input type="submit" value="Save"></td></tr>
</table>	

</form>

</body>
</html>