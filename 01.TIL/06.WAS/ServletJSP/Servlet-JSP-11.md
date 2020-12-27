# [목차](#목차)
- [목차](#목차)
- [Service()](#service)
- [doGet(), doPost()](#doget-dopost)
  - [코드](#코드)
  - [References](#references)

# Service()

- `GET`요청과, `POST` 요청 부분을 처리하는 `공통적인 부분`이 있다면, `service()`를 오버라이드하여 처리한다.
- HTML form 데이터 method가 소문자 `get`일 때, 서블릿에선 `대문자`로 비교한다.

html
```html
<form method="get">
    <input type="submit" value="요청">
</form>
```

Servlet
```java
```java
package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")

public class Calculator extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 공통적으로 처리해야 할 코드
        super.service(req, resp);

        // 아래는 doGet, doPost를 오버라이드 하지 않았을 때 데이터 유효성 검사
        if(req.getMethod().equals("GET")) {
            
            // 코드
        }

        if(req.getMethod().equals("POST")) {
            
            // 코드
        }

    }
}


```
> super.service(req, resp);
- 기본 기능 : form의 method를 doGet, doPost으로 가져온다.


# doGet(), doPost()
- GET, POST를 각각 처리해야 할 때는 `doGet()`, `doPost()`를 오버라이드 하여 사용한다.

## 코드
```java
package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")

public class Calculator extends HttpServlet{
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get 처리 코드
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Post 처리 코드

	}

}
```
- 405 오류 : URL은 있지만, 그 메서드를 처리할 수 없을 때 오류

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2020.12.27