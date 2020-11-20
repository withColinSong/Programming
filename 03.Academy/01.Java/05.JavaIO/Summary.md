#[목차](#목차)
- [1. 요약](#1-요약)
  - [1.1 블로킹](#11-블로킹)
  - [1.2. 스레드](#12-스레드)
  - [1.3. IO](#13-io)
  - [1.4. 소켓(자바 소켓)](#14-소켓자바-소켓)
    - [1.4.1. ServerSocket](#141-serversocket)
    - [1.4.2. 클라이언트 - Socket](#142-클라이언트---socket)

# 1. 요약

- 블로킹
- 스레드
- IO
- 소켓

## 1.1 블로킹

- 키 입력대기, 데이터 수신 대기 등 IO와 관련해서 코드가 특정라인(해당 연산 메서드 호출 부분)에 멈춤

## 1.2. 스레드

- 한 프로그램 내에서 실행 흐름이 두 개 이상이 될 수 있다.
- 블로킹이나 연산 코스트가 높은 작업을 별도로 분리할 수 있다.
  - `serverSocket.accept()`

## 1.3. IO

InputStream/ OutputStream

- InputStream : 우리가 작성하는 프로그램이 도착지(키보드, 외부 컴퓨터..)
- OutputStream : 우리가 작성하는 프로그램이 출발지(화면에 출력, 외부 컴퓨터로 전송 등)
  

## 1.4. 소켓(자바 소켓)

- ServerSocket(서버)
- Socket(클라이언트)

### 1.4.1. ServerSocket

```java
int port = 12345;
// 해당 포트 번호로 서버 시작!
final Serversocket serverSocket = new ServerSocket(port);
// 클라이언트의 접속을 대기
// 접속되면 클라이언트와 서버간의 스트림을 가지고 있는 소켓 생성
final Socket client = serverSocket.accept();
```

### 1.4.2. 클라이언트 - Socket

```java
final String ip = "127.0.0.1";
final int port = 12345;

```java
final String ip = "127.0.0.1";
final int port = 12345;
// 해당 ip와 해당 port로 접속
final Socket socket = new Socket(ip, port);
```