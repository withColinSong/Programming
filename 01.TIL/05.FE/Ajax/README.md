# [목차](#목차)
- [목차](#목차)
- [1. XMLHttpRequest(XHR)](#1-xmlhttprequestxhr)
  - [1.1 속성](#11-속성)
  - [References](#references)

# 1. XMLHttpRequest(XHR)

- 객체는 서버와 상호작용하기 위하여 사용 
- 전체 페이지의 새로고침없이도 URL 로부터 데이터를 받아올 수 있다.
- 모든 종류의 데이터를 받아오는데 사용

## 1.1 속성

`XMLHttpRequest.open()`
- 서버로부터 응답을 받은 후에 동작을 결정한 뒤 요청.
>XMLHttpRequest.open(method, url[, async[, user[, password]]])

`XMLHttpRequest.onreadystatechange`
- readystate 속성이 변경될 때 마다 호출되는 이벤트.
>onreadystatechange: ((this: XMLHttpRequest, ev: Event) => any) | null;
>
>XMLHttpRequest.onreadystatchange = funtion() { .. }

`XMLHttpRequest.responseText`
- 요청에 대한 응답을 텍스트로 갖는 DOMString 을 반환
- 요청이 성공하지 못했거나 아직 전송되지 않았을 경우 null 을 반환.
- 요청이 전송 된 후 서버에서 받은 텍스트를 반환
- responseText: string;
>JSON.parse(req.responseText);

`readystate`
- readyState: number;
- 클라이언트 상태 반환

값|상태|기술
|:-:|:-:|:-:|
0|	UNSENT|	클라이언트가 생성되었습니다. open()아직 요청되지 않음
1|	OPENED|	open() 호출
2|	HEADERS_RECEIVED|	send() 호출되었으며 헤더 및 상태를 사용할 수 있다.
3|	LOADING|	다운로드 responseText부분 데이터를 보유
4|	DONE|	작업이 완료

`XMLHttpRequest.send()`
- 요청을 보냄
- 요청이 비동기인 경우(기본값 true)
- false 동기방식 
- 메소드는 요청이 보내진 즉시 반환한다.


## References
- 참고 : https://developer.mozilla.org/ko/docs/Web/API/XMLHttpRequest
- 🎈2020.12.09

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
