<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	/*所有标签*/
	/* *{
		margin: 1px;
		padding: 1px;
	} */
	
	.main{
		margin-left: 5px;
		margin-top: 5px;
	}
	
	.caption{
		font-size: 25px;
		color: #FF0000;
		font-weight: bold;
	}
	thead{
		background-color: #E1283E;
	}
	
	td{
		text-align: center;
		width: 150px;
		line-height: 25px;
	}
	
</style>
</head>
<body>
	<div class="main">
	<input name="addPerson" type="button" value="添加"/> 		
	<table border="1" cellpadding="0" cellspacing="0" class="tb">
		<caption class="caption">用户列表</caption>
		<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号</th>
				<th>手机号</th>
				<th>地址</th>
				<th colspan="2" width="100px">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${persons }" var="person">
				<tr>
					<td><c:out value="${person.name }"></c:out></td>
					<td><c:out value="${person.idCard }"></c:out></td>
					<td><c:out value="${person.phone }"></c:out></td>
					<td><c:out value="${person.address }"></c:out></td>
					<td><a href="updatePrompt?id=${person.id}">修改</a></td>
					<td><a href="deletePersonById?id=${person.id }" onclick="javascript:return confirm('确定要删除吗？');">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>