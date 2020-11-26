# [목차](#목차)
- [목차](#목차)
- [1. STS 프로젝트 만들기](#1-sts-프로젝트-만들기)
  - [1.1. Spring 실행](#11-spring-실행)
    - [1.1.1 DB Oracle 계정등록](#111-db-oracle-계정등록)
    - [1.1.2 실행 결과](#112-실행-결과)
  - [References](#references)


- IDE : 이클립스
# 1. STS 프로젝트 만들기
1. New -> Project -> Spring Starter Project
![](https://images.velog.io/images/withcolinsong/post/6a90f65e-458c-450f-8dca-aba41a8dc8cd/image.png)

![](https://images.velog.io/images/withcolinsong/post/d7ef1ba5-06af-4d60-8a7b-e2363598328a/image.png)

> - type : 빌드도구
> - pkg : jar (자바 아카이브)
> - Group : 도메인(역순으로 입력하기)
> - Aftifact : 원하는 것 적기



![](https://images.velog.io/images/withcolinsong/post/87f9b375-82de-4478-8baa-2d11f77d11ae/image.png)

![](https://images.velog.io/images/withcolinsong/post/6f9beb0f-f02e-49ef-849a-e06c0f8a9759/image.png)

![](https://images.velog.io/images/withcolinsong/post/bd7afcc2-8960-4b95-b48d-e0873f644ded/image.png)

![](https://images.velog.io/images/withcolinsong/post/f98ce387-928a-478b-bbde-b1d391cfd586/image.png)

## 1.1. Spring 실행
![](https://images.velog.io/images/withcolinsong/post/883329ce-d19b-499f-8cf6-c61dfb4badda/image.png)

### 1.1.1 DB Oracle 계정등록
- src/main/resources -> application.properties  

![](https://images.velog.io/images/withcolinsong/post/2e2ac596-769b-4d83-b95b-2f5b868b375f/image.png)


> - server.port = 연결할 PORT
> - spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
> - spring.datasource.username= 오라클계정아이디
> - spring.datasource.password= 오라클계정비밀번호


![](https://images.velog.io/images/withcolinsong/post/a3bff8b3-ddab-41b0-ba8b-63caecb1914f/image.png)

### 1.1.2 실행 결과
![](https://images.velog.io/images/withcolinsong/post/1cdc1a12-fa37-488f-bd3b-396ead83dad8/image.png)

## References
- 🎈2020.11.25
- 🎈정리 : song

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)