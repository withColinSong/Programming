<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_select</title>
</head>
<body>
	<div id="member_select">
		<h1>회원조회</h1>
		<form name="frm" method="POST" action="/kh-web-2020/member.song">
		<input type="submit" value="조회"/>
		<a href="/kh-web-2020/filter/filter_main.jsp">HOME</a>
		</form>
		<hr/>
		${msg }
	</div>
</body>
</html>