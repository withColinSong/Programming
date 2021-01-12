<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sale_select</title>
</head>
<body>
	<div id="sale_select">
		<h1>판매 실적</h1>
		<form name="frm" method="POST" action="/kh-web-2020/sale.yeon">
			<input type="submit" value="조회"/>
			<a href="/kh-web-2020/filter/filter_main.jsp">HOME</a>
		</form>
		<hr/>
		${msg }
	</div>
</body>
</html>