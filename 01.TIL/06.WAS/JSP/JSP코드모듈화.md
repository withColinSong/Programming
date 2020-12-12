# [목차](#목차)
- [목차](#목차)
	- [1.1 JSP 코드 모듈화](#11-jsp-코드-모듈화)
	- [1.2. 작업](#12-작업)
		- [1.3.1 정적 삽입 주의](#131-정적-삽입-주의)
	- [References](#references)


## 1.1 JSP 코드 모듈화 
- [`프로젝트 경로`](../../03.Academy/05.frontend/05.AJAX/web-2020)
  - 위에 작업했던 결과물로 코드 모듈화
- HTML 파일에서 header, footer 부분을 jsp 페이지로 분할 작업
  - include를 사용함.

## 1.2. 작업
- `header.jsp` `footer.jsp` 생성 및 불필요한 코드 제거
- `index.jsp`에서 헤더영역을 `header.jsp`에 붙여넣는다.
- header 영역에 정적삽입으로 header.jsp를 include
```java
<%@ include file=''@>
```

- header.jsp
```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header id='header'>
    <h1>내용</h1>
</header>

<%
	int a = 10;
%>
```
- footer.jsp
```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer id='footer'>내용</footer>	

<%
	
	int a = 20;
%>
```

- index.jsp
```java
<div id='index'>
		<%-- header영역 --%>
		<%@include file="header.jsp" %>
		<section id='contents'>
			<article class='content'>
				<jsp:include page="<%=inc %>" />
			</article>
			<aside class='aside'>
				<img src='http://placehold.it/150X100'>
				<div id='sub_menu'>
					<jsp:include page="<%=sub %>" />
				</div>
			</aside>
		</section>
		<%-- footer영역 --%>
		<%@include file="footer.jsp"%> // 중복 변수 선언으로 에러
	</div>
```

### 1.3.1 정적 삽입 주의
- **중복 변수 선언 주의**


## References
- 🎈2020.12.12
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)