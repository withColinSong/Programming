# [목차](#목차)
- [목차](#목차)
- [1. traverse](#1-traverse)
  - [1.1. 종류](#11-종류)
    - [1.1.1 parent](#111-parent)
    - [1.1.2 first(),slice(),filter()](#112-firstslicefilter)
- [2. manipulation](#2-manipulation)
  - [2.1. 종류](#21-종류)
- [3. 그 외 메모](#3-그-외-메모)

# 1. traverse
- traverse는 `.`을 찍어서 표현한다.
- 명령어는 filter와 traverse가 매우 유사하거나, 상중된다.

## 1.1. 종류

- .eq(index)
- .first()
- .last
- .slice(start [, end])

메서드
- .chidren(expr)
- .find(expr)
- .parent(expr)
- .prev(expr)


### 1.1.1 parent

```js
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
```


```js

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
```

### 1.1.2 first(),slice(),filter()

```java
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
</div>
<script>
$('#traverse>ul>li').first().css('color', 'red');
$('#traverse>ul>li').filter(':odd').css('color', 'blue');
$('#traverse>ul>li').slice(1,4).css('font-family', '궁서체'); // slice (s, e) s보다 크거나 같고 e보다 같거나 작다.
</script>
</body>
</html>

```


```java
$(#id ul) -> 후손(깊이에 관계없이 모든 ul)
```

# 2. manipulation

- 지정된 요소의 내부환경, 외부환경에 대한 추가 제거

## 2.1. 종류
- append
- prepend
- before
- after
- remove
- empty

# 3. 그 외 메모


- var : 전역형

```js
a = 10; // 전역형
let b = 10; 
```
- let : 지역형, 재선언 불가

```js
var a = 10;
var a = 20; // OK
let b = 10;
let b = 20; // 에러
```


