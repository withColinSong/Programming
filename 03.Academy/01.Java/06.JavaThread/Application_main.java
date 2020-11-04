public class Application {


	//thread
	//runnable
	public static void main(String[] args) {
		final BeepThread thread1 = new BeepThread();
		final BeepThread thread2 = new BeepThread();
		thread1.start();
		thread2.start();
		
		final Scanner scanner = new Scanner(System.in);
		while(true) {
			final int valueFromKeyboard = scanner.nextInt();
			System.out.println("main : " + valueFromKeyboard);
		}
	}

}
//
//# 웹서버 스레드(싱글)
//main---> 접속대기 --> 접속(socket) --> 응답해줌 --> 접속대기
