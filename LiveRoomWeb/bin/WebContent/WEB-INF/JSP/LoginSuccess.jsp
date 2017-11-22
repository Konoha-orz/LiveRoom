<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
Edit by @Teemo

2017-10-25

登陆成功界面并完成界面设计
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

<meta name="viewport" content="width=device-width">

<title>Login Success</title>



<link rel="assets" href="https://assets-cdn.github.com/">



<meta name="html-safe-nonce"
	content="be9cd812220c018ee865f7015ea2dd6e44670fa7">

<meta http-equiv="x-pjax-version"
	content="a0bcf5f0e23b49bd85d1f242993d22d2">


<meta name="description"
	content="GitHub is where people build software. More than 25 million people use GitHub to discover, fork, and contribute to over 69 million projects.">

<link rel="canonical" href="https://github.com/login"
	data-pjax-transient="">


<meta name="browser-stats-url"
	content="https://api.github.com/_private/browser/stats">

<meta name="browser-errors-url"
	content="https://api.github.com/_private/browser/errors">

<link rel="mask-icon"
	href="https://assets-cdn.github.com/pinned-octocat.svg" color="#000000">
<link rel="icon" type="image/x-icon" class="js-site-favicon"
	href="https://assets-cdn.github.com/favicon.ico">

<meta name="theme-color" content="#1e2327">


<meta name="u2f-support" content="true">

</head>

<body
	class="logged-out env-production page-responsive min-width-0 session-authentication">
	<h1>LoginSuccessfully....</h1>
	<a href="http://localhost:8080/LiveRoomWeb/login">back</a>
	<a href="http://localhost:8080/LiveRoomWeb/home">home</a>









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
					<h1>Message</h1>
				</div>


				<div id="js-flash-container"></div>


				<div class="auth-form-body mt-3">

					<div class="auth-form-body mt-3">
						<div style="text-align: center">
							<h2 for="Success Message">Login Successfully..</h2>
						</div>
						<br />
						<div style="text-align: center">
							<a href="http://localhost:8080/LiveRoomWeb/userInfo">View
								User Information</a>
						</div>
					</div>
				</div>



			</div>

		</div>
		<div class="modal-backdrop js-touch-events"></div>
	</div>



</body>

</html>