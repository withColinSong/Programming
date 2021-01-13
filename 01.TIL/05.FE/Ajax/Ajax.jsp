<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery-3.5.1.js" 
	        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" 
	        crossorigin="anonymous"></script>
</head>
<body>
 
<form method="POST">
<input type="text" id="msg" name="msg"/>
<input type="button" id="getResult" value="button"/>
</form>

<div id="result"></div>

<script>
$('#getResult').click(function(){

 	var fullname = $('#msg').val();
	$.ajax({
		
		type:'POST',
		success:function(result) {
			$('#result').html(fullname);
		},
		
		error:function(data, textStatus) {
		alert('실패');
		},
		
	});
});
</script>
</body>
</html>