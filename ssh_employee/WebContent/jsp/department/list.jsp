<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.table1 {
	border: 1px solid #ddd;
	width: 900px;
}

thead {
	background-color: lightblue;
}
</style>
</head>
<body>
	<table border="0" width="900px">
		<tr>
			<td align="center" style="font-size: 24px; color: #999">部门管理</td>
			<td width="57%" align="right">
				<a href="${pageContext.request.contextPath }/department-saveUI.action">添加</a>
			</td>
		</tr>
		
	</table>

	<br />
	<%-- <s:debug></s:debug> --%>
	<table cellspacing="0" border="1" class="table1">
		<thead>
			<tr>
				<th width="300">部门名称</th>
				<th width="300">编辑</th>
				<th width="300">删除</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="list" var="d">
			<tr>
				<td align="center"><s:property value="#d.dname"/> </td>
				<td align="center"><a href="${pageContext.request.contextPath }/department-edit.action?did=<s:property value="#d.did"/>">编辑</a></td>
				<td align="center"><a href="${pageContext.request.contextPath }/department-delete.action?did=<s:property value="#d.did"/>">删除</a></td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
	<br />


	<table border="0" cellspacing="0" cellpadding="0" width="900px">
		<tr>
			<td align="right"><span>第<s:property value="currentPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
			总记录数：<s:property value="totalCount"/>&nbsp;&nbsp;每页显示:<s:property value="pageSize"/> 
				<span> 
					<s:if test="currentPage != 1">
						<a href="${pageContext.request.contextPath }/department-findAll.action?curPage=1">[首页]</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/department-findAll.action?curPage=<s:property value="currentPage - 1"/>">[上一页]</a>&nbsp;&nbsp; 
					</s:if>
					<s:if test="currentPage != totalPage">
						<a href="${pageContext.request.contextPath }/department-findAll.action?curPage=<s:property value="currentPage + 1"/>">[下一页]</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/department-findAll.action?curPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp; 
					</s:if>
				</span>
				</td>
		</tr>
	</table>
</body>
</html>