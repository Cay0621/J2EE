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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("admin") && password.equals("admin")){
			session.setAttribute("username", username);
			//request.getRequestDispatcher("login_success.jsp").forward(request, response);
			
			//2、
			request.getRequestDispatcher("usebean.jsp").forward(request, response);
		}else{
			response.sendRedirect("login_failure.jsp");
		}
	%>
</body>
</html>