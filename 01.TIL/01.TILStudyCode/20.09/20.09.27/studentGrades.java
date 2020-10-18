package Practice0927;

import java.util.Scanner;

public class arr09 {

	public static void main(String[] args) {
		// 성적 입력하기
		//		성적이 90점 이상이면 A학점
		//		 90점 미만 80점 이상이면 B학점
		//		 70점 이상이고 80점 미만이면 C학점.
		
		Scanner scan = new Scanner(System.in);
		System.out.print("성적을 입력하시오 : ");
		int a = scan.nextInt();
		
		if(a >= 90) {
			System.out.println("A학점");
		}else if(a < 90 && a >= 80) {
			System.out.println("B학점");
		}else {
			System.out.println("C학점");
		}

	}

}
