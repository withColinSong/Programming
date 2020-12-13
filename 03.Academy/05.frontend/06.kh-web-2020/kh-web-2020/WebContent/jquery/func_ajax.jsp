<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>function ajax</title>
</head>
<body>
<div id="func_ajax">
	<h2>ajax in jQuery</h2>
	<form name='frm' method='post' id='frm'>
		<label>단수를 입력하세요 : </label>
		<input type='text' size='4' name = 'dan' value='9'>
		<input type='button' value='구구단 실행' id='btnRun'>
	</form>
	<div id="result"></div>
</div>
<script>
// 파라미터는 맵구조로 전달 받는다.
$('#btnRun').on('click', function(){
	let param = $('#frm').serialize();
	$.ajax({
		type : 'get',
		url : './jquery/gugudan.jsp',
		data : param,
		dataType: 'html',
		success : function(receiveData, status) {
			console.log(receiveData);
			console.log(status);
			$('#result').append(receiveData);
		},
			
		error : function(xhr, status, error) {
			alert(status);
		}
	});
});

</script>
</body>
</html>