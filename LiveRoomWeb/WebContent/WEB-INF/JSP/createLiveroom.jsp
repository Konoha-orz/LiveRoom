<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form>
<p>Create Liveroom..</p>
<select name="user">
<option value="-1">请选择</option>
<c:forEach items="${userList}" var="ul">
<option value="${ul.username}">${ul.username}</option>
</c:forEach>
</select>
</form>
</body>
</html>