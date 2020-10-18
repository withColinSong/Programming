package Ex0928_yj;

import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {
		 // 최대값 찾기
     
		Scanner scanner = new Scanner(System.in);
		int [] IntArray = new int [6];
		int [] IntArray2 = new int [6];
		
		int i=0;
		int max = 0;
		int a = 0;
		
		System.out.println("양수를 5개를 입력하세요. ");
		
		for(i=0; i<5; i++) {
			a = scanner.nextInt();
			IntArray[i] = a;
			if(max < a) {
				max = a;
			}
		}
		
		System.out.println("가장 큰 수는 " + max + " 입니다.");
		
	}

}
