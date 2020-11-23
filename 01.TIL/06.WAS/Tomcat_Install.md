# [목차](#목차)
- [목차](#목차)
- [1. Tomcat 설치](#1-tomcat-설치)
  - [sql Develop을 설치되어 있을 시 참고사항](#sql-develop을-설치되어-있을-시-참고사항)
  - [1.1 Tomcat port 넘버 바꾸기](#11-tomcat-port-넘버-바꾸기)
    - [1.1.1 cmd창](#111-cmd창)
    - [1.1.2. server.xml](#112-serverxml)
    - [1.1.3. tomcat-users.xml](#113-tomcat-usersxml)
    - [1.1.4 cmd창](#114-cmd창)
  - [References](#references)

# 1. Tomcat 설치
- [https://tomcat.apache.org/](https://tomcat.apache.org/)

![](https://images.velog.io/images/withcolinsong/post/093e856c-30af-4782-a5aa-d17833444321/image.png)



- Tomcat 9.0 

![](https://images.velog.io/images/withcolinsong/post/d6697ddd-7ecb-4693-bbe3-31fc485e8a9a/image.png)

1. 압축을 풀어서 원하는 경로에 넣는다. (c:C:\Users\user 경로가 제일 무난하다.)
2. 톰켓은 여러버전이 올 수 있으니 tomcat 디렉토리를 하나 만들고 그 경로에 압축을 풀어준다.

![](https://images.velog.io/images/withcolinsong/post/d38f4913-5826-4eb6-96de-ce550115eae0/image.png)

## sql Develop을 설치되어 있을 시 참고사항
- ** 혹시나 sql Develop을 사용하고 있다면 해당 오라클이 포트 8080을 쓰고 있으니, 
Tomcat은 다른 포트로 설정해줘야 한다.** 
  
  
## 1.1 Tomcat port 넘버 바꾸기

- 톰캣 기본 포트 : 8080 -> 9090으로 바꿀 계획
- VSCode를 이용하여 수정.
### 1.1.1 cmd창
```txt
C:\Users\user\tomcat\apache-tomcat-9.0.40>code . << VScode 
```

### 1.1.2. server.xml
![](https://images.velog.io/images/withcolinsong/post/4b722a49-8c32-446f-b8b0-fd2754ea5ac3/image.png)
![](https://images.velog.io/images/withcolinsong/post/1ef00c17-4b66-45f7-b22e-e315284b3516/image.png)

### 1.1.3. tomcat-users.xml
![](https://images.velog.io/images/withcolinsong/post/978c6878-539b-4431-9681-9f09b48b7556/image.png)
- tomcat-users.xml 클릭 해 파일을 열어 스크롤을 맨 아래로 내리면 주석으로 처리 된 코드가 있다.
```xml
<!--
  <role rolename="tomcat"/>
  <role rolename="role1"/>
  <user username="tomcat" password="<must-be-changed>" roles="tomcat"/>
  <user username="both" password="<must-be-changed>" roles="tomcat,role1"/>
  <user username="role1" password="<must-be-changed>" roles="role1"/>
-->
```
- 주석을 풀어주고, role을 부여해준다.
```xml
<role rolename="tomcat"/>
<role rolename="role1"/>
<role rolename="manager"/>
<role rolename="admin"/>
<role rolename="manager-gui"/>
<role rolename="admin-gui"/>
<user roles="tomcat" password="tomcat" username="tomcat"/>
<user roles="tomcat,role1" password="tomcat" username="both"/>
<user roles="role1" password="tomcat" username="role1"/>
<user roles="admin,manager,admin-gui,manager-gui" password="admin" username="admin"/>
<user roles="admin,manager,admin-gui,manager-gui" password="tomcat" username="tomcat"/>
```

** Ctrl+S로 파일 저장을 눌러준다. **

### 1.1.4 cmd창
```txt
C:\Users\user>cd tomcat\apache-tomcat-9.0.40\bin>startup.bat
```

## References
- 🎈2020.11.23
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
