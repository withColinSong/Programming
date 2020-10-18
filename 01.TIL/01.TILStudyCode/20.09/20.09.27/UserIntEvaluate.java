package Practice0927;

import java.util.Scanner;

public class arr10 {

	public static void main(String[] args) {
		// 사용자로부터 받은 2개의 정수 구하기
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력하시오 : ");
		int numberA = scan.nextInt();
		
		System.out.print("첫번째 숫자를 입력하시오 : ");
		int numberB = scan.nextInt();
		
		
		System.out.println("합계 : " + (numberA + numberB));
		
		//배열로 응용학습
    
		int[] numberA01 = new int [2];

		int n = 1;
		int sum = 0;
		int i=0;
		
		for(i=0; i<2; i++) {
			System.out.println(i+1 + "번 숫자를 입력하시오.");
			int a = scan.nextInt();
			numberA01[i] = a;
			sum = sum + a;
		}
		System.out.println("합계 : " + (sum));
		
		for(i=1; i<3; i++) {
			System.out.println("i값 " + numberA01[i-n]);
		}
	}

}
