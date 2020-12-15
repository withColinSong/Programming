<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select</title>
<link rel=stylesheet type="text/css" href="./css/gestbook.css">
<script src="./js/guestbook.js"></script>
</head>
<body>
	<div id="guestbook">
		<h2>방명록</h2>
	</div>
	<form name="frm_gb" id="frm_gb" method="post">
		<input type="search" name="findStr" size="30" placeholder="작성자나 내용으로 검색">
		<input type="button" value="검색" id="btnFind">
	</form>
	<div id="list">
		<div id="item">
			<label>작성자</label>
			<output class="mid"></output>
			<label>작성일자</label>
			<output class="mdate"></output>
			<div>
			<textarea rows="5" cols="80"></textarea>
			</div>
			<div class="btns">
				<input type="button" value="수정" id="btnUpdate">
				<input type="button" value="삭제" id="btnDelete">
			</div>
		</div>
	</div>
</body>
</html>