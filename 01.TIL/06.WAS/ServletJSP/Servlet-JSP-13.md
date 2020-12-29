# [목차](#목차)
- [목차](#목차)
- [JSP를 이용한 자바 웹 프로그래밍](#jsp를-이용한-자바-웹-프로그래밍)
  - [1. 코드블럭](#1-코드블럭)
    - [1.1. Jasper](#11-jasper)
  - [1.2. 코드 블럭 종류](#12-코드-블럭-종류)
    - [1.2.1 지역변수 알고리즘](#121-지역변수-알고리즘)
    - [1.2.2 멤버함수, 멤버변수](#122-멤버함수-멤버변수)
    - [1.2.3. 선언부(Declaration)](#123-선언부declaration)
    - [1.2.4. Page 지시자](#124-page-지시자)
  - [2. JSP 키워드](#2-jsp-키워드)
  - [References](#references)

# JSP를 이용한 자바 웹 프로그래밍

- Tomcat JSP 경로
```text
C:\Users\user\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\work\Catalina\localhost\ROOT\org\apache\jsp
```


## 1. 코드블럭

### 1.1. Jasper 
- Jasper은 .jsp 파일 전체 데이터를 `out.write();` 라고 인식한다. 그렇기 때문에 변수, 메서드 선언을 필요로 할 때 `코드 블럭`이 필요하다.

```java
<%  
    // 코드 블럭
    int x = 1; 
	int y = 3;
%>

	int x1 = 1;
	int x2 = 1;

```

- Jasper는 아래와 같이 인식한다.

![](https://images.velog.io/images/withcolinsong/post/51ec8e63-edfa-4104-a200-08069114e990/image.png)

## 1.2. 코드 블럭 종류

### 1.2.1 지역변수 알고리즘
- `<% %>` 코드블럭에 작성하면 무조건 `Service()`에 들어간다.
```java
public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException {


        }
```      
### 1.2.2 멤버함수, 멤버변수
```java
public final class calculator_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {
                     
        }
```
### 1.2.3. 선언부(Declaration)

- 메서드 안에 메서드는 정의할 수 없기 때문에 `<% %>`에 메서드를 정의할 수 없다.
- `멤버함수, 멤버변수 메서드`에 정의됨.
- `<%! %>`
```java
<%

    // 구문 에러
    public int sum(int a, int b) {
        return a + b;
    }

%>

- 위에 구문을 아래처럼 변경한다.


<%!

    public int sum(int a, int b) {
        return a + b;
    }

%>
```

### 1.2.4. Page 지시자

```java
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
```
- 제일 맨 위에 존재해야 함.


## 2. JSP 키워드
- 변수 이름으로 지정할 수 없다.
```java
    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;
```
- `pageContext`
- `session`
- `application`
- `config`
- `out`
- `page`

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2020.12.29