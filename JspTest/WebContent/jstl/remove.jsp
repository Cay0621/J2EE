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
	<c:set var="lastName" value="Lily"></c:set>
	<c:out value="${lastName }"></c:out>
	<c:set var="firstName" value="Wang"></c:set>
	<c:out value="${firstName }"></c:out><br/>
	
	<c:remove var="lastName"/><!-- 删除 -->
	<c:out value="${lastName }"></c:out>
	<c:out value="${firstName }"></c:out>
</body>
</html>