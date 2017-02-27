<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="bookServlet?method=getBooks" method="post">
			Price:
			<input size="1" name="minPrice"/>
			<input size="1" name="maxPrice"/>
			<input type="submit" value="查询" />
		</form>
		
		<br/>
		<br/>
		<table>
			<c:forEach items="${bookpage.list}" var="book">
				<tr>
					<td>
						<a href="">${book.title }</a><br/>
						${book.author }
					</td>
					<td>${book.price }</td>
					<td><a href="">加入购物车</a></td>
				</tr>
			</c:forEach>
		</table>
		<br/><br/>
		
		共${bookpage.totalItemNumber }页&nbsp;&nbsp;
		当前第${bookpage.pageNo }页&nbsp;&nbsp;
		<c:if test="${bookpage.hasPrev }">
			<a href="bookServlet?method=getBook&pageNo=1">首页</a>
			&nbsp;&nbsp;
			<a href="bookServlet?method=getBook&pageNo=${bookpage.prevPage }">上一页</a>
		</c:if>&nbsp;&nbsp;
		
		<c:if test="${bookpage.hasNext }">
			<a href="bookServlet?method=getBook&pageNo=${bookpage.nextPage }">下一页</a>
			&nbsp;&nbsp;
			<a href="bookServlet?method=getBook&pageNo=${bookpage.totalPageNumber }">末页</a>
		</c:if>&nbsp;&nbsp;
	</center>
</body>
</html>