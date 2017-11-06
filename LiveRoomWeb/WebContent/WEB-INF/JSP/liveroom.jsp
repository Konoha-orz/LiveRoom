<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet"/>
<link rel="stylesheet"  href="css/liveroom.css"/>
<link href="css/videojs.css" rel="stylesheet">
<script src="js/videojs.js"></script>
<link rel="stylesheet"  href="css/reset.css"/>
<link rel="stylesheet"  href="css/liveroom1.css"/>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/vue.js"></script>
<script src="js/jquery.danmu.min.js"></script>
<title>LiveRoom</title>    
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<!-- 左侧导航栏开始 -->
		<div class="nav left-nav b1 ">
			<div class="nav-header">
				<a href="#"><img src="images/6.jpg" /></a>
			</div>
			<div class="nav-search">
				<div class="nav-search-wrapper">
				<input type="text" class="search-input" placeholder="输入关键字"/>
				<i class="icon icon-search glyphicon glyphicon-search"></i>
				</div>
			</div>
			<div class="categories">
				<ul>
					<li>
						<a href="#" class="category-item">
							<span class="title">绝地求生</span>
						</a>
					</li>
					<li>
						<a href="#" class="category-item">
							<span class="title">英雄联盟</span>
						</a>
					</li>
					<li>
						<a href="#" class="category-item">
							<span class="title">王者荣耀</span>
						</a>
					</li>
					<li>
						<a href="#" class="category-item">
							<span class="title">饥荒</span>
						</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 左侧导航栏结束 -->
		<!-- 中间的视频播放区开始 -->
		<div class="main b2" id="liveroom">
			<div class="room-info">
				<div class="user-avatar">
					<a href="#"><img src="images/6.jpg" /> </a>
				</div>
				<div class="room-detail">
					<dl>
						<dt><h3>香港卫视</h3></dt>
						<dd><p>房间号：{{roomId}}   简介：海外的电视直播</p></dd>
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
<input type="hidden" name="roomId" value="${sessionScope.roomId}" />
<script>
var chatroom = new Vue({
    el: '#chatroom',
    data: {
    	numbers: 0,
    	messages: [],
    	messageinput:"",
    	socketClient:null,
        danmu: null,
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
            };
            this.socketClient.onmessage = function (message) {
                // 你登陆之后
                data=JSON.parse(message.data);
                chatroom.roomId = data.roomId;
                chatroom.numbers=data.roomNumbers;
                console.log(this.numbers)
                chatroom.messages.push({
                    creator: data.creator,
                    msgBody: data.msgBody
                });
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
                this.messageinput = "";
            } else if (chatroom.messageinput === "") {
                chatroom.messageinput = "请输入内容!!!";
            }
        },
    },
    watch: {
    	roomId(newVal) {
    		window.liveroom.roomId=newVal;
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
        roomId:0,
	},
	methods:{
		videoInit: function(){
        	this.videoPlayer = videojs('v-player', {
                //初始化数据
                height: '439px',
                width: '640px',
                "techOrder": ["html5", "flash"],
                controls: true,
                "autoplay": true,
                sources: [{
                    /*rtmp://live.hkstv.hk.lxdns.com/live/hks*/
                    //src:'rtmp://rlive.jia.360.cn/live_camera/36054700726',
                    src: 'rtmp://live.hkstv.hk.lxdns.com/live/hks',
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
		this.videoInit();
	}
})
</script>
</body>
</html>