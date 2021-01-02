# [목차](#목차)
- [목차](#목차)
- [JSP 기초](#jsp-기초)
	- [1. 결과](#1-결과)
	- [2. 결과](#2-결과)
	- [References](#references)

# JSP 기초

- basic.jsp

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	
	String cnt_ = request.getParameter("cnt");
	
	int cnt = 50;
	
	if (cnt_ != null && !cnt_.equals("")) {
		cnt = Integer.parseInt(cnt_);
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	안녕
	
	<% for(int i = 0; i<cnt; i++) { %>
	
		안녕 Servlet<br>
	
	<% } %>
	
	
	
</body>
</html>
```

## 1. 결과

`http://localhost:9090/basic.jsp`

![](https://images.velog.io/images/withcolinsong/post/ca875e17-aac5-4585-a91f-f06781b58754/image.png)

## 2. 결과


- `form 태그`를 사용하지 않고 `get방식` 사용하기
```java
<% 
	String cnt_ = request.getParameter("cnt");
	int cnt = 50;
	
	if (cnt_ != null && !cnt_.equals("")) {
		cnt = Integer.parseInt(cnt_);
	}
%>

```
`http://localhost:9090/basic.jsp?cnt=3`

![](https://images.velog.io/images/withcolinsong/post/d1b2a8c9-5f8f-4e44-82a1-31bd602f2452/image.png)

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2021.01.01

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)