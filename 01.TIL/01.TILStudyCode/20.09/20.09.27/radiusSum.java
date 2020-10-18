package Practice0927;

import java.util.Scanner;

public class arr07 {

	public static void main(String[] args) {
		// 반지름을 입력하시오.
		
		Scanner scan = new Scanner(System.in);
		final double PI = 3.14;
		
		System.out.print("반지름을 입력하시오: ");
		int a = scan.nextInt();
		
		System.out.println(a * a * PI);
		
	}

}
