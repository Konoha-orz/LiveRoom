<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
Edit by @Teemo

2017-10-25

修改用户信息界面并完成界面设计
-->

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="StaticResource.jsp"/>
<meta name="viewport" content="width=device-width">

<title>更新用户个人信息</title>

</head>

<body>
<div class="big_div">
 <div class="div_nav">
	<jsp:include page="nav.jsp" />
</div> 

<div class="div_main">
	

			<div class="userFrame_main" id="login">

				<form accept-charset="UTF-8" action="updateUserInfo" method="post">
				
						<h1>更新用户个人信息</h1>

						<div>
							<label for="username"> 用户名 </label>
							<input autofocus="autofocus" id="username" name="username" tabindex="1" type="text" value="${username }"/>
						</div>
						<div>
							<label for="email">电子邮箱地址 </label> 
							<input id="email" name="email" tabindex="2" type="text" value="${email }"/> 
						</div>
						<div>
							<label for="dscp">个人简介 </label> 
							<textarea id="dscp" name="dscp" >${dscp}</textarea><br>
						</div>
							
						<div style="text-align:center;width:30%;margin:10px auto;">
							<input class="button" tabindex="3" type="submit" value="保存" />
						</div>
					
				</form>
			</div>

</div>
</div>
</body>
</html>