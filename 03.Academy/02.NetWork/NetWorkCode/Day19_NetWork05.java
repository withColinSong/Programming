  package Day19;
  //20.10.19
  import java.io.*;
  import java.net.*;

  public class TCPEchoServer {
    public void tcpSerever (int port) {
      //서버 소켓 관련 객체
      ServerSocket serverSock = null;
      Socket sock = null;
      InetAddress inetAddr = null;

      //입출력 객체
      InputStream in = null;
      OutputStream out = null;
      BufferedReader br = null;
      PrintWriter wr = null;

      try {
        serverSock = new ServerSocket(port); //서버 소켓 생성
        while(true) {

          //클라이언트의 접속 대기
          System.out.println("===== 클라이언트 접속 대기중" + "(port: " + serverSock.getLocalPort() + ")=====");
          sock = serverSock.accept();

          //클라이언트의 접속 요청
          inetAddr = serverSock.getInetAddress();
          System.out.println("클라이언트 (" + inetAddr.getHostAddress() + ") 접속");

          //클라이언트의 Stream 요청
          in = sock.getInputStream();
          out = sock.getOutputStream();
          br = new BufferedReader(new InputStreamReader(in));
          wr = new PrintWriter(new OutputStreamWriter(out));
          String msg = null;

          //클라이언트와 통신
          while((msg = br.readLine()) != null) {
            System.out.println("\tCLIENT> " + msg);
            wr.print(msg);
            wr.flush();
          }
        }
      } catch (IOException ie) {
        // TODO Auto-generated catch block
        System.out.println(ie);
      }finally {
        try {
          br.close();
          wr.close();
          in.close();
          out.close();
          sock.close();
          serverSock.close();
          System.out.println("종료.");
        }catch (IOException ie) {
          System.out.println(ie);
        }
      }
    }
  }
