<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl函数使用</title>
</head>
<body>
	<c:out value="${fn:contains('你好，Hello World','world') }"></c:out><br/>
	<c:out value="${fn:containsIgnoreCase('你好，Hello World','world') }"></c:out><br/>
	
	<c:out value="${fn:startsWith('你好，Hello World','World') }"></c:out><br/>
	<c:out value="${fn:endsWith('你好，Hello World','World') }"></c:out><br/>
	<book>假如只有三天光明</book><br/>
	<!-- 进行转义 -->
	<c:out value="${fn:escapeXml('<book>假如只有三天光明</book>') }"></c:out><br/>
	<c:out value="<book>假如只有三天光明</book>"></c:out><br/>
	
	<c:out value="${fn:indexOf('Hello World','or') }"></c:out>
</body>
</html>