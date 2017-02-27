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
	<cay:dbConnection password="Cam20150916" url="jdbc:mysql://localhost:3306/test" driver="com.mysql.jdbc.Driver" sql="select * from tmp_user" username="root"/>
</body>
</html>