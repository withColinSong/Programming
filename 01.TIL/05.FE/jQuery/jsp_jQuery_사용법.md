# [목차](#목차)
- [목차](#목차)
- [.jsp file일 때 jQuery 사용법](#jsp-file일-때-jquery-사용법)
  - [1. 다운로드 형식](#1-다운로드-형식)
  - [2. CDN 형식](#2-cdn-형식)
    - [2.1. CDN 사용 시 주의사항](#21-cdn-사용-시-주의사항)
  - [.jsp file](#jsp-file)
  - [References](#references)

# .jsp file일 때 jQuery 사용법
## 1. 다운로드 형식
- https://jquery.com/download/
- jquery-3.5.1. js  다운로드
![](https://images.velog.io/images/withcolinsong/post/0348b3cb-a751-43f3-aa7d-0ca184024893/image.png)

![](https://images.velog.io/images/withcolinsong/post/3f38f93c-be48-4e4f-99f1-fa82fbb16b97/image.png)

- `JSP File` ->` WebContent` -> 라이브러리 저장 할 폴더 만들기(lib으로 만듦.) 
-> 만든 폴더 위치에 다운로드 받은 `jquery-3.5.1.js` 파일을 복사 붙여넣기 한다. 
(드래그 앤 드랍도 OK)

```java
<head>
<script src="./lib/jquery-3.5.1.js"></script> 
`WebContent` 가 최상위 폴더이며, 그 기준에 따른 경로에 따라 지정해주면 된다.
</head>
```


## 2. CDN 형식
- http://code.jquery.com/

![](https://images.velog.io/images/withcolinsong/post/72889714-e5c3-4278-9830-bad2819f2919/image.png)
- uncompressed
- minifield
둘 중 하나 선택.
```java
<head>
<script 
  src="http://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
</head>
```
### 2.1. CDN 사용 시 주의사항
- 네트워크가 연결이 안될 시 문제가 생길 수 있다.

## .jsp file
```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- CDN 형태 : 네트워크가 연결이 안될 시 문제가 생길 수 있다.--%>
<script 
  src="http://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
  
<%-- 다운로드 형태--%>  
<script src="./lib/jquery-3.5.1.js"></script>
</head>
<body>
<h1 id="header">jQuery Test를 위한 태그</h1>
<% 
	// 스크립트릿 영역 (scriptlet) : java coding area
	// java -> System.out.println();
	// js -> console.log();, document.write();
	out.print("hi jQuery...");
%>
<script>
$('#header').css('color', '#00f'); //jQuery문법
</script>
</body>
</html>
```


## References
- 🎈2020.11.30
- 🎈정리 : song

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)

