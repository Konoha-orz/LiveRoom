<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--

Edit by @Teemo

2017-10-25
用户注册界面并完成界面设计

2017-10-27
完成用户名重复性验证及两次密码输入是否相同的验证

-->

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>


<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css1.css"
	type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css2.css"
	type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css3.css"
	type="text/css" />
	<link rel="shortcut icon" href="images/favicon.ico" />　　

<meta name="viewport" content="width=device-width"/>

<title>用户注册</title>

<script src="<%=request.getContextPath() %>/js/jquery-3.2.1.min.js" ></script>

</head>

<body
	class="logged-out env-production page-responsive min-width-0 session-authentication">


	<div class="position-relative js-header-wrapper ">

		<div id="js-pjax-loader-bar" class="pjax-loader-bar">
			<div class="progress"></div>
		</div>

		<div class="header header-logged-out width-full pt-5 pb-4"
			role="banner">
			<div class="container clearfix width-full"></div>
		</div>


	</div>

	<div id="start-of-content" class="show-on-focus"></div>



	<div role="main">

		<div id="js-pjax-container" data-pjax-container="">


			<div class="auth-form px-3" id="login">

				<!-- '"` -->
				<!-- </textarea></xmp> -->
				<form accept-charset="UTF-8" action="register" name="register" method="post">
					<div style="margin: 0; padding: 0; display: inline">
						<input name="utf8" type="hidden" value="✓"><input
							name="authenticity_token" type="hidden"
							value="jjTCIuxLb1pgXsdqb+gEfNZEGiuvLpC8i9Fr1fwZR941RvHGGiz8v9hLErL4zUpav5ky19mdHVbvZ6vcWwBwJA==">
					</div>
					<div class="auth-form-header p-0">
						<h1>用户注册</h1>
					</div>


					<div id="js-flash-container"></div>


					<div class="auth-form-body mt-3">

							<label for="username"> 用户名 </label> 
							<input autocapitalize="off" autocorrect="off" autofocus="autofocus"
							class="form-control input-block" id="username" name="username"
							tabindex="1" type="text" onblur="checkUsername()"/> 
							
							<label for="checkusername" id="checkusername" name="checkusername"style="color:red"></label>
							
							<label for="password">密码 </label> 
							<input class="form-control form-control input-block"
							id="password" name="password" tabindex="2" type="password" /> 
							
							<label for="cpassword">确认密码 </label> 
							<input class="form-control form-control input-block"
							id="cpassword" name="cpassword" tabindex="2" type="password" onblur="checkConfirmPassword()"/> 
							
							<label for="error" id="error" style="color:red"></label>
							

							
							<label for="dscp">个人简介 </label> 
							<input class="form-control form-control input-block"
							id="dscp" name="dscp" tabindex="2" type="text" /> 
							
							<label for="email">电子邮箱 </label> 
							<input class="form-control form-control input-block"
							id="email" name="email" tabindex="2" type="text" /> 
							
							<a href="#" onclick="submit()">发送邮件</a><br>
							<label for="sendMsg" id="sendMsg" style="color:red"></label>
							<br>
							</form>
							
							<!-- <form accept-charset="UTF-8" id="form2" action="checkEmail" method="post"> -->
							<label for="ver"> 输入验证码:</label> <input
							autocapitalize="off" autocorrect="off" autofocus="autofocus"
							class="form-control input-block" id="verificationCode" name="verificationCode"
							tabindex="1" type="text" /> 
							<a href="#" onclick="checkVer()">验证验证码</a>
							<label for="checkver" id="checkver" style="color:red"></label>
							<!-- </form> -->
							
							<input
							class="btn btn-primary btn-block" data-disable-with="Signing in…"
							name="commit" tabindex="3" type="submit" value="注册" />
							
					</div>
			
			</div>

		</div>
		<div class="modal-backdrop js-touch-events"></div>
	</div>



</body>
<script type="text/javascript">
function checkConfirmPassword(){
	if(document.getElementById(	"password").value!=document.getElementById("cpassword").value){
		document.getElementById("error").innerText="两次密码输入不同";
	}else{
		document.getElementById("error").innerText="";
	}
}

 function checkUsername(){
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath() %>/register/check",
		data:{"username":$("#username").val()},
		success:function(r){
			if(r == "success"){
				$("#checkusername").html("");  
			}else{
				$("#checkusername").html("用户名已存在");  
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log(XMLHttpRequest.status);
			console.log(XMLHttpRequest.readyState);
			console.log(textStatus);
		}
	});
} 
 
 function submit(){
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath() %>/register/sendEmail",
			data:{"username":$("#username").val(),
				  "email":$("#email").val()},
		    success:function(r){
		    	if(r=="success"){
		    		$("#sendMsg").html("邮件已发送");
		    	}else{
		    		$("#sendMsg").html("邮箱地址错误");
		    	}
		    },
		    error:function(XMLHttpRequest, textStatus, errorThrown){
				console.log(XMLHttpRequest.status);
				console.log(XMLHttpRequest.readyState);
				console.log(textStatus);
		    }
		});
	}
 function checkVer(){
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath() %>/register/checkVer",
			data:{"ver":$("#verificationCode").val()},
			success:function(r){
				if(r == "success"){
					$("#checkver").html("验证码正确！");  
				}else{
					$("#checkver").html("验证码错误！");  
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				console.log(XMLHttpRequest.status);
				console.log(XMLHttpRequest.readyState);
				console.log(textStatus);
			}
		}); 
	}
</script>
</html>