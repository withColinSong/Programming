<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>each</title>
</head>
<body>
<div id='each'>
	<div id='source'>
		<div><font color ='red'>index 0</font></div>
		<div>index 1</div>
		<div>index 2</div>
		<div>index 3</div>
	</div>
	<div id='target'></div>
	<div id='btns'>
		<input type='button' value='SIZE' id='btnSize'>
		<input type='button' value='TEXT' id='btnText'>
		<input type='button' value='HTML' id='btnHtml'>
		<input type='button' value='EACH' id='btnEach'>
	</div>
</div>
<script>
	
	
	$('#each #btnSize')[0].onclick = function() {
		var len = $('#each>#source>div').length;
		$('#each>#target').html('div 개수 : ' + len);
	}
	
	$('#each #btnText')[0].onclick = function() {
		var div = $('#each>#source>div').get(0);
		// var div = $('#each>#source>div').first();
		var text = $(div).text();
		$('#each #target').text(text);
		
	}

	$('#each #btnHtml')[0].onclick = function() {
		let div = $('#each>#source>div:first');
		let html = $(div).html();
		$('#each #target').html(html);
	}
	
	$('#each #btnEach')[0].onclick = function() {
		let bg = ['#00f', '#44f', '#88f', '#aaf']; 
		$('#each>#source>div').each(
		function(index) {
			$(this).css('background-color', bg[index]);
		});
	}
	

	
	$('#target').css({
			'background-color' : 'pink',
			'width' : '300px',
			'height' : '50px',
			'color' : '#114573',
			'line-height' : '50px'
	});
</script>
</body>
</html>