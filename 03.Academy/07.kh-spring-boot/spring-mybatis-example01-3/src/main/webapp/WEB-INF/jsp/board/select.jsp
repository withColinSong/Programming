<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="css/board.css"/>
<script src="js/index.js"></script>
<script src="js/board.js"></script>
</head>
<body>
	<div id="board">
		<h1>일반 공지 게시판</h1>
		
		<form name="frm_board" id="frm_board" method="POST">
			<input type="button" value="공지추가" id="btnInsert"/>
			<input type="text" name="findStr"/>
			<input type="button" value="검색" id="btnFind"/>
			<input type="hidden" value="1"/>
			<input type="hidden" value="1"/>
		</form>
	
		<hr/>
		
		<c:forEach var="vo" items="${list }">
			<div>${vo.mid }</div>
			<div>${vo.subject }</div>
		</c:forEach>
		
	</div>
</body>

<script>
brd();
</script>
</html>