$(() => {
	var xmlHttpRequest;
	var num = 1;
	var arr = new Array("text", "xml");
	
	var type = arr[0];
	
	//自动刷新
	var fn_load = () => {
		(() => {
			if(window.XMLHttpRequest){
				xmlHttpRequest = new XMLHttpRequest();
			}else if(window.ActiveXObject){
				try{
					xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
				}catch(e){
					xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");					
				}
			}	
		})();
			
		var url = "autoRefresh";
		xmlHttpRequest.open("post", url, true);
		//如果是post请求，需要手动加上content-type
		xmlHttpRequest.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
		xmlHttpRequest.onreadystatechange = () => {
			if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
				if(type == "text")
					num = xmlHttpRequest.responseText;
				else if(type == "xml")
					//num = xmlHttpRequest.responseXML.getElementsByTagName("num").firstChild.nodeValue;
					//等价于
					num = $("num", xmlHttpRequest.responseXML).text();
				$("#tb1 #num1").text(num);
				setInterval(fn_load, 1000);
			}
		}
		xmlHttpRequest.send("num=" + num + "&type=" + type);
	};
	fn_load();

		
	$("#domRefresh").click(() =>{
		var num = $("#tb6 #num6").text();
		num++;
		$("#tb6 #num6").text(num);
	})
	
	var age = 12;
	$("#add").click(() => {
		age++;
		var tr = "";
		tr += "<tr><td>";
		tr += "Amy" + (age - 12);
		tr += "</td><td>";
		tr += age;
		tr += "</td></tr>";
		$("#tb2").append(tr);
	})
	
	$("#del1").click(() => {
		$("#tb2 tr:gt(0)").remove()
	})
	$("#del2").click(() => {
		$("#tb2 tr:eq(1)").remove()
	})
	$("#del3").click(() => {
		$("#tb2 tr:last").remove()
	})
	
	$("#ajaxRefreshText").click(() => {
		$.ajax({
			url:"autoRefresh",
			type:"post",
			data:{
				"num":$("#tb3 #num3").text(),
				"type":"text"
			},
			dataType:"text",
			success:(data)=>{
				//alert(data)
				num = data;
				$("#tb3 #num3").text(num);
			}
		})
	})
	
	$("#ajaxRefreshXML").click(() => {
		$.ajax({
			url:"autoRefresh",
			type:"post",
			data:{
				"num":$("#tb4 #num4").text(),
				"type":"xml"
			},
			dataType:"xml",
			success:(data)=>{
				num = $("num", data).text();
				$("#tb4 #num4").text(num);
			}
		})
	})
	
	$("#ajaxRefreshJson").click(() => {
		$.ajax({
			url:"autoRefresh",
			type:"post",
			data:{
				"num":$("#tb5 #num5").text(),
				"type":"json"
			},
			dataType:"json",
			success:(data) => {
				$("#tb5 #num5").text(data.num);
			},
			error:() => {
				alert("访问请求出错...");
			}
		})
	})
})



