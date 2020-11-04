import java.util.Scanner;

public class ThreadApplication {

	public static void main(String[] args) {
  
		//메인 쓰레드가 터져도 beepThread는 계속돈다.
		final BeepThread thread = new BeepThread();
		thread.start();
		
		
		//메인 쓰레드
		final Scanner scanner = new Scanner(System.in);
		while(true) {
    System.out.printin("입력해주세요. ");
			scanner.nextInt(); 
		}
		  
	}
}

// nextInt()에 문자열을 넣으면 프로그램이 에러가 나고 종료되는데, BeepThread는 계속 실행되고 있다.
