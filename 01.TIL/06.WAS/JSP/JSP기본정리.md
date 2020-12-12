# [목차](#목차)
- [목차](#목차)
- [JSP 특징 (Java Server Pages)](#jsp-특징-java-server-pages)
  - [1.1. JSP와 Servelt의 차이점](#11-jsp와-servelt의-차이점)
  - [1.2 JSP 기본태그](#12-jsp-기본태그)
    - [1.2.1 기본태그 특징](#121-기본태그-특징)
  - [1.3. JSP 지시자](#13-jsp-지시자)
    - [1.3.1. 지시자](#131-지시자)
  - [1.4. JSP 생성된 경로](#14-jsp-생성된-경로)
  - [1.5. JSP 외부 페이지 삽입](#15-jsp-외부-페이지-삽입)
    - [1.5.1 동적 삽입](#151-동적-삽입)
    - [1.5.2. 정적 삽입](#152-정적-삽입)
  - [References](#references)

# JSP 특징 (Java Server Pages)

## 1.1. JSP와 Servelt의 차이점
`JSP`
- HTML태그 사용이 용이하고 자바코드 사용이 불편하기 때문에 웹어플리케이션에서 사용자에게 결과를 보여주는 View(Client)를 담당

`Servlet`
- Servlet은 자바코드 작성이 편리하기 때문에 주로 화면과 통신하여 자료를 받아 가공하고 가공한 자료를 다시 화면에 전달


## 1.2 JSP 기본태그
종류| 설명| 형식|
|:-:|:-:|:-:|
주석(Comments tag)| 컴파일 시 주석으로 취급하기 위한 코드| <%-- --%>
지시자(directive tag)| JSP 페이지 전체에 사용하기 위한 설정을 작성| <%@ %>
선언(declaration)| 변수와 메소드를 선언 |<%! %>
스크립트릿(scriptlet)| 자바 코드를 기술 |<% %>
표현식(expression)| 계산식이나 함수 리턴을 문자열 형태로 출력 |<%= %>

### 1.2.1 기본태그 특징
- `표현식`  
  - `;` 작성하지 않는다.
  - `변수, 수식, 메소드호출` 가능
```java
<%=변수 %>
<%=수식 %>
<%=메소드호출 %>
```
- `스크립트릿`
  - 스크립트릿 태그 내에 정의된 내용은 JSP코드가 서블릿으로 변환될 때 `_jspService()` 메소드 내부로 들어가게 된다.

## 1.3. JSP 지시자

종류| 목적
|:-:|:-:|:-:|
page |해당 JSP 페이지 전반적인 환경 설정
include|페이지에 다른 파일의 내용을 삽입
taglib| 태그 라이브러리에서 기능을 사용할 수 있도록 제공
import| 

`page, include, taglib -> 중복 선언 불가능`



```java
<%@ 지시자 속성="값" … %>
```

### 1.3.1. 지시자

page 지시자
- JSP 페이지에서 에러가 발생했을 때 보여줄 에러 페이지를 설정
```java
<%@ page errorPage="error.jsp" %>
```
include 지시자


## 1.4. JSP 생성된 경로
- .jsp파일로 만들어진 페이지는 웹 서버 내부적으로 서블릿 코드를 생성한다.
- 이클립스로 작업한 경우 
>`(workspace폴더)\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\test\org\apache\jsp\`

## 1.5. JSP 외부 페이지 삽입
### 1.5.1 동적 삽입
```java
<jsp:include page='...'> // action tag
```
- 해당 위치에 실행결과가 복사된다.
- page 속성에 `파일명`이나 `변수`를 사용할 수 있다.

### 1.5.2. 정적 삽입
```java
<% include file='...'%> // 무조건 파일명
```
- 해당 위치에 소스가 그대로 복사된다.
- `변수 사용 불가`

## References
- 🎈2020.12.12
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)