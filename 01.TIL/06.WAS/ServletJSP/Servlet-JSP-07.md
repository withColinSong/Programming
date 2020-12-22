# [목차](#목차)
- [목차](#목차)
- [response.sendRedirect()](#responsesendredirect)
  - [sendRedirect CODE;](#sendredirect-code)
  - [References](#references)

# response.sendRedirect()
- 새로운 요청을 함.
- 서버에서 페이지 전환 역할
 
## sendRedirect CODE;
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

/**
 * Servlet implementation class calc
 */
@WebServlet("/calc2")
public class calc extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			
			int y = v; 
			
//			String operator = (String) app.getAttribute("operator");
//			String operator = (String) session.getAttribute("operator");
			
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
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

			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);

			valueCookie.setPath("/calc2"); 
			valueCookie.setMaxAge(60*60); // 쿠키 유효 시간
			opCookie.setPath("/calc2"); // calc2 쿠키를 저장

			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc.html"); // "calc.html"를 돌려준다.
		}

	}

}
```


## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2020.12.22