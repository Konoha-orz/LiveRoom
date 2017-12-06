<%@page import="com.niit.org.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%
	String context = request.getContextPath();
%>
<title>在线直播间</title>
<link rel="stylesheet" href="<%=context%>/css/d4e0488237db533e.css">
<link rel="stylesheet" href="<%=context%>/css/ruc_v1.1.5.css">
<link rel="stylesheet" href="<%=context%>/css/fc9e619cd23e8c28.css">
<link rel="stylesheet" href="<%=context%>/css/596c2be88ac9a5a0.css">
<link rel="stylesheet" href="<%=context%>/css/93c97f35e37e6edb.css">
<link rel="stylesheet" href="<%=context%>/css/level-style.css">
<link rel="stylesheet" href="<%=context%>/css/d96e788401080238.css">
<link rel="stylesheet" href="<%=context%>/css/ruc_v1.1.5.css">
<link rel="stylesheet" href="<%=context%>/css/8305aac31ae2dad7.css">
<link rel="stylesheet" href="<%=context%>/css/cfd22de72e2813e9.css">
<link rel="stylesheet" href="<%=context%>/css/jquery.datetimepicker.css">
<link rel="stylesheet" href="<%=context%>/css/sidebar_v1.1.0.css">
<link rel="stylesheet" href="<%=context%>/css/level-style.css">
<script src="<%=context%>/js/da870659adfe1ddc.js"></script>
<script src="<%=context%>/js/hm.js"></script>
<script src="<%=context%>/js/ff7cbc1b3b59cc0a.js"></script>
<link href="<%=context%>/css/videojs.css" rel="stylesheet">
<script src="<%=context%>/js/video.js"></script>
<script src="<%=context%>/js/vue.js"></script>
<title>头部导航栏</title>


<style type="text/css" media="screen">
#swf_play {
	visibility: hidden
}
</style>
</head>
<body>
	<!-- header start -->
	<header id="panda_header" data-current="index"
		data-logo-url="https://i.h2.pdim.gs/bae905b5ccc183b82c00b445c5fb4c89.png">
	<div class="panda-header-container clearfix">
		<div class="panda-header">

			<div class="header-tab-container clearfix">
				<div id="panda_header_index" class="header-tab ">
					<a href="/LiveRoomWeb/index">首页</a>
				</div>
				<div id="panda_header_all_lives" class="header-tab">
					<a href="/LiveRoomWeb/roomlist/all">全部</a>
				</div>
				<div id="panda_header_go_sort" class="header-tab">
					<a href="https://www.panda.tv/cate">分类</a>
				</div>



			</div>

			<%
				if (session.getAttribute("username") == null) {
			%>
			<div class="header-tool-user-info">
				<a class="tool-user-info-login header-login-btn" href="/LiveRoomWeb/login">登录</a>
				<b>|</b> <a class="tool-user-info-regist header-register-btn"
					href="/LiveRoomWeb/register">注册</a>
			</div>
			<%
				} else {
					User user = (User) session.getAttribute("user");
					String username = user.getUsername();
			%>
			<div class="header-tool-user-info">
				<a class="tool-user-info-login header-login-btn" href="userInfo"><%=username%></a>
				<b>|</b> <a class="tool-user-info-regist header-register-btn"
					href="logout">注销</a>
			</div>
			<%
				}
			%>

			<div class="panda-search header-tool">
				<form name="room-search" action="/LiveRoomWeb/roomlist/search" method="post"
					target="_top" class="search-form">
					<input type="text" name="searchKey" value="搜房间号/主播"
						autocomplete="off" class="search-key search-default">
					<div class="search-submit-btn">
						<input type="submit" class="search-submit">
					</div>
				</form>
			</div>
		</div>
	</div>
	</header>
	<!-- header end -->
</body>
</html>