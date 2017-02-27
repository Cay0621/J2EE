<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
<style type="text/css">
	#mydiv{
		position: absolute;
		left: 50%;
		top: 50%;
		margin-left: -200px;
		margin-top: -50px;
	}
	
	.mouseOver{
		background-color: #708090;
		color: #FFFAFA;
	}
	.mouseOut{
		background-color: #FFFAFA;
		color: #000;
	}
</style>
<script type="text/javascript">
	var xmlHttpRequest;
	
	function createXmlHttpRequest() {
		if(window.XMLHttpRequest){
			xmlHttpRequest = new XMLHttpRequest();
		}else{
			if(window.ActiveXObject)
				xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			else{
				xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
			}
		}
	}
	
	function getMoreContent(){
		
		//获得用户输入内容
		var content = document.getElementById("keyword").value;
		if(content == ""){
			clearContent();
			return ;
		}
		
		createXmlHttpRequest();
		
		var url = "search?keyword=" + escape(content);
		xmlHttpRequest.open("get", url, true);
		
		xmlHttpRequest.onreadystatechange = function(){
			if(xmlHttpRequest.readyState == 4){
				if(xmlHttpRequest.status == 200){
					var result = xmlHttpRequest.responseText;
					var json = eval("(" + result + ")");
					
					//动态显示到输入框下面
					setContent(json);
					
				}
			}
		};
		xmlHttpRequest.send(null);
	}
	
	function setContent(contents){
		
		//清空
		clearContent();
		
		//获取关联数据的长度
		var size = contents.length;
		if(contents.length != 0){
			//设置位置
			setLocation();
		}
		
		
		//设置内容
		for(var i = 0;i < size; ++i){
			var nextNode = contents[i];
			var tr = document.createElement("tr");
			var td = document.createElement("td");
			td.setAttribute("border", "0");
			td.setAttribute("bgColor","#FFFAFA");
			td.onmouseover = function(){
				this.className = "mouseOver";
			};
			td.onmouseout = function(){
				this.className = "mouseOut";
			};
			td.onclick = function(){
				document.getElementById("keyword").value = this.innerText;
			};
			var text = document.createTextNode(nextNode);
			td.appendChild(text);
			tr.appendChild(td);
			document.getElementById("content_table_body").appendChild(tr);
		}
	}
	
	//清空body中的数据
	function clearContent(){
		var contentTableBody = document.getElementById("content_table_body");
		var size = contentTableBody.childNodes.length;
		for(var i = size - 1; i >= 0; --i){
			contentTableBody.removeChild(contentTableBody.childNodes[i]);
		}
		
		document.getElementById("popDiv").style.border = "none";
	}
	
	//当输入框失去焦点的时候清空
	function keywordBlur(){
		clearContent();
	}
	
	function setLocation(){
		var content = document.getElementById("keyword");
		var width = content.offsetWidth;//输入框宽度
		var left = content["offsetLeft"];//距离左边框的距离
		var top = content["offsetTop"] + content.offsetHeight;//到顶部的距离
		
		//获取显示数据的div
		var popDiv = document.getElementById("popDiv");
		popDiv.style.border = "black 1px solid";
		popDiv.style.left = left + "px";
		popDiv.style.top = top + "px";
		popDiv.style.width = width + "px";
		
		document.getElementById("content_table").style.width = width + "px";
	}
</script>
</head>
<body>
	<div id="mydiv">
		<!-- 输入框 -->
		<input size="20" id="keyword" onkeyup="getMoreContent();" onblur="clearContent();"  onfocus="getMoreContent();"/>
		<input type="button" value="百度一下" width="50px"/>
		<!-- 内容展示区域 -->
		<div id="popDiv">
			<table id="content_table" bgcolor="#FFFAFA" border="0" cellpadding="0" cellspacing="0">
				<tbody id="content_table_body"></tbody>
			</table>
		</div>
	</div>
</body>
</html>