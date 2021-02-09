<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
</head>
<body>

<div id="board">
	<form name="frm_board" id="frm_board" method="post">
		
		<label>작성자</label>
		<input type="text" name="mid" value="song"/>
		<br/>
		
		<label>제목</label>
		<input type="text" name="subject" value="hi"/>
		<br/>
		
		<label>파일첨부</label>
		<input type="file" name="attFile" multiple="multiple"/>
		<p/>
		
		<input type="button" id="btnSave"  value="저장"/>
		<input type="button" id="btnList" value="목록"/>
	</form>
</div>
<script>
brd();
</script>
</body>
</html>