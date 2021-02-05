<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="css/board.css"/>
</head>
<body>
	<div id="board">
		<h1>일반 공지 게시판</h1>
		<c:forEach var="vo" items="${list }">
			<div>${vo.mid }</div>
			<div>${vo.subject }</div>
		</c:forEach>
	</div>
</body>
</html>