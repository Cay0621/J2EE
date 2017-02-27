<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>登录</h1>
			
		<s:form action="/sso/doLogin.action" namespace="/">
			<input type="hidden" name="gotoUrl" value="<s:property value="%{gotoUrl}"/>"/>
			<s:textfield name="username" label="用户名"></s:textfield>
			<s:password name="password" label="密码"></s:password>
			<s:submit></s:submit>
		</s:form>
	</center>
</body>
</html>