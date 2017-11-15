
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.niit.org.dto.LiveRoomDTO"%>
<%@page import="com.niit.org.bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-cmn-Hans">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1">

<% List<LiveRoomDTO> roolist=(List<LiveRoomDTO>)session.getAttribute("roomlist"); %>

<title>直播间列表</title>

<link rel="stylesheet" href="css/d4e0488237db533e.css">
<link rel="stylesheet" href="css/ruc_v1.1.5.css">
<link rel="stylesheet" href="css/fc9e619cd23e8c28.css">
<link rel="stylesheet" href="css/596c2be88ac9a5a0.css">
<link rel="stylesheet" href="css/93c97f35e37e6edb.css">
<link rel="stylesheet" href="css/level-style.css">
<script src="js/da870659adfe1ddc.js"></script>
<script src="js/hm.js"></script>
<script src="js/ff7cbc1b3b59cc0a.js"></script>
<link href="css/videojs.css" rel="stylesheet">
<script src="js/video.js"></script>
<script src="js/vue.js"></script>

</head>

<body>
        <%for(LiveRoomDTO room:roolist){  String url= "liveroom/"+room.getId();           %>
        
        <H><%=room.getId() %>|<%=room.getTitle() %>|<%=room.getUsername() %></H>
        <br/>
        <%}%>
                            
</body>
</html>