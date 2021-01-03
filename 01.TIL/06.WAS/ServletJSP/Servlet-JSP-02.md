# [목차](#목차)
- [목차](#목차)
- [Servlet를 이용한 계산 기능 만들기](#servlet를-이용한-계산-기능-만들기)
  - [calc.java](#calcjava)
  - [calc.html](#calchtml)
  - [코드 설명](#코드-설명)
  - [References](#references)

# Servlet를 이용한 계산 기능 만들기
## calc.java
```java

package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
          response.setCharacterEncoding("utf-8");
          response.setContentType("text/html; charset=utf-8");
          request.setCharacterEncoding("utf-8");

          String x_ = request.getParameter("x");
          String y_ = request.getParameter("y");
          String op = request.getParameter("operator");


          int x = 0;
          int y = 0;

          if(!x_.equals("")) {
              x = Integer.parseInt(x_);
          }

          if(!y_.equals("")) { // 사용자의 입력값이 없을 수 있을 때 데이터 유효검사
              y = Integer.parseInt(y_); 
          }

          int result = 0;

          if(op.equals("덧셈")) {
              result = x+y;
          } else {
              result = x-y;
          }

          response.getWriter().printf("result is %d\n", result);

      }

  }
```

## calc.html
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="calc" method="post">
		<label for="id">X</label>
		<input type="text" name="x" id="id"> //request.getParameter("x")
		<label for="id">Y</label>
		<input type="text" name="y" id="id"> //request.getParameter("y")
		<input type="submit" name="operator" value="덧셈">  // request.getParameter("operator") 
		<input type="submit" name="operator" value="뺄셈">  // request.getParameter("operator")
	</form>
	<div>
		결과: 0
	</div>
</body>
</html>
```


## 코드 설명
- `@WebServlet("/calc")`
어노테이션을 이용한 맵핑

- `인코딩`
```java
response.setCharacterEncoding("utf-8"); // 서버 인코딩
response.setContentType("text/html; charset=utf-8"); // 이 문서가 무슨 타입인지 알려줘!
request.setCharacterEncoding("utf-8"); // 클라이언트 인코딩
```
- `데이터 유효검사`
```java
int x = 0; // 변수 초기화
int y = 0; // 변수 초기화

// html태그의 속성이 없을 때 빈문자열이 될 수 있기에 데이터 유효검사

if(!x_.equals("")) {
    x = Integer.parseInt(x_);
}

if(!y_.equals("")) {
    y = Integer.parseInt(y_); 
}
```
- `request.getParameter();`

```java
- request.getParameter("x"), request.getParameter("y")  
```
사용자가 입력한 값을 받아올 값을 문자열로 나타낸다. 
`request.getParameter("x")` -> `x: "1"`
`request.getParameter("y")` -> `y: "2"`

![](https://images.velog.io/images/withcolinsong/post/5cfdf1da-9f1b-4343-8f31-1e4e29d5e334/image.png)

- `request.getParameter("operator")`
-> operator의 덧셈이라는 텍스트와 같다면`result = x+y`  같지 않다면 `result = x-y`
```java
String op = request.getParameter("operator");
int result = 0; // 변수 초기화

if(op.equals("덧셈")) { 
      result = x+y;
  } else { // "덧셈"이 아니라면,
      result = x-y;
  }
```          

- `출력`
```java
response.getWriter().printf("result is %d\n", result);    
```

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2020.12.16

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)