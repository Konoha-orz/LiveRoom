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
<link rel="stylesheet" href="<%=context%>/css/navigate-header.css">
<script src="<%=context%>/js/da870659adfe1ddc.js"></script>
<script src="<%=context%>/js/hm.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
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

<script>
(function(){
	//查看全部分类
	$.ajax({
		type:'get',
		url:'/LiveRoomWeb/category/all',
		dataType:"json"
	}).done(function(res) {
		var oSelect = $("#go_sort_select .sort-body"),htmlTemplate="";
		if(!(res && res.length> 0)) return;
		res.forEach(function(item){
			htmlTemplate += '<a class="tag-item tag-info text-break" href="/LiveRoomWeb/roomlist/category/'+item.categoryname+'">'+item.categoryname+'</a>';		
		})
		oSelect.append(htmlTemplate);
	}).fail(function(err) {
		var oSelect = $("#go_sort_select .sort-body"),
		htmlTemplate = '<h3 class="no-data-tip">暂无数据</h3>';
		oSelect.append(htmlTemplate);
		console.log(err)
	})
})()
</script>
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
					<a href="javascript:;">分类</a>
					<div id="go_sort_select" style="display:none;">
						<i></i>
						<div class="sort-header"><p>直播分类</p></div>	
						<div class="sort-body"></div>
					</div>
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
					<input type="text" name="searchKey" placeholder="搜房间号/主播"
						autocomplete="off" class="search-key search-default">
					<div class="search-submit-btn">
						<input type="submit" class="search-submit">
					</div>
				</form>
			</div>
		</div>
	</div>
	</header>
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
	<div id="alert-1" class="message message-error" style="z-index:2000;" v-show="isShow">
		<p class="message-content">关键字不能为空哦！</p>
	</div>
</transition>
<script>	
	var alert =[];
	alert[1] = new Vue({
		el: "#alert-1",
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
	<!-- header end -->
</body>
<script>
var oSort = $("#panda_header_go_sort").children('a');
var oMenu = $("#go_sort_select");
var oForm = document.forms['room-search'];

oSort.on('click',function(){
	oMenu.fadeToggle(500);
})

// 表单提交判断
oForm.addEventListener("submit",function(event){
	var content = oForm.searchKey.value;
	event = event || window.event;
	if(!(content && content.length > 0)) {		
		window.alert[1].show();
		event.preventDefault();
	}
})

</script>
</html>