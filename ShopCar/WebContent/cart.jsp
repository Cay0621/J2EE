<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*,bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>View</title>
</head>
<body topmargin="10">
	<div id="append_parent"></div>
	<table cellspacing="6" cellpadding="6" width="100%" border="0">
		<tbody>
			<tr>
				<td>
					<table class="guide" cellspacing="0" cellpadding="0" border="1">
						<tbody>
							<tr>
								<td>&nbsp;&nbsp;<a href="#">主页</a>&nbsp;&nbsp;/&nbsp;&nbsp;
									<a href="#">花卉市场</a>&nbsp;&nbsp;/&nbsp;&nbsp; <span
									class="flower">花卉列表</span>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="tableborder" cellspacing="0" cellpadding="0"
						width="100%" border="1">
						<tbody>
							<tr class="header">
								<td class="altbg1" width="15%"><b>名称</b></td>
								<td class="altbg1" width="20%"><b>单价</b></td>
								<td class="altbg1" width="30%"><b>数量</b></td>
								<td class="altbg1" colspan="3"><b>操作</b></td>
							</tr>
						</tbody>
						<tbody>
							<%
								//从session中取出cart对象
								Cart cart = (Cart)session.getAttribute("cart");
								if(cart != null && cart.list().size() > 0){
									//以表格的方式显示所有选购的商品
									List<CartItem> items = cart.list();
									for(CartItem item : items){
								%>
							<tr>
								<td class="altbg2"><%=item.getPro().getName() %></td>
								<td class="altbg2"><%=item.getPro().getPrice() %></td>
								<td class="altbg2"><%=item.getCount() %></td>
								<td class="altbg2"><input type="text" size="3" value=""
									id="num_<%=item.getPro().getId() %>" /></td>
								<td class="altbg2"><a href="javascript:;" onclick="location='modify.do?id=<%=item.getPro().getId()%>&value=' + document.getElementById('num_<%=item.getPro().getId() %>').value;">更改数量</a></td>
								<td class="altbg2"><a href="delete.do?id=<%=item.getPro().getId()%>">删除</a></td>
							</tr>
							<%}
									%>
							<tr>
								<td class="procost" colspan="6"><b>总价格：￥<%=cart.cost() %></b>
								</td>
							</tr>
							<%
									}else{
										//显示还没选购商品
										%>
							<tr>
								<td class="procost" colspan="6"><b>还未选购任何商品</b></td>
							</tr>
							<%
									} %>
						</tbody>
					</table>
					<center>
						<input type="button" class="button" value="返回商品列表" name="setting"
							onclick="location='list.do';" /> <input type="button"
							class="button" value="清空商品" name="setting"
							onclick="location='clear.do';" />
					</center>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>