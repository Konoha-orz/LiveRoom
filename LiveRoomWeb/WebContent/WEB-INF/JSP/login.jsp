<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css1.css"
	type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css2.css"
	type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css3.css"
	type="text/css" />
	<link rel="shortcut icon" href="images/favicon.ico" />　　

<meta name="viewport" content="width=device-width">


<title >User Login</title>

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
				<form accept-charset="UTF-8" action="login" method="post">
					<div style="margin: 0; padding: 0; display: inline">
						<input name="utf8" type="hidden" value="✓"><input
							name="authenticity_token" type="hidden"
							value="jjTCIuxLb1pgXsdqb+gEfNZEGiuvLpC8i9Fr1fwZR941RvHGGiz8v9hLErL4zUpav5ky19mdHVbvZ6vcWwBwJA==">
					</div>
					<div class="auth-form-header p-0">
						<h1>User Login</h1>
					</div>


					<div id="js-flash-container"></div>


					<div class="auth-form-body mt-3">

						<label for="username"> Username </label> <input
							autocapitalize="off" autocorrect="off" autofocus="autofocus"
							class="form-control input-block" id="username" name="username"
							tabindex="1" type="text" /> <label for="password">
							Password <a href="http://localhost:8080/LiveRoomWeb/forgotPassword" class="label-link">Forgot password?</a>
						</label> <input class="form-control form-control input-block"
							id="password" name="password" tabindex="2" type="password" /> <input
							class="btn btn-primary btn-block" data-disable-with="Signing in…"
							name="commit" tabindex="3" type="submit" value="Login" />
					</div>
				</form>

				<p class="create-account-callout mt-3">
					Do not have an account?<br> <a
						href="http://localhost:8080/LiveRoomWeb/register"
						data-ga-click="Sign in, switch to sign up">Create an account</a>.
				</p>
			</div>

		</div>
		<div class="modal-backdrop js-touch-events"></div>
	</div>


<!-- 	<div class="footer container-lg p-responsive py-6 mt-6 f6"
		role="contentinfo">
		<ul class="list-style-none d-flex flex-justify-center">
			<li class="mr-3"><a href="https://github.com/site/terms"
				class="link-gray" data-ga-click="Footer, go to terms, text:terms">Terms</a></li>
			<li class="mr-3"><a href="https://github.com/site/privacy"
				class="link-gray"
				data-ga-click="Footer, go to privacy, text:privacy">Privacy</a></li>
			<li class="mr-3"><a href="https://github.com/security"
				class="link-gray"
				data-ga-click="Footer, go to security, text:security">Security</a></li>
			<li><a href="https://github.com/contact" class="link-gray"
				data-ga-click="Footer, go to contact, text:contact">Contact
					GitHub</a></li>
		</ul>
	</div> -->


</body>
</html>

