<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*,entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>List Product</title>
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
					</table> <br />
					<table class="tableborder" cellspacing="0" cellpadding="0"
						width="100%" border="1">
						<tbody>
							<tr class="header">
								<td class="altbg1" width="15%"><b>名称</b></td>
								<td class="altbg1" width="20%"><b>图片</b></td>
								<td class="altbg1" width="30%"><b>说明</b></td>
								<td class="altbg1" width="10%"><b>报价</b></td>
								<td class="altbg1"></td>
							</tr>
						</tbody>
						<tbody>
							<%
								List<Product> products = (List<Product>) request
										.getAttribute("products");
								for (Product pro : products) {
							%>
							<tr>
								<td class="altbg2">&nbsp;&nbsp;<%=pro.getName()%></td>
								<td class="altbg2"><img src="images/<%=pro.getPic()%>"
									width="120" height="90" /></td>
								<td class="altbg2"><%=pro.getDesc()%></td>
								<td class="altbg2">￥<%=pro.getPrice()%></td>
								<td class="altbg2">
									<table>
										<tr>
											<td width="100"><a href="buy.do?id=<%=pro.getId()%>">购买</a>
											</td>
											<td><span style="color: red;"> <%
 	String msg = (String) request.getAttribute("buy_msg_"
 				+ pro.getId());
 %> <%=(msg == null ? "" : msg)%>
											</span></td>
										</tr>
									</table>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table> <br />
					<center>
						<input type="button" class="button" value="查看购物" name="setting"
							onclick="location='cart.jsp';" />
					</center>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>