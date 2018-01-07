<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="StaticResource.jsp" />
<meta name="viewport" content="width=device-width">
<html>
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
				<form accept-charset="UTF-8" action="login" method="post">
					<div style="margin: 0; padding: 0; display: inline">
						<input name="utf8" type="hidden" value="✓"><input
							name="authenticity_token" type="hidden"
							value="jjTCIuxLb1pgXsdqb+gEfNZEGiuvLpC8i9Fr1fwZR941RvHGGiz8v9hLErL4zUpav5ky19mdHVbvZ6vcWwBwJA==">
					</div>
					<div class="auth-form-header p-0">
						<h1>用户登陆</h1>
					</div>


					<div id="js-flash-container"></div>


					<div class="auth-form-body mt-3">

						<label for="username" style="text-align: left"> 用户名 </label> <input
							autocapitalize="off" autocorrect="off" autofocus="autofocus"
							class="form-control input-block" id="username" name="username"
							tabindex="1" type="text" /> <label for="password"
							style="text-align: left"> 密码 <a
							href="http://localhost:8080/LiveRoomWeb/forgotPassword"
							class="label-link">忘记密码?</a>
						</label> <input class="form-control form-control input-block"
							id="password" name="password" tabindex="2" type="password" /> <input
							class="btn btn-primary btn-block" data-disable-with="Signing in…"
							name="commit" tabindex="3" type="submit" value="登陆" />
					</div>
				</form>

				<p class="create-account-callout mt-3">
					没有账号?<br> <a href="http://localhost:8080/LiveRoomWeb/register"
						data-ga-click="Sign in, switch to sign up">注册账号</a>.
				</p>
			</div>

		</div>
		<div class="modal-backdrop js-touch-events"></div>
	</div>




</body>
</html>
