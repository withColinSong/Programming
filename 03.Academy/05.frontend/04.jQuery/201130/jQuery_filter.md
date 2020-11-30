# [목차](#목차)
- [목차](#목차)
- [1. filter](#1-filter)
	- [1.1. filter 종류](#11-filter-종류)


# 1. filter

- 선택된 요소중 필요한 요소만을 걸러내는 방법
- 접두문자 ':'을 사용한다.
- 필터와필터를 연결하여 사용할 수 있다.

## 1.1. filter 종류
:eq(index) 
:even 
:odd 
:first 
:last
:gt(index)
:lt(index)

- index -> 0부터 시작한다.


```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>filter</title>
<script src="../lib/jquery-3.5.1.js"></script>
</head>
<body>
<div id='filter'>
	<fieldset>
		<legend>filter</legend>
		<ul>
		<li>선택된 요소중 필요한 요소만을 걸러내는 방법</li>
		<li>접두문자 ':'을 사용한다.</li>
		<li>필터와필터를 연결하여 사용할 수 있다.</li>
		<li>종류 -> :eq(index), :even, :odd, :first, :last :gt(index)
, :lt(index)</li>
		</ul>
	</fieldset>
	
	<ol>
		<li>백두산</li>
		<li>금강산</li>
		<li>설악산</li>
		<li>치악산</li>
		<li>내장산</li>
		<li>속리산</li>
		<li>맛동산</li>
		<li>한라산</li>
	</ol>
	<div id='items'>
		<div>안녕하세요..1</div>
		<div>안녕하세요..2</div>
		<div>안녕하세요..3</div>
		<div>안녕하세요..4</div>
		<div>안녕하세요..5</div>
		<div>안녕하세요..6</div> 
	</div>
</div>
<script>
 // ul 태그 안에 있는 첫번째 li 
 $('#filter>ol>li:first').css('color', '#f00');
 $('#filter>ol>li:even').css('font-weight', 'bold');
 $('#filter>#items>div:even').css('background-color', 'pink');
 $('#filter>#items>div:odd').css('background-color', 'red');
</script>
</body>
</html>
```
