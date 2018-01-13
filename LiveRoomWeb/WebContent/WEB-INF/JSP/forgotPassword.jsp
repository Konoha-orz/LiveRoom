<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
Edit by @Teemo

2017-10-31

用户忘记密码界面，通过邮件认证用户是否为本人
-->

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="StaticResource.jsp"/>

<title>忘记密码</title>

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
				
					<div style="margin: 0; padding: 0; display: inline">
						<input name="utf8" type="hidden" value="✓"><input
							name="authenticity_token" type="hidden"
							value="jjTCIuxLb1pgXsdqb+gEfNZEGiuvLpC8i9Fr1fwZR941RvHGGiz8v9hLErL4zUpav5ky19mdHVbvZ6vcWwBwJA==">
					</div>
					<div class="auth-form-header p-0">
						<h1>忘记密码</h1>
					</div>


					<div id="js-flash-container"></div>


					<div class="auth-form-body mt-3">
						<form accept-charset="UTF-8" id="form1" action="forgotPassword" method="post">
						<label for="Username"> 用户名:</label> <input
							autocapitalize="off" autocorrect="off" autofocus="autofocus"
							class="form-control input-block" id="username" name="username"
							tabindex="1" type="text" onblur="checkUsername()"/> 
							
							<label for="checkusername" id="checkusername" name="checkusername"style="color:red"></label>
							<label for="Email"> 邮箱:</label> <input
							autocapitalize="off" autocorrect="off" autofocus="autofocus"
							class="form-control input-block" id="email" name="email"
							tabindex="1" type="text" /> 
							
							<a href="#" onclick="submit()">发送邮件</a><br>
							<label for="sendMsg" id="sendMsg" style="color:red"></label>
							<br>
							
							</form>
							<form accept-charset="UTF-8" id="form2" action="forgotPassword" method="post">
							<label for="Email"> 输入验证码:</label> <input
							autocapitalize="off" autocorrect="off" autofocus="autofocus"
							class="form-control input-block" id="verificationCode" name="verificationCode"
							tabindex="1" type="text" /> 
							<a href="#" onclick="checkVer()">验证验证码</a>
							<label for="checkver" id="checkver" style="color:red"></label>
							<input
							class="btn btn-primary btn-block" data-disable-with="Submiting…"
							name="submit" tabindex="3" type="submit" value="提交" />
				</form>
					</div>
				
					
				

			</div>

		</div>
		<div class="modal-backdrop js-touch-events"></div>
	</div>



</body>
<script type="text/javascript">
function submit(){
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath() %>/forgotPassword/sendEmail",
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
function checkUsername(){
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath() %>/forgotPassword/check",
		data:{"username":$("#username").val()},
		success:function(r){
			if(r == "success"){
				$("#checkusername").html("用户名不存在");  
			}else{
				$("#checkusername").html("");  
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log(XMLHttpRequest.status);
			console.log(XMLHttpRequest.readyState);
			console.log(textStatus);
		}
	});
}
 function checkVer(){
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath() %>/forgotPassword/checkVer",
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