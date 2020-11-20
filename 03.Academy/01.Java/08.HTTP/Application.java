import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Application {
    private static final int PORT = 8081;
    public static void main(String[] args) {
        try {
            final ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket;

            //while -> 한 번 실행하고 끝내지 않기 위해서 while
            while((socket = serverSocket.accept()) != null) {
                final InputStream in = socket.getInputStream();
                final BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while (!(line = br.readLine()).equals("")) {
                    System.out.println(line);
                }
            }
            // 2. 응답생성
            // 2.1. 상태라인 생성
            final String statusLine = "HTTP/1.1 200 OK \r\n"; // \r\n -> CRLF
            //2.2. 메세지 헤더
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "text/html; charset=UTF-8");
            final String content = getMessageBody();
            final int contentLength = content.length();
            headers.put("Content-Length", String.valueOf(contentLength));
            //2.3. 메세지 바디
            final OutputStream out = socket.getOutputStream();
            out.write(statusLine.getBytes(StandardCharsets.UTF_8));
            for (Map.Entry<String, String> e : headers.entrySet()) {
                final String header = String.format("%s: %s \r\n", e.getKey(), e.getValue());
                out.write(header.getBytes(StandardCharsets.UTF_8));
            }

            //3.응답바디
            out.write("\r\n".getBytes(StandardCharsets.UTF_8));
            final String body = getMessageBody();
            out.write(body.getBytes(StandardCharsets.UTF_8));
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getMessageBody() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Hello HTTP Server!</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>제목이고</h1>\n" +
                "        <p>내용이야</p>\n" +
                "    </body>\n" +
                "</html>";
    }
}