<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	param.n > 3 : ${param.n ge 3 }<br>
	empty param.n : ${empty param.n}<br>
	empty param.n : ${not empty param.n}<br>
	empty param.n : ${empty param.n ? '값이 비었습니다.' : param.n}<br>
</body>
</html>