<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>date1.jsp</title>
<script src="../resources/jquery/jquery-3.4.1.js"></script>
<link rel="stylesheet"
href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#calendar").datepicker({
		altField:"#hid_date1"
		,altFormat:"yy-mm-dd"
	});//calendar.datepicker
	$("#input_date").datepicker({
		changeMonth:true
		,changeYear:true
		,dateFormat:"yy-mm-dd"
	});
});//ready
</script>
</head>
<body>

<br><br>열린 달력 :
<div id="calendar"></div>
<br><br>열린 달력 data :
<input type="text" id="hid_date1" />
<br><br>클릭하면 열리는 달력 :
<input type="text" id="input_date" />

</body>
</html>
