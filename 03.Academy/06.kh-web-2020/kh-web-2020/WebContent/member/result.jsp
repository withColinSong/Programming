<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작업결과 Result</title>
<link rel="stylesheet" href="./css/member.css" type="text/css">
<script src="./js/member.js"></script>

</head>
<body>
	<div id="member">
		<div class="result_msg">
			작업이 처리 되었습니다.
		</div>
	</div>
	<form name="frm_member" method='post'>
	<input type='text' name='findStr' value='${param.findStr }' />
	<input type='text' name='nowPage' value='${param.nowPage }' />
		<div class="btn">
		<input type="button" value="목록" id="btnSelect">
		</div>
	</form>
<script>member()</script>
</body>
</html>