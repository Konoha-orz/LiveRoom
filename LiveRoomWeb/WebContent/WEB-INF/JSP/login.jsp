<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<h1>Login</h1>
<h1>${loginmessage}</h1>
<form action="login" method="post">
<label for="account">Account:</label><input type="text"  id="account"  name="account"/><br/>
<label for="password">Password:</label><input type="password"  id="password"  name="password"/><br/>
<input type="submit" value="Login" name="submit" />
</form>
</body>
</html>