<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test_mybatis.jsp</title>
</head>
<body>

<table border="1">
	<c:forEach items="${boardList}"
				var="vo" varStatus="status">
		<tr>
			<td>${vo.articleNo}</td>
			<td>${vo.parentNo}</td>
			<td>${vo.title}</td>
			<td>${vo.content}</td>
			<td>${vo.imageFileName}</td>
			<td>${vo.id}</td>
			<td>${vo.writeDate}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>