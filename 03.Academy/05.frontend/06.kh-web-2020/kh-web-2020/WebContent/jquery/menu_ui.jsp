<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu_ui</title>
<link rel='stylesheet' type='text/css'
   href='https://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css'/>

<script src="https://code.jquery.com/jquery-3.5.1.js" 
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" 
        crossorigin="anonymous"></script>
<script src='http://code.jquery.com/ui/1.12.1/jquery-ui.js'></script>
<style>
.menu{ width:120px;}
</style>
</head>
<body>
<div id='menu_ui'>
	<ul class='menu'>
		<li><a href='#' class='ui-state-disabled'>강이름</a></li>
		<li><a href='#'>산이름</a></li>
		<li><a href='#'>과일명</a></li>
		<li>
			<a href='#'>동물명</a>
			<ul>
				<li><a href='#'>사자</a></li>
				<li><a href='#'>고양이</a></li>
				<li><a href='#'>강아지</a></li>
				<li><a href='#'>원숭이</a></li>
				<li><a href='#'>사슴</a></li>
			</ul>
		</li>
	</ul>
</div>
<script>
$('#menu_ui>.menu').menu();
</script>
</body>
</html>