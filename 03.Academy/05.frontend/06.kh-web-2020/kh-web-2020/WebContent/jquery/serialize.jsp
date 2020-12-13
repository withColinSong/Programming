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
	<form name='frm_serialize' method='post' id='frm_serialize'>
		<label>아이디</label>
		<input type='text' name='mid' value='a001'><br/>
		<label>이름</label>
		<input type='text' name='mName' value='홍길동' /><br/>
		<label>연락처</label>
		<input type='text' name='phone' value='010-1234-1234'> <br/>
		
		<input type='submit' value="전송">
	</form>
</div>
<script>
	$('#frm_serialize').submit(function(){
		let data = $(this).serialize();
		console.log(data);
		return false; //submit 기능 중지.
	}) 

</script>








</body>
</html>