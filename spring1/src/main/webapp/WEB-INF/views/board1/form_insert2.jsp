<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form_insert.jsp</title>
<script src="../resources/jquery/jquery-3.4.1.js"></script>
<script src="../resources/ckeditor/ckeditor.js"></script>
<script>
$(document).ready(function() {
	$("#btn_write").click(function() {
		if($.trim($("#title").val()) == ""){
			alert("제목을 확인하세요.");
			return;
		}
		if($.trim($("#writer").val()) == ""){
			alert("작성자를 확인하세요.");
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
		$.post("/board1/insert"
				,{
					title:$("#title").val()
					,writer:$("#writer").val()
					,pass:$("#pass").val()
					,cnts:ckobj.getData()
				}//data
				,function(data,status){
// 					alert(data); alert(status);
					if(status == "success"){
						if(data > 0){
							alert("저장 되었습니다.");
							location.href="/board1/list";
						} else {
							alert("잠시 후에 다시 시도해 주세요.");
						}
					} else {
						alert("admin : 02-5555-7777");
					}
				}//function
		);//post
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
<h1>자유 게시판 글 쓰기</h1>
<form id="form_write">
	<br><br>제목 :
	<input type="text" id="title" name="title"
			maxlength="30" />
	<br><br>작성자 :
	<input type="text" id="writer" name="writer"
			maxlength="20" />
	<br><br>게시글 비밀번호 :
	<input type="text" id="pass" name="pass"
			maxlength="13" />
	<br><br>내용 :
	<textarea rows="5" cols="35" id="cnts" name="cnts"></textarea>
	<script>
		CKEDITOR.replace('cnts');
	</script>
</form>
<br><br>
<input type="button" id="btn_write" value="게시글 전송" />
</body>
</html>
