<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cay" uri="/cay-tag" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/test" ;
		String username="root";
		String password="Cam20150916";
		String sql="select * from tmp_user" ;
		
		pageContext.setAttribute("driver", driver);
		pageContext.setAttribute("url", url);
		pageContext.setAttribute("username", username);
		pageContext.setAttribute("password", password);
		pageContext.setAttribute("sql", sql);
	%>
	
	<!-- 在自定义标签中，如果需要在运行的时候接收表达式的值，需要在tld中将需要动态获取值的attribute中的rtexprvalue设为true -->
	<cay:dbConnection 
		password="${password }" 
		url="${url }" 
		driver="${driver }" 
		sql="${sql }" 
		username="${username }"/>
</body>
</html>