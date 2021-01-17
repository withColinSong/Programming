# [목차](#목차)
- [목차](#목차)
- [1. forEach의 속성 사용하기](#1-foreach의-속성-사용하기)
- [2. forEach 속성](#2-foreach-속성)
  - [2.1 forEach 속성 종류](#21-foreach-속성-종류)
    - [2.1.1. ${st.current}](#211-stcurrent)
    - [2.1.2 ${st.index}](#212-stindex)
    - [2.1.3 ${st.count}](#213-stcount)
    - [2.1.4 ${st.first}](#214-stfirst)
    - [2.1.5 ${st.last}](#215-stlast)
    - [2.1.6 ${st.begin}](#216-stbegin)
    - [2.1.7 ${st.end}](#217-stend)
    - [2.1.8 ${st.step}](#218-ststep)
  - [References](#references)

# 1. forEach의 속성 사용하기

```java
List<Notice> list = (List<Notice>)request.getAttribute("list");
					
for(Notice notice : list) { 
    pageContext.setAttribute("notice", notice);
```
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
```java
List<Notice> list = (List<Notice>)request.getAttribute("list");
<c:forEach items="${list}">
```
```java
<c:forEach var="notice">
pageContext.setAttribute("notice", notice);
```

# 2. forEach 속성
- Basic
```java
<c:forEach begin="" end="" varStatus="">
```
|||
|:-:|:-:|
${st.current} | 객체 반환
${st.index} | 인덱스 출력 `0부터 시작`
${st.count} | count
${st.first} | boolean, first-> true 그외 false
${st.last} | boolean, last -> true 그 외 false
${st.begin}|
${st.end}|
${st.step}|// index -> 늘어나는 숫자

## 2.1 forEach 속성 종류
- 이해 하기 전 확인 코드 [Servlet-JSP-22.md](Servlet-JSP-22.md)
```java
<c:forEach var="notice" items="${list}" begin="0" end="3" varStatus="st">
```
### 2.1.1. ${st.current}

![](https://images.velog.io/images/withcolinsong/post/8e6f3097-d46e-4ac5-b128-7beab7cb6afc/image.png)

### 2.1.2 ${st.index}
begin을 시작시 그 인덱스 번호로 출력한다.

![](https://images.velog.io/images/withcolinsong/post/752ad8f6-7af7-40a5-bc4b-8f2bdb885929/image.png)

### 2.1.3 ${st.count}
![](https://images.velog.io/images/withcolinsong/post/32cc4cb7-79b5-476f-af0c-b69c5265c548/image.png)

### 2.1.4 ${st.first}
![](https://images.velog.io/images/withcolinsong/post/ac9a5620-282f-40f6-aaa1-5d250194ff6c/image.png)

### 2.1.5 ${st.last}
![](https://images.velog.io/images/withcolinsong/post/c36474b7-370f-4e88-9859-dd3d790382a9/image.png)

### 2.1.6 ${st.begin}
![](https://images.velog.io/images/withcolinsong/post/7269b972-0e7f-40c2-bc86-aaee4d943e8e/image.png)

### 2.1.7 ${st.end}
![](https://images.velog.io/images/withcolinsong/post/57513d31-edc1-4e7e-82ce-99b3b4f1d770/image.png)

### 2.1.8 ${st.step}
- 증가 단계 지정

```java
<c:forEach var="notice" items="${list}" begin="0" end="3" varStatus="st" step="2">
```

![](https://images.velog.io/images/withcolinsong/post/9dd1131a-4a7b-44aa-83a6-07fa3906b814/image.png) 

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2021.01.17

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)