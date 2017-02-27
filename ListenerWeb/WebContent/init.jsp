<%@page import="org.com.cay.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	request.setAttribute("requestName", "requestValue");
	request.getSession().setAttribute("sessionName", "sessionValue");
	request.getServletContext().setAttribute("contextName", "contextValue");
	
	//只要某个javaBean实现了HttpSessionBindingListener，一旦绑定到session就会触发绑定事件
	request.getSession().setAttribute("user", new User());
%>
</head>
<body>
	这是初始化参数的界面<br/>
	<button onclick="location.href='init.jsp'">Init</button>
	<button onclick="location.href='destroy.jsp'">Destroy</button>
</body>
</html>