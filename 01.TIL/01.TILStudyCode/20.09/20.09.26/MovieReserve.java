package Practice0926;

import java.util.Scanner;

문제점 : 배열의 인덱스 활용이 어려웠다.
해결점 : 복습으로 이해하고 방법을 터득하기.


public class MovieReserve {

	public static void main(String[] args) {
		//  극장 예약 시스템 연습

		Scanner scan = new Scanner(System.in);
		int[] reserve = new int [10];
    int [] seat = new int [10];

		for(;;) {
			System.out.println("---------------------");


			for(int i=0; i<10; i++) {
				reserve[i] = i + 1;
				System.out.print(reserve[i] + " ");
			}
			System.out.println("\n---------------------");

			for(int i=0; i<10; i++) {
				System.out.print(seat[i] + " ");
			}

			System.out.print("원하시는 좌석번호를 입력하세요. (종료는 -1) : ");
			int number = scan.nextInt();

			if(number == -1) {
				System.out.println("예약이 종료됩니다.");
				break;
			}

			if(seat[number-1] == 0) {
				seat[number-1] = 1;
				System.out.println("예약 되었습니다.");
			} else {
				System.out.println("이미 예약된 자리입니다.");
			}

		}
	}

}
