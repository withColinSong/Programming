# [목차](#목차)
- [목차](#목차)
- [웹 계산기 완성하기](#웹-계산기-완성하기)
	- [calc3.html](#calc3html)
	- [Calc3.java](#calc3java)
	- [calcPage.java](#calcpagejava)
	- [References](#references)

# 웹 계산기 완성하기

![](https://images.velog.io/images/withcolinsong/post/de9b00e4-056d-4659-b829-fce641d58d56/ezgif.com-gif-maker.gif)

## calc3.html
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

input {
	width : 50px;
	height: 50px;
}

.output {
	height: 50px;
	background: #e9e9e9;
	font-size: 24px;
	font-weight: bold;
	text-align:right;
	padding: 0px 5px;
}

</style>
</head>
<body>
	<form action="calc3" method="post">
		<table>
			<tr>
			<td class="output" colspan="4">0</td>
			</tr>
			
			<tr>
			<td><input type="submit" name="operator" value="CE"></td>
			<td><input type="submit" name="operator" value="C"></td>
			<td><input type="submit" name="operator" value="BS"></td>
			<td><input type="submit" name="operator" value="/"></td>
			</tr>
			
			<tr>
			<td><input type="submit" name="value" value="7"></td>
			<td><input type="submit" name="value" value="8"></td>
			<td><input type="submit" name="value" value="9"></td>
			<td><input type="submit" name="operator" value="*"></td>
			</tr>
			
			<tr>
			<td><input type="submit" name="value" value="4"></td>
			<td><input type="submit" name="value" value="5"></td>
			<td><input type="submit" name="value" value="6"></td>
			<td><input type="submit" name="operator" value="-"></td>
			</tr>
			
			<tr>
			<td><input type="submit" name="value" value="1"></td>
			<td><input type="submit" name="value" value="2"></td>
			<td><input type="submit" name="value" value="3"></td>
			<td><input type="submit" name="operator" value="+"></td>
			</tr>
			
			<tr>
			<td></td>
			<td><input type="submit" name="value" value="0"></td>
			<td><input type="submit" name="dot" value="."></td>
			<td><input type="submit" name="operator" value="="></td>
			</tr>
			
		</table>
	</form>
</body>
</html>
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

		/*		
		Cookie expCookie = new Cookie("쿠키이름", 쿠키값 );
		Cookie expCookie = new Cookie("exp", exp); 		
		*/
		
		if(operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
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
	
		response.addCookie(expCookie);
		response.sendRedirect("calcpage");
	}

}

```

## calcPage.java
```java
package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calcpage")
public class calcPage extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();
		
		
		String exp = "0";
		
		if(cookies != null) {
			for(Cookie c: cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		
		
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");

		out.write("input {");
		out.write("width : 50px;");
		out.write("height: 50px;");
		out.write("}");

		out.write(".output {");
		out.write("height: 50px;");
		out.write("background: #e9e9e9;");
		out.write("font-size: 24px;");
		out.write("font-weight: bold;");
		out.write("text-align:right;");
		out.write("padding: 0px 5px;");
		out.write("}");

		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("<form action=\"calc3\" method=\"post\">");
		out.write("<table>");
		out.write("<tr>");
		out.printf("<td class=\"output\" colspan=\"4\">%s</td>", exp);
		out.write("</tr>");
					
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"CE\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"C\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"BS\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"/\"></td>");
		out.write("</tr>");
					
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"7\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"8\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"9\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"*\"></td>");
		out.write("</tr>");
					
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"4\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"5\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"6\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"-\"></td>");
		out.write("</tr>");
					
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"1\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"2\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"3\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"+\"></td>");
		out.write("</tr>");
					
		out.write("<tr>");
		out.write("<td></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"0\"></td>");
		out.write("<td><input type=\"submit\" name=\"dot\" value=\".\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"=\"></td>");
		out.write("</tr>");
					
		out.write("</table>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");
		
		// - "\ quite앞에 \" -> 변경
	}

}
```

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2020.12.24
