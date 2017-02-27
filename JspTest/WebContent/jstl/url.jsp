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
	
	<c:if test="${1 < 3 }">
		<c:set var="parturl" value="aa"></c:set>
	</c:if>
	<c:url value="http://localhost:8080/${parturl }" var="newUrl" scope="session"></c:url>
	<a href="${sessionScope.newUrl }">新Url</a>
	
</body>
</html>