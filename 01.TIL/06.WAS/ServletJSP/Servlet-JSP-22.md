# [목차](#목차)
- [목차](#목차)
- [1. view에서 사용하는 제어구조](#1-view에서-사용하는-제어구조)
- [2. JSTL(JSP Standard Tag Library) 다운로드](#2-jstljsp-standard-tag-library-다운로드)
    - [2.1. `다운로드` MavenRepository](#21-다운로드-mavenrepository)
- [3.  JSTL Core -> `제어 담당`](#3--jstl-core---제어-담당)
  - [References](#references)

# 1. view에서 사용하는 제어구조

- `JSTL`를 이용 -> Java 코드를 없애기 위한 태그를 이용한 제어구조로 변경

```java
<% 

List<Notice> list = (List<Notice>)request.getAttribute("list");

for(Notice notice : list) { 
    pageContext.setAttribute("notice", notice);

%>

<tr>
    <td>${notice.id }</td>
    <td class="title indent text-align-left"><a href="detail?id=${notice.id }">${notice.title }</a></td>
    <td>${notice.writer_id }</td>
    <td>${notice.hit }</td>
    <td>${notice.files }</td>
</tr>
<% } %>

```
- JSTL 라이브러리를 사용하여 Java 코드를 없앤다.
```java
    <c:forEach var="notice" items="${list}">
    <tr>
        <td>${notice.id }</td>
        <td class="title indent text-align-left"><a href="detail?id=${notice.id }">${notice.title }</a></td>
        <td>${notice.writer_id }</td>
        <td>${notice.hit }</td>
        <td>${notice.files }</td>
    </tr>
    </c:forEach>
```

# 2. JSTL(JSP Standard Tag Library) 다운로드

### 2.1. `다운로드` [MavenRepository](https://mvnrepository.com/artifact/javax.servlet/jstl/1.2)

![](https://images.velog.io/images/withcolinsong/post/0bb99cf2-ce95-4ce0-bd91-52c7149f273a/image.png)

![](https://images.velog.io/images/withcolinsong/post/3ab51942-6795-4d1f-8d95-b55d0582ead6/image.png)

- WebContent/WEB-INF/lib 경로에 JSTL.jar를 넣어준다.

- 디렉티브 설정
```java
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```


# 3.  JSTL Core -> `제어 담당`

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="notice" items="${list}">
    <tr>
        <td>${notice.id }</td>
        <td class="title indent text-align-left"><a href="detail?id=${notice.id }">${notice.title }</a></td>
        <td>${notice.writer_id }</td>
        <td>${notice.hit }</td>
        <td>${notice.files }</td>
    </tr>
</c:forEach>
```

- Jasper에게 서버에서 처리할 taglib 임을 알 수 있게 함
> `c:` -> `prifix="c"` : 식별자 -> `http://java.sun.com/jsp/jstl/core`

```java
<http://java.sun.com/jsp/jstl/core:forEach>
</forEach>

<c:forEach> 
</forEach>

```

```java
public class ForTag extends TagSupport {
    ....
}
```

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2021.01.16

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)