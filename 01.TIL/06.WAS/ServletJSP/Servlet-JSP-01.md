# [목차](#목차)
- [목차](#목차)
- [1. Tomcat WEB-INF](#1-tomcat-web-inf)
  - [1.1. `WebContent`](#11-webcontent)
- [2. 어노테이션을 이용한 URL 맵핑](#2-어노테이션을-이용한-url-맵핑)
- [3. 문자열 출력](#3-문자열-출력)
- [3. 인코딩](#3-인코딩)
  - [3.1. 서블릿 출력 형식을 지정해야 하는 이유](#31-서블릿-출력-형식을-지정해야-하는-이유)
  - [3.2. 한글 깨지는 이유](#32-한글-깨지는-이유)
  - [References](#references)

# 1. Tomcat WEB-INF
- 톰캣은 사용자가 `WEB-INF` 영역에 접근할 수 없다.
- 외부에서 요청 불가
- 맵핑을 이용하여 요청한다.

![](https://images.velog.io/images/withcolinsong/post/15b1bc5b-2860-4e19-94e9-d4e87871a4b9/image.png)

## 1.1. `WebContent`
- 홈 디렉토리
- 이클립스 run을 누르면 Tomcat 서버로 배포되어 실행

# 2. 어노테이션을 이용한 URL 맵핑
`@WebServlet("name, url ....")`
- 맵핑 정보를 등록할 수 있다.(XML에 설정하지 않아도 된다.)
```java
@WebServlet("/index.jsp")
```
# 3. 문자열 출력
response를 이용한 출력방법
```java
OutputStream os = response.getOutputStream();
PrintStream out = new PrintStream(os, true); 
out.println("Hello Servlet!!"); // 클라이언트에게 전송
```
`PrintStream(os, true);`
- 버퍼를 꽉 채우지 않을 때 전송시키기 위함
- 자동 flush

`PrintWriter out = response.getWrite` : 간단한 문자열 출력

# 3. 인코딩
## 3.1. 서블릿 출력 형식을 지정해야 하는 이유

- 웹문서로 렌더링 되기 때문에, `html`-> `<br>`로만 개행이 가능하다.
```java
out.println("hello")
out.println("hello") // 개행이 되지 않는다. 

hello hello

out.println("hello <br>")
out.println("hello <br>")

hello
hello
```


- 브라우저에 컨텐츠 형식을 알려주지 않으면 `자의적`으로 해석한다.
- `text`
- `html`

## 3.2. 한글 깨지는 이유

- 한글은 기본적으로 2byte씩 인식함. 
- 톰캣 서버는 읽어드리는 값이 1byte씩 읽고 기본적으로 인코딩이 `ISO-8859-1`이므로,  한글이 깨질 수밖에 없다.
- 톰캣 서버 옵션에서 직접 변경하는 것보다 아래 메서드를 사용하는 것이 좋다.

```java
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
```


## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2020.12.15

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)

