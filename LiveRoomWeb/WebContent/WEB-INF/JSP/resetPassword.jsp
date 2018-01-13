<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--

Edit by @Teemo

2017-10-31
用户重置密码界面，通过验证的用户在此界面重置密码

-->

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<jsp:include page="StaticResource.jsp"/>

<meta name="viewport" content="width=device-width"/>

<title>重置密码</title>


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
				<form accept-charset="UTF-8" action="resetPassword" name="resetPassword" method="post">
					<div style="margin: 0; padding: 0; display: inline">
						<input name="utf8" type="hidden" value="✓"><input
							name="authenticity_token" type="hidden"
							value="jjTCIuxLb1pgXsdqb+gEfNZEGiuvLpC8i9Fr1fwZR941RvHGGiz8v9hLErL4zUpav5ky19mdHVbvZ6vcWwBwJA==">
					</div>
					<div class="auth-form-header p-0">
						<h1>重置密码</h1>
					</div>


					<div id="js-flash-container"></div>


					<div class="auth-form-body mt-3">

							<label for="username"> 你好   ${username},</label> 
							
							<label for="password">密码 </label> 
							<input class="form-control form-control input-block"
							id="password" name="password" tabindex="2" type="password" /> 
							
							<input
							class="btn btn-primary btn-block" data-disable-with="Setting…"
							name="commit" tabindex="3" type="submit" value="重置" />
					</div>
				</form>
			</div>

		</div>
		<div class="modal-backdrop js-touch-events"></div>
	</div>


</body>
</html>