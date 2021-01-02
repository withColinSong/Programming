# [목차](#목차)
- [목차](#목차)
- [1. 기존 JSP의 문제점](#1-기존-jsp의-문제점)
- [2. MVC Model 1](#2-mvc-model-1)
- [3. MVC Model 2](#3-mvc-model-2)
	- [3.1. spaghetti.java](#31-spaghettijava)
	- [3.2 spaghetti.jsp](#32-spaghettijsp)
	- [3.3 메서드 설명](#33-메서드-설명)
		- [`forward`](#forward)
		- [`getRequestDispatcher("");`](#getrequestdispatcher)
		- [`RequestDispatcher dispatcher = request.getRequestDispatcher("spaghetti.jsp");`](#requestdispatcher-dispatcher--requestgetrequestdispatcherspaghettijsp)
		- [`dispatcher.forward(request, response);`](#dispatcherforwardrequest-response)
- [4. 서버 저장소](#4-서버-저장소)
	- [References](#references)

# 1. 기존 JSP의 문제점

- 코드 블럭이 복잡하다.

스파게티 코드
```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
	
	String num_ = request.getParameter("n");
	
	int num = 0; 
	
	if(num_ != null && !num_.equals("")) {
		num = Integer.parseInt(num_);	
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%if(num % 2 == 0) { %>
	짝수입니다.
	<% } else { %>
	홀수입니다.

	<% } %>
</body>
</html>
```

# 2. MVC Model 1

> 컨트롤러와 뷰가 물리적으로 분리되지 않은 방식

- `Model` : 출력 데이터 
- `View` : 출력 담당 
  - `[HTML 코드] `
- `Cotroller` : 입력과 제어를 담당 
  - `[JAVA 코드]`


```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
	
	String num_ = request.getParameter("n");
	int num = 0; 
	if(num_ != null && !num_.equals("")) {
		num = Integer.parseInt(num_);	
	}
	
    String result;

    if(num % 2 == 0) {
        result = "짝수";
    }else {
        result = "홀수";
    }

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%= result %> 입니다.

</body>
</html>
```

# 3. MVC Model 2
> 컨트롤러와 뷰가 물리적으로 분리된 방식

- view : JSP
- Servlet : Controller, model

## 3.1. spaghetti.java
```java
package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spaghetti")
public class spaghetti extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num_ = request.getParameter("n");
		int num = 0; 
		if(num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);	
		}
		
	    String result;

	    if(num % 2 == 0) {
	        result = "짝수";
	    }else {
	        result = "홀수";
	    }
	    
	    request.setAttribute("result", result);
	    
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("spaghetti.jsp");
	    dispatcher.forward(request, response);

		RequestDispatcher dispatcher = request.getRequestDispacter("경로");
		dispatcher.forward(request, response);
	    
	 
	}
}

```
## 3.2 spaghetti.jsp
```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%= request.getAttribute("result") %> 입니다.

</body>
</html>
```


## 3.3 메서드 설명

### `forward`
- 현재 작업페이지를 계속 이어 나갈 수 있도록 함.

### `getRequestDispatcher("");`
- jsp url

### `RequestDispatcher dispatcher = request.getRequestDispatcher("spaghetti.jsp");`
- dispatcher 될 파일 경로

### `dispatcher.forward(request, response);`
- dispatcher 과 연결 될 forward

# 4. 서버 저장소
1. application
2. session
3. request
4. page

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2021.01.01

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)