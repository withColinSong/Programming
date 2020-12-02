<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>traverse</title>
<script src="../lib/jquery-3.5.1.js"></script>
</head>
<body>
<div id='traverse'>
	<h1>TRAVERSE</h1>
	<fieldset>
		<legend>traverse</legend>
		<ul>
			<li>traverse는 `.`을 찍어서 표현한다.</li>
			<li>명령어는 filter와 traverse가 매우 유사하거나, 상중된다.</li>
		</ul>
	</fieldset>
	<ul>
		<li>index 0</li>
		<li>index 1</li>
		<li>index 2</li>
		<li>index 3</li>
		<li>index 4</li>
		<li>index 5</li>
		<li>index 6</li>
		<li>index 7</li>
	</ul>
</div>
<script>
$('#traverse>ul>li').first().css('color', 'red');
$('#traverse>ul>li').filter(':odd').css('color', 'blue');
$('#traverse>ul>li').slice(1,4).css('font-family', '궁서체'); // slice (s, e) s보다 크거나 같고 e보다 같거나 작다.

</script>
</body>
</html>