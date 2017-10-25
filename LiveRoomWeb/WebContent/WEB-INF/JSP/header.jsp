<%@ page language="java" contentType="text/html; charset=utf-8"

    pageEncoding="utf-8"%>
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet"/>
<link rel="stylesheet"  href="css/header.css"/>
<style>
*{
	margin:0;
	padding:0;
}
header{
	height:50px;
	background:#fff;
	width:100%;
}
.header-logo{
    float: left;
    position: relative;
    width: 80px;
    height: 46px;
    top: 5px;
}
.header-logo a {
    display: block;
    width: 100%;
    height: 100%;
}
.header-logo img {
    width: 100%;
    height: 100%;
}
.header-nav{
	float:right;
	overflow:hidden;
}
.search-wrapper{
    position: relative;
    font-size: 14px;
    display: inline-block;
    width:180px;
    float:left;
    line-height: 50px;
    margin-right:50px;
}
.search-wrapper .search-icon{
    position: absolute;
    width: 35px;
    height: 100%;
    right: 0;
    top: 0;
    text-align: center;
    color: #bfcbd9;
    transition: all .3s;
    line-height: 50px;
}
.search-wrapper .search-input{
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    background-color: #fff;
    background-image: none;
    border-radius: 4px;
    border: 1px solid #bfcbd9;
    box-sizing: border-box;
    color: #1f2d3d;
    display: inline-block;
    font-size: inherit;
    height: 36px;
    line-height: 1;
    outline: none;
    padding: 3px 10px;
    transition: border-color .2s cubic-bezier(.645,.045,.355,1);
    width: 100%;
}
</style>
<!-- 头部开始 -->
<header class="navbar navbar-default">
    <div class="container">
        <div class="header-logo">
        	<a href="javascript:void(0)"><img src="images/6.jpg" /></a>
        </div>
        <nav class="header-nav">
        	<div class="search-wrapper">
        		<i class="search-icon glyphicon glyphicon-search"></i>
        		<input class="search-input" autocomplete="off" placeholder="请输入直播间号码" />
        	</div>
            <ul class="nav navbar-nav">
            	<c:choose>
				    <c:when test="${session.username}!=null">
				        <li class="active"><a href="#">${session.username}</a></li>
				    </c:when>
				    <c:otherwise>
				        <li class="active"><a href="/LiveRoomWeb/login">登录</a></li>
                		<li class="active"><a href="/LiveRoomWeb/register">注册</a></li>
				    </c:otherwise>
				</c:choose>
                <li class="active"><a href="#">开通直播间</a></li>
            </ul>
        </nav>
    </div>
</header>
<!--头部结束 -->