

import java.util.*;

public class PracticeArr02 {

//평균 구하기
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		int[] IntArray = new int[5];
		
		System.out.println("5개의 정수를 입력하세요 >> ");
		
		int i=0;
		int sum = 0;
		int count = 0;
		
		for(i=0; i<IntArray.length; i++) {
			IntArray[i] = scanner.nextInt();
			 sum = sum + IntArray[i];
			
		}
		
		for(i=0; i<IntArray.length; i++) {
			count++;
			
		}
		
		System.out.println("평균은 " + sum / (double)count);
	}

}
