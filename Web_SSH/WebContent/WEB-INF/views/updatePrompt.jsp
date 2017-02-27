<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updatePerson" method="post">
		<input type="hidden" name="id" value="${person.id }" />
		<table>
			<tr>
				<td>姓名</td>
				<td><input name="name" value="${person.name }"/></td>
			</tr>
			<tr>
				<td>身份证号</td>
				<td><input name="idCard" value="${person.idCard }"/></td>
			</tr>
			<tr>
				<td>手机号</td>
				<td><input name="phone" value="${person.phone }"/></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input name="address" value="${person.address }"/></td>
			</tr>
		</table>
		<input type="submit" value="保存" />
	</form>
</body>
</html>