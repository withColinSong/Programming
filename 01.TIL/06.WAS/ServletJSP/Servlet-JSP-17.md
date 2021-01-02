# [목차](#목차)
- [목차](#목차)
- [EL 기본 객체](#el-기본-객체)
  - [References](#references)

# EL 기본 객체

`pageContext` 
- JSP의 page 기본 객체와 동일
 
`pageScope` 
- pageCntext 기본 객체에 저장된 속성의 <속성, 값> 매핑을 지정한 Map객체

`requestScope` 
- request 기본 객체에 저장된 속성의 <속성, 값> 매핑을 지정한 Map 객체

`sessionScope` 
- session 기본 객체에 저장된 속성의 <속성, 값> 매핑을 지정한mMap 객체

`applicationScope` 
- application 기본 객체에 저장된 속성의 <속성, 값> 매핑을 지정한 Map객체

`param` 
- 요청 파라미터의 <파라미터이름, 값> 매핑을 저장한 Map객체
- 파라미터 값의 타입은 String으로서, `request.Parameter(이름)의 결과와 동일`

`paramValues` 
- 요청 파라미터의 <파라미터이름, 값> 매핑을 저장한 Map객체
- 파라미터 값의 타입은 String으로서, `request.ParameterValues(이름)의 결과와 동
일`

`header` 
- 요청 정보의 <헤더이름, 값> 매핑을 지정한 Map객체
- request.getHeader(이름)의 결과와 동일

`headerValues`
- 요청 정보의 <헤더이름, 값> 매핑을 지정한 Map객체
- request.getHeaders(이름)의 결과와 동일

`cookie` 
- <쿠키이름, Cookie> 매핑을 저장한 Map객체
- request.getCookie( )로 구한 Cookie 배열로부터 매핑을 생성

`initParam` 
- 초기화 파라미터의 <이름, 값> 매핑을 저장한 Map객체
- application.getInitParameter( )결과와 동일

```java
<h1>표현식 버전</h1><hr>
아이디 : <%=request.getParameter("id") %><br>
암호 : <%=request.getParameter("pass") %><br><br>

<h1>EL 버전</h1><hr>
아이디 : ${param.id }<br>
암호 : ${param.pass }<br><br>

```

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2021.01.02

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)