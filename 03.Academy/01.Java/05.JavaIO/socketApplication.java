
import java.io.*;
import java.net.*;


public class socketApplication2 {

	public static void main(String[] args) {
		try (final ServerSocket serverSocket = new ServerSocket(1905)) {
			final Socket socket = serverSocket.accept(); //
			final InputStream in = socket.getInputStream(); //from client
			final OutputStream out = socket.getOutputStream(); //to client

			//input
			BufferedReader br = new BufferedReader(new InputStreamReader(in)); 
			String readLine;
			while(!(readLine = br.readLine()).equals("")) {
				System.out.println(readLine);
			}

			//output
			final String body = "message";
			final byte[] raw = body.getBytes();
			final DataOutputStream dos = new DataOutputStream(out);

			//헤더 쓰는 부분
			dos.writeBytes("HTTP/1.1 200 OK \r\n");
			dos.writeBytes("Content-type: text/html;charset=utf-8\r\n");
			dos.writeBytes("Content-Length: " + raw.length + "\r\n");
			dos.writeBytes("\r\n");

			//바디 쓰는 부분
			dos.write(raw, 0, raw.length);
			dos.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
