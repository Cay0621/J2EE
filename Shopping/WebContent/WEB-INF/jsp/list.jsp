<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<style type="text/css">
	tr{
		text-align: center;
	}
</style>
</head>
<body>
	<form action="modify.action" method="post">
		<table border="1" cellpadding="0" cellspacing="0" width="50%">
			<caption>商品列表</caption>
			<thead>
				<tr>
					<td width="15%">ID号</td>
					<td>名称</td>
					<td>数量</td>
					<td>价格</td>
					<td>修改</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products }" var="product" varStatus="stat">
					<tr>
						<!-- 方法1 -->
						<%-- <td>${product.id }"</td>
						<td>${product.name }"</td>
						<td>${product.amounts }"</td>
						<td>${product.price }"</td> --%>
						
						<!-- 方法2 -->
						<td><c:out value="${product.id }"></c:out></td>
						<td><c:out value="${product.name }"></c:out></td>
						<td><c:out value="${product.amounts }"></c:out></td>
						<td><c:out value="${product.price }"></c:out></td>
						<td><input name="modifyAmounts[${stat.index }]"/> </td>
						
					</tr>
				</c:forEach>
				
				<%-- <s:iterator value="products" status="stat" id="product">
					<tr><!-- 方法1 -->
						<td><s:property value="products[#stat.index].id"/></td>
						<td><s:property value="products[#stat.index].name"/></td>
						<td><s:property value="products[#stat.index].amounts"/></td>
						<td><s:property value="products[#stat.index].price"/></td>
						
						<!-- 方法2 -->
						<td><s:property value="#product.id"/></td>
						<td><s:property value="#product.name"/></td>
						<td><s:property value="#product.amounts"/></td>
						<td><s:property value="#product.price"/></td>
						<td><input name="modifyAmounts[<s:property value='#stat.index'/>]" value="" /></td>
						
					</tr>
				</s:iterator> --%>
			</tbody>
			<%-- <tfoot>
				<tr>
					<td>总金额:</td>
					<td colspan="4" style="text-align: left;padding-left: 20px;">
						￥<c:out value="${totalPrice }"></c:out>
					</td>
				</tr>
			</tfoot> --%>
		</table>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>