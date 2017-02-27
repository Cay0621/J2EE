<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>转账成功页面</title>
</head>
<body>
	转账成功...
	<hr/>
	<table>
		<c:forEach items="${applicationScope.listAccounts }" var="account">
			<tr>
				<td>${account.aid }</td>
				<td>${account.aname }</td>
				<td>${account.money }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>