# [목차](#목차)

- [목차](#목차)
- [1. Client / Server](#1-client--server)
- [2. 요청과 응답하기](#2-요청과-응답하기)
  - [References](#references)


```
처음에는 HTTP의 기본 개념이 없어서 코드를 해석하고 다시 작성해보는 과정이 어려웠는데, 
HTTP의 기본 개념을 정리하고, Java의 IO을 공부하니 코드를 이해하기 시작했다.
차근차근 하나씩 공부하고 코드를 왜 이렇게 사용했는지 생각하다 보면 시간이 지나면 자연스럽게
이해가 되는 게 너무 신기했다!👍 엄청 뿌듯하고 행복하다!!!
```

# 1. Client / Server

![](https://images.velog.io/images/withcolinsong/post/57b781a8-269c-48d7-9c44-06051de20114/image.png)

![](https://images.velog.io/images/withcolinsong/post/cd8982eb-13c7-4f51-acd4-c659ec7a48fa/image.png)


# 2. 요청과 응답하기

아래 코드는 웹 브라우저와 통신하기 위한 코드이다.

- try-with-resources



```java
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HTTP {

    public static int PORT = 12345;

    public static void main(String[] args) {
        final String html = 
       		"<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Hello HTTP Server!</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>HEADER</h1>\n" +
                "        <p>Contents</p>\n" +
                "    </body>\n" +
                "</html>";

        try (
                // 클라이언트 접속 대기 -> 클라이언트 접속
                ServerSocket serverSocket = new ServerSocket(PORT);
                Socket socket = serverSocket.accept();

                // 클라이언트가 입력 스트림 얻기
                InputStream in = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

        ) {

            String line;
            while (!(line = br.readLine()).equals("")) {
                // 클라이언트의 요청의 내용이 없을 때 까지 line을 읽을거야.
                // null이 안되는 이유 : 개행이 있기 때문이다.
                System.out.println(line);
            }

            // 서버가 출력 스트림 얻기
            OutputStream out = socket.getOutputStream();

            // -- 응답 헤더 --
            
            //시작라인
            final String startLine = "HTTP/1.1 200 OK \r\n";
            out.write(convertStringToBytes(startLine));

            // Content-Type
            final String contentType = "Content-Type : text/html; charset=UTF-8;";
            out.write(convertStringToBytes(contentType+"\r\n"));
            // Content-Length
            final String contentLength = "Content-Length :" + html.length();
            out.write(convertStringToBytes(contentLength+"\r\n"));

            // 개행
            out.write(convertStringToBytes("\r\n"));

            // 바디
            out.write(convertStringToBytes(html));
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static byte[] convertStringToBytes(String st) {
        return st.getBytes(StandardCharsets.UTF_8);
    }
}
```

## References
- 🎈2020.11.26
- 🎈정리 : song, ipad

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)