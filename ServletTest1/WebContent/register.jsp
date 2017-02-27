<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="registerServlet" method="post">
		用户名:<input type="text" name="username"/><br/>
		密码:<input type="password" name="password"/><br/>
		确认密码:<input type="password" /><br/>
		性别:
		<input type="radio" name="gender" value="male" />男
		<input type="radio" name="gender" value="female" />女<br/>
		出生日期:
		<input type="text" name="birthday"/><br/>
		邮箱：
		<input type="text" name="email" /><br/>
		爱好:
		<input type="checkbox" name="hobby" value="swimming"/>游泳 
		<input type="checkbox" name="hobby" value="football"/>足球 
		<input type="checkbox" name="hobby" value="basketball"/>篮球 
		<input type="checkbox" name="hobby" value="tennis"/>网球<br/>
		自我介绍:
		<input type="text" height="20" width="10" name="introduce"/><br/>
		是否接收协议:<input type="checkbox" name="acceptflag"/><br/>
		<input type="submit" value="提交"/>
		<input type="reset" value="取消"/>
	</form>
</body>
</html>