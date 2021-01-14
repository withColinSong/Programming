<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회 페이지</title>
<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
</head>
<body>
<h1>회원조회 페이지</h1>
<hr/>
<form name="frm" id="select_frm">
<input type="text" name="frm_text" id="frm_data" value="당산지원"/>
<input type="button" name="btn" value="조회하기" id="btn"/>
<div id="result"></div>
</form>
<script>

$('#btn').on('click', function() {
	var findStr = $('#frm_data').val();
	var sendData = { 'findStr' : findStr};
	
	console.log(sendData);
	
	$.ajax({
		
		url: 'searchKH',
		data: sendData,
		type: 'post',
		dataType: 'json',
		success:function(data) {
			console.log(data);
			var result 
			= "<ul><li>" + data.kh_no
			+ "<li>" + "kh_name : " + data.kh_name
			+ "<li>" + data.addr
			+ "<li>" + data.fax
			+ "</ul>";
			$('#result').html(result);

			},
			
		error: function() {
			
			}	
		
		})
		
})


</script>
</body>
</html>