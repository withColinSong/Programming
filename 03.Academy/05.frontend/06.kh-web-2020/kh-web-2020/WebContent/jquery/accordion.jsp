<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accordion</title>
<link rel='stylesheet' type='text/css'
   href='https://code.jquery.com/ui/1.12.1/themes/sunny/jquery-ui.css'/>
<script src='http://code.jquery.com/ui/1.12.1/jquery-ui.js'></script>

</head>
<body>
<div id='accordion'>
	<h2>HTML5</h2>
	<div>
		<ul>
			<li>웹표준의 시작</li>
			<li>현재 5버전이지만 대중화된 버전은 4.x대 버전</li>
			<li>canvas나 localStorage등과 같은 기술이 있지만 국내에서는 아직은 ... </li>
		</ul>
	</div>
	
	<h2>CSS3</h2>
	<div>
		<img src='./images/bg.png' width='200px' height='120px' />
	</div>
	
	<h2>JavaScript</h2>
	<h2>Java</h2>
	<h2>JSP</h2>
	<h2>Oracle</h2>
	<h2>Spring</h2>
</div>
<script>
	$('#accordion').accordion();
</script>
</body>
</html>