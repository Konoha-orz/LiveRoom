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
<jsp:include page="NavigateHeader.jsp"/>
<div class="big_div">
 <div class="div_nav">
	<jsp:include page="nav.jsp" />
</div> 

<div class="div_main">
	

			<div class="smart-green" id="login">

				<form accept-charset="UTF-8" action="updatePassword" method="post">
				
						<h1>修改密码</h1>
							
							 <label for="password">密码 </label> 
							<input id="password" name="password" tabindex="1" type="password" placeholder="输入新密码" /> 
							
							<label for="cpassword">确认密码 </label> 
							<input id="cpassword" name="cpassword" tabindex="2" type="password" placeholder="再次输入密码" onblur="checkConfirmPassword()"/>  							
							
							<label for="error" id="error" style="color:red"></label>
							
							<div style="text-align:center">
							<input id="btn" class="button" tabindex="3" type="submit" value="保存" onClick="check()"/>
							</div>
					
				</form>
			</div>

</div>
</div>
<script type="text/javascript">

function checkConfirmPassword(){
		if(document.getElementById(	"password").value!=document.getElementById("cpassword").value){
			document.getElementById("error").innerText="两次密码输入不同";
			document.getElementById("btn").disabled=true;
		}else{
			document.getElementById("error").innerText="";
			document.getElementById("btn").disabled=false;
		}
}
	
function check(){
		if(document.getElementById(	"password").value!=document.getElementById("cpassword").value){
			alert("修改失败，两次密码输入不同");
		}else{
			alert("修改成功");
		}
		
}

</script>
</body>
</html>