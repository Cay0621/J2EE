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
	<!-- include -->
	<c:catch var="error1">
		<!-- 导入网络地址 -->
		<c:import url="http://www.baidu.com"></c:import>
	</c:catch>
	<c:out value="${error1 }"></c:out>
	<br/>
	<c:catch var="error2">
		<!-- 导入文件相对地址 -->
		<c:import url="if.jsp"></c:import>
	</c:catch>
	<c:out value="${error2 }"></c:out>
	
	<br/>
	<c:catch var="error3">
		<!-- 导入文件相对地址，并设置编码格式 -->
		<c:import url="tt.txt" charEncoding="utf-8"></c:import>
	</c:catch>
	<c:out value="${error3 }"></c:out>
	
	<br/>
	<c:catch var="error4">
		<!-- 导入文件内容到scope，并设置var值 -->
		<c:import url="tt.txt" var="tt" scope="session" charEncoding="utf-8"></c:import>
	</c:catch>
	<c:out value="${error4 }"></c:out>
	<c:out value="${sessionScope.tt }"></c:out>
</body>
</html>