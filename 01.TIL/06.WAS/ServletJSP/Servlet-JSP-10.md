# [목차](#목차)
- [목차](#목차)
- [쿠키 삭제하기](#쿠키-삭제하기)
  - [Calc3.java](#calc3java)
  - [References](#references)

# 쿠키 삭제하기
- 참고 코드👉 [웹 계산기 만들기](Servlet-JSP-09.md)

![](https://images.velog.io/images/withcolinsong/post/817e74c0-487c-4d87-93b7-25e8ebc75a9d/ezgif.com-gif-maker%20(1).gif)

- `C` : 계산기 초기화 작업 할 코드
```java
out.write("<td><input type=\"submit\" name=\"operator\" value=\"C\"></td>");
```

## Calc3.java
```java
package com.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calc3")
public class Calc3 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		ServletContext app = getServletContext();
		//		HttpSession session = request.getSession();

		Cookie[] cookies = request.getCookies();

		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");

		String exp = "";
		if(cookies != null) {
			for(Cookie c: cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}

		if(operator != null && operator.equals("=")) {
			
			/* 자바스크립트 엔진 */
			
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			
			try {
				exp = String.valueOf(engine.eval(exp)); // 지정된 스크립트를 실행
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			exp += (value == null) ? "" : value;
			exp += (operator == null) ? "" : operator;
			exp += (dot == null) ? "" : dot;	
		}	

		Cookie expCookie = new Cookie("exp", exp);

		/* 쿠키 삭제 */
		if(operator != null && operator.equals("C")) {
			expCookie.setMaxAge(0);	
		}

		response.addCookie(expCookie);
		response.sendRedirect("calcpage");
	}

}

```

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2020.12.26