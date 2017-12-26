<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
Edit by @Teemo

2017-10-25

用户个人信息
-->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css1.css"
	type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css2.css"
	type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css3.css"
	type="text/css" />
	<link rel="stylesheet" type="text/css" href="css/nav.css">
	<link rel="stylesheet" type="text/css" href="css/teemocss.css" />
	<link rel="shortcut icon" href="images/favicon.ico" />　　
<meta name="viewport" content="width=device-width">


<title>个人信息</title>
</head>

<body
	class="logged-out env-production page-responsive min-width-0 session-authentication">
	
 <div class="div_nav">
 
	<iframe src="nav" frameborder="0" scrolling="no" height="800px"></iframe>
</div> 

<div class="div_main">


				<form accept-charset="UTF-8" action="login" method="post">
							
						<div class="smart-green">
						<h1>用户个人信息</h1>
						<h2 for="greeting">你好: <%=session.getAttribute("username").toString() %> </h2><br/>
						<label class="info" for="username"> 用户名:<%=session.getAttribute("username").toString() %> </label> <br/>
						<label class="info" for="password"> 密码:<%=session.getAttribute("password").toString() %> </label> <br/>
						<label class="info" for="email"> 邮箱地址:<%=session.getAttribute("email").toString() %> </label> <br/>
						<label class="info" for="dscp"> 个人简介:<%=session.getAttribute("dscp").toString() %> </label> <br/>
						</div>
				</form>

</div>
</body>
</html>