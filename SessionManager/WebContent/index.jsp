<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,org.com.cay.entity.User" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	当前在线用户人数:${userCount }<br/>
	<%
		List<User> userList = (List<User>)request.getServletContext().getAttribute("userList");
		if(userList != null){
			for(User user : userList){
				%>
				IP:<%=user.getIpString() %>,FirstTime:<%=user.getFirstTimeString() %>,SessionId:<%=user.getSessionIdString() %>
				<%
			}
		}
	%>
</body>
</html>