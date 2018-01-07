<%@page import="com.niit.org.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%User user=(User)session.getAttribute("user");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>

<jsp:include page="StaticResource.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>nav</title>

</head>
<body>

<jsp:include page="NavigateHeader.jsp"/>
	<div class="nav">

		<div class="nav_photo">
			<img src="<%=request.getContextPath() %>/images/photo.jpg" width="100px" height="100px"/>
		</div>

		<div class="nav_name">
			<p style="color:#fff;">
			<%=session.getAttribute("msg").toString()%> 
			<%=session.getAttribute("logout").toString()%>
			</p>
		</div>
		<ul>
			<li style="border-width:1px 0px 0px 0px"><a href="/LiveRoomWeb/user/userInfo" target="_parent">个人信息</a></li>
			<li><a href="/LiveRoomWeb/updateUserInfo" target="_parent">修改信息</a></li>
			<li><a href="/LiveRoomWeb/resetPassword/userUpdate" target="_parent">修改密码</a></li>
			<li><a href="/LiveRoomWeb/mycollect/<%=user.getId()%>" target="_parent">我的订阅</a></li>
			<li style="border-width:1px 0px 1px 0px"><a href="/LiveRoomWeb/createLiveroom" target="_parent">我的直播间</a></li>

		</ul>
	</div>
</body>
</html>
