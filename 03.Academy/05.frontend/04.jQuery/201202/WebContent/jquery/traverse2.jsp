<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>traverse</title>
<script src="../lib/jquery-3.5.1.js"></script>
</head>
<body>
<div id='traverse'>
	<h1>TRAVERSE</h1>
	<fieldset>
		<legend>traverse</legend>
		<ul>
			<li>traverse는 `.`을 찍어서 표현한다.</li>
			<li>명령어는 filter와 traverse가 매우 유사하거나, 상중된다.</li>
		</ul>
	</fieldset>
	<ul>
		<li>index 0</li>
		<li>index 1</li>
		<li>index 2</li>
		<li>index 3</li>
		<li>index 4</li>
		<li>index 5</li>
		<li>index 6</li>
		<li>index 7</li>
	</ul>
	
	<!-- .parent() example code -->
	<div id='div1'>
		<input type='button' value='x' class="btn1">
	</div>
	<div id='div2'>
		<input type='button' value='x' class='btn2'>
	</div>
</div>
<script>
$('#traverse>ul>li').first().css('color', 'red');
$('#traverse>ul>li').filter(':odd').css('color', 'blue');
$('#traverse>ul>li').slice(1,4).css('font-family', '궁서체'); // slice (s, e) s보다 크거나 같고 e보다 같거나 작다.

// div1, div의 넓이와 높이를 지정.
$('#traverse>div').css({
	'width' : '200px',
	'height': '100px',
	'border': '1px solid #444'
});

// btn1, btn2의 넓이와 높이도 지정

$('#traverse>div>.btn1, #traverse>div>.btn2').css({
	'width' : '80px',
	'height' : '30px',

});

// btn1, btn2에 이벤트 처리
// class -> 배열처리

var btn1 = $('.btn1')[0];
btn1.onclick = function() {
	var p = $(btn1).parent(); // btn1을 포함하고 있는 부모
	$(p).css('background-color', 'pink');
	
	//var p = $(btn1).parent().css('background-color', 'pink');
}


var btn2 = $('.btn2')[0];
btn2.onclick = function() {
	$(this).parent().css('background-color', 'pink');
	// this -> 이벤트가 발생한 자신의 객체
}

</script>
</body>
</html>