# [목차](#목차)
- [목차](#목차)
- [1. 네트워크](#1-네트워크)
- [4.1. Socket](#41-socket)

# 1. 네트워크

client - server
서버 : ServerSocket
클라이언트 : Socket

- ip : 네트워크 상에서 컴퓨터를 식별하기 위한 주소
- port : 컴퓨터에서 프로그램을 구분하기 위한 번호

# 4.1. Socket

서버 소켓 생성 방법
```java

int portNumber = 12345;
final ServerSocket serverSocket = new ServerSocket(포트번호);
```

서버 소켓으로 클라이언트 접속 대기

```java
final Socket client = serverSocket.accept(); 
```

accept는 blocking 상태
- 접속이 되고 나면 `socket` 반환


클라이언트 소켓
```java
new Socket("아이피주소", 포트번호)
```

```java
Final String ip = "localhost";
Final int port = "12345";
Final Socket socket = new Socket(ip, port)
```

소켓(Server, Client 동일)에서 스트림 얻기

```java
socket.getInputStream(); // 입력 스트림
socket.getOutputStream(); // 출력 스트림
```