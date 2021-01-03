# [목차](#목차)
- [목차](#목차)
- [입력된 값을 배열로 받기](#입력된-값을-배열로-받기)
		- [연결 자료 : Servelt-JSP-02](#연결-자료--servelt-jsp-02)
	- [add.html](#addhtml)
	- [add.java](#addjava)
	- [코드 설명 정리](#코드-설명-정리)
	- [References](#references)



# 입력된 값을 배열로 받기
### 연결 자료 : [Servelt-JSP-02](Servelt-JSP-02.md)

## add.html
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="post">
		<input type="text" name="num" > // request.getParameterValues("num")
		<input type="text" name="num" > 
		<input type="text" name="num" > 
		<input type="text" name="num" > 
		<input type="submit" name="operator" value="덧셈">
	</form>
</body>
</html>
```

## add.java
```java
package com.yj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class add2 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		String[] num_ = request.getParameterValues("num");
		String op_ = request.getParameter("operator");

		int result = 0;

		if(op_.equals("덧셈")) {
			for(int i = 0; i < num_.length; i++) {
				int num = Integer.parseInt(num_[i]);
				System.out.println(num_[i]);
				result+=num;
			}
		}
		response.getWriter().printf("result is %d\n", result);
	}

}


```
## 코드 설명 정리
- `getParameterValues("num");`
같은 name의 값이 여러 개 있을 때, 배열로 받을 수 있다.
```java
// request.getParameterValues("num")
<input type="text" name="num" value="num[0]"> // 1
<input type="text" name="num" value="num[1]"> // 2
<input type="text" name="num" value="num[2]"> // 3
<input type="text" name="num" value="num[3]"> // 4
```

![](https://images.velog.io/images/withcolinsong/post/212aa136-f765-4c52-a366-dd48f69fa45c/image.png)

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2020.12.17

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)