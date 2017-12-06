<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.niit.org.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=utf-8"

    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%String context=request.getContextPath();%>
<html>

<head>

<link href="<%=context %>/css/bootstrap.css" rel="stylesheet"/>
<link rel="stylesheet"  href="<%=context %>/css/liveroom.css"/>
<link href="<%=context %>/css/videojs.css" rel="stylesheet">
<script src="<%=context %>/js/video.js"></script>
<link rel="stylesheet"  href="<%=context %>/css/reset.css"/>
<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/liveroom1.css"/>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="<%=context %>/js/bootstrap.js"></script>
<script src="<%=context %>/js/vue.js"></script>
<script src="<%=context %>/js/jquery.danmu.min.js"></script>
<title>LiveRoom</title>    

</head>
<%
	
    List<Category> categoryList = (List<Category>) session.getAttribute("categoryList");
%>
<body style="overflow: hidden;">



<div class="container">
<jsp:include page="NavigateHeader.jsp"/>
		<!-- 左侧导航栏开始 -->
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
									<input type="text" name="searchKey" value="搜房間號/主播" 
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
		<!-- 左侧导航栏结束 -->
	<div class="row clearfix">

		<!-- 中间的视频播放区开始 -->
		<div class="main b2" id="liveroom">
			<div class="room-info">
				<div class="user-avatar">
					<a href="#"><img src="<%=context %>/images/6.jpg" /> </a>
				</div>
				<div class="room-detail">
					<dl>
						<dt><h3>{{roomInfo.title}}</h3></dt>
						<dd><p>房间号：{{roomInfo.id}}   简介：{{roomInfo.dscp | defaultDscp}}</p></dd>
						<dd></dd>
					</dl>
					<button type="button" class="collect btn btn-default">订阅</button>
				</div>	
			</div>
			<div style="position:relative; background-color: black ; height: 439px; width: 100%;">

                <div id="danmu" style=""></div>

                <video id="v-player"

                       class="video-js col-center-block">

                    <!--<source src="rtmp://live.hkstv.hk.lxdns.com/live/hks"  type="rtmp/flv"></source>-->

                </video>

            </div>
			<p v-if="roomInfo.status===1">正在直播中</p>
			<p v-else>主播不在线</p>
		</div>
		<!-- 中间的视频播放区结束-->
		<!-- 右侧聊天室 -->
		<div class="chatroom b1" id="chatroom">
			 <ul id="menuTabs" class="nav nav-pills nav-justified">

                <li class="active">

                    <a href="#discussion" data-toggle="tab"><i class="fa fa-tree"></i>互动聊天({{numbers}})</a>

                </li>

                <li>

                    <a href="#members" data-toggle="tab"><i class="fa fa-tree"></i>现场嘉宾({{numbers}})</a>

                </li>

            </ul>

            <!--内容滚动区域开始-->

            <div id="tabContent" class="tab-content">

                <div class="tab-pane fade active in" id="discussion" style="padding:10px;">

                    <div v-for="message in messages">

                        <span style="color: cornflowerblue;">{{message.creator}}:</span>

                        <span>{{message.msgBody}}</span>

                    </div>

                </div>

                <!--内容滚动区域结束-->

                <!--现场观众统计开始-->

                <div class="tab-pane fade in" style="padding-top: 10px;" id="members" style="padding:10px;">

                	<c:forEach items="${online_guests}" var="user">

                		<span style="color: cornflowerblue;">

                			<c:out value="${user.randomName}"/>

                		</span>

                	</c:forEach>

                </div>

                <!--现场观众统计结束-->

                <!-- 发送消息开始 -->
                <div id="chatinput" class="input-group" style="margin-top: 5px;width: 100%;">
              		<input type="text" class="form-control" v-model="messageinput"

                       @keyup.13="sendMessage"

                       placeholder="参与话题讨论">

                       <span class="input-group-btn">

				        	<button class="btn btn-success" type="button" @click="sendMessage">发送!</button>

                		</span>


                </div>

                <!-- 发送消息结束  -->

            </div>

        </div>

		<!-- 右侧聊天室结束 -->
	</div>

</div>

<input type="hidden" name="roomId" value="${room_info.id}" />

<script>

var chatroom = new Vue({
    el: '#chatroom',
    data: {
    	numbers: 0,
    	messages: [],
    	messageinput:"",
    	socketClient:null,
        danmuArr: [],
        beginTime:Date.now(),
        username:"guest",
        roomId:document.querySelector("input[name=roomId]").value || 0,
        danmuColor: ['#666666', 'blue', 'white', 'red', 'pink'],
        webSocketUrl:"",
    },
    methods: {
    	connectToSocket: function () {
            this.socketClient = new WebSocket(this.webSocketUrl);
            this.socketClient.onopen = function (frame) {
                chatroom.messages.push({
                    creator: '系统消息',
                    msgBody: '连接成功！'
                })

                $("danmu").danmu({
                	height: 360,  //弹幕区高度
                	width: 640,   //弹幕区宽度
                	zindex :100,   //弹幕区域z-index属性
                	speed:7000,      //滚动弹幕的默认速度，这是数值值得是弹幕滚过每672像素所需要的时间（毫秒）
                	sumTime:65535,   //弹幕流的总时间
                	danmuLoop:false,   //是否循环播放弹幕
                	defaultFontColor:"#FFFFFF",   //弹幕的默认颜色
                	fontSizeSmall:16,     //小弹幕的字号大小
                	FontSizeBig:24,       //大弹幕的字号大小
                	opacity:"0.9",			//默认弹幕透明度
                	topBottonDanmuTime:6000,   // 顶部底部弹幕持续时间（毫秒）
                	SubtitleProtection:false,     //是否字幕保护
                	positionOptimize:false,         //是否位置优化，位置优化是指像AB站那样弹幕主要漂浮于区域上半部分

                	maxCountInScreen: 100,   //屏幕上的最大的显示弹幕数目,弹幕数量过多时,优先加载最新的。
                	maxCountPerSec: 100      //每分秒钟最多的弹幕数目,弹幕数量过多时,优先加载最新的。
                	});
                chatroom.beginTime = Date.now()
                $('#danmu').danmu('danmuStart');
            };
            this.socketClient.onmessage = function (message) {
                // 你登陆之后
                data=JSON.parse(message.data);
                chatroom.roomId = data.roomId;
                chatroom.numbers = data.roomNumbers;
                chatroom.messages.push({
                    creator: data.creator,
                    msgBody: data.msgBody
                });
                if (data.msgBody && data.msgBody!=="") {
                	let time = parseInt((Date.now() - chatroom.beginTime)/100); 
                	var obj = { text:data.msgBody ,color:"white",size:1,position:0,time:time}
                	chatroom.danmuArr.push(obj);
                    $('#danmu').danmu("addDanmu",chatroom.danmuArr) 
                }
            };
            // 连接出错触发
            this.socketClient.onerror = function () {
                console.log("websocket connect error");
            };
            //连接关闭触发
            this.socketClient.onclose = function (message) {
                console.log("websocket connect close");
            }
            //when browser window closed, close the socket, to prevent server exception
            // 浏览器关闭触发
            window.onbeforeunload = function () {
                chatroom.socketClient.close();

            }

        },

        sendMessage: function () {
            if (chatroom.messageinput != "") {
                this.socketClient.send(chatroom.messageinput)
                // 自己发送信息不发送弹幕，服务器返回消息时会发送给聊天室的所有人。
                this.messageinput = "";
            } else if (chatroom.messageinput === "") {
                chatroom.messageinput = "请输入内容!!!";
            }
        }
    },
    mounted: function () {
        //设置webSocketUrl
        var basePath="<%="ws://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/webSocket/" %>"
        this.webSocketUrl=basePath+this.roomId;
    	//聊天室初始化
        this.connectToSocket()
    }

});
var liveroom = new Vue({
	el: "#liveroom",
	data: {
        rtmpSource: null,
        videoPlayer: null,
        roomInfo: {
        	id: 0,
        	title:"",
        	dscp:"",
        	rtmpurl:"",
        	categoryname:"",
        	seriescode:"",
        	status:""
        }
	},
	filters: {  
	    defaultDscp: function (value) {
	      var defaultValue = "暂无简介"
	      return value || defaultValue;
	    }  
	}, 
	methods:{
		getRoomInfo:function(){
            this.roomInfo.id = ${room_info.id};
            this.roomInfo.title = "${room_info.title}";
            this.roomInfo.dscp = "${room_info.dscp}";
            this.roomInfo.rtmpurl = "${room_info.rtmpurl}";
            this.roomInfo.seriescode = ${room_info.seriescode};
            this.rtmpSource = this.roomInfo.rtmpurl+"/"+this.roomInfo.seriescode;
		},
		videoInit: function(){
			let me = this
        	this.videoPlayer = videojs('v-player', {
                //初始化数据
                height: '439px',
                width: '640px',
                "techOrder": ["html5", "flash"],
                controls: true,
                "autoplay": true,
                sources: [{
                    /*rtmp://live.hkstv.hk.lxdns.com/live/hks*/
                    src: me.rtmpSource,
                    //src: 'rtmp://live.hkstv.hk.lxdns.com/live/hks',
                    type: 'rtmp/flv'
                }]
            },
            function () {
                this.on('loadeddata', function () {
                    console.log(this)
                })
                this.on('pause', function () {
                    //alert('pause')
                })
            })
        }
	},
	mounted() {
		this.getRoomInfo();
		this.videoInit();
	}
})

</script>


</body>

</html>