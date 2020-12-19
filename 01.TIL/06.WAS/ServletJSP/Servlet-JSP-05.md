# [목차](#목차)
- [목차](#목차)
- [1. Session](#1-session)
	- [1.1. 웹 서버가(Session) 현재 사용자를 구분하는 방식](#11-웹-서버가session-현재-사용자를-구분하는-방식)
	- [1.2. Session 메서드](#12-session-메서드)
	- [1.3. Session CODE](#13-session-code)
	- [References](#references)

# 1. Session
- 현재 접속한 사용자
- 사용자마다 저장할 수 있는 공간

```java
HttpSession session = requset.getSession();
```

## 1.1. 웹 서버가(Session) 현재 사용자를 구분하는 방식
- Session ID가 없으면 Session 공간에 저장할 수 없다.
- 웹 서버에서 임의의 Session ID를 부여한다.

## 1.2. Session 메서드

`void setAttribute(String name, Object value)`
- 지정된 이름으로 객체를 설정

`Object getAttribute(String name)`
- 지정한 이름의 객체를 반환

`void invalidate()`
- 세션에서 사용되는 객체들을 바로 해제

`void setMaxInactivelnterval(int interval)`
- 세션 타임아웃을 정수(초)로 설정

`boolean isNew()`
- 세션이 새로 생성되었는지 확인

`Long getCreationTime()`
- 세션이 시작된 시간을 반환, 1970년 1월 1일을 시작으로 하는 밀리초

`Long getLashAccessedTime()`
- 마지막 요청 시간, 1970년 1월 1일을 시작하는 밀리초

## 1.3. Session CODE 

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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class calc
 */
@WebServlet("/calc")
public class calc extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext app = getServletContext();
		
		HttpSession session = request.getSession();
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		
		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		
		int result = 0;
		
		if(op.equals("=")) {
//			int x = (Integer)app.getAttribute("value");
			int x = (Integer)session.getAttribute("value");
			int y = v; 
			
//			String operator = (String) app.getAttribute("operator");
			String operator = (String) session.getAttribute("operator");
			
			if(operator.equals("+")) {
				result = x + y; 
			}else {
				result = x - y;
			}
			
			response.getWriter().printf("result is %d", result);
		} else {
//			app.setAttribute("value", v);
//			app.setAttribute("operator", op);
			session.setAttribute("value", v);
			session.setAttribute("operator", op);
		}

	}

}
```

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2020.12.19

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)