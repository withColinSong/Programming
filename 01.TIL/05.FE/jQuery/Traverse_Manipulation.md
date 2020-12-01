[목차](#목차)
- [Traverse](#traverse)
	- [1.1. 종류](#11-종류)
		- [1.1.1 .slice()](#111-slice)
		- [1.1.2 parent()](#112-parent)
- [2. manipulation](#2-manipulation)
	- [2.1. 종류](#21-종류)
		- [2.1 wrap, append, prepend](#21-wrap-append-prepend)
	- [References](#references)

# Traverse
- traverse는 `.`을 찍어서 표현한다.
- 명령어는 filter와 traverse가 매우 유사하거나, 상중된다.

## 1.1. 종류

- .eq(index)
- .first()
- .last
- .slice(start [, end])

method
- .chidren()
- .find()
- .parent()
- .prev()
- .wrap()
- .append()
- .prepend()
- [더 많은 method 종류](https://www.w3schools.com/jquery/jquery_ref_traversing.asp)
### 1.1.1 .slice()
```java
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

```

```java
$('#traverse>ul>li').first().css('color', 'red');
$('#traverse>ul>li').filter(':odd').css('color', 'blue');
$('#traverse>ul>li').slice(1,4).css('font-family', '궁서체'); 
// slice (s, e) s보다 크거나 같고 e보다 같거나 작다.
```
![](https://images.velog.io/images/withcolinsong/post/5864a0df-6e2b-42d1-af73-724fcf6840b7/image.png)

### 1.1.2 parent()
```
<!-- .parent() example code -->

<div id='div1'>
    <input type='button' value='x' class="btn1">
</div>
<div id='div2'>
    <input type='button' value='x' class='btn2'>
</div>
```


```java

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

![](https://images.velog.io/images/withcolinsong/post/007176ba-d455-4d65-82a8-6514678a0fb2/image.png)

![](https://images.velog.io/images/withcolinsong/post/96fab207-a7f8-429a-b7f6-e204835c94cc/image.png)
- 버튼 클릭 시  pink로 변경된다.
# 2. manipulation

## 2.1. 종류
- wrap()
- append()
- prepend()

- [그외 jQuery_API](https://api.jquery.com/category/manipulation/)

### 2.1 wrap, append, prepend
```java
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
	- 단점 : 이 버튼을 퍼블리셔나, 디자이너들이 함부로 건들이기가 어렵다.*/
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
```
![](https://images.velog.io/images/withcolinsong/post/575d8dba-91be-4127-8a65-cd7644b0f6e3/image.png)

- 1번
![](https://images.velog.io/images/withcolinsong/post/bba9167b-4c2c-4365-bcf2-d53b2a749a18/image.png)

- 2번
![](https://images.velog.io/images/withcolinsong/post/96bc8c5d-1840-48c6-92a9-4c6c075da986/image.png)

- 3번
![](https://images.velog.io/images/withcolinsong/post/af0503b0-600a-47d0-8bef-5e7b48e039c5/image.png)

## References
- 🎈2020.12.01
- 🎈정리 : song

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)