<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{
		text-align: center;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-2.1.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.blockUI-2.70.0.js"></script>
<script type="text/javascript">
/*
 *	1、获取id为province节点，并添加change响应函数
 *	2、使id为city只保留第一个option子节点
 *	3、获取id为province选择的值，若该值为"",即选择的是"请选择..."，则不需要发送ajax请求
 *	4、若值不为""，说明province发生了改变，则需要发送ajax请求
 		4.1、url: chinaServlet?method=cityList
 		4.2、args: province_id,time
 	5、返回的是一个json数组
 		5.1、若返回的数组中的元素为0，则提示
 		5.2、若返回的数组中的元素不为0，则创建<option id="city_id">city_name</option>,并把新创建的option节点添加到id为city的子节点
 */
	$(function(){
		
		//使用blockUI,ajax请求发出时执行ajaxStart函数,响应送达时执行ajaxStop函数
		$(document).ajaxStart(function() {
	        $.blockUI({
	            message: $('#loading'),
	            css: {
	                top:  ($(window).height() - 200) /2 + 'px',
	                left: ($(window).width() - 400) /2 + 'px',
	                width: '400px',
	                border: 'none'
	            }
	        });

	        //setTimeout($.unblockUI, 2000);
	    }).ajaxStop($.unblockUI);
		
		$("#province").change(function(){
			$("#detail").hide();
			$("#city option:not(:first)").remove();
			$("#district option:not(:first)").remove();
			
			var provinceId = $(this).val();
			
			if(provinceId != ""){
				$.ajax({
					url: 'chinaServlet?method=cityList',
					data:{
						'province_id':provinceId,
						'time':new Date()
					},
					dataType:'json',
					type:'post',
					success:function(data){
						if(data.length == 0){
							alert('当前省份没有城市!');
						}else{
							for(var i = 0; i < data.length; ++i){
								var cityId = data[i].id;
								var cityName = data[i].name;
								
								$("#city").append("<option value='" + cityId + "'>" + cityName + "</option>"); 
							}
						}
					},
					error:function(){
						alert('ajax请求失败...');
					}
				});
			}
		});
		
		$("#city").change(function(){
			$("#detail").hide();
			$("#district option:not(:first)").remove();
			
			var cityId = $(this).val();
			
			if(cityId != ""){
				$.ajax({
					url:'chinaServlet?method=districtList',
					data:{
						'city_id':cityId,
						'time':new Date()
					},
					dataType:'json',
					type:'post',
					success:function(data){
						if(data.length == 0){
							alert('该城市没有区县!');
						}else{
							for(var i = 0; i < data.length; ++i){
								var districtId = data[i].id;
								var districtName = data[i].name;
								$("#district").append("<option value='" + districtId +"'>" + districtName + "</option>")
							}
						}
					},
					error:function(){
						alert('ajax请求失败...');
					}
				})
			}
		});
		
		$("#district").change(function(){
			var districtId = $(this).val();
			if(districtId != ""){
				$.ajax({
					url:'chinaServlet?method=detail',
					type:'post',
					data:{
						'province_id':$("#province").val(),
						'city_id':$("#city").val(),
						'district_id':districtId,
						'time':new Date()
					},
					dataType:'json',
					success:function(data){
						//alert(data);
						$("#detail").show();
						$("#detail_id").html(data.id);
						$("#detail_province").html(data.province);
						$("#detail_city").html(data.city);
						$("#detail_district").html(data.district);
						$("#detail_post").html(data.post);
					},
					error:function(){
						alert('查询失败...');
					}
				})
			}
		})
	});
</script>
</head>
<body>
	<img alt="" id="loading" src="images/block.gif" style="display: none" />
	<center>
		省份:
		<select id="province">
			<option value="">请选择...</option>
			<c:forEach items="${provinces }" var="province">
				<option value="${province.id }">${province.name }</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		城市:
		<select id="city">
			<option value="">请选择...</option>
		</select>
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		区县:
		<select id="district">
			<option value="">请选择...</option>
		</select>
		
		<br/><br/>
		<table id="detail" border="1" cellpadding="0" cellspacing="0" style="display:none" width="500px">
			<tr>
				<th>ID</th>
				<th>Province</th>
				<th>City</th>
				<th>District</th>
				<th>Post</th>
			</tr>
			<tr>
				<td id="detail_id"></td>
				<td id="detail_province"></td>
				<td id="detail_city"></td>
				<td id="detail_district"></td>
				<td id="detail_post"></td>
			</tr>
		</table>
	</center>
</body>
</html>