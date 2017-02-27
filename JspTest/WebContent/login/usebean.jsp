<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.User" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = new User();
		user.setUsername("zs");
		user.setPassword("admin");
	%>
	用户名:<%=user.getUsername() %><br/>
	密码:<%=user.getPassword() %><br/>
	
	<hr/>
	<jsp:useBean id="myUser1" class="entity.User"></jsp:useBean>
	<!-- 根据表单自动匹配所有属性 -->
	<jsp:setProperty property="*" name="myUser1"/>
	用户名:<%=myUser1.getUsername() %><br/>
	密码:<%=myUser1.getPassword() %><br/>
	<br/>
	使用getProperty<br/>
	用户名:<jsp:getProperty property="username" name="myUser1"/><br/>
	密码:<jsp:getProperty property="password" name="myUser1"/> <br/>
	
	<hr/>
	<jsp:useBean id="myUser2" class="entity.User"></jsp:useBean>
	<!-- 根据表单自动匹配部分属性 -->
	<jsp:setProperty property="username" name="myUser2"/>
	
	<!-- 与表单无关，通过手动设置属性 -->
	<jsp:setProperty property="password" name="myUser2" value="888888"/>
	
	用户名:<%=myUser2.getUsername() %><br/>
	密码:<%=myUser2.getPassword() %><br/>
	
	<hr/>
	<jsp:useBean id="myUser3" class="entity.User"></jsp:useBean>
	<jsp:setProperty property="username" name="myUser3"/>
	<!-- 通过URL传参数给属性 -->
	<jsp:setProperty property="password" name="myUser3" param="mypass"/>
	用户名:<%=myUser3.getUsername() %><br/>
	密码:<%=myUser3.getPassword() %><br/>
</body>
</html>