# 목차
- [목차](#목차)
- [1. jQuery](#1-jquery)
  - [1.1 jQuery 문법](#11-jquery-문법)
    - [1.1.1 DOM](#111-dom)
  - [1.2. jQuery 다운로드](#12-jquery-다운로드)
    - [1.2.1. Downloading jQuery](#121-downloading-jquery)
    - [1.2.2. CDN](#122-cdn)
  - [1.3. 환경 설정](#13-환경-설정)
    - [1.3.1. 한글 인코딩 : utf-8](#131-한글-인코딩--utf-8)
    - [1.3.2. 자바 연결 확인](#132-자바-연결-확인)
    - [1.3.3. 웹서버 설정 : JSP 컨테이너 -> Tomcat](#133-웹서버-설정--jsp-컨테이너---tomcat)
    - [1.3.4. 현재 프로젝트에 웹서버 설정](#134-현재-프로젝트에-웹서버-설정)
    - [1.3.5. PORT 확인.](#135-port-확인)
  - [1.4. 라이브러리 오류](#14-라이브러리-오류)
    - [1.4.1 해결방안](#141-해결방안)


# 1. jQuery
1. html + css + javaScript를 통합한 하나의 라이브러리
2. 굉장히 쉬운 접근방법을 제공 -> **전체 처리 속도 감소**
3. 모든 JavaScript 문법은 그대로 사용 가능
4. 대소문자 구별
5. `''`, or `""`는 구별하지 않음
6. 라이브러리를 사용하는 방법
  - CDN
  - 라이브러리를 해당 프로젝트내에 복사해서 사용
7. jQuery는 모든 것이 함수화되어 있기 때문에 함수에 대한 이해가 좋을 수록 jQuery의 이해도가 높아질 수 있다.


## 1.1 jQuery 문법

- 정적 -> 동적

id = 'abc인 요소를 선택
- js
```js
const ID = document.getElementByid('abc');

function getID() {
    function(id) {
        return document.getElementByid(id)
    }
}

getID();

var id = $('#abc'); // jQuery
```

```java
id = #element { ... } -> $(element).css('key','value');
// css -> #header{ color : #f00; } 
```

### 1.1.1 DOM
- Document Object Model
- HTML을 트리구조로 표현한 것.
- selectors, Attributes, Travrsing, Manipulation, CSS
- Event, Effects, Ajax

## 1.2. jQuery 다운로드

### 1.2.1. Downloading jQuery
> https://jquery.com/download/
> 
![](https://images.velog.io/images/withcolinsong/post/8acee999-af19-4de0-a7ca-3eaf2d88bce3/image.png)
### 1.2.2. CDN
> http://code.jquery.com/
> 
> uncompressed, minified 둘 중 하나를 사용

compressed 
  - 속도를 최대화 하기 위해 띄어쓰기, 주석 제거한 부분

## 1.3. 환경 설정

eclipse EE 버전 설치 후 환경 설정
.jsp

### 1.3.1. 한글 인코딩 : utf-8
![](https://images.velog.io/images/withcolinsong/post/6abeaa56-989a-43e2-993a-b3788de89e88/image.png)

![](https://images.velog.io/images/withcolinsong/post/1c786cc8-1e55-40fd-b602-da453eeb766a/image.png)

### 1.3.2. 자바 연결 확인

![](https://images.velog.io/images/withcolinsong/post/d918b41a-9003-444c-84b3-1133959c2e27/image.png)

### 1.3.3. 웹서버 설정 : JSP 컨테이너 -> Tomcat

![](https://images.velog.io/images/withcolinsong/post/93c04f4e-49ec-4f9c-8387-824bee572265/image.png)

### 1.3.4. 현재 프로젝트에 웹서버 설정

![](https://images.velog.io/images/withcolinsong/post/196f5fae-ccc8-495b-85f9-6c1ee25226e7/image.png)

### 1.3.5. PORT 확인.

![](https://images.velog.io/images/withcolinsong/post/d15c325f-9ecc-4643-8ac2-f7167ac0891e/image.png)

## 1.4. 라이브러리 오류

![](https://images.velog.io/images/withcolinsong/post/f06c4abd-d4a0-4b78-9c7c-93d774c132ca/image.png)

### 1.4.1 해결방안

![](https://images.velog.io/images/withcolinsong/post/66318b91-31fc-4865-8d65-10ca9da92d18/image.png)

> 혹은 module path가 아닌 class path 경로에 라이브러리를 추가하면 오류가 뜨지 않는다.

Libraries -> modulepath -> add Libaray -> Server Runtime -> Tomcat 경로 

