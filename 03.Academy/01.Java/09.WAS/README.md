# [목차](#목차)
- [목차](#목차)
- [1. 서블릿](#1-서블릿)
  - [1.1. 서블릿 기본 골격](#11-서블릿-기본-골격)
  - [1.2. HttpServletRequest](#12-httpservletrequest)
  - [1.3. HttpServletResponse](#13-httpservletresponse)
  - [1.4. 서블릿 라이프사이클](#14-서블릿-라이프사이클)
  - [1.5. 서블릿 작성 시 유의사항](#15-서블릿-작성-시-유의사항)
- [2. JSP](#2-jsp)
  - [2.1. 디렉티브](#21-디렉티브)
  - [2.2. 스크립트 요소](#22-스크립트-요소)
    - [2.2.1. 표현식](#221-표현식)
    - [2.2.2. 스크립틀릿](#222-스크립틀릿)
    - [2.2.3. 선언부](#223-선언부)
  - [2.3. 기본 객체](#23-기본-객체)
  - [2.3.1 jsp 형식](#231-jsp-형식)
  - [2.4. .jsp 브라우저 설정 방법](#24-jsp-브라우저-설정-방법)

# 1. 서블릿

서블릿은 Java EE 스펙, 이것을 구현한 구현체가 tomcat, undertow, jetty.

웹 서버(Web Server)
- 스태틱 파일 서빙
- 로드 밸런싱
- 리버스 프록시

웹 애플리케이션 서버 (Web Application Server)

- 비즈니스 로직

서블릿 구현체를 서블릿 컨테이너 (Servlet Container)라고 부른다.
구현체 
- tomcat
- undertow
- jetty
- ...

## 1.1. 서블릿 기본 골격

- 싱글톤

```java
package example_Servlet;

import java.io.IOException;
import javax.servlet.*;

/**
 * Servlet implementation class HelloServelt
 */
@WebServlet("/path") // 경로
public class HelloServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 서블릿 생성자
     */
    public HelloServelt() { 
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
     
     //WebServlet에 지정된 경로로 GET 메서드로 요청 시 처리 할 로직
	protected void doGet(HttpServletRequest request, HttpServletResponseresponse) throws ServletException, IOException {
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

      //WebServlet에 지정된 경로로 POST 메서드로 요청 시 처리 할 로직
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
```
## 1.2. HttpServletRequest

HTTP 요청에 대한 객체
- 요청라인
 - 메서드
 - URI
 - 프로토콜
- 요청 헤더
- 요청 바디

## 1.3. HttpServletResponse

- 상태라인
  - 상태 코드(status code)
- 응답 헤더
- 응답 바디

## 1.4. 서블릿 라이프사이클

- init : 최초에 단 한 번 실행됨
- service : 요청과 응답을 처리
- destroy : 메모리에서 해제 될 때 호출
  - 내용이 변경되어 컨텍스트 다시 로드 할 때
  - 서버 재시동
  - 서버 종료

## 1.5. 서블릿 작성 시 유의사항

- 서블릿은 싱글톤임
  - 파괴되기 전 까지 남아 있음.
  - 상태를 가지면 사이드 이펙트 발생 가능성 존재
    - 가급적 멤버 변수 두지 말 것
  
# 2. JSP

JSP 기본 코드 구조
```jsp
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP</title>
</head>
<body>
<%
	final Date date = new Date();
	final SimpleDateFormat sdf 
	= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss(E)");
%>
	<h1>._.</h1>
	<p>현재 시간: <%= sdf.format(date) %></p>
</body>
</html>
```

위 코드는 크게 세 가지 부분으로 나뉨
1. 디렉티브(directive)
2. 스크립트 요소(Scriptlet, Expression)
3. HTML

## 2.1. 디렉티브

디렉티브는 해당 JSP의 설정 정보를 나타냄.

```jsp
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
```

기본적인 사용 방법
```jsp
<%@ 디렉티브이름 속성="값"%>
```


- page: 해당 페이지에 대한 필요한 정보 지정.
  - java import, 응답 버퍼 사이즈, 문서 타입
- taglib: 태그 라이브러리 지정
  - JSTL
- include: 다른 문서 임포트

## 2.2. 스크립트 요소

JSP 페이지 내에서 동적으로 생성되는 내용들을 위해 존재함.

- 표현식(Expression)
- 스크립틀릿(Scriptlet)
- 선언부(Declaration)

### 2.2.1. 표현식
- 표현식(Expression): 값을 출력. 정확히 값만 출력한다.
- `<%=`와 `>`로 감싼 값으로 평가되는 식
```jsp
<p>현재 시간: <%= sdf.format(date) %></p>
```

### 2.2.2. 스크립틀릿
- 스크립틀릿(Scriptlet): 자바 코드 실행
```jsp
<%
	final Date date = new Date();
	final SimpleDateFormat sdf 
	= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss(E)");
%>
```
### 2.2.3. 선언부
- 선언부(Declaration): 자바 메서드 선언
```jsp
<%!
	private static String printDate() {
	final Date date = new Date();
	final SimpleDateFormat sdf 
	= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss(E)");
	return sdf.format(date);
}
%>
```

## 2.3. 기본 객체
- request(HttpServletRequest) :  HTTP 요청에 대한 객체.
- response(HttpServletResponse): HTTP 응답에 대한 객체. 응답 결과 가공 후 전송.
- session(HttpSession): 세션
- application: 현재 애플리케이션(톰캣)의 정보
- pageContext: 현재 페이지 구성에 대한 컨텍스트

## 2.3.1 jsp 형식
```java
// <%@ 지시문 - >  direction %> 
// <%! 선언문 %>
// <%= 표현식 %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	// 스크립트릿 영역 (scriptlet) : java coding area
	// java -> System.out.println();
	// js -> console.log();, document.write();
	out.print("hi jQuery...");
%>
</body>
</html>

```
## 2.4. .jsp 브라우저 설정 방법
![](https://images.velog.io/images/withcolinsong/post/58d0228b-3086-4da5-9002-427fcbc26aeb/image.png)

![](https://images.velog.io/images/withcolinsong/post/5e817718-7ff9-441c-9cff-c72210f577fe/image.png)




