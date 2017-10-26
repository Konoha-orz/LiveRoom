<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>直播房间</title>
    <link href="css/videojs.css" rel="stylesheet">
    <script src="js/videojs.js"></script>
    <!--<script src="http://vjs.zencdn.net/ie8/1.1.1/videojs-ie8.min.js"></script>-->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link rel="stylesheet"  href="css/liveroom.css"/>
    <link rel="stylesheet"  href="css/dialog.css"/>
    <!--<script src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.min.js"></script>-->
    <!--<script src="http://cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>-->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/vue.js"></script>
    <script src="js/jquery.danmu.min.js"></script>

    <style>
        .login-inside {
            position: absolute;
            z-index: 2;
            height: 34px;
            line-height: 34px;
            padding-left: 13px;
        }
    </style>
</head>
<body>
<!--/*@thymesVar id="online_guests" /-->
<!--/*@thymesVar id="history_guests" */-->
<%@ include file="header.jsp" %>
<div class="container" id="chatroom" ref="chatroom">
    <div class="row">
    <p style="float:left;">当前房间号：<c:out value="${sessionScope.roomId}"/></p>
    </div>
    <div class="row">
        <div class="col-md-12" style="margin-bottom: 10px;">
            <!--æ é¢åºå-->
            <div class="col-md-8" style="height: 80px;padding-left: 0px;background-color: #47d5af;">
                <div>
                    <img class="img-responsive" style="width: 80px;height:80px; float: left;"
                         src="images/haha.gif" alt="">
                    <button class="btn btn-default pull-right" style="background-color: #47d5af" onclick="changeSrc()">
                        	开通直播间 
                    </button>
                    <h3 style="margin-left: 15px;margin-top: 10px; float: left;">直播间demo(移动端、电脑端、安卓客户端)</h3>
                </div>
            </div>
            <!--公告区域-->
            <div class="col-md-4" style="height: 80px; background-color: #47d5af;">
                <h3 class="anchorNotice" style="margin-top: 0px; float: left;"><i class="fa fa-bell"
                                                                                  aria-hidden="true"></i>主播公告</h3>
                <div style="padding: 10px;">功能:1.直播推流(rtmp)。2:本页面拉流(电脑端拉取rtmp,手机端拉取hls)。3:聊天室。4:弹幕系统。5.数据统计。</div>
                <p></p>
            </div>
        </div>
 <!-- 左侧栏目开始-->
        <div class="col-md-8">
            <div style="position:relative; background-color: black ; height: 439px; width: 100%;">
                <div id="danmu" style=""></div>
                <video id="v-player"
                       class="video-js col-center-block">
                    <!--<source src="rtmp://live.hkstv.hk.lxdns.com/live/hks"  type="rtmp/flv"></source>-->
                </video>
            </div>
        </div>
        <!--左侧栏目结束-->
        <!--右侧讨论区开始-->
        <div class="col-md-4">
            <!--tabs-->
            <ul id="menuTabs" class="nav nav-pills nav-justified">
                <li class="active">
                    <a href="#discussion" data-toggle="tab"><i class="fa fa-tree"></i>互动聊天({{numbers}})</a>
                </li>
                <li>
                    <a href="#members" data-toggle="tab"><i class="fa fa-tree"></i>现场嘉宾({{numbers}})</a>
                </li>
                <li>
                    <a href="#guests" data-toggle="tab"><i class="fa fa-tree"></i>最近访问</a>
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
                <!--最近访问统计总数-->
                <div class="tab-pane fade in" style="padding-top: 10px;" id="guests" style="padding:10px;">
                	<c:forEach items="${online_guests}" var="user">
                		<span style="color: cornflowerblue;">
                			<c:out value="${user.randomName}"/>
                		</span>
                	</c:forEach>
                    <div th:each="guest : ${history_guests}">
                    	<c:forEach var="guest" items="${history_guests}">
	                    	<span style="color: cornflowerblue;">
	                    		<c:out value="${guest.userEntity.randomName}"/>
	                    	</span>
	                        <span>
	                        	<c:out value="${guest.userEntity.ip}"/>
	                        </span>
	                        <span>
	                       	 <c:out value="${guest.accessTime}"/>
	                        </span>
                    	</c:forEach>
                    </div>
                </div>
            </div>
            <div id="chatinput" class="input-group" style="margin-top: 5px;width: 100%;">
                <c:choose>
				    <c:when test="${sessionScope.username!=null}" >
				       <input type="text" class="form-control" v-model="messageinput"
                       @keyup.13="sendMessage"
                       placeholder="参与话题讨论">
                       <span class="input-group-btn">
				        	<button class="btn btn-success" type="button" @click="sendMessage">发送!</button>
                		</span>
				    </c:when>
				    <c:otherwise>
                		<p class="login-inside"><a href="/LiveRoomWeb/login">登录</a>才能观看加入直播间
				    </c:otherwise>
				</c:choose>
            </div>
        </div>
        <!--右侧讨论区结束-->
    </div>
</div>
<%@ include file="footer.jsp" %>
<!-- 遮罩层 -->
<div class="dialog-wrapper" v-show="!isClose" ref="dialog">
    <div class="dialog dialog-small">
        <div class="dialog-header">
            <span class="dialog-title">登陆</span>
            <button class="dialog-headerbtn" @click="close">关闭</button>
        </div>
        <div class="dialog-body">
            <form action="">
                <div class="form-item">
                    <label class="form-label" for="username">昵称：</label>
                    <div class="form-item-content">
                        <input type="text" name="username" id="username" v-model="username" class="form-input" :placeholder="tips"
                               maxlength="14" required="required"/>
                    </div>
                </div>
            </form>
        </div>
        <div class="dialog-footer-wrapper" style="display:none;">
            <div class="dialog-footer">
                <button class="disabled btn btn-default btn-cancel">取消</button>
                <button class="btn btn-success btn-ok" @click="submit">确定</button>
            </div>
        </div>
    </div>
</div>
<input type="hidden" name="roomId" value="${sessionScope.roomId}">
<script>
    var dialog = new Vue({
        el: document.querySelector(".dialog-wrapper"),
        data: {
            username: "",
            tips: "请输入用户名",
            isClose:true
        },
        methods: {
            submit: function () {
                // 确认操作，关闭遮罩层
            },
            close: function () {
            	// 遮罩层关闭
            },
            sendRequest: function () {
                // 使用ajax发送请求
            }
        }
    });
    var chatroom = new Vue({
        el: '#chatroom',
        data: {
            socketClient: null,
            messages: [],
            messageinput: "",
            rtmpSource: null,
            videoPlayer: null,
            numbers: 0,
            danmu: null,
            username:"guest",
            roomId:document.querySelector("input[name=roomId]").value || 0,
            danmuColor: ['#666666', 'blue', 'white', 'red', 'pink'],
            webSocketUrl:"",
        },
        methods: {
            login:function () {
            	//登录
            },
            logout:function () {
				// 登出
            },
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
        mounted: function () {
            //设置webSocketUrl
            this.webSocketUrl="ws://localhost:8080/LiveRoomWeb/webSocket/"+this.roomId;
        	//聊天室初始化
            this.connectToSocket()
            //视频初始化
            this.videoInit()
        }
    });

    function changeSrc() {
        alert("请使用推流软件(OBS等)，推送到rtmp://139.199.82.213/live/demo,即可在本直播间看到您的直播内容!")
        chatroom.videoPlayer.src('rtmp://139.199.82.213/live/demo')
        chatroom.videoPlayer.load('rtmp://139.199.82.213/live/demo');
        chatroom.videoPlayer.play()
    }
</script>

</body>
</html>