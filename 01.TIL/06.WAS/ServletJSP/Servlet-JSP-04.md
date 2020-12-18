# [목차](#목차)
- [목차](#목차)
- [Application 객체](#application-객체)
	- [1.1 Application 저장소](#11-application-저장소)
	- [1.2. Application setter, getter](#12-application-setter-getter)
	- [1.3. Application CODE](#13-application-code)
	- [References](#references)

# Application 객체

```java
ServletContext application = getServletContext();
```
## 1.1 Application 저장소 
`getServletContext()`


## 1.2. Application setter, getter

`setAttribute("name", "value")`
- 값을 저장

`getAttribute("value")`
- 값을 가져옴.

## 1.3. Application CODE

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

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		
		int result = 0;
		
		if(op.equals("=")) {
			
			int x = (Integer) application.getAttribute("value");// 에플리케이션에 저장되어 있는 걸 꺼내옴.
			int y = v; // 사용자가 저장할 value값
			
			String operlator = (String)application.getAttribute("op");
			
			if(operlator.equals("+")) {
				result = x+y;
			} else {
				result = x-y;
			}
		
			response.getWriter().printf("result is %d\n", result);
		
			// 값을 저장
		
		}else {
			application.setAttribute("value", v);
			application.setAttribute("op", op);
		}

	}

}

```

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2020.12.18

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)