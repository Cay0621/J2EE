<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List All Users</title>
<style type="text/css">
	table{
		border:1px solid black;
		width:50%;
		border-collapse: 0;
	border-spacing: 0;
	}
	tr, td{
		text-align:center;
		
	}
	td{
		
	}
</style>
</head>
<body>
	<table border="1">
		<caption>UserList</caption>
		<thead>
			<tr>
				<td>姓名</td>
				<td>密码</td>
				<td>年龄</td>
				<td>生日</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users }" var="user">
				<tr>
					<td><c:out value="${user.username }"></c:out></td>
					<td><c:out value="${user.password }"></c:out></td>
					<td><c:out value="${user.age }"></c:out></td>
					<td><c:out value="${user.birthday }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>