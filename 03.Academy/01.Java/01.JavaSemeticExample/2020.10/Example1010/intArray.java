package Day1010;

import java.util.Scanner;

public class Review01 {

	public static void main(String[] args) {
		//문제1. 양의 정수 10개를 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력해보자.
		
		Scanner scan = new Scanner(System.in);
		
		int[] intArray = new int[10];
		
		
		System.out.println("정수를 입력해주세요. ");
		
		for(int i=0; i<intArray.length; i++) {
			intArray[i] = scan.nextInt();
		}
		
		int i=0;
		
		for(i=0; i<intArray.length; i++) {
			if(intArray[i] % 3 == 0) {
				System.out.println(intArray[i]);
			}
		}
	}
}
