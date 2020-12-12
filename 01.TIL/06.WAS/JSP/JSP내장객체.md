# [목차](#목차)
- [목차](#목차)
- [JSP 내장 객체](#jsp-내장-객체)
  - [1.1. 객체 종류](#11-객체-종류)
    - [1.1.1. 내장객체](#111-내장객체)
    - [1.1.2 out 내장 객체](#112-out-내장-객체)
    - [1.1.3. request 내장 객체](#113-request-내장-객체)
      - [1.1.3.1. 메서드](#1131-메서드)
    - [1.1.4. response 내장 객체](#114-response-내장-객체)
      - [1.1.4.1. JSP 페이지 이동 방법](#1141-jsp-페이지-이동-방법)
  - [1.2. 내장 객체의 영역(범위, Scope)](#12-내장-객체의-영역범위-scope)
    - [1.2.1 데이터 저장 위치](#121-데이터-저장-위치)
    - [1.2.2 저장 위치 설명](#122-저장-위치-설명)

# JSP 내장 객체

## 1.1. 객체 종류

### 1.1.1. 내장객체
내장 객체 분류| 내장 객체
|:-:|:-:|:-:|
입출력 관련 객체|`resquest` `response` `out`
서블릿 관련 객체|`page` `config` 
외부 환경 정보를 제공하는 객체|`session` `application` `pageContext`
예외 관련 객체| `exception`

### 1.1.2 out 내장 객체
- 서버에서 클라이언트로 열려있는 출력 스트림

### 1.1.3. request 내장 객체
- 클라이언트의 요청과 관련된 정보가 저장되는 내장 객체
- request 객체를 파악하면 클라이언트에서 서버로 전송된 데이터를 알 수 있다.

#### 1.1.3.1. 메서드
- 클라이언트의 요청이 있을 때 관련된 정보들을 알 수 있는 메소드

반환타입| 메소드명| 설명
|:-:|:-:|:-:|
String| getRemoteAddr()| 웹 서버에 연결한 클라이언트의 P주소를 구함
long| getContentLength()| 클라이어트가 전송한 요청정보의 길이를 구함
String| getCharacterEncoding()| 클라이언트가 요청 정보를 전송할 때 사용한 캐릭터셋을 구함
String| getContentType()| 클라이언트가 요청 정보를 전송할 때 사용한 컨텐트 타입을 구함
String| getProtocol()| 클라이언트가 요청한 프로토콜을 구함
String| getMethod()| 데이터 전송 방식을 구함
String| getRequestURL()| 요청 URL을 구함
String| getContextPath()| JSP페이지가 속한 웹어플리케이션의 컨텍스트패스 반환
String| getServerName()| 연결할 때 사용한 서버이름을 구함
int| getServerPort()| 사용중인 프로토콜을 구함

- request 객체의 요청 파라미터 관련 메소드

반환타입| 메소드명| 설명
|:-:|:-:|:-:|
String| getParameter(String name)|지정한 이름의 파라미터가 있을 경우 첫 번째 파라미터의 값을 구함
String[]| getParameterValues(String name)|지정한 이름의 파라미터가 있을 경우 지정한 이름을 가진 파라미터의 모든 값을 String[]으로 구함
Enumeration|getParameterNames()| 모든 파라미터의 이름을 구함
Map| getParameterMap()| 전송한 파라미터를 맵 형식으로 구함

### 1.1.4. response 내장 객체
- 클라이언트에 대한 응답을 처리하는 내장 객체
- 실행 결과를 브라우저로 되돌려 줄 때 사용
- 리다이렉트 기능을 많이 사용

#### 1.1.4.1. JSP 페이지 이동 방법

1. `리다이렉트`
- 브라우저의 URL을 변경하도록 하여 페이지를 이동하는 방식
- request와 response 객체가 유지되지 않는다
- response 객체의 `sendRedirect()` 메소드를 사용하여 페이지 이동

2. `포워딩`
- 브라우저의 URL을 유지하며 문서의 내용(페이지)만 이동하는 방식


## 1.2. 내장 객체의 영역(범위, Scope)
![](https://images.velog.io/images/withcolinsong/post/f953cc32-b2c6-4837-94bb-b1c578c3ec6f/image.png)


### 1.2.1 데이터 저장 위치
- Application : 모든 유저에 공유
- Session: 개인용(인당 발생)
	- login, logout
-Request: 요청 정보
-Page : JSP page

### 1.2.2 저장 위치 설명

`Page영역`
- 한 번의 클라이언트 요청에 하나의 JSP 페이지를 범위로 갖는다.
- 라이언트의 요청을 처리하는 `JSP 페이지`는 요청에 따라 새로운 `page영역`을 갖게 되고 `pageContext` 내장 객체를 할당 받으며, `해당 페이지 내에서만 사용`할 수 있다.

`request 영역`
- `클라이언트로부터 오는 한 번의 요청과 관련된 영역`으로, 클라이언트가 요청한 페이지와 요청을 받은 페이지 사이에서 `request 내장 객체에 정보를 저장`할 수 있다. 
- `브라우저가 결과를 받으면` 그 요청과 관련된 `request 내장 객체는 사라진다`.
- request 영역은 `하나의 요청을 처리하는데 사용되는 모든 JSP 페이지를 포함`한다.
- `request 영역에 저장된 정보를 얻기 위해서는 request 객체가 필요.`

`session 영역`
- 웹 브라우저를 닫기 전까지 페이지를 이동하더라도 유지되며 웹 서버에서 제공하는 것
- 세션을 통해 웹 어플리케이션의 로그인 상태를 유지한다

`application 영역`
- 웹 어플리케이션에 속한 `모든 페이지`, `페이지에 대한 요청`, `세션 모두 하나의 application 영역`에 속한다. 
- 모든 JSP 페이지는 하나의 application 내장 객체를 공유하고 있으며 이 application 내장 객체가 application 영역에 속한다.


## References
- 🎈2020.12.12
- 🎈정리 : VScode
