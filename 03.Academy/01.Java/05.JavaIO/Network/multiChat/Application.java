import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket client;
            System.out.println("접속 확인 중");
            while((client = serverSocket.accept()) != null) {
                System.out.println("새로운 클라이언트 접속");
                ClientManager.registerClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}