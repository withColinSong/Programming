# [목차](#목차)
- [목차](#목차)
- [Cookie](#cookie)
  - [1.1. 상태 저장을 위한 값의 저장소의 특징](#11-상태-저장을-위한-값의-저장소의-특징)
  - [1.2. 쿠키](#12-쿠키)
    - [1.2.1. 쿠키 저장하기](#121-쿠키-저장하기)
    - [1.2.2. 쿠키 읽기](#122-쿠키-읽기)
  - [1.3. 차이점](#13-차이점)
    - [1.3.1. Application](#131-application)
    - [1.3.2. Session](#132-session)
    - [1.3.3. Cookie](#133-cookie)
  - [1.4. Cookie CODE](#14-cookie-code)
  - [간단 정리](#간단-정리)
  - [References](#references)

# Cookie

## 1.1. 상태 저장을 위한 값의 저장소의 특징

서버
- Application
- Session

사용자 저장소
- Cookie

## 1.2. 쿠키

### 1.2.1. 쿠키 저장하기
Cookie cookie = new Cookie("name", value);

```java
Cookie cookie = new Cookie("c", String.valueOf(result));
response.addCookkie(cookie);
```

### 1.2.2. 쿠키 읽기

```java
Cookie[] cookies = requset.getCookies();

String _c = "";
if(cookes != null) {
    for(Cookie cookie : cookie) {
        if("c".equals(cookie.getName())) {
            _c = cookie.getValue();
        }
    }
}

```
- 쿠키가 여러값이 있을 수 있기에 배열로 온다.
- 쿠키는 문자열로만 저장할 수 있다.
- 브라우저가 닫히면 쿠키도 사라진다.

`String.valueof()`
`setPath("path")`

`maxAge(완료날짜)`-> ex ) maxAge(24*60);


## 1.3. 차이점

### 1.3.1. Application
사용범위 | 생명주기 | 저장위치
|:-:|:-:|:-:|
전역 범위에서 사용하는 저장 공간|WAS가 시작해서 종료할 때 까지|WAS 서버의 메모리

### 1.3.2. Session
사용범위 | 생명주기 | 저장위치
|:-:|:-:|:-:|
세션 범위에서 사용하는 저장 공간|세션이 시작해서 종료할 때 까지|WAS 서버의 메모리

### 1.3.3. Cookie
사용범위 | 생명주기 | 저장위치
|:-:|:-:|:-:|
웹 브라우저에 별 지정한 path 범주 공간|브라우저에 전달한 시간부터 만료시간까지|웹 브라우저의 메모리 또는 파일


## 1.4. Cookie CODE

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calc</title>
</head>
<body>
	<form action="calc" method="post">
		<div>
		<input type="text" name="v">
		</div>
		<div>
		<input type="submit" name="operator" value="+">
		<input type="submit" name="operator" value="-">
		<input type="submit" name="operator" value="=">
		</div>
	</form>
</body>
</html>
```

```java
package com.song.pra;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calc")
public class Calc3 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServletContext app = getServletContext();
//		HttpSession session = request.getSession();
		
        Cookie[] cookies = request.getCookies();
		
        String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		
		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		
		int result = 0;
		
		if(op.equals("=")) {
//			int x = (Integer)app.getAttribute("value");
//			int x = (Integer)session.getAttribute("value");

            // 쿠키 꺼내기
            int x = 0; // 변수 초기화
            for(Cookie c : cookies) {
                if(c.getName().equals("value")) {
                    x = Integer.parseInt(c.getValue());
                    break;
                }
            }
			int y = v; 
			
//			String operator = (String) app.getAttribute("operator");
//			String operator = (String) session.getAttribute("operator");
            String operator = ""; // 변수 초기화
            for(Cookie c : cookies) {
                if(c.getName().equals("op")) {
                    operator = c.getValue();
                    break;
                }
            }

			if(operator.equals("+")) {
				result = x + y; 
			}else {
				result = x - y;
			}
			
			response.getWriter().printf("result is %d", result);
		} else {
//			app.setAttribute("value", v);
//			app.setAttribute("operator", op);
//			session.setAttribute("value", v);
//			session.setAttribute("operator", op);
            
           
            // 쿠키는 문자열로 받을 수 있지만,
            // XML, JSON을 이용하면 다양한 형태로 저장할 수 있다.
            // valueOf -> INT형을 문자열로 변환해준다.

            Cookie valueCookie = new Cookie("value", String.valueOf(v)); 
            Cookie opCookie = new Cookie("operator", op);
            response.addCookie(valueCookie);
            response.addCookie(opCookie);
            
		}
	}

}
```

## 간단 정리
- 쿠키 생성하기
```java
Cookie valueCookie = new Cookie("value", String.valueOf(v));
Cookie opCookie = new Cookie("operator", op); 
```
- 쿠키 추가하기
  - 서버 -> 쿠키 추가하기
```java
 response.addCookie(valueCookie);
 response.addCookie(opCookie);
```
- 쿠키 값 가져오기
  - 클라이언트 -> 쿠키 가져오기
  - 쿠키는 여러 개 일 수 있으니 배열로 받는다.
```java
Cookie[] cookies = request.getCookies();

    String operator = "";
    for(Cookie c : cookies) {
        if(c.getName().equals("op")) {
            operator = c.getValue();
            break;
        }
    }
```

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2020.12.20

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)