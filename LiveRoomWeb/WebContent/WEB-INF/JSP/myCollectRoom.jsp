<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="com.niit.org.bean.Category"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.niit.org.dto.LiveRoomDTO"%>
<%@page import="com.niit.org.bean.User"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String context = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-cmn-Hans">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="<%=context %>/js/vue.js"></script>
<script src="<%=context %>/js/toast.js"></script>
<link rel="stylesheet"  href="<%=context %>/css/toast.css"/>

<jsp:include page="StaticResource.jsp"/>
<title>更新用户个人信息</title>
<%
	List<LiveRoomDTO> collectList = (List<LiveRoomDTO>) session.getAttribute("collectList");
    
%>
</head>

<body>
<jsp:include page="NavigateHeader.jsp"/>
<div class="big_div">
 <div class="div_nav">
	<jsp:include page="nav.jsp" />
</div> 

<div class="div_main">
	

			<div class="smart-green" id="login">

				<div class="pd-sc-container">
		
		
		<div >



            <%if(!collectList.isEmpty()){ %>
			<!-- 正在直播 start -->
			<div class="later-play-container">
				<!--房间列表start  -->
				<ul id="later-play-list" class="video-list clearfix"
					data-total="4165">

					<%
						for (LiveRoomDTO room : collectList) {
							String url = "/LiveRoomWeb/liveroom/" + room.getId();
					%>
					<li class="video-list-item video-no-tag  " data-id="821335">
					<a  href="<%=url%>" class="video-list-item-wrap" data-id="821335">
							<div class="video-cover">
								<img class="video-img video-img-lazy"
									data-original="https://i.h2.pdim.gs/90/e1cecbf68656f84ad830e1314a439dd8/w338/h190.webp"
									alt="<%=room.getDscp()%>" src="css/h190.webp"
									style="display: block;" >
								<div class="video-overlay"></div>
								<div class="video-play"></div>

							</div>
							<div class="video-info">
								<span class="video-title" title="<%=room.getTitle()%>"><%=room.getTitle()%></span>
								<span class="video-nickname" title="<%=room.getUsername()%>"><%=room.getUsername()%>
								</span> <span class="video-number"><%=room.getId()%></span> <span
									class="video-station-info"> <i class="video-station-num">11人</i>
								</span>
							</div>
					</a>
						<div class="video-label"></div></li>
					<%
						}
					%>
				</ul>
				<!--房间列表end  -->

			</div>
			<!-- 正在直播 end -->
            <%}else{ %>
            <div class="empty-msg">
             <p style="font-size: 20px;text-align: center;margin-top: 25%;">您还没有收藏</p>
            </div>
            
            <%} %>
		</div>
	</div>
			</div>

</div>
</div>

</body>
</html>