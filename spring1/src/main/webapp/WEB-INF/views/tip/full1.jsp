<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>full1.jsp</title>
<script src="../resources/jquery/jquery-3.4.1.js"></script>
<link rel='stylesheet'
href="../resources/fullcalendar-4.2.0/packages/core/main.css">
<link rel='stylesheet'
href="../resources/fullcalendar-4.2.0/packages/daygrid/main.css">
<script
src="../resources/fullcalendar-4.2.0/packages/core/main.js"></script>
<script
src="../resources/fullcalendar-4.2.0/packages/daygrid/main.js"></script>
</head>
<body>
<script>
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		plugins: [ 'dayGrid' ]
	});
	calendar.render();
});
</script>

<div id="calendar" style="width:50%;"></div>

</body>
</html>
