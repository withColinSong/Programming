<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>parameterValues</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
</head>
<body>
	<div id="parameter">
		<div id="result"></div>
		<h3>parameter values</h3>
		<form name='frm_param' method='get' id="frm_param"> <!--폼태그에 action 생략될 경우 submit은 자신에게 전달--> 
			<div>
			<label for="mid">아이디</label>
			<input type="text" id='mid' name='mid' value="Song">
			</div>
			
			<div>
			<label>성별</label>
			<label><input type='radio' name='gender' value='M'>남성</label>
			<label><input type='radio' name='gender' value='F'>여성</label>
			</div>
			
			<div>
			<label>취미</label>
			<label><input type="checkbox" value="영화보기" name="hobby">영화보기</label>
			<label><input type="checkbox" value="독서하기" name="hobby">독서하기</label>
			<label><input type="checkbox" value="공부하기" name="hobby">공부하기</label>
			<label><input type="checkbox" value="맛집탐방" name="hobby">맛집탐방</label>
			<label><input type="checkbox" value="코딩하기" name="hobby">코딩하기</label>
			</div>
			
			<div>
				<label>선택과목</label>
				<select name='subject' size='6' multiple>
					<option value='html5'>HTML5</option>
					<option value='css'>CSS</option>
					<option value='javacript'>JavaScript</option>
					<option value='java'>JAVA</option>
					<option value='jsp'>JSP</option>
					<option value='ajax'>Ajax</option>
					<option value='jquery'>jQuery</option>
				</select>
			</div>
			<div>
				<input type='file' name='attFile' multiple> <!-- Ctrl로 눌러서 다중으로 선택 -->
			</div>
			<input type="submit" value='실행' id='btnRun'>
		</form>
	</div>
	<script>
		$('#btnRun').on('click', function() {
			var param = $('#frm_param').serialize();
			$('#result').load('./jsp/parameterValuesCtrl.jsp', param);
		});
	</script>
</body>
</html>