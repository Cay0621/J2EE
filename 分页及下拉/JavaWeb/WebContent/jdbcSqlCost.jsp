<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学生信息</title>
	<link href="css/pagination.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.pagination.js"></script>
	<%
		// 获取请求的上下文
		String context = request.getContextPath();
	%>
	<script type="text/javascript">
		function handlePaginationClick(new_page_index, pagination_container) {
	        // 这将选择20个内容数组中的元素
	        $("#costForm").attr("action", "<%=context %>/JdbcSqlServlet?pageNum=" + (new_page_index + 1));
	        $("#costForm").submit();
	        return false;
	    }
	
		$(function(){
			$("#New-Pagination").pagination(${result.totalRecord},{
				items_per_page: ${result.pageSize},//pageSize每页最多显示多少条
				current_page:${result.currentPage} - 1,//当前页号
				num_display_entries: 5,//页码数量
				next_text:"下一页",
				prev_text:"上一页",
				ellipse_text:"...",
				num_edge_entries:2,
				callback:handlePaginationClick
			});
		});
	</script>
</head>

<body onload="">
	<div style="margin-left: 100px; margin-top: 100px;">
		<div>
			<font color="red">${errorMsg }</font>
		</div>
		<div>
			<form action="<%=context %>/JdbcSqlServlet"   id="costForm"  method="post">
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
			<br>
			<div id="New-Pagination">
				
			</div>	
		</c:if>
	</div>
</body>
</html>