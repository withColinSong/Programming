# [목차](#목차)
- [목차](#목차)
- [1. EL](#1-el)
	- [1.1 표기 방법](#11-표기-방법)
	- [1.2. List 출력 방식](#12-list-출력-방식)
	- [1.3. Map 출력 방식](#13-map-출력-방식)
- [2. EL의 데이터 저장소](#2-el의-데이터-저장소)
	- [2.1. 클라이언트의 입력 값 추출](#21-클라이언트의-입력-값-추출)
		- [2.1.1 우선순위](#211-우선순위)
		- [2.1.2. 그 외](#212-그-외)
- [3. EL 연산자](#3-el-연산자)
	- [3.1. empty](#31-empty)
	- [References](#references)

# 1. EL
- Expression Language 
- 저장 객체에서 값을 추출해서 출력하는 표현식

## 1.1 표기 방법

> Contorller
```java
request.setAttribute("cnt", cnt);
```
> View
```java
request.getAttribure("cnt");
```

> EL
```java
`${cnt}`
```

## 1.2. List 출력 방식
- 오브젝트로 반환하기 때문에 형변환을 해줘야한다.

> Contorller
```java
List <String> list = new ArrayList<>();
list.add("hello");
request.setAttribute("list", list)
```

> View
```java
((List))request.getAttribute("list")).get(0)
```
> EL
```java
${list[0]}
```

## 1.3. Map 출력 방식
```java
Map <String, Object> map = new HashMap<>();

map.put("id", 1)
map.put("title", "내용")

request.setAttribute("map", map)

((Map))request.getAttribute("map")).get(0)
```

> EL
```java
${notice.title}

```

# 2. EL의 데이터 저장소

- page
- request
- response
- application

## 2.1. 클라이언트의 입력 값 추출

### 2.1.1 우선순위 

```java
setAttribute("cnt", cnt);
getAttribute("cnt");
```
> ${cnt}가 EL 저장소에 각각 저장되어 있을 때 page, request, response, application

1. page 
2. request 
3. response 
4. application

`Scope`를 사용하여 값을 꺼내올 수 있다.

- `pageScope`
- `requestScope`
- `responseScope`
- `applicationScope`

```java

${pageScope.cnt}
${requestScope.cnt}
${responseScope.cnt}
${applicationScope.cnt}
```
### 2.1.2. 그 외

`${param.cnt}`
- 파라미터 값을 저장하고 있는 저장소

`${header.cnt}`
- header 정보를 저장하고 있는 저장소

`${header["문자열"]}`
- `""`, `-`을 사용할 때

```java
pageContext.setAttribute("result" ,"hello");
pageContext : ${result }
```
```java
String num_ = request.getParameter("n");
		int num = 0; 
		if(num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);	
		}
		
	    String result;

	    if(num % 2 == 0) {
	        result = "짝수";
	    }else {
	        result = "홀수";
	    }
	    
request.setAttribute("result", result);
request: ${requestScope.result}
```
```java
String num_ = request.getParameter("n");
		int num = 0; 
		if(num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);	
		}
param.n : ${param.n }
```
```java
header.accept : ${header.accept }
```
![](https://images.velog.io/images/withcolinsong/post/77f98fc3-3ac2-40ce-849b-9af6bccd4f59/image.png)


```java
<%=pageContext.getRequest().getMethod() %>
${pageContext.request.method}
```

# 3. EL 연산자

- html 태그 안에 `<>`가 있기 때문에 엄격한 기준을 가지고 있는 어떠한 문서는 `ge, gt, lt, le` 연산자를 사용할 수 있는 문제점이 생길 수 있다.
## 3.1. empty

```JAVA
if(n != null || !n.equals("")) {

}

empty param.n : ${empty param.n}<br>
not empty param.n : ${not empty param.n}<br>
empty param.n : ${not empty param.n ? '값이 비었습니다.' : param.n}<br>
empty param.n/2 : ${param.n/2}<br>
```

![](https://images.velog.io/images/withcolinsong/post/69c26d8c-494e-427d-93c2-899d76c53278/image.png)

![](https://images.velog.io/images/withcolinsong/post/7235da18-66b6-4fb6-8ca2-80a4cec3ba92/image.png)

## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2021.01.02

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)