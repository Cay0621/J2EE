<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<form action="transform.action" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<caption>用户转账</caption>
			<tr>
				<td>从</td>
				<td>至</td>
			</tr>
			<tr>
				<td><input name="accountid1" value=""/></td>
				<td><input name="accountid2" value=""/></td>
			</tr>
			<tr>
				<td colspan="2"><input name="money" value=""/></td>
			</tr>
		</table>
		<input type="submit" value="转账" />
	</form>
</body>
</html>