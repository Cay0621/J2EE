<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		var url = "<%=context%>/HibernateDataServlet";
		var totalPages = 10E6;
		var pageSize = 20;
		var currentPage = 1;//当前页号
		var isLoading = false;//是否加载更多数据
		
		//第一步：页面渲染完之后，请求后台，获取Cost信息，加载Cost信息
		$(function(){
			//绑定滚动事件，监听下拉动作
			bindScrollEvent();
			//请求后台，加载信息	
			queryCost(1);
		})
		
		//请求后台，加载数据
		function queryCost(pageNum){
			if(pageNum > totalPages){
				$("#emptyinfo").html("没有更多数据了.");
				$(window).unbind("scroll");
			}
			if(isLoading)
				return;
			else
				isLoading = true;//正在加载数据
			
			var name = $("#cost_name").val();//获取名称
			//进行post请求
			$.ajax({
				url:url,//需要访问的url
				type:"POST",//请求方式
				dataType:"json",//返回类型
				data:{"pageSize": pageSize,"costName":name, "pageNum":pageNum},//传递的参数
				success:function(data){//返回的结果data
					//加载信息
					totalPages = data.totalPages;//总共多少页数据
					var costList = data.dataList;//cost信息
					currentPage = data.currentPage;//获取当前页号
					if(totalPages == 0){
						$("#emptyinfo").html("没有查询结果.");
					}
					//加载数据
					showCostData(costList);
					isLoading = false;
				}
			});
		}
		
		function showCostData(costList){
			var costDataHtml = "";
			//each函数：对costList进行遍历，执行function操作，index为索引，cost为每次遍历的cost值
			$.each(costList, function(index, cost){
				costDataHtml += "<tr>";
				costDataHtml += "<td>" + cost.name + "</td>";//获取cost的name属性
				costDataHtml += "<td>" + cost.baseDuration + "</td>";//获取cost的baseDuration属性
				costDataHtml += "<td>" + cost.baseCost + "</td>";//获取cost的baseCost属性
				costDataHtml += "<td>" + cost.unitCost + "</td>";//获取cost的unitCost属性
				if(cost.status == '1')
					costDataHtml += "<td>" + "开通" + "</td>";//获取cost的status属性
				else
					costDataHtml += "<td>" + "暂停" + "</td>";//获取cost的status属性
					
				costDataHtml += "<td>" + cost.descr + "</td>";//获取cost的descr属性
				costDataHtml += "<td>" + cost.createTime + "</td>";//获取cost的createTime属性
				if(cost.startTime != undefined)
					costDataHtml += "<td>" + cost.startTime + "</td>";//获取cost的startTime属性
				else
					costDataHtml += "<td></td>";//获取cost的startTime属性
				costDataHtml += "</tr>";
			});
			$("#cost_body").append(costDataHtml);
		}
		
		//第二步：完成查询功能
		function queryForm(){
			//绑定滚动事件，监听下拉动作
			bindScrollEvent();
			
			//清空之前查询获取的数据
			$("#cost_body").html("");
			$("#emptyinfo").html("");
			
			//查询
			queryCost(1);
		}
		//第三步：下拉加载更多数据的功能
		function bindScrollEvent(){
			$(window).scroll(function(){
				//添加滚动监听事件
				var docHeight = $(document).height();	//获取整个页面文档的高度
				var winHeight = $(window).height();//获取当前窗体的高度
				var winScrollHeight = $(window).scrollTop();//获取滚动条滚动的距离
				
				if(docHeight - 30 <= winHeight + winScrollHeight){
					//加载更多的数据	
					queryCost(currentPage + 1);
				}
			});
		};
	</script>
</head>

<body>
	<div style="margin-left: 100px; margin-top: 100px;">
		<div>
			<form action="<%=context %>/HibernateServlet"   id="costForm"  method="post">
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
				<input type="button" value="查询" onclick="queryForm();">
			</form>
		</div>		
		<br>
		信息列表：<br>
		<br>
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
			<tbody id="cost_body"></tbody>
		</table>
		<div id="emptyinfo"></div>
	</div>
</body>
</html>