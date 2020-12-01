<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./lib/jquery-3.5.1.js">
</script>
</head>
<body>
	<ul class="ul">
		<li>li -> index 0</li>
		<li>li -> index 1</li>
		<li>li -> index 2</li>
	</ul>
	<ul class="list">
		<li>li -> index 3</li>
		<li>li -> index 4</li>
		<li>li -> index 5</li>
	</ul>
</body>
<script>
$('.ul:eq(0)').css('color','blue');
</script>

</html>