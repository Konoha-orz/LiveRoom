<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>

<link rel="stylesheet" type="text/css" href="css/nav.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>nav</title>

</head>
<body>
	<div class="nav">

		<div class="nav_photo">
			<img src="images/photo.jpg" width="100px" height="100px"
				float="center" />
		</div>

		<div class="nav_name">
			<p><%=session.getAttribute("msg").toString()%></p>
			<p><%=session.getAttribute("logout").toString()%></p>
		</div>
		<ul>
			<li><a href="http://localhost:8080/LiveRoomWeb/userInfo" target="_parent">个人信息</a></li>
			<li><a href="http://localhost:8080/LiveRoomWeb/updateUserInfo" target="_parent">修改信息</a></li>
			<li><a href="http://localhost:8080/LiveRoomWeb/mySub" target="_parent">我的订阅</a></li>
			<li><a href="http://localhost:8080/LiveRoomWeb/createLiveroom" target="_parent">我的直播间</a></li>

		</ul>

	</div>
</body>
</html>