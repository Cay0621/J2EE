<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> fruits = new ArrayList<String>();
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("lemon");
		fruits.add("orange");
		fruits.add("pear");
		fruits.add("grape");
		request.setAttribute("fruits", fruits);
	%>
	<!-- 全部遍历 -->
	<c:forEach items="${requestScope.fruits }" var="fruit">
		<c:out value="${fruit }"></c:out><br/>
	</c:forEach>
	<c:out value="==========================="></c:out><br/>
	
	<!-- 部分遍历,从0开始,同时包括begin和end -->
	<c:forEach items="${requestScope.fruits }" var="fruit" begin="1" end="4">
		<c:out value="${fruit }"></c:out><br/>
	</c:forEach>
	<c:out value="==========================="></c:out><br/>
	
	<!-- 部分和步长遍历-->
	<c:forEach items="${requestScope.fruits }" var="fruit" begin="1" end="4" step="2">
		<c:out value="${fruit }"></c:out><br/>
	</c:forEach>
	<c:out value="==========================="></c:out><br/>
	
	<!-- 部分遍历并输出元素状态 -->
	<c:forEach items="${requestScope.fruits }" var="fruit" begin="2" end="4" varStatus="f">
		<c:out value="${fruit }的属性值"></c:out><br/>
		<c:out value="index:${f.index }"></c:out><br/><!-- 在整个数组中的索引 -->
		<c:out value="count:${f.count }"></c:out><br/><!-- 在begin和end组成的数组中的索引 -->
		<c:out value="first:${f.first }"></c:out><br/><!-- 在新数组中是否是第一个 -->
		<c:out value="last:${f.last }"></c:out><br/><!-- 在新数组中是否是最后一个 -->
		<c:out value="-----------------------------"></c:out><br/>
	</c:forEach>	
</body>
</html>