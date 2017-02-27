<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/index.css" rel="stylesheet" style="text/css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<div>
		<table id="tb1">
			<caption>测试表格:用于测试自动刷新</caption>
			<tr>
				<td colspan="2"><em>消息提示</em></td>
			</tr>
			<tr>
				<td><strong>当前数目为：</strong></td>
				<td id="num1" width="50">1</td>
			</tr>
		</table>
	</div>
	<div>
		<button id="add">添加</button>
		<button id="del1">删除所有</button>
		<button id="del2">删除第一个</button>
		<button id="del3">删除最后一个</button>
		<table id="tb2">
			<caption>测试表格:用于测试dom操作</caption>
			<thead>
				<tr>
					<td>姓名</td>
					<td>年龄</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	<div>
		<button id="ajaxRefreshText">Ajax刷新，返回text</button>
		<table id="tb3">
			<caption>测试表格:用于测试Ajax刷新，返回text</caption>
			<tr>
				<td colspan="2"><em>消息提示</em></td>
			</tr>
			<tr>
				<td><strong>当前数目为：</strong></td>
				<td id="num3" width="50">1</td>
			</tr>
		</table>
	</div>
	<div>
		<button id="ajaxRefreshXML">Ajax刷新，返回XML</button>
		<table id="tb4">
			<caption>测试表格:Ajax刷新，返回xml</caption>
			<tr>
				<td colspan="2"><em>消息提示</em></td>
			</tr>
			<tr>
				<td><strong>当前数目为：</strong></td>
				<td id="num4" width="50">1</td>
			</tr>
		</table>
	</div>
	<div>
		<button id="ajaxRefreshJson">Ajax刷新，返回json</button>
		<table id="tb5">
			<caption>测试表格:Ajax刷新，返回json</caption>
			<tr>
				<td colspan="2"><em>消息提示</em></td>
			</tr>
			<tr>
				<td><strong>当前数目为：</strong></td>
				<td id="num5" width="50">1</td>
			</tr>
		</table>
	</div>
	<div>
		<button id="domRefresh">dom刷新</button>
		<table id="tb6">
			<caption>测试表格:dom刷新</caption>
			<tr>
				<td colspan="2"><em>消息提示</em></td>
			</tr>
			<tr>
				<td><strong>当前数目为：</strong></td>
				<td id="num6" width="50">1</td>
			</tr>
		</table>
	</div>
</body>
</html>