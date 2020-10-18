package Practice0927;

import java.util.Scanner;

public class arr04 {

	public static void main(String[] args) {
		// 키보드에서 입력 받은 정수가 홀수인지 짝수인지 말해주는 프로그램 작성하기.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하시오 : ");
		int EvenNumber = scan.nextInt();
		if(EvenNumber % 2 == 0) {
			System.out.println("입력된 정수는 짝수입니다.");
		}
		
		System.out.println("프로그램이 종료되었습니다.");
		

	}

}
