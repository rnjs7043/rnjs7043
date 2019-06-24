<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail.jsp</title>
<script src="../resources/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#btn_delete").click(function() {
		var del_yn = false;
		del_yn = confirm("really ???");
		if(del_yn == false){
			return;
		}
		$.get("/board1/delete"
				,{
					no:$("#hid_no").val()
				}//data
				,function(data,status) {
					if(status == "success") {
						if(data > 0){
							alert("삭제 되었습니다.");
							location.href="/board1/list";
						} else {
							alert("잠시 후 다시 시도해 주세요.");
						}
					} else {
						alert("admin : 02-5555-7777");
					}
				}//function
		);//get
	});//btn_delete
	$("#btn_update").click(function() {
		location.href="/board1/formu?no=${detailVO.no}";
	});//btn_update
});//ready
</script>
</head>
<body>

<br><br>
<h1>게시글 상세 보기</h1>
<br><br>
<input type="hidden" id="hid_no" value="${detailVO.no}" />
<table border="1">
	<tr>
		<th>번호</th>
		<td>${detailVO.no}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${detailVO.title}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${detailVO.writer}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${detailVO.pass}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${detailVO.cnts}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${detailVO.write_date}</td>
	</tr>
	<tr>
		<th>첨부 파일</th>
		<td>
			<a href="/board1/filedown?no=${detailVO.file_no}">${detailVO.file_name}</a>
		</td>
	</tr>
</table>
<br><br>
<button id="btn_delete">삭제</button>
<button id="btn_update">수정</button>

</body>
</html>
