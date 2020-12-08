# [목차](#목차)
- [목차](#목차)
- [Ajax](#ajax)
	- [1.1 Ajax 목적](#11-ajax-목적)
	- [1.2. Ajax 처리 방식](#12-ajax-처리-방식)
		- [1.2.1 ui분리](#121-ui분리)
		- [1.2.2. 로직 추가](#122-로직-추가)
		- [1.2.3. 처리 결과](#123-처리-결과)
	- [2. 용어](#2-용어)

# Ajax

## 1.1 Ajax 목적

- 별도의 외부 플러그인이나 라이브러리, ActiveX와 같은 API 프로그램들이 필요없다.
- 브라우저 내부에 있는 자바 스크립트만으로 처리 가능하다.
- 비동기 방식으로 서버와 통신하며, 브라우저의 새로고침없이 특정 영역의 내용을 동적으로 변경할 수 있다.
- 프로그램 방식을 Web 방식에서 App방식으로 처리할 수 있다.
- Asynchronous Javascript And Xml
- Ajax의 가장 중추적인 역할을 하는 객체 -> XMLHttpRequest
- Web은 form을 전송 시 전체 페이지가 새로고침 되는 역할이 있다.
- ajax를 사용하여 전체 페이지가 새로고침 되는 현상을 피할 수 있다.
전체 페이지가 새로고침되지 않도록 하는 것이 ajax를 사용하는 목적이다.

## 1.2. Ajax 처리 방식
1. 서버에서 처리할 내용을 ui에서 분리
2. 서버는 처리 된 내용을 화면에 출력하는 로직을 추가한다.
3. ui단에서는 XMLHttpRequest 객체를 사용하여 서버의 처리 결과를 가져온다.

### 1.2.1 ui분리
- begin.jsp <!-- view단 -->
```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#result {
	width: 400px;
	height: 250px;
	background-color:#eee;
}
</style>
</head>
<body>
	<div id='begin'>
	<fieldset>
	<legend>Ajax의 특징</legend>
	<ul>
		<li>별도의 외부 플러그인이나 라이브러리, ActiveX와 같은 API 프로그램들이 필요없다.</li>
		<li>브라우저 내부에 있는 자바 스크립트만으로 처리 가능하다.</li>
		<li>비동기 방식으로 서버와 통신하며, 브라우저의 새로고침없이 특정 영역의 내용을 동적으로 변경할 수 있다.</li>
		<li>프로그램 방식을 Web 방식에서 App방식으로 처리할 수 있다.</li>
		<li>Asynchronous Javascript And Xml</li>
		<li>Ajax의 가장 중추적인 역할을 하는 객체 -> XMLHttpRequest</li>
		<li>Web은 form을 전송 시 전체 페이지가 새로고침 되는 역할이 있다.</li>
		<li>ajax를 사용하여 전체 페이지가 새로고침 되는 현상을 피할 수 있다.</li>
		<li>전체 페이지가 새로고침되지 않도록 하는 것이 ajax를 사용하는 목적이다.</li>
		
	</ul>
	</fieldset>
	</div>
	<h3>홀짝수를 확인해보자.</h3>
	<p>테스트(서버의 결과를 표시해 주기 위해 전체 화면이 새로고침이 되느냐 아니면 필요한 부분만 새로고침 되느냐)</p>
	<%  // 서버
		String temp = request.getParameter("su");
		String msg = ""; // 결과 메세지	
		int su = 0;
		if(temp != null && !temp.equals("")) {
			su = Integer.parseInt(temp); // 문자열을 Int 변환. Wrapper class
			if(su % 2 == 0) {
				msg = su + " 는 짝수입니다.";				
			} else {
				msg = su + " 는 홀수입니다.";
			}
		}
	%>
	<!-- form의 action이 없을 시에 자기 자신의 정보를 전송한다. -->
	<form name="frm" method="post">
		<label>정수를 입력하세요.</label>
		<input type="text" size="6" name="su">
		<input type="submit" value="Check">
	</form>
	<div id='result'>
		<%=msg %>
	</div>
	
</body>
</html>

```
-> view 단에서 <% %> 서버 코드를 복사해서 새로운 jsp file에 옮겨준 후, view 단에 코드는 지워준다.
- odd_even_check.jsp
```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String temp = request.getParameter("su");
String msg = ""; // 결과 메세지	
int su = 0;
if(temp != null && !temp.equals("")) {
	su = Integer.parseInt(temp); // 문자열을 Int 변환. Wrapper class
	if(su % 2 == 0) {
		msg = su + " 는 짝수입니다.";				
	} else {
		msg = su + " 는 홀수입니다.";
	}
}
    // (1.2.2) 로직 추가  out.print(msg);
%>
```

### 1.2.2. 로직 추가
`odd_even_check.jsp` -> `out.print(msg);` 추가
`기본.jsp` -> `<%=msg>` 삭제


### 1.2.3. 처리 결과
- begin.jsp (view단)

```java
<script>
// ajax를 통해 서버의 처리 결과를 result에 표시
var frm = document.frm;
frm.onsubmit = function() {
	var param = "?su=" + frm.su.value;

	var req = new XMLHttpRequest();
	req.open('get', './ajax/odd_even_check.jsp' + param); // 요청 정보 생성

	// 상태변화
	req.onreadystatechange = function() {
		// req.status == 200 -> 정상 요청됨, req.readyState == 4 -> 서버에서 처리된 응답 상태값.
		if (req.status == 200 && req.readyState == 4) {
			var r = document.getElementById('result');
			r.innerHTML = req.responseText;
		}
	}
	req.send(); // 요청 정보를 서버에 전송
	return false; // submit 기능을 취소한다.
}
</script>
```

- begin.jsp // view
- odd_even_check.jsp // ajax


## 2. 용어

- readyState
![](https://images.velog.io/images/withcolinsong/post/2ca610d1-f574-4ea9-ba04-5d3dfb5b4e42/image.png)

- status(응답상태)
- onreadystatechange 

```java
httpRequest.onreadystatechange = function() {
  // 서버의 응답에 따른 로직을 작성
  }
```

 