<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form_addr.jsp</title>
<script src="../resources/jquery/jquery-3.4.1.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".callAddrPop").click(function() {
		new daum.Postcode({
		    oncomplete: function(data) {
		    	$("#addrCode").val(data.zonecode);
		    	$("#addr1").val(data.address);
		    }
		}).open();
	});//callAddrPop.click
});//ready
</script>
</head>
<body>

<br><br>우편번호 :
<input type="text" id="addrCode" name="addrCode"
	placeholder="click here" class="callAddrPop"
	readonly="readonly" style="background-color:lightgray" />
<br><br>주소 :
<input type="text" id="addr1" name="addr1" size="50"
	placeholder="click here" class="callAddrPop"
	readonly="readonly" style="background-color:lightgray" />
<br><br>나머지 주소 :
<input type="text" id="addr2" name="addr2" />

</body>
</html>
