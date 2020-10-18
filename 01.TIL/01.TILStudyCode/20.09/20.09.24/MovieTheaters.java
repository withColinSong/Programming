package Ex_0924;

import java.util.Scanner;

public class LAB_Practice {

	public static void main(String[] args) {
		// 

		Scanner scan = new Scanner(System.in);

		int [] arr = new int [10];
		int [] arr01 = new int [10];
		// 현재 array 0 0 0 0 0


		// length 는 배열의 길이. length 속성은 배열의 최대 인덱스보다 항상 크다.
		for(;; ) {
			System.out.println("--------------------");
			for(int i = 0; i < arr.length; i++) {
				arr[i] = i + 1; 

				System.out.print(arr[i] + " ");
			}						
			System.out.println("\n--------------------");

			for(int i = 0; i < arr01.length; i++) {
				System.out.print(arr01[i] + " ");

			}

			System.out.println("\n원하시는 좌석번호를 입력하세요. (종료는 -1) : ");
			int chair = scan.nextInt();

			if( chair == -1  ) {
				System.out.println("종료 합니다.");
				break;	
			}

			if( arr01[chair - 1] == 0) {
				arr01[chair-1] = 1;
				System.out.println("예약되었습니다.");
			} else {
				System.out.println("이미 예약된 자리입니다.");
			}


		}
	}

}

# 코드를 보지 않고 스스로 복습했다.
