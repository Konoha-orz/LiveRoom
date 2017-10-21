<%@ page language="java" contentType="text/html; charset=utf-8"

    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Index</title>

</head>

<body>

	<h1 style="text-align:center;color:red">Index</h1>
	<p>

		The account name:${account.username }

		<br />

		The account password:${account.password }

	</p>
	
	<div>
	 <c:forEach items="${rolelist}" var="role">
	 
	 <p> Id: ${role.id}  RoleName:${role.role_name }  Des: ${role.description}</p>
	 
	 </c:forEach>
	 ${role1.id }     
	 ${role1.description}
	 
	 
	 
	 
	 
	 ${role1.role_name}
	 
	 
	</div>
	
	
	<br/>
	<h1>插入数据：</h1>
	<div>
	<form action="insert" method="post">
	<table>
	<tr>
	<td>RoleName:</td>
	<td><input type="text" name="rolename" /></td>
	</tr>
	<tr>
	<td>Description:</td>
	<td><input type="text" name="des" /></td>
	</tr>
	</table>
	<input type="submit" value="提交"/>
	</form>
	
	</div>
	
</body>

</html>