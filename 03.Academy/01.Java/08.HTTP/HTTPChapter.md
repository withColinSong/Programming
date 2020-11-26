# [목차](#목차)
- [목차](#목차)
  - [1. 소켓실습](#1-소켓실습)
  - [2. 요청 받기 실습](#2-요청-받기-실습)
  - [3. 응답 하기 실습](#3-응답-하기-실습)

## 1. 소켓실습

1. 소켓 실습 - 서버 소켓 생성 후 브라우저의 접속 대기
   1. 브라우저로 접속 해보기

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {

    private static final int PORT = 8081;


    public static void main(String[] args) {
        try {
            // 1번 소켓 실습
            Socket socket;
            final ServerSocket serverSocket = new ServerSocket(PORT);
            while(( socket = serverSocket.accept()) != null) {
                System.out.println("클라이언트 접속");
            }
            // 2번 요청 받기 실습

            // 3. 응답 하기 실습
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 2. 요청 받기 실습

2. 요청 받기 실습 - 브라우저가 요청 시 전송한 HTTP 메세지 모두 출력
   1. 요청 라인
   2. 요청 헤더

```java
    // 2번 요청 받기 실습
    String line;
    while (!"".equals((line = br.readLine()))) { //
        System.out.println(line);
    }
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {

    private static final int PORT = 8081;


    public static void main(String[] args) {
        try {
            Socket socket;
            final ServerSocket serverSocket = new ServerSocket(PORT);
            while(( socket = serverSocket.accept()) != null) {
                System.out.println("클라이언트 접속");
                final InputStream in = socket.getInputStream();
                final InputStreamReader isr = new InputStreamReader(in);
                final BufferedReader br = new BufferedReader(isr);

                // 2번 요청 받기 실습
                
                // br.readLine() 요청 라인, 요청 헤더, 문자열 "" (빈문자열) 만날 때 까지 읽기
                String line;
                while (!"".equals((line = br.readLine()))) { //
                    System.out.println(line);
                }
            }
                // 3번 html 응답 하기 실습
                


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 3. 응답 하기 실습

3. 응답 하기 실습 (Content-Length, Content-Type 유의)
   1. html 문자열 응답하기
   2.  파일(이미지, 텍스트) 읽어서 응답
       1.  html, css(text/html; text/css;)
       2.  이미지(image/png; image/jpeg)

```java
        final String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Hello HTTP Server!</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>제목이고</h1>\n" +
                "        <p>내용이야</p>\n" +
                "    </body>\n" +
                "</html>";

            // 3번 html
            final OutputStream out = socket.getOutputStream();

            // 3.1. 상태 라인
            final String statusLine = "HTTP/1.1 200 OK \r\n";
            out.write(convertStringToBytes(statusLine));

            // 3.2. 헤더

            final String contentType = "Content-Type : text/html; charset=UTF-8;";
            // Content-Type: text/html; charset=UTF-8;
            out.write(convertStringToBytes(contentType+"\r\n"));
            // Content-Length: 160
            final String contentLength = "Content-Length: " + html.length();
            out.write(convertStringToBytes(contentLength+"\r\n"));
            // 헤더 끝을 명시해주기 위해 CRLF를 넣음.
            out.write(convertStringToBytes("\r\n"));

            // 3.3. 바디
            out.write(convertStringToBytes(html));
            out.flush();

    private static byte[] convertStringToBytes(String st) {
        return st.getBytes(StandardCharsets.UTF_8);
    }        

```

```java


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Application {

    private static final int PORT = 8081;
    public static void main(String[] args) {
        final String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Hello HTTP Server!</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>제목이고</h1>\n" +
                "        <p>내용이야</p>\n" +
                "    </body>\n" +
                "</html>";

        try {
            // 1번
            Socket socket;
            final ServerSocket serverSocket = new ServerSocket(PORT);
            while ((socket = serverSocket.accept()) != null) {
                System.out.println("클라이언트 접속");
                final InputStream in = socket.getInputStream();
                final InputStreamReader isr = new InputStreamReader(in);
                final BufferedReader br = new BufferedReader(isr);

                // 2번
                // br.readLien() 요청 라인, 요청 헤더, 문자열 "" (빈문자열) 만날 때 까지 읽기
                String line;
                while (!"".equals((line = br.readLine()))) { //
                    System.out.println(line);
                }
            }
            // 3번 html
            final OutputStream out = socket.getOutputStream();

            // 3.1. 상태 라인
            final String statusLine = "HTTP/1.1 200 OK \r\n";
            out.write(convertStringToBytes(statusLine));

            // 3.2. 헤더

            final String contentType = "Content-Type : text/html; charset=UTF-8;";
            // Content-Type: text/html; charset=UTF-8;
            out.write(convertStringToBytes(contentType+"\r\n"));
            // Content-Length: 160
            final String contentLength = "Content-Length: " + html.length();
            out.write(convertStringToBytes(contentLength+"\r\n"));
            // 헤더 끝을 명시해주기 위해 CRLF를 넣음.
            out.write(convertStringToBytes("\r\n"));

            // 3.3. 바디
            out.write(convertStringToBytes(html));
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] convertStringToBytes(String st) {
        return st.getBytes(StandardCharsets.UTF_8);
    }
}

```
