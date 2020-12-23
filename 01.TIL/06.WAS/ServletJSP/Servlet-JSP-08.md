# [목차](#목차)
- [목차](#목차)
- [동적인 페이지](#동적인-페이지)
  - [계산기 CODE](#계산기-code)
    - [calc3.html](#calc3html)
    - [CalcPage.java](#calcpagejava)
  - [References](#references)


# 동적인 페이지

- 정적인 html -> Servlet을 이용하여 동적인 페이지 만들기

## 계산기 CODE
### calc3.html
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
			<td><input type="submit" name="operator" value="÷"></td>
			</tr>
			
			<tr>
			<td><input type="submit" name="value" value="7"></td>
			<td><input type="submit" name="value" value="8"></td>
			<td><input type="submit" name="value" value="9"></td>
			<td><input type="submit" name="operator" value="X"></td>
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

### CalcPage.java
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
public class CalcPage extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
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
		out.printf("<td class=\"output\" colspan=\"4\">%d</td>", 3+7);
		out.write("</tr>");
					
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"CE\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"C\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"BS\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"÷\"></td>");
		out.write("</tr>");
					
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"7\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"8\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"9\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"X\"></td>");
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
		
		
	}

}

```
- `""` -> `"\` , `\"` 추가 작업
- `out.printf("<td class=\"output\" colspan=\"4\">%d</td>", 3+7);`
  - html 문서를 동적인 웹으로 표현할 수 있다.


## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2020.12.23
