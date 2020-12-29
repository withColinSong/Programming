<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESULT</title>
<link rel="stylesheet" type="text/css" href="./css/board.css"/>
<script src="./js/board.js"></script>
</head>
<body>
	<div id="board">
		<div id="msg">
			입력|수정|삭제|댓글 처리가 됨
		</div>
		<form name="frm_board" method="post">
			<input type="button" value="목록" id="btnSelect"/>
			<input type="text" name="findStr" value="${param.findStr }">
			<input type="text" name="nowPage" value="${param.nowPage }">
		</form>
	</div>
	<script>
		board();
	</script>
</body>
</html>