package IO.p2ptpchat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 클라이언트
 */
public class Client {

    private static final String IP = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            final Socket socket = new Socket(IP, PORT);
            // 외부에서 수신 받은 데이터를 화면에 출력하는 스레드
            final ListenerThread listener = new ListenerThread(socket.getInputStream());
            listener.start();

            while (true) {
                writeMessage(socket.getOutputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeMessage(OutputStream outputStream) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("입력 > ");
        final String messageToSend = scanner.next();
        final byte[] raw = messageToSend.getBytes(StandardCharsets.UTF_8);
        outputStream.write(raw);
    }
}

