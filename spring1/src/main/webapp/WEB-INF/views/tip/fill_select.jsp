<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fill_select.jsp</title>
<script src="../resources/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#select1").change(function() {
		if($("#select1").val() == 0){
			alert("대분류를 선택 하세요.");
			return;
		}//if
		$.get("/tip/fill2"
				,{
					l_no:$("#select1").val()
				}//data
				,function(data,status){
					if(status == "success"){
						$("#select2").empty();
						$("#select2").append(
							"<option value='0' selected='selected'>"
							+"전체</option>"
						);//append
						$("#select3").empty();
						$("#select3").append(
							"<option value='0' selected='selected'>"
							+"전체</option>"
						);//append
						$.each(data,function(index,vo){
							$("#select2").append(
								"<option value="+vo.m_no+">"
								+vo.m_nm
								+"</option>"
							);//append
						});//each
					} else {
						$("#select2").empty();
						$("#select2").append(
							"<option value='0' selected='selected'>"
							+"전체</option>"
						);//append
						$("#select3").empty();
						$("#select3").append(
							"<option value='0' selected='selected'>"
							+"전체</option>"
						);//append
					}//if
				}//function
				,"json"
		);//get
	});//select1.change
	$("#select2").change(function() {
		if($("#select1").val() == 0){
			alert("대분류를 선택 하세요.");
			return;
		}//if
		if($("#select2").val() == 0){
			alert("중분류를 선택 하세요.");
			return;
		}//if
		$.get("/tip/fill3"
				,{
					l_no:$("#select1").val()
					,m_no:$("#select2").val()
				}//data
				,function(data,status){
					if(status == "success"){
						$("#select3").empty();
						$("#select3").append(
							"<option value='0' selected='selected'>"
							+"전체</option>"
						);//append
						$.each(data,function(index,vo){
							$("#select3").append(
								"<option value='"
								+vo.s_no
								+"'>"
								+vo.s_nm
								+"</option>"
							);//append
						});//each
					} else {
						$("#select3").empty();
						$("#select3").append(
							"<option value='0' selected='selected'>"
							+"전체</option>"
						);//append
					}//if
				}//function
				,"json"
		);//get
	});//select2.change
});//ready
</script>
</head>
<body>

<br><br>대분류 :
<select id="select1">
	<option value="0" selected="selected">전체</option>
	<c:forEach items="${listLarge}" var="vo">
		<option value="${vo.l_no}">${vo.l_nm}</option>
	</c:forEach>
</select>

<br><br>중분류 :
<select id="select2">
	<option value="0" selected="selected">전체</option>
</select>

<br><br>소분류 :
<select id="select3">
	<option value="0" selected="selected">전체</option>
</select>

</body>
</html>
