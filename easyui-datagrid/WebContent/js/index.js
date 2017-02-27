/**
 * 
 */

$(function(){
	$('#dateFrom').datebox({
		formatter:function(date){
			//alert(date);
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			var d = date.getDate();
			return y + "-" + (m > 9 ? m : "0" + m) + "-" + (d > 9 ? d : "0" + d);
		},
		parser:function(date){
			//return date;
		}
	});
	
	$('#dateTo').datebox({
		formatter:function(date){
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			var d = date.getDate();
			return y + "-" + (m > 9 ? m : "0" + m) + "-" + (d > 9 ? d : "0" + d);
		},
		parser:function(date){
			//return date;
		}
	});
	
	$("#search").on('click', function(){
		var dateFrom = $("#dateFrom").datebox('getText');
		var dateTo = $("#dateTo").datebox('getText');
		$("#dataTable").datagrid('load', {
			name: $.trim($("#tb input[name='name']").val()),
			dateFrom:dateFrom == '' ? null : dateFrom,
			dateTo:dateTo == '' ? null : dateTo
		});
	});
	
	$("#dataTable").datagrid({
		width: 600,
		url:'user/list/',
		title:'用户列表',
		collapsible: true,
		iconCls:'icon-search',
		striped:true,
		toolbar:'#tb',
		fitColumns:true,
		loadMsg:'正在加载中...',
		rownumbers:true,
		pageSize:5,
		pageList:[5,10,15,20],
		pagination:true,
		columns:[[
		    //列属性
		    {
				title:'编号',
				field:'id',
				width: 100,
				sortable:true,
				align:'center',
			},
			{
				title:'姓名',
				field:'username',
				width: 100,
				align:'center',
			},
			{
				title:'密码',
				field:'password',
				width: 100,
				align:'center',
			},
			{
				title:'年龄',
				field:'age',
				width: 100,
				sortable:true,
				align:'center',
			},
			{
				title:'生日',
				field:'birthday',
				width: 100,
				align:'center',
				sortable:true,
				formatter:function(value, row, index){
					var date = new Date(value);
					var year = date.getFullYear();
					var month = date.getMonth() + 1;
					var day = date.getDate();
					
					return year + "-" + (month > 9 ? month : "0" + month) + "-" + (day > 9 ? day : "0" + day);
				}
			}
		]]
	});
	
	$("#add").on('click', function(){
		$("#dg").window({
			title:'添加数据',
			width: 400,
			height: 300,
			modal:true,
			maximizable:false,
		});
	});
	
});
