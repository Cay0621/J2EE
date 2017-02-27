<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/script/jquery-2.1.4.js"></script>
<script type="text/javascript">
	$(function() {
		$("input[type='button']").click(function() {
			//alert($("form").serialize());
			$.ajax({
				url : 'jsonAction.action',
				type : 'get',
				dataType : 'json',
				data : $("form").serialize(),
				success : function(data) {
					alert("success...");
					window.location.href = "success.jsp";
				},
				error : function() {
					alert("error...");
				}
			});
		});
	});
</script>
</head>
<body>
	<form method="post" action="">
		<input name="username" /><br /> <input name="password" /><br /> <input
			type="button" value="点击" />
	</form>
</body>
</html>