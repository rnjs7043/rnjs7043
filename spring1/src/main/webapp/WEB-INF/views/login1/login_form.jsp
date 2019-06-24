<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login_form.jsp</title>
<script src="../resources/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#btn_login").click(function() {
		$.post("/login1/login"
				,{
					id:$("#id").val()
					,pass:$("#pass").val()
				}//data
				,function(data,status){
					if(status == "success") {
						if(data == -1){
							alert("아이디를 확인하세요.");
						} else if(data == -2) {
							alert("비밀번호를 확인하세요.");
						} else if(data > 0) {
							alert("로그인 성공");
							location.reload();
						} else {
							alert("일시적 장애 입니다.");
						}
					} else {
						alert("admin : 02-5555-7777");
					}
				}//function
		);//post
	});//btn_login
});//ready
</script>
</head>
<body>

<c:choose>
	<c:when test="${usrVO != null && usrVO.id != null
				&& usrVO.id != ''}">
		<h1>${usrVO.name}님 환영합니다.</h1>
		<button id="btn_logout">Log Out</button>
		<button id="btn_my_page">My Page</button>
	</c:when>
	<c:otherwise>
		<form id="form_login">
			<br><br>아이디 :
			<input type="text" id="id" name="id" />
			<br><br>비밀번호 :
			<input type="password" id="pass" name="pass" />
			<br><br>
		</form>
		
		<button id="btn_login">Log In Check</button>
		<button id="btn_login2">Log In Session Setting</button>
	</c:otherwise>
</c:choose>

<form id="form_go_my_page" action="/member1/mypage"
		method="get">
	<input type="hidden" id="no" name="no"
			value="${usrVO.no}" />
</form>

<script type="text/javascript">
$(document).ready(function() {
	$("#btn_login2").click(function() {
		$.post("/login1/login2"
				,{
					id:$("#id").val()
					,pass:$("#pass").val()
				}//data
				,function(data,status){
					if(status == "success") {
						if(data < 0){
							alert("잘못된 아이디 또는 비밀번호 입니다.");
						} else if(data > 0) {
							alert("로그인 성공");
							location.reload();
						} else {
							alert("일시적 장애 입니다.");
						}
					} else {
						alert("admin : 02-5555-7777");
					}
				}//function
		);//post
	});//btn_login2
	$("#btn_logout").click(function() {
		$.get("/login1/logout"
				,function(data,status){
					if(status == "success") {
						location.reload();
					} else {
						alert("admin : 02-5555-7777");
					}
				}//function
		);//get
	});//btn_logout
	$("#btn_my_page").click(function() {
		$("#form_go_my_page").submit();
	});//btn_my_page
});//ready
</script>

</body>
</html>
