<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>serialize</title>
</head>
<body>
<div id='serialize'>
	<form name='form_serialize' id='form_serialize' method='post' accept-charset="utf-8">
		<label>아이디</label>
		<input type='text' name='mid' value='a001'><br>
		<label>이름</label>
		<input type='text' name='mName' value='song'><br>
		<label>연락처</label>
		<input type='text' name='phone' value='010-1234-5678'>
		
		<input type='submit' value='전송'>
	</form>

</div>
<script>
/* $('#form_serialize')[0].onsubmit = function() {} //js callback 함수 */
$('#form_serialize').submit(function() {
	let data = $(this).serialize();
	console.log(data);
	return false; // submit 기능이 중지
}) //jq
</script>
</body>
</html>