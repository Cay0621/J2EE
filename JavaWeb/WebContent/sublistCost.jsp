<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学生信息</title>
	<%
		// 获取请求的上下文
		String context = request.getContextPath();
	%>
	<script type="text/javascript">
		// 当前第几页数据
		var currentPage = ${result.currentPage};
		
		// 总页数
		var totalPages = ${result.totalPages};
		
		function submitForm(actionUrl){
			var formElement = document.getElementById("costForm");
			formElement.action = actionUrl;
			formElement.submit();
		}
		
		// 第一页
		function firstPage(){
			if(currentPage == 1){
				//alert("已经是第一页数据");
				return false;
			}else{
				submitForm("<%=context %>/SublistServlet?pageNum=1");
				return true;
			}
		}
		
		// 下一页
		function nextPage(){
			if(currentPage == totalPages){
				//alert("已经是最后一页数据");
				return false;
			}else{
				submitForm("<%=context %>/SublistServlet?pageNum=" + (currentPage+1));
				return true;
			}
		}
		
		// 上一页
		function previousPage(){
			if(currentPage == 1){
				//alert("已经是第一页数据");
				return false;
			}else{
				submitForm("<%=context %>/SublistServlet?pageNum=" + (currentPage-1));
				return true;
			}
		}
		
		// 尾页
		function lastPage(){
			if(currentPage == totalPages){
				//alert("已经是最后一页数据");
				return false;
			}else{
				submitForm("<%=context %>/SublistServlet?pageNum=${result.totalPages}");
				return true;
			}
		}
		function initPage(){
			var genderRequest = "${gender}" ;
			var genderVal = 0;
			var genderElement = document.getElementById("gender");
			if(genderRequest != ""){
				genderVal = parseInt(genderRequest);
			}
			
			var options = genderElement.options;
			var i = 0;
			for(i = 0; i < options.length; i++){
				if(options[i].value == genderVal){
					options[i].selected=true;
					break;
				}
			}
			
		}
	</script>
</head>

<body onload="<!-- initPage(); -->">
	<div style="margin-left: 100px; margin-top: 100px;">
		<div>
			<font color="red">${errorMsg }</font>
		</div>
		<div>
			<form action="<%=context %>/SublistServlet"   id="costForm"  method="post">
				姓名
				<input type="text" name="costName" id="cost_name" style="width:120px" value="<%-- ${stuName } --%>">
				&nbsp;
				<!-- 性别
				<select name="gender" id="gender" style="width:80px">
					<option value="0">全部</option>
					<option value="1">男</option>
					<option value="2">女</option>
				</select> -->
				&nbsp;&nbsp;
				<input type="submit" value="查询">
			</form>
		</div>		
		<br>
		信息列表：<br>
		<br>
		<!-- 后台返回结果为空 -->
		<c:if test="${fn:length(result.dataList) eq 0 }">
			<span>查询的结果不存在</span>
		</c:if>
		
		<!-- 后台返回结果不为空 -->
		<c:if test="${fn:length(result.dataList) gt 0 }">
			<table border="1px" cellspacing="0px"
				style="border-collapse: collapse">
				<thead>
					<tr height="30">
						<th width="90">资费名称</th>
						<th width="90">包在线时长</th>
						<th width="90">月固定费</th>
						<th width="90">单位费用</th>
						<th width="90">状态</th>
						<th width="90">资费信息说明</th>
						<th width="90">创建日期</th>
						<th width="90">启用日期</th>
					</tr>
				</thead>
					<c:forEach items="${result.dataList }" var="cost">
						<tr>
							<td><c:out value="${cost.name }"></c:out></td>
							<td><c:out value="${cost.baseDuration }"></c:out></td>
							<td><c:out value="${cost.baseCost }"></c:out></td>
							<td><c:out value="${cost.unitCost }"></c:out></td>
							<td>
								<c:if test="${ cost.status eq '1'}">开通</c:if>
								<c:if test="${ cost.status eq '0'}">暂停</c:if>
							</td>
							<td><c:out value="${cost.descr }"></c:out></td>
							<td><c:out value="${cost.createTime }"></c:out></td>
							<td><c:out value="${cost.startTime }"></c:out></td>
						</tr>
					</c:forEach>
			</table>
			<br> 共${result.totalRecord }条记录共${result.totalPages }页&nbsp;&nbsp;当前第${result.currentPage }页&nbsp;&nbsp;
			<a href="#" onclick="firstPage();">首页</a>&nbsp;&nbsp; 
			<a href="#" onclick="previousPage();">上一页</a>&nbsp;&nbsp;
			<a href="#" onclick="nextPage();">下一页</a>&nbsp;&nbsp; 
			<a href="#" onclick="lastPage();">尾页</a>	
		</c:if>
	</div>
</body>
</html>