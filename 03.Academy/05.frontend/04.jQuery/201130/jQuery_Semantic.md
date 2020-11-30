# [목차](#목차)
- [목차](#목차)
- [1. jQuery 문법](#1-jquery-문법)
	- [1.1 JSON 표기법](#11-json-표기법)
	- [1.2. 그외](#12-그외)
	- [1.3. 동적 삽입](#13-동적-삽입)

# 1. jQuery 문법
- .jsp file을 이용하여 jQuery-css를 이용하여 작성

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<script src="./lib/jquery-3.5.1.js"></script>
</head>
<body>
<div id="index">
	<header id="header">헤더</header>
	<section id="contents">contents</section>
	<footer id="footer">융합 S/W 개발(주)</footer>
</div>
<script>
 // 모든 기본태그의 마진, 패딩을 0으로 설정
 $('*').css('margin', '0px');
 $('*').css('padding', '0px');

 // 패딩의 증가의 영향을 최소화
 $('*').css('box-sizing', 'border-box');
 
 // index페이지의 넓이와 중앙배치
 $('#index').css('width', '800px');
 $('#index').css('margin', 'auto');
 
 //header 높이와 색깔
 $('#index>#header').css('height', '150px');
 $('#index>#header').css('background-color', '#ccc');
// #header라고 선택해도 되지만, 보다 빠르게 선택하기 위해 위에 코드로 실행한다.

 // contents는 최소 높이
 $('#index>#contents').css('min-height', '250px');
 // height -> 고정높이 min-height -> 유동성'
 
 // footer 높이와 바탕색
 $('#index>#footer').css('height', '100px')
 $('#index>#footer').css('background-color', '#bbb');
 $('#index>#footer').css('text-align', 'center');
 $('#index>#footer').css('line-height', '100px');

  // footer의 속성들을 -> json 표기법으로 변경
 $('#index>#footer').css({
	 'height' : '100px',
	 'background-color' : '#bbb',
	 'text-align' : 'center',
	 'line-height' : '100px'
	 });
</script>
</body>
</html>
```

## 1.1 JSON 표기법
1. KEY:VALUE -> { KEY: VALUE, KEY:VALUE , ...}
2. 배열 -> [v1, v2, v3...]
3. 혼합형 
  - 배열 안에 map 구조
    - [{  }, {  }, ...]
  - map 안에 배열
    - { key : [...], }

```java
<script>
  // jQuery css 
 $('#index>#footer').css('height', '100px')
 $('#index>#footer').css('background-color', '#bbb');
 $('#index>#footer').css('text-align', 'center');
 $('#index>#footer').css('line-height', '100px');

  // json 표기법으로 변경
 $('#index>#footer').css({
	 'height' : '100px',
	 'background-color' : '#bbb',
	 'text-align' : 'center',
	 'line-height' : '100px'
	 });
</script>
```


## 1.2. 그외

- MVC
M - model(데이터)
V - view(UI,UX)
C - Control(code)

외부 링크 걸기
- css : <link>
- js : <script src=""></script>

## 1.3. 동적 삽입

`index.jsp?inc=./jquery/filter.jsp`
- inc -> parameter 

```java
<%
	String inc = "intro.jsp";
	if(request.getParameter("inc") != null) {
		inc = request.getParameter("inc");
	}
%>

<jsp:include page="<%=inc %>"/> <%--동적 include --%>
```

```java
<li><a href="index.jsp?inc=./jquery/filter.jsp">Filter</a></li>
<li><a href="index.jsp?inc=./jquery/traverse.jsp">TRAVERSE</a></li>
```