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
	<s:include value="list.jsp"></s:include>
	<table border="1" cellpadding="0" cellspacing="0" width="50%">
		<tr>
			<td width="15%">总金额:</td>
			<td colspan="4">
				<s:property value="totalPrice"/>
			</td>
		</tr>
	</table>
</body>
</html>