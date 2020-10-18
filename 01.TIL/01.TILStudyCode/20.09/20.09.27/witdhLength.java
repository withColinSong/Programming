package Practice0927;

import java.util.Scanner;

public class arr05 {

	public static void main(String[] args) {
		// 직사각형의 둘레와 면적 계산하기
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("사각형의 가로를 입력하시오. ");
		int width = scan.nextInt();
		
		System.out.print("사각형의 세로를 입력하시오. ");
		int length = scan.nextInt();
		
		System.out.print("사각형의 넓이는 : " + (double)width * length);
		System.out.print("\n사각형의 둘레는 : " + (double)(width + length)*2);

	}

}
