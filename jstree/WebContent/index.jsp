<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="jstree/themes/default/style.min.css" />
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="jstree/jstree.min.js"></script>
<script type="text/javascript">
	$(function () {
		$('#jstree_demo_div').jstree({
			'core' : {
				'data':{
					'url':'getAllProvince'
				},
				"themes" : { "stripes" : true },
			}
		}); 
	});
</script>
</head>
<body>
	<div id="jstree_demo_div"></div>
</body>
</html>