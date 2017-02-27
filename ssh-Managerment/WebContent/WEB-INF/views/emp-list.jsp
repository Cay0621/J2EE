<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		//1、点击delete时，弹出确定是否是要删除信息吗？若确定，则删除，否则取消
		$(".delete").click(function(){
			var lastName = $(this).next(":input").val();
			//var id = $(this).parent().parent().children().first("td:eq(0)").text();
			//等价上面一行
			var id = $(this).parent().siblings("td:eq(0)").text();
			var $tr = $(this).parent().parent();
			var flag = confirm("确定要删除该条id为" + id + ",name为" + lastName + "记录吗？");
			if(flag){
				//删除，使用ajax的方式删除
				$.ajax({
					url:"emp-delete",
					data:{
						"id":id,
						"time":new Date()
					},
					success:function(data){
						//判断data的返回值
						if(data == "1"){
							alert("删除成功!");
							$(".delete").parent().parent().remove();
						}else{
							alert("删除失败!");
						}
					}
				})
			}
			return false;
		})
	})
</script>
</head>
<body>
	<h4>Employee List Page</h4>
	<s:if test="#request.employees == null || #request.employees.size() == 0">
		没有员工信息
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>LastName</td>
				<td>Email</td>
				<td>Birth</td>
				<td>CreateTime</td>
				<td>Department</td>
				<td>Delete</td>
			</tr>
			<s:iterator value="#request.employees">
				<tr>
					<td>${id }</td>
					<td>${lastName }</td>
					<td>${email }</td>
					<td>${birth }</td>
					<td>${createTime }</td>
					<td>${department.departmentName}</td>
					<td>
						<a href="" class="delete">Delete</a>
						<input type="hidden" value="${lastName } "/>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:else>
</body>
</html>