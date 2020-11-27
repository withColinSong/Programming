# [목차](#목차)

- [목차](#목차)
- [2. HTTP](#2-http)
  - [2.1. HTTP Message](#21-http-message)
    - [2.1.1. 시작 라인(start line)](#211-시작-라인start-line)
    - [2.1.2. 메시지 헤더(message header)](#212-메시지-헤더message-header)
    - [2.1.3. 메시지 바디(message body)](#213-메시지-바디message-body)
  - [2.2. 요청(Request)](#22-요청request)
    - [2.2.1. 요청 라인(Request Line)](#221-요청-라인request-line)
    - [2.2.2. 메세지 헤더](#222-메세지-헤더)
    - [2.2.3. 메세지 바디](#223-메세지-바디)
  - [2.3. 응답](#23-응답)
    - [2.3.1. 상태 라인](#231-상태-라인)
  - [2.4. HTTP/1.1 프로토콜 특징](#24-http11-프로토콜-특징)
  - [3.1. 브라우저가 요청한 부분](#31-브라우저가-요청한-부분)
    - [3.1.1. 요청 라인](#311-요청-라인)
    - [3.1.2. 요청 헤더](#312-요청-헤더)
  - [3.2. 서버가 응답한 부분](#32-서버가-응답한-부분)
    - [3.2.1. 상태 라인](#321-상태-라인)
    - [3.2.2. 응답 헤더](#322-응답-헤더)
    - [3.2.3. 메세지 바디](#323-메세지-바디)
  - [3.3 실습](#33-실습)
  - [3.4. 실습](#34-실습)
  - [3.5 실습 - static file Server](#35-실습---static-file-server)

# 2. HTTP

[https://tools.ietf.org/html/rfc2616](https://tools.ietf.org/html/rfc2616)

## 2.1. HTTP Message

HTTP 메시지는:
- 클라이언트가 서버에게 하는 `요청(request)`
- 서버가 클라이언트에게 주는 `응답(response)`
으로 구성이 됨.  

메세지 구조

1. 시작 라인(start-line)
   1. 요청 라인(클라이언트(대표적으로 브라우저))
   2. 상태 라인(서버)
2. 메세지 헤더(message)
3. 메세지 바디: 전송할 데이터

### 2.1.1. 시작 라인(start line)

HTTP 메시지의 시작을 알리는 라인.

* 요청(c -> s)의 경우 `요청 라인(request line)`
* 응답(s -> c)의 경우 `상태 라인(status line)`

### 2.1.2. 메시지 헤더(message header)

필드 이름, 필드 값으로 구분됨. 구분자는 `콜론(:)`으로.  

```text
Cache-Control: 값
```

### 2.1.3. 메시지 바디(message body)

- 필수는 아님. 
- 데이터 전송 시 이 부분에 담아서 보냄.  
- 요청과 응답 모두에서 바디 사용 가능. 
  - 다만 헤더에 바디의 길이를 알려주어야 함.  

## 2.2. 요청(Request)

1. 요청 라인
2. 요청 헤더
3. 메세지 바디

### 2.2.1. 요청 라인(Request Line)

요청 라인은 다음과 같은 구조로 구성됨.  

Method SP Request-URI SP HTTP-Version CRLF

* Method: HTTP Method (https://developer.mozilla.org/ko/docs/Web/HTTP/Methods)
* SP: Separator. 여기서는 공백 사용.  
* Request-URI: URI (Uniform Resourece Identifer) - 리소스
  * `/html/rfc2616#section-4`
  * `/`
* HTTP-Version: HTTP 버전
  * `HTTP/1.1`

### 2.2.2. 메세지 헤더

- HTTP Message 헤더랑 동일
- 요청에 대한 메타 정보

### 2.2.3. 메세지 바디

- 전송할 데이터. 
- 이 데이터 길이를 `Contect-Length` 헤더에 바이트 수 명시 필요.

`Contect-Length` : 메세지 바디와 데이터 길이 바이트 수를 명시 해야함.

`Contect-Type` : 메세지 바디의 데이터 타입(`text/html`, `application/json`)

CRLF로 요청 헤더와 메세지 바디를 구분함.



## 2.3. 응답

1. 상태라인
2. 응답 헤더
3. 메시지 바디

### 2.3.1. 상태 라인

상태 라인의 구조는 다음과 같음


```text
HTTP-Version SP Status-Code SP Reason-Phrasen CRLF
```

* Status-Code: 서버의 처리 결과 상태 값을 표현하는 수
* Reason-Phrase : 상태 값을 표현하는 문자열

[HTTP status code](https://developer.mozilla.org/ko/docs/Web/HTTP/Status)

```text
404 Page Not Found
```

상태 라인 예제

```example
HTTP/1.1 404 Page Not Found
```

## 2.4. HTTP/1.1 프로토콜 특징

- 상태가 없다 (Stateless Protocol)
- 요청-응답 후 접속 종료

## 3.1. 브라우저가 요청한 부분

```text
GET / HTTP/1.1 //요청라인
Host: localhost:8081
Connection: keep-alive
Cache-Control: max-age=0
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
```

### 3.1.1. 요청 라인

GET / HTTP/1.1

HTTP method는 `GET`
URI는 `/`
프로토콜은 `HTTP/1.1`

### 3.1.2. 요청 헤더

Host, Connection 등등..

## 3.2. 서버가 응답한 부분

```text
HTTP/1.1 200 OK 
Content-Type: text/html; charset=UTF-8
Content-Length: 160

<!DOCTYPE html>
<html>
    <head>
        <title>Hello HTTP Server!</title>
    </head>
    <body>
        <h1>제목이고</h1>
        <p>내용이야</p>
    </body>
</html>
```

### 3.2.1. 상태 라인

HTTP/1.1 200 OK

프로토콜은 `HTTP/1.1`
상태 코드는 `200
Reason Phrase `OK`

### 3.2.2. 응답 헤더

```text
HTTP/1.1 200 OK 
Content-Type: text/html; charset=UTF-8
Content-Length: 160
```

`Content-Type`: 내가 body에 담아준 데이터는 text-html이야. 인코딩은 UTF-8

`Content-Length`: 내가 body에 담아준 데이터 길이는 160바이트야.

### 3.2.3. 메세지 바디

```text
<!DOCTYPE html>
<html>
    <head>
        <title>Hello HTTP Server!</title>
    </head>
    <body>
        <h1>제목이고</h1>
        <p>내용이야</p>
    </body>
</html>

```

우리가 보여주고 싶은 HTML 텍스트.

## 3.3 실습
1. 이미지를 응답해준다.
   1. Content-Type: image/png; image/jpeg;
   2. Content-Length: 응답할 리소스의 길이(바이트)

byte정보

```java
public class Application {

    // localhost:8081
    private static final int PORT = 8081;

    public static void main(String[] args) {
        try {
            final ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket;
            while ((socket = serverSocket.accept()) != null) {
                // 1. 요청을 읽어서 화면에 출력
                final InputStream in = socket.getInputStream();
                final BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while (!(line = br.readLine()).equals("")) {
                    System.out.println(line);
                }

                // 2. 응답 생성
                // 2.1. 상태 라인 작성
                final String statusLine = "HTTP/1.1 200 OK \r\n";

                // 2.2. 메세지 헤더
                final Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "image/png; image/jpeg;");
                final File file = new File("C:\\Users\\user1\\Desktop\\think-twice.png");
                final long contentLength = file.length();
                headers.put("Content-Length", String.valueOf(contentLength));

                // 2.3. 메세지 바디
                final OutputStream out = socket.getOutputStream();
                // 1. 상태 라인 쓰기
                out.write(statusLine.getBytes(StandardCharsets.UTF_8));
                // 2. 응답 헤더 쓰기
                for (Map.Entry<String, String> e : headers.entrySet()) {
                    final String header =
                            String.format("%s: %s \r\n", e.getKey(), e.getValue());
                    out.write(header.getBytes(StandardCharsets.UTF_8));
                }
                // 3. 응답 바디
                out.write("\r\n".getBytes(StandardCharsets.UTF_8));

                try(final InputStream fis = new FileInputStream(file)) {
                    int readBytes;
                    final byte[] buf = new byte[4096];
                    while ((readBytes = fis.read(buf)) != -1) {
                        out.write(buf);
                    }
                }

                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

## 3.4. 실습

1. 소켓 실습 - 서버 소켓 생성 후 브라우저의 접속 대기
   1. 브라우저로 접속 해보기
2. 요청 받기 실습 - 브라우저가 요청 시 전송한 HTTP 메세지 모두 출력
   1. 요청 라인
   2. 요청 헤더
3. 응답 하기 실습 (Content-Length, Content-Type 유의)
   1. html 문자열 응답하기
   2.  파일(이미지, 텍스트) 읽어서 응답
       1.  html, css(text/html; text/css;)
       2.  이미지(image/png; image/jpeg)


## 3.5 실습 - static file Server

과제 내용
1. 브라우저에서 `/file이름`으로 요청하면 `file이름`에 해당하는 파일을 응답
2. 루트 디렉터리는 알아서 지정
3. 루트 디렉터리 내의 파일을 클라이언트에게 응답

문제 분석
1. Paths.resolve로 지정된 디렉토리와 사용자가 원하는 파일의 이름을 합쳐서 절대 경로 얻는 메서드
2. 응답해줄 파일에서 mine type(i.e text/html, image/png)을 반환해주는 메서드
   1. URLCOnnection.guessContentTypeFromName(경로)
3. 응답해줄 파일에서 사이즈 반환해주는 메서드
4. 요청라인에서 uri 분리해주는 메서드
 
응답에 필요한 것
- Content-Type : mime type을 알려주어야 함.
- Content-Length: 응답한 파일의 길이(바이트 수)
- 메세지 바디에 넣을 byte 배열

위의 것들을 위해 필요한 것

1. 요청 라인에서 URI 추출
2. 파일 정대 경로 추출
3. 파일로부터 mime type 추출
4. 파일 길이 추출
5. 파일 byte 배열로 변환
   


