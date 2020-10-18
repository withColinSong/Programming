package Practice0927;

import java.util.Scanner;

public class arr11 {

	public static void main(String[] args) {

		//구구단 출력

		Scanner scan = new Scanner(System.in);
		System.out.print("구구단 중에서 출력하고 싶은 단을 입력하시오 : ");
		int multiply = scan.nextInt();


		int i=0;
		int j=0;

		
		for(i=multiply; i<=9; i++) {
			for(j=1; j<=9; j++) {
				System.out.println(i +" * " +  j + " = " + (i*j));			
			}
		}
	}

}
