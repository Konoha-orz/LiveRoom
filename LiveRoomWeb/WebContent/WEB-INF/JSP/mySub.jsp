<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="StaticResource.jsp"/>
<meta name="viewport" content="width=device-width">


<title>我的订阅</title>
</head>
<body>
<div class="big_div">

<div class="div_nav">
		<jsp:include page="nav.jsp" />
	</div>
	<div class="div_main">
	<div style="padding-top:20px">
						<h1 style="padding-left:250px">我的订阅</h1>
		<table>
			<c:forEach items="${SubLiveroomList}" var="sll">
				<tr <c:if test="${sll.status==1}">style="color:green"</c:if>>
					<td width="200px" height="60px">房间标题：${sll.title}  </td>
					<td width="200px" height="60px">房间描述：${sll.dscp}  </td>
					<td width="200px" height="60px">房间类型：${sll.categoryname}  </td>
					<td width="200px" height="60px">主播：${sll.username}  </td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
	</div>
</body>
</html>