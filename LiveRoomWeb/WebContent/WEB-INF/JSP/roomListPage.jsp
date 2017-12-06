
<%@page import="com.niit.org.bean.Category"%>
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

<%
	List<LiveRoomDTO> roomList = (List<LiveRoomDTO>) session.getAttribute("roomList");
    List<Category> categoryList = (List<Category>) session.getAttribute("categoryList");
%>

<title>直播间列表</title>
<jsp:include page="StaticResources.jsp" />
</head>
<style>
	.video-list-item {
		width: 317px !important;
	}
	
	.video-list-item .video-img {
		height: 178px !important;
	}
	
	.video-highlight .video-hls {
		width: 782px !important;
		left: -68px !important;
	}
</style>
<body>

    <jsp:include page="NavigateHeader.jsp"/>
	<div class="pd-sc-container">
		<!-- side tools bar start -->
		<div id="side-tools-bar" class="pd-sc-sidebar">

			<div
				class="sidebar-container-next sidebar-add-events sidebar-no-login"
				style="display: block;">

				<div class="sidebar-expand">
					<!-- sidebar-head start -->
					<div class="sidebar-head">
						<br /> <br /> <br /> <br />
						<div class="sidebar-search">
							<div class="panda-search ">
								<form name="room-search" action="/LiveRoomWeb/roomlist/search"
									method="post" target="_top" class="search-form">
									<input type="text" name="searchKey" placeholder="搜房間號/主播" 
										autocomplete="off" class="search-key search-default">
									<div class="search-submit-btn" data-toggle="panda-monitor"
										data-paew="pc_web-all-sidebar_search">
										<input type="submit" class="search-submit">
									</div>
								</form>
							</div>
						</div>
						<!-- sidebar-events start -->

					</div>
					<!-- sidebar-head end -->
					<div
						class="sidebar-content ps-container ps-theme-default ps-active-y"
						data-ps-id="bc11d1ce-bde9-7b95-c9b1-c389a23ec2a8"
						style="bottom: 86px;">
						<!-- sidebar-entrance start -->
						<div class="sidebar-entrance">
							<a target="_top" class="sidebar-entrance-item curcate"
								data-cate="alllives" data-toggle="panda-monitor"
								data-paew="pc_web-all-sidebar_alllives"
								href="/LiveRoomWeb/roomlist/all"> <span class="icon alllives"></span>
								<span class="sidebar-entrance-name">全部直播</span>
							</a>

						</div>
						<!-- sidebar-entrance end -->

						<!-- sidebar-cates start -->
						<div class="sidebar-cates">
						
						    <%  for(Category category:categoryList){
						    	String categoryUrl="/LiveRoomWeb/roomlist/category/"+category.getCategoryname();
						    	%>
							<div class="sidebar-cate-item-1stlevel cate-jingji"
								data-cate="jingji">
								<div class="title" data-cate="jingji">
									<a target="_top" class="link"
										href="<%=categoryUrl%>" data-cate="jingji"
										data-toggle="panda-monitor"
										data-paew="pc_web-all-sidebar_cate1_jingji"><%=category.getCategoryname()%> </a> <span
										class="expand"> <i class="sidebar-icon"> </i> <span
										class="sidebar-expand"> 展开 </span>
									</span>
								</div>


							</div>
                            <%} %>
						</div>
						<!-- sidebar-cates end -->

						<div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;">
							<div class="ps-scrollbar-x" tabindex="0"
								style="left: 0px; width: 0px;"></div>
						</div>
						<div class="ps-scrollbar-y-rail"
							style="top: 0px; height: 672px; right: 0px;">
							<div class="ps-scrollbar-y" tabindex="0"
								style="top: 0px; height: 586px;"></div>
						</div>
					</div>

				</div>
				<div class="sidebar-collapse">
					<div class="sidebar-collapse-head">
						<a href="https://www.panda.tv/" target="_top"
							class="sidebar-icon-home"> </a>
					</div>


				</div>

			</div>



		</div>
		<!-- side tools bar end -->
		
		<div id="main-container" class="pd-sc-content"
			style="visibility: visible;">


            <%if(!roomList.isEmpty()){ %>
			<!-- 正在直播 start -->
			<div class="later-play-container">
				<!--房间列表start  -->
				<ul id="later-play-list" class="video-list clearfix"
					data-total="4165">

					<%
						for (LiveRoomDTO room : roomList) {
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
             <p style="font-size: 20px;text-align: center;margin-top: 25%;">没有找到合适的结果，建议您更换关键词试试</p>
            </div>
            
            <%} %>
		</div>
	</div>
		<style>
		.message{
		    min-width: 380px;
		    box-sizing: border-box;
		    border-width: 1px;
		    border-style: solid;
		    border-color: #e6ebf5;
		    position: fixed;
		    left: 50%;
		    top: 50px;
		    -webkit-transform: translateX(-50%);
		    transform: translateX(-50%);
		    background-color: #edf2fc;
		    -webkit-transition: opacity .3s,-webkit-transform .4s;
		    transition: opacity .3s,-webkit-transform .4s;
		    transition: opacity .3s,transform .4s;
		    transition: opacity .3s,transform .4s,-webkit-transform .4s;
		    padding: 15px 15px 15px 20px;
		    display: -webkit-box;
		    display: flex;
		    align-items: center;
		}
		.message-error{
		    background-color: #fee;
	    	border-color: #fedddd;
		}
		.message-content{
			margin:0;
		    padding: 0;
		    font-size: 14px;
		    line-height: 1;
		}
		.message-error .message-content{
			color:#fa5555;
		}
	   	.drop-enter-active, .drop-leave-active{
	      transition: all .3s;
	    }
	    .drop-enter, .drop-leave-to{
	    	transform: translate(0px,20px);
	    	opacity:1;
	    }
	</style>
	<transition name="drop">
		<div id="alert-2" class="message message-error" style="z-index:2000;" v-show="isShow">
			<p class="message-content">关键字不能为空哦！</p>
		</div>
	</transition>
	<script>	
		alert[2] = new Vue({
			el: "#alert-2",
			data:{
				duration:2000,
				timer:null,
				isShow:false
			},		
			methods: {
				show(){
					var me = this;
					clearInterval(this.timer);
					this.isShow = true;
					this.timer = setInterval(function(){
						me.hide();
					},this.duration)
				},
				hide(){
					this.isShow = false;
				}
				
			}
		})
	</script>

</body>
<script>
var oForm = document.forms[1];
// 表单提交判断
oForm.addEventListener("submit",function(event){
	var content = oForm.searchKey.value;
	event = event || window.event;
	if(!(content && content.length > 0)) {
		window.alert[2].show();
		event.preventDefault();
	}
})

</script>
</html>