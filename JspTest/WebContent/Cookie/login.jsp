<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = "";
		String password = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("username")){
					username = URLDecoder.decode(cookie.getValue(), "utf-8");
				}
				if(cookie.getName().equals("password")){
					password = URLDecoder.decode(cookie.getValue(), "utf-8");
				}
			}
		}
	%>
	<form action="dologin.jsp" method="post">
		用户名:<input name="username" value="<%=username %>"/><br/>
		密码:<input type="password" name="password" value="<%=password %>"/><br/>
		<input type="checkbox" name="tip" id="tip"/><label for="tip">一周内自动登录</label><br/>
		<input type="submit" name="login" value="登录"/>
		<input type="reset" name="reset" value="取消"/>
	</form>
</body>
</html>