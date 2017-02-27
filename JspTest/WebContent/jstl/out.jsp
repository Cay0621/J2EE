<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="this is a first jstl example..."></c:out><br/>
	<%
		session.setAttribute("name", "Cay");
	%>
	<c:out value="${name }"></c:out><br/>
	
	<!-- default：如果没有value值，输出default指定的值 -->
	<c:out value="${pwd }" default="error"></c:out><br/>
	
	<!-- 默认不转义escapeXml为true，需要转义则设为false -->
	<c:out value="&ltout标签&gt" escapeXml="true"></c:out><br/>
	<c:out value="&ltout标签&gt" escapeXml="false"></c:out>
</body>
</html>