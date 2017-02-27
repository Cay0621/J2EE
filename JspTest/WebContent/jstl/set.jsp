<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<jsp:useBean id="person" class="entity.Person"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 存值在scope -->
	<c:set value="today" var="day" scope="session"></c:set>
	<c:out value="${day }"></c:out><br/>
	<c:set value="eleven" var="age" scope="request"></c:set>
	<c:out value="${age }"></c:out><br/>
	
	<!-- 存在javaBean -->
	<c:set target="${person }" property="name" value="zhangsan"></c:set>
	<c:out value="${person.name }"></c:out>
	<c:set target="${person }" property="age" value="7"></c:set>
	<c:out value="${person.age }"></c:out>
	<c:set target="${person }" property="address" value="Sh"></c:set>
	<c:out value="${person.address }"></c:out>
</body>
</html>