<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my_page.jsp</title>
</head>
<body>

<c:choose>
	<c:when test="${usrVO == null
					|| usrVO.id == null
					|| usrVO.id == ''}">
		<h1>Log In Please !!!</h1>
		<h1><a href="/login1/form1">Go to Log In</a></h1>
	</c:when>
	<c:otherwise>

		<h1>${usrVO.no}</h1>
		<h1>${usrVO.id}</h1>
		<h1>${usrVO.pass}</h1>
		<h1>${usrVO.name}</h1>
		<h1>${usrVO.tel}</h1>
		<h1>${usrVO.email}</h1>
		<h1>${usrVO.join_date}</h1>

	</c:otherwise>
</c:choose>

</body>
</html>
