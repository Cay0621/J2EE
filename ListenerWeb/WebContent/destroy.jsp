<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	request.removeAttribute("requestName");
	request.getSession().removeAttribute("sessionName");
	request.getServletContext().removeAttribute("contextName");
	
	request.getSession().removeAttribute("user");
%>
</head>
<body>
	这是删除参数的界面<br/>
	<button onclick="location.href='init.jsp'">Init</button>
	<button onclick="location.href='destroy.jsp'">Destroy</button>
</body>
</html>