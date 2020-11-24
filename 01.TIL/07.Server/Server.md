# [목차](#목차)
- [목차](#목차)
- [1. Vultr](#1-vultr)
  - [1.1. 새로운 계정 만들기](#11-새로운-계정-만들기)
  - [1.2 계정 권한 부여](#12-계정-권한-부여)
- [2. 도메인](#2-도메인)
- [3. MobaXtrem](#3-mobaxtrem)
  - [3.1. 웹 서버](#31-웹-서버)
  - [3.2. 웹 서버 폴더 만들기](#32-웹-서버-폴더-만들기)
  - [3.3. http → https 인증서 설치](#33-http--https-인증서-설치)
  - [3.4. 앱 실행](#34-앱-실행)
  - [References](#references)


사전준비 
- Vultr Cloud 구매
- 도메인
- MobaXtrem
- .jar

# 1. Vultr
홈페이지 : [https://my.vultr.com/](https://my.vultr.com/)
Products -> Cloud Instance
![](https://images.velog.io/images/withcolinsong/post/16213b56-a98b-431b-9daa-e2245e1aa88b/image.png)

![](https://images.velog.io/images/withcolinsong/post/d02d8812-d201-45e9-abc4-aee62eb8b448/image.png)
- Veiw console 창을 눌러준다.

![](https://images.velog.io/images/withcolinsong/post/48c529e5-832a-4709-8b8e-5e866187e7b6/image.png)
- Product에 있는 IP Address, Password 입력.
```text
vultr login: Username
Password : Password (눈 표시 모양을 눌러주면 비밀번호가 보인다.) 
```
![](https://images.velog.io/images/withcolinsong/post/a9056dfa-ed5c-46a0-81e4-5f435465339c/image.png)
- 비밀번호의 커서는 보이지 않는다.

## 1.1. 새로운 계정 만들기
- admin 계정에 직접 무언가를 하는 것보단 서브 계정을 만드는 것이 안전하므로,
서브 계정을 만든다.

```text
adduser 유저이름
```
password : 비밀번호 입력 
(비밀번호 입력 시 커서가 보이지 않는다.)


## 1.2 계정 권한 부여

```text
sudo vim /etc/sudoers
```
![](https://images.velog.io/images/withcolinsong/post/9e48de97-10b0-419c-a7a8-379b32d2dbd8/image.png)
- 위에 명령어를 치면, 위에 창이 뜰텐데, admin이라고 써져있는 건 각자 vultr에서 주어진 계정명으로 나올 것이다.
- 그 아래에 바로 2번에서 만들었던 계정명을 입력하고 :wq로 저장한다.
- i을 누르면 --INSERT-- 모드가  되면서 입력이 가능하다.
```text
유저이름  ALL=(ALL:ALL) ALL

:wq! //저장
```

# 2. 도메인

홈페이지 : [https://my.gabia.com/](https://my.gabia.com/)
![](https://images.velog.io/images/withcolinsong/post/0cbedd0d-ae53-4354-9f4a-06d87ca7293c/image.png)

![](https://images.velog.io/images/withcolinsong/post/916e3686-c28f-4e04-a970-588029bf92b2/image.png)

![](https://images.velog.io/images/withcolinsong/post/c04e9df7-0925-43f6-be89-db82b5be4b90/image.png)

![](https://images.velog.io/images/withcolinsong/post/18762894-b537-48e1-9638-2e9c81fc2eae/image.png)

![](https://images.velog.io/images/withcolinsong/post/52373746-a1e6-473a-b366-2b7fc02f5738/image.png)

1. 레코드 추가
2. 위 처럼 추가
	- 값/위치에는 Vultr IP Address를 입력
3. 저장

# 3. MobaXtrem

다운로드 : [https://mobaxterm.mobatek.net/](https://mobaxterm.mobatek.net/)
![](https://images.velog.io/images/withcolinsong/post/f0e8560e-7bd4-4b18-aea5-5e0b37ca2332/image.png)

![](https://images.velog.io/images/withcolinsong/post/13d79b99-cc7a-423b-86eb-a68716e7e1f3/image.png)

```txt
Remote host * : vultr에서 받은 IP Address
Specify username : 2번에서 만든 계정이름
```
- 입력 후 OK.
- 접속하면 비밀번호를 입력하라고 한다. 그 때 2번에서 만든 계정 비밀번호를 입력하면 된다.
(비밀번호 커서 표시 안됨)

## 3.1. 웹 서버

1. 패키지 인덱스 인덱스 정보를 업데이트
```
sudo apt-get install -y nginx
```

2. openJDK 설치 
```
sudo apt-get install -y openjdk-8-jdk
```

3. Java 버전 확인
```
java -version
```
![](https://images.velog.io/images/withcolinsong/post/5f1fbaf6-50f1-4d05-a08a-a5638be660db/image.png)

## 3.2. 웹 서버 폴더 만들기
```
mkdir 폴더명 


mkdir app // app로 만들었다.
cd app // app 경로로 이동
.jar 파일을 app위치에 드래그 앤 드랍으로 넣어준다.
```

- 파일명 변경 명령어
```
mv 현재파일명 바꿀파일명
```



## 3.3. http → https 인증서 설치

홈페이지 : [https://certbot.eff.org](https://certbot.eff.org/lets-encrypt/ubuntufocal-nginx)


```text
1. sudo snap install core
2. sudo snap install --classic certbot
3. 받을 이메일 설정  
4. (A)gree/(C)ancel: -> A 
5. (Y)es/(N)o: -> Y
6. 도메인 입력
```

## 3.4. 앱 실행
```txt
java -jar 파일명.jar
```
- 아까 .jar 파일이 있는 디렉토리로 가서 해당 .jar 실행
![](https://images.velog.io/images/withcolinsong/post/c8051494-2703-4426-b92f-2ba64a477787/image.png)

## References
- 🎈2020.11.24
- 🎈정리 : song

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)