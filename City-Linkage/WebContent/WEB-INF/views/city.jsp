<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:'getAllProvince',
			type:'post',
			dataType:'json',
			success:function(data){
				$.each(data, function(index, item){
					$("#province").append("<option value=" + item.cityId + ">" + item.cityName + "</option>");
				});
			}
		});
		
		$("#province").change(function(){
			$("#city").children().not(":first").remove();
			
			if(this.value != '00'){
				$.ajax({
					url:'getCitiesByProvinceId',
					data:{
						province_id:this.value,
						time:new Date()
					},
					type:'post',
					dataType:'json',
					success:function(data){
						$.each(data, function(index, item){
							if(index != 0)
								$("#city").append("<option value=" + item.cityId + ">" + item.cityName + "</option>");
						});
					}
				});
			}
		});
	});
</script>
</head>
<body>
	<select id="province">
		<option value="00">请选择</option>
	</select>
	
	<select id="city">
		<option value="00">请选择</option>
	</select>
</body>
</html>