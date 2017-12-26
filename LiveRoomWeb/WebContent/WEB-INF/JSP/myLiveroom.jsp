<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/nav.css" />
<link rel="stylesheet" type="text/css" href="css/teemocss.css" />
<link rel="shortcut icon" href="images/favicon.ico" />
<meta name="viewport" content="width=device-width">


<title>我的直播间</title>
</head>

<body>

	<div class="div_nav">

		<iframe src="nav" frameborder="0" scrolling="no" height="800px"></iframe>
	</div>

	<div class="div_main">
	<div style="padding-top:20px" class="smart-green">
		<h1>我的直播间</h1>
		<form action="createLiveroom" name="createLiveroom" method="post">
		<label for="title">直播间标题</label><input type="text" id="title" name="title" autofocus="autofocus" value="${title }"/><br />
		<label for="dscp">直播间描述</label><input type="text" id="dscp" name="dscp"  value="${dscp}"/><br />
		<label for="categoryname">直播分类</label>
		<select name="categoryname" id="sel">
			<option value="-1">请选择</option>
			<c:forEach items="${categoryList}" var="cl">
				<option value="${cl.categoryname}">${cl.categoryname}</option>
			</c:forEach>
		</select><br />
		<!-- <label for="rtmpuel">推流地址</label><input type="text" id="rtmpurl" name="rtmpurl" /><br /> -->
		<input class="button" type="submit" value="开始直播" />
		</form>
		</div>
	</div>
	
	<script type="text/javascript">
		function change(){
			document.getElementById("sel").
		}
	</script>
</body>
</html>