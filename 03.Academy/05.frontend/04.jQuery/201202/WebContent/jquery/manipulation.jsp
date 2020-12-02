<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manipulation</title>
</head>
<body>
<div id='main'>
	<div id='target'>TARGET</div>
	<div id='btn_zone'>
		<input type='button' value='WRAP' id='btnWrap' onclick='abc(this)'> 
		<input type='button' value='APPEND' id='btnAppend'>
		<input type='button' value='PREPEND' id='btnPrepend'>
	</div>
</div>
<script>
	
	/* 이벤트 처리 방법 1번
	- 단점 : 이 버튼을 함부로 건들일 수가 없다.*/
	function abc(button) {
		console.log(button.value);
		var wrap ="<lable><input type='checkbox'>확인</lable>";
	    $('#main>#target').wrap(wrap); // 타겟 뒤쪽에 체크박스가 생긴다.
	}
	
	
	/* 이벤트 처리방법 2번*/
	var btnAppend = $('#btnAppend')[0];
	btnAppend.onclick = function() {
		console.log(this.value);
		var wrap = "<lable><input type='checkbox'>확인</lable>";
		for(var i = 0 ; i < 5; i++ ){
			$('#main>#target').append(wrap); // 타겟 뒤쪽으로 계속 생성.
		}

	}
	
	
	/* 이벤트 처리방법 3번 */
	var btnPrepend = document.getElementById('btnPrepend');
	btnPrepend.onclick = function() {
		console.log(this.value);
		var wrap = "<lable><input type='checkbox'>확인</lable>";
		$('#main>#target').prepend(wrap); // 타겟 앞쪽에 체크박스가 생김.
	}

	
</script>
</body>
</html>
