<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="choose.jsp" method="post">
		<input type="text" name="score" value="${param.score }"/>
		<input type="submit" value="submit"/>
	</form>
	<c:choose>
		<c:when test="${param.score >= 90 && param.score <= 100 }">优秀</c:when>
		<c:when test="${param.score >= 80 && param.score < 90}">良好</c:when>
		<c:when test="${param.score >= 70 && param.score < 80}">中等</c:when>
		<c:when test="${param.score >= 60 && param.score < 70}">及格</c:when>
		<c:when test="${param.score >= 0 && param.score < 60}">不及格</c:when>
		<c:otherwise>输入错误</c:otherwise>
	</c:choose>
</body>
</html>