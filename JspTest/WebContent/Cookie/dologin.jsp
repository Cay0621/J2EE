<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录成功</h1>
	<hr/>
	<%
		request.setCharacterEncoding("utf-8");
		String[] isUserCookies = request.getParameterValues("tip");
		if(isUserCookies != null && isUserCookies.length > 0){
			//把用户名和密码保存在Cookie中
			//使用URLEncoder解决无法在cookie中保存中文字符的问题
			String username = URLEncoder.encode(request.getParameter("username"),"utf-8");
			String password = URLEncoder.encode(request.getParameter("password"),"utf-8");
			
			Cookie usernameCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("password", password);
			
			//选中多选框
			usernameCookie.setMaxAge(7 * 24 * 60 * 60);
			passwordCookie.setMaxAge(7 * 24 * 60 * 60);
			
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
		}else{
			Cookie[] cookies = request.getCookies();
			if(cookies != null && cookies.length > 0){
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("username") || cookie.getName().equals("password")){
						cookie.setMaxAge(0);//设置cookie失效
						response.addCookie(cookie);//重新添加到Cookie中
					}
				}
			}
		}
	%>
	<br/>
	<a href="user.jsp">查看用户信息</a>
</body>
</html>