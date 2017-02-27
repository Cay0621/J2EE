<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<jsp:useBean id="user" scope="session" class="entity.User"></jsp:useBean>
		<table cellpadding="0" cellspacing="0" border="1" align="center">
			<caption>用户信息</caption>
			<tr>
				<td width="100">用户名</td>
				<td width="200">&nbsp;<jsp:getProperty property="username" name="user"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td>&nbsp;<jsp:getProperty property="password" name="user"/> </td>
			</tr>
			<tr>
				<td>性别</td>
				<td>&nbsp;<jsp:getProperty property="gender" name="user"/> </td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td>&nbsp;
					<%
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String birthday = sdf.format(user.getBirthday());
					%>
					<%=birthday %>
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td>&nbsp;<jsp:getProperty property="email" name="user"/> </td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>
					<%
						String[] hobbies = user.getHobbies();
						for(String hobby : hobbies){
					%>
						<%=hobby %>&nbsp;
					<%		
						}
					%>
				</td>
			</tr>
			<tr>
				<td>自我介绍</td>
				<td>&nbsp;<jsp:getProperty property="introduce" name="user"/> </td>
			</tr>
			<tr>
				<td>是否接受协议？</td>
				<td>&nbsp;<jsp:getProperty property="acceptflag" name="user"/> </td>
			</tr>
		</table>
	</form>
</body>
</html>