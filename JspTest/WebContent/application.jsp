<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>application内置对象</h1>
	<hr/>
	<%
		application.setAttribute("city", "上海");
		application.setAttribute("postcode", "10000");
		application.setAttribute("email", "123@qq.com");
	%>
	所在城市:<%=application.getAttribute("city") %><br/>
	application的属性有:
	<%
		Enumeration<String> attributes = application.getAttributeNames();
		while(attributes.hasMoreElements()){
			out.println(attributes.nextElement() + "&nbsp;&nbsp;,");
		}
	%><br/>
	jsp引擎版本号:<%=application.getServerInfo() %>
</body>
</html>