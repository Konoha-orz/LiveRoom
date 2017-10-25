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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="dns-prefetch" href="https://assets-cdn.github.com/">
<link rel="dns-prefetch" href="https://avatars0.githubusercontent.com/">
<link rel="dns-prefetch" href="https://avatars1.githubusercontent.com/">
<link rel="dns-prefetch" href="https://avatars2.githubusercontent.com/">
<link rel="dns-prefetch" href="https://avatars3.githubusercontent.com/">
<link rel="dns-prefetch" href="https://github-cloud.s3.amazonaws.com/">
<link rel="dns-prefetch"
	href="https://user-images.githubusercontent.com/">

<meta content="origin" name="referrer">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css1.css"
	type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css2.css"
	type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css3.css"
	type="text/css" />

<meta name="viewport" content="width=device-width">

<title>Update User Information</title>

<meta property="fb:app_id" content="1401488693436528">

<meta property="og:url" content="https://github.com">
<meta property="og:site_name" content="GitHub">
<meta property="og:title" content="Build software better, together">
<meta property="og:description"
	content="GitHub is where people build software. More than 25 million people use GitHub to discover, fork, and contribute to over 69 million projects.">
<meta property="og:image"
	content="https://assets-cdn.github.com/images/modules/open_graph/github-logo.png">
<meta property="og:image:type" content="image/png">
<meta property="og:image:width" content="1200">
<meta property="og:image:height" content="1200">
<meta property="og:image"
	content="https://assets-cdn.github.com/images/modules/open_graph/github-mark.png">
<meta property="og:image:type" content="image/png">
<meta property="og:image:width" content="1200">
<meta property="og:image:height" content="620">
<meta property="og:image"
	content="https://assets-cdn.github.com/images/modules/open_graph/github-octocat.png">
<meta property="og:image:type" content="image/png">
<meta property="og:image:width" content="1200">
<meta property="og:image:height" content="620">


<link rel="assets" href="https://assets-cdn.github.com/">

<meta name="pjax-timeout" content="1000">

<meta name="request-id" content="34C1:1BF2C:2ED5E2E:465471B:59EFF213"
	data-pjax-transient="">


<meta name="selected-link" value="/login" data-pjax-transient="">

<meta name="google-site-verification"
	content="KT5gs8h0wvaagLKAVWq8bbeNwnZZK1r1XQysX3xurLU">
<meta name="google-site-verification"
	content="ZzhVyEFwb7w3e0-uOTltm8Jsck2F5StVihD0exw2fsA">
<meta name="google-analytics" content="UA-3769691-2">

<meta content="collector.githubapp.com" name="octolytics-host">
<meta content="github" name="octolytics-app-id">
<meta
	content="https://collector.githubapp.com/github-external/browser_event"
	name="octolytics-event-url">
<meta content="34C1:1BF2C:2ED5E2E:465471B:59EFF213"
	name="octolytics-dimension-request_id">
<meta content="sea" name="octolytics-dimension-region_edge">
<meta content="iad" name="octolytics-dimension-region_render">
<meta content="true" data-pjax-transient="true"
	name="analytics-location-query-strip">




<meta class="js-ga-set" name="dimension1" content="Logged Out">




<meta name="hostname" content="github.com">
<meta name="user-login" content="">

<meta name="expected-hostname" content="github.com">
<meta name="js-proxy-site-detection-payload"
	content="ZjQ5YjhhMzY3NWNkMWFiNWE3NzE4YWIxY2QyMDdiNDQxYzc4YjNlNTk3M2MxMTE3ZmE4MmEzOGQ2M2JhNjFkYXx7InJlbW90ZV9hZGRyZXNzIjoiMjE5LjE0Ni4yNDIuMTM0IiwicmVxdWVzdF9pZCI6IjM0QzE6MUJGMkM6MkVENUUyRTo0NjU0NzFCOjU5RUZGMjEzIiwidGltZXN0YW1wIjoxNTA4ODk3MzA3LCJob3N0IjoiZ2l0aHViLmNvbSJ9">


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
</head>



<body>
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
				<form accept-charset="UTF-8" action="updateUserInfo" method="post">
					<div style="margin: 0; padding: 0; display: inline">
						<input name="utf8" type="hidden" value="✓"><input
							name="authenticity_token" type="hidden"
							value="jjTCIuxLb1pgXsdqb+gEfNZEGiuvLpC8i9Fr1fwZR941RvHGGiz8v9hLErL4zUpav5ky19mdHVbvZ6vcWwBwJA==">
					</div>
					<div class="auth-form-header p-0">
						<h1>Update User Information</h1>
					</div>


					<div id="js-flash-container"></div>


					<div class="auth-form-body mt-3">

						<label for="username"> Username </label> 
						<input autocapitalize="off" autocorrect="off" autofocus="autofocus"
							class="form-control input-block" id="username" name="username"
							tabindex="1" type="text" value="${username }"/> 
							
							<label for="password">Password </label> 
							<input class="form-control form-control input-block"
							id="password" name="password" tabindex="2" type="password" value="${password }" /> 
							
							<label for="cpassword">Confirm Password </label> 
							<input class="form-control form-control input-block"
							id="cpassword" name="cpassword" tabindex="2" type="password" value="${password }" /> 
							
							<label for="email">Email Adress </label> 
							<input class="form-control form-control input-block"
							id="email" name="email" tabindex="2" type="text" value="${email }"/> 
							
							<label for="dscp">Description </label> 
							<input class="form-control form-control input-block"
							id="dscp" name="dscp" tabindex="2" type="text" value="${dscp }"/> 
							
							<input
							class="btn btn-primary btn-block" data-disable-with="Signing in…"
							name="commit" tabindex="3" type="submit" value="Save" />
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

	<div class="footer container-lg p-responsive py-6 mt-6 f6"
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
	</div>


</body>
</body>
</html>