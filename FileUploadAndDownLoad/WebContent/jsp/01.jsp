<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$(".thumbs a").click(function(){
			var largePath = $(this).attr("href");
			var largeTitle = $(this).attr("title");
			
			$("#largeImg").attr({
				src:largePath,
				title:largeTitle
			})
			return false;
		});
	});
	
	
</script>
</head>
<body>
	<form action="singleupload" method="post" enctype="multipart/form-data">
		上传文件:<input type="file" name="upload" /><br/>
		<input type="submit" value="提交" />${result }
	</form>

	<hr/>
	<h2>图片预览</h2>
	<p><img id="largeImg" src="../images/img1-lg.jpg" title="large Image"/></p>
	<p class="thumbs">
		<a href="../images/img2-lg.jpg" title="image2"><img src="../images/img2-thumb.jpg" /></a>
		<a href="../images/img3-lg.jpg" title="image3"><img src="../images/img3-thumb.jpg" /></a>
		<a href="../images/img4-lg.jpg" title="image4"><img src="../images/img4-thumb.jpg" /></a>
		<a href="../images/img5-lg.jpg" title="image5"><img src="../images/img5-thumb.jpg" /></a>
		<a href="../images/img6-lg.jpg" title="image6"><img src="../images/img6-thumb.jpg" /></a>
	</p>
</body>
</html>