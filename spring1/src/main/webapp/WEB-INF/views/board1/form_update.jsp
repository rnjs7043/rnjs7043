<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form_update.jsp</title>
<script src="../resources/jquery/jquery-3.4.1.js"></script>
<script src="../resources/ckeditor/ckeditor.js"></script>
<script>
$(document).ready(function() {
	$("#btn_update").click(function() {
		if($.trim($("#title").val()) == ""){
			alert("제목을 확인하세요.");
			return;
		}
		if($.trim($("#pass").val()) == ""){
			alert("비밀번호를 확인하세요.");
			return;
		}
		if($.trim($("#pass").val()).length < 3){
			alert("비밀번호는 3자리 이상입니다.");
			return;
		}
		var ckobj = CKEDITOR.instances.cnts;
		if($.trim(ckobj.getData()) == ""){
			alert("내용을 확인하세요.");
			return;
		}
		var form = new FormData(
				document.getElementById("form_write"));
		form.append("cnts",ckobj.getData());
		$.ajax({
			type:"POST"
			,encType:"multipart/form-data"
			,url:"/board1/update"
			,data:form
			,processData:false
			,contentType:false
			,cache:false
			,success:function(result){
				if(result == -1){
					alert("비밀번호가 맞지 않습니다.");
				} else if(result > 0){
					alert("수정 되었습니다.");
					location.href="/board1/list";
				} else {
					alert("일시적 장애 입니다.\n"
						+"잠시 후에 다시 시도해 주세요.");
				}
			}
			,error:function(xhr){
				alert("admin : 02-5555-7777");
			}
		});//ajax
	});//btn_write
});//ready
</script>
<script type="text/javascript">
$(document).ready(function() {
	$("#pass").keyup(function(event) {
		//alert(event.keyCode);
		$("#pass").val(
			$("#pass").val().replace(/[^a-z A-Z 0-9\.]/g,'')
		);//한글 입력 방지
	});//pass.keydown
});//ready
</script>
</head>
<body>

<br><br>
<h1>자유 게시판 글 수정</h1>
<form id="form_write" enctype="multipart/form-data">
	<br><br>글번호 :
	<input type="text" id="no" name="no"
			value="${detailVO.no}"
			readonly="readonly"
			style="background-color:lightgray" />
	<br><br>제목 :
	<input type="text" id="title" name="title"
			maxlength="30" value="${detailVO.title}" />
	<br><br>작성자 :
	<input type="text" id="writer" name="writer"
			value="${detailVO.writer}"
			readonly="readonly"
			style="background-color:lightgray" />
	<br><br>게시글 비밀번호 :
	<input type="text" id="pass" name="pass"
			maxlength="13" />
	<br><br>내용 :
	<textarea rows="5" cols="35" id="cnts" name="cnts">${detailVO.cnts}</textarea>
	<script>
		CKEDITOR.replace('cnts',{
			filebrowserUploadUrl:"/ckupload?type=Files"
		});
	</script>
</form>
<br><br>
<input type="button" id="btn_update" value="게시글 수정" />

</body>
</html>
