<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file1</title>
<script src="../resources/jquery/jquery-3.4.1.js"></script>
</head>
<body>

<br><br>

<h1>1. 첨부 파일 하나 올리기</h1>
<form action="/tip/fileUp1" method="post"
		enctype="multipart/form-data">
	<input type="file" id="chumbu" name="chumbu" />
	<br><br>
	<input type="submit" value="파일 전송" />
</form>

<br><br>
<hr>
<br><br>

<h1>2. 첨부 파일 하나 이름 바꿔 올리기</h1>
<form id="form2" action="/tip/fileUp2" method="post"
		enctype="multipart/form-data">
	<input type="file" id="chumbu" name="chumbu" />
	<br><br>
	<input type="submit" value="파일 전송" />
</form>

<br><br>
<button id="btn_ajax">Ajax file upload</button>
<script type="text/javascript">
$(document).ready(function() {
	$("#btn_ajax").click(function() {
		var form = new FormData(
					document.getElementById("form2"));
		$.ajax({
			url:"/tip/fileUp3"
			,data:form
			,dataType:"text"
			,processData:false
			,contentType:false
			,type:"POST"
			,success:function(result){
				alert("success");
			}
			,error:function(xhr){
				alert("fail");
			}
		});//ajax
	});//btn_ajax
});//ready
</script>

<br><br>
<hr>
<br><br>

<h1>3. 첨부 파일 두개 이상 올리기</h1>
<form action="/tip/fileUp3" method="post"
		enctype="multipart/form-data">
	<input type="file" id="chumbu" name="chumbu" />
	<br><br>
	<input type="file" id="chumbu2" name="chumbu2" />
	<br><br>
	<input type="submit" value="파일 전송" />
</form>

<br><br>
<hr>
<br><br>

</body>
</html>
