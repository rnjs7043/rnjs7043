<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form_ck.jsp</title>
<script src="../resources/jquery/jquery-3.4.1.js"></script>
<script src="../resources/ckeditor/ckeditor.js"></script>
</head>
<body>

<br><br>
<h1>CKEditor File Upload</h1>
<textarea id="cnts" rows="10" cols="50"></textarea>
<script>
	CKEDITOR.replace("cnts",{
		filebrowserUploadUrl:"/ckupload?type=Files"
	});
</script>

</body>
</html>
