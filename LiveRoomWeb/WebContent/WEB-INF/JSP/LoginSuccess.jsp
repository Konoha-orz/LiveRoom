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

<jsp:include page="StaticResource.jsp"/>
<meta http-equiv="Refresh" content="3;url=http://localhost:8080/LiveRoomWeb/userInfo">
<title>登陆成功</title>

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
					<h1>消息</h1>
				</div>


				<div id="js-flash-container"></div>


				<div class="auth-form-body mt-3">

					<div class="auth-form-body mt-3">
						<div style="text-align: center">
							<h2 for="Success Message">登陆成功</h2>
							<p>3秒后自动跳转</p>
						</div>
						<br />
						<div style="text-align: center">
							<a href="http://localhost:8080/LiveRoomWeb/userInfo">查看个人信息</a>
						</div>
					</div>
				</div>



			</div>

		</div>
		<div class="modal-backdrop js-touch-events"></div>
	</div>

</body>

</html>