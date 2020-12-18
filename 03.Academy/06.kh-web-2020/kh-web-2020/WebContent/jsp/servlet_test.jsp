<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>servlet_test</title>
</head>
<body>
<div id='servlet_test'>
	<h3>Servlet Test(GET|POST)</h3>
	<div>
		이클립스의 콘솔창을 확인하세요.
	</div>
	<ul>
		<li><a href="test.do?mid=song&phone=010-1111-1111">GET Test</a></li>
	</ul>
	<form name ="frm" action="test.do" method="POST">
		<div>
		<label>이름</label>
		<input type="text" name="name" value="song">
		</div>
		<div>
		<label>주소</label>
		<input type="text" name="address" value="Seoul">
		</div>
		<input type="submit" value="POST 타입전송">
	</form>
</div>
</body>
</html>