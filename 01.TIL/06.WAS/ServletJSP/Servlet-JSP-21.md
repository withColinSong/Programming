# [목차](#목차)
- [목차](#목차)
- [1. WEB-INF](#1-web-inf)
  - [2. view 은닉하기](#2-view-은닉하기)
    - [2.1. 기존 WebContent 경로](#21-기존-webcontent-경로)
    - [2.2. view 은닉 경로](#22-view-은닉-경로)
  - [References](#references)

# 1. WEB-INF
- **`외부에서 요청할 수 없다.`**
- 라이브러리, 설정, 코드 파일을 둘 수 있다.
- view page
- 사용자가 직접 요청하지 못하도록 관리할 수 있다.
- JSP를 유출해 버그를 나타내는 것을 방지한다.

## 2. view 은닉하기
### 2.1. 기존 WebContent 경로

![](https://images.velog.io/images/withcolinsong/post/8e71d056-fc9e-40d9-81a6-33fe17eb60c4/image.png)
- notice/list.jsp

### 2.2. view 은닉 경로

![](https://images.velog.io/images/withcolinsong/post/b3f53836-7655-4d2c-a273-bcbeef758615/image.png)
- WEB-INF/view/notice/list.jsp


## References
- [뉴렉처](https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd): `Servlet / JSP`
- 🎈vscode 정리
- 🎈2021.01.04

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)