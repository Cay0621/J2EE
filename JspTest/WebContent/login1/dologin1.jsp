<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<jsp:useBean id="loginUser" class="entity.User"></jsp:useBean>
	<jsp:useBean id="userDAO" class="dao.UserDAO"></jsp:useBean>
	<jsp:setProperty property="*" name="loginUser"/>
	<%
		if(userDAO.userLogin(loginUser)){
			session.setAttribute("username", loginUser.getUsername());
			//request.getRequestDispatcher("login_success.jsp").forward(request, response);
			
			//2、
			request.getRequestDispatcher("usebean.jsp").forward(request, response);
		}else{
			response.sendRedirect("login_failure.jsp");
		}
	%>
</body>
</html>