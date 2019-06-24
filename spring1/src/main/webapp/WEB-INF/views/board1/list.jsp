<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<script src="../resources/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#btn_write").click(function() {
		location.href = "/board1/formi";
	});//btn_write
	$("#btn_write2").click(function() {
		location.href = "/board1/formi2";
	});//btn_write2
	$("#btn_write3").click(function() {
		location.href = "/board1/formi3";
	});//btn_write3
	$("#btn_write4").click(function() {
		location.href = "/board1/formi4";
	});//btn_write4
	$("#btn_write5").click(function() {
		location.href = "/board1/formi5";
	});//btn_write4
});//ready
</script>
</head>
<body>

<br><br>
<button id="btn_write">게시글 쓰기</button>
<button id="btn_write2">게시글 쓰기2</button>
<button id="btn_write3">게시글 쓰기3</button>
<br><br>
<button id="btn_write4">CK 이미지 처리</button>
<button id="btn_write5">CK image + file upload</button>
<br><br>
<table border="1">
	<c:forEach items="${boardList}"
				var="vo" varStatus="status">
		<tr>
			<td>${vo.no}</td>
			<td>
				<a href="/board1/detail?no=${vo.no}">
					${vo.title}
				</a>
			</td>
			<td>${vo.writer}</td>
			<td>${vo.pass}</td>
			<td>${vo.cnts}</td>
			<td>${vo.write_date}</td>
		</tr>
	</c:forEach>
</table>

<c:if test="${endPage != null && endPage > 0}">
	<c:if test="${startPage > 10}">
	<a href="/board1/list2?page=${startPage - 1}">prev</a>
	</c:if>
	<c:forEach begin="${startPage}" end="${endPage}" step="1"
				var="printNo" varStatus="status">
		<a href="/board1/list2?page=${printNo}">${printNo}</a>
	</c:forEach>
	<c:if test="${endPage < totPage}">
	<a href="/board1/list2?page=${endPage + 1}">next</a>
	</c:if>
</c:if>
<br><br>

</body>
</html>
