<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cay" uri="/cay-tag2" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("score", 80);
	%>
	
	<cay:choose>
		<cay:when test="${score == 100 }">
			优秀
		</cay:when>
		<cay:otherwise>
			继续努力
		</cay:otherwise>
	</cay:choose>
</body>
</html>