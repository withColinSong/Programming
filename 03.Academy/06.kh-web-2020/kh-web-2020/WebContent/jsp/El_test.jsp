<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_test</title>
</head>
<body>
<div id='el_test'>
	<h3>EL</h3>
	<ul>
		<li>정수형 : ${100 }</li>
		<li>실수형 : ${10.5}</li>
		<li>문자열 : ${"하이 IT여행자입니다." }</li>
		<li>논리형 : ${true } </li>
		<li>NULL : ${null }
	</ul>

	<h3>EL 연산식</h3>
	<ul>
		<li> 10+10 => ${10+10 }</li>
		<li> 10%3  => ${10%3 }</li>
		<li> 10==10 => ${10 == 10 } </li>
		<li> (10>5)? '크다':'작다' => ${(10>5)? '크다' : '작다' } </li>
		<li> empty '' => ${empty '' }
	</ul>

</div>
</body>
</html>