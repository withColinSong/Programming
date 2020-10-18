package Ex0928_yj;

import java.util.Scanner;

public class ex02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		 // 탐색할 값 찾기.
     
		int [] IntArray = new int [6];
		int [] IntArray2 = new int [6];
		
		int i = 0;
		int sum = 0;
		int n = 1;
		int value = 0;
		

		System.out.println("탐색할 값을 입력하시오. ");
		value = scan.nextInt();
		
		for(i=1; i<IntArray.length; i++) {
			IntArray[i] = 10;
			
		}
		

		for(i=0; i<IntArray.length; i++) {
			sum = sum + IntArray[i];
			if(value == sum) {
				IntArray2[i] = i;
			}

		}
		
		System.out.println(value + " 값은 " +  IntArray2[i-n] +  "번째에 있습니다. ");


	}

}
