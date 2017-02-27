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
		String name = "cay";
		pageContext.setAttribute("name", name);
	%>
	<cay:if test="${name == 'cay' }">
		我爱妳
	</cay:if>
	<cay:if test="${name != 'cay' }">
		http://www.baidu.com
	</cay:if>
</body>
</html>