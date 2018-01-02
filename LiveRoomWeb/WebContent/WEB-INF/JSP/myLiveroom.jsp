<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="StaticResource.jsp"/>
<meta name="viewport" content="width=device-width">


<title>我的直播间</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
</head>

<body onload="change()">
<div class="big_div">

	<div class="div_nav">
		<jsp:include page="nav.jsp" />
	</div>

	<div class="div_main">
		<div style="padding-top: 20px" class="smart-green">
			<h1>我的直播间</h1>
			<form action="myLiveroom" name="myLiveroom" method="post">
				<label for="title">直播间标题</label><input type="text" id="title"
					name="title" autofocus="autofocus" value="${liveRoom.title }" /><br /> <label
					for="dscp">直播间描述</label><input type="text" id="dscp" name="dscp"
					value="${liveRoom.dscp}" /><br /> <label for="categoryname">直播分类</label> <select
					name="categoryname" id="sel">
					<c:forEach items="${categoryList}" var="cl">
						<option value="${cl.categoryname}">${cl.categoryname}</option>
					</c:forEach>
				</select><br /> <label for="rtmpurl">推流地址</label><input type="text"
					id="rtmpurl" name="rtmpurl" value="${liveRoom.rtmpurl}" /><br /> <label
					for="seriescode">推流名称</label><input type="text" id="seriescode"
					name="seriescode" value="${liveRoom.seriescode}" /><br /> <input
					class="button" type="submit" value="保存修改" />
			</form>


			<label for="status" style="font-size: 18px;">直播间状态</label><label
				id="status" style="font-size: 18px; color: blue;"> </label> <input
				class="button" type="submit" id="switch" value=""
				onclick="changestatus()" />


		</div>



	</div>
</div>
	<script type="text/javascript">
		function change(){
			var s=document.getElementById('sel');
			var categoryname= "<%=session.getAttribute("categoryname") %>";
			for(var i=0;i<s.options.length;i++){
				if(s.options[i].value == categoryname){
					s.options[i].selected= true;
					isExit = true;
					break;
				}
			}
			var status = "<%=session.getAttribute("status")%>";
			if(status == "0"){
				 document.getElementById('status').innerHTML="直播间已关闭";
				 document.getElementById('switch').value="开启直播";
			}else{
				document.getElementById('status').innerHTML="正在直播";
				document.getElementById('switch').value="关闭直播";
			}
		}
		 function changestatus(){
				$.ajax({
					type:"post",
					url:"<%=request.getContextPath() %>/myLiveroom/changestatus",
				success : function(r) {
					if (r == "open") {
						document.getElementById('status').innerHTML = "正在直播";
						document.getElementById('switch').value = "关闭直播";
					}
					if (r == "close") {
						document.getElementById('status').innerHTML = "直播间已关闭";
						document.getElementById('switch').value = "开启直播";
					}

				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					console.log(XMLHttpRequest.status);
					console.log(XMLHttpRequest.readyState);
					console.log(textStatus);
				}
			});
		}
	</script>
	
</body>
</html>