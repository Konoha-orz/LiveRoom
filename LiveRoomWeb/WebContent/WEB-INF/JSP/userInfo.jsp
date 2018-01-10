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

<jsp:include page="StaticResource.jsp"/>

<title>个人信息</title>
</head>

<body class="logged-out env-production page-responsive min-width-0 session-authentication">
<jsp:include page="NavigateHeader.jsp"/>
<div class="big_div">
 <div class="div_nav">
	<jsp:include page="nav.jsp" />
</div>  

<div class="div_main">

				<form accept-charset="UTF-8" action="login" method="post">
							
						<div class="userFrame_main">
						<h1>用户个人信息</h1>
						<h2 for="greeting">你好: <%=session.getAttribute("username").toString() %> </h2><br/>
		  				<div>
							<label for="username"> 用户名 </label>
							<input autofocus="autofocus" id="username"  disabled="true" name="username" tabindex="1" type="text" value="${username }"/>
						</div>
						<div>
							<label for="email">电子邮箱地址 </label> 
							<input id="email" name="email" tabindex="2" disabled="true" type="text" value="${email }"/> 
						</div>
						<div>
							<label for="dscp">个人简介 </label> 
							<textarea id="dscp" name="dscp" disabled="true">${dscp}</textarea><br>
						</div>
				-	</div>
				</form>

</div>
</div>
</body>
</html>