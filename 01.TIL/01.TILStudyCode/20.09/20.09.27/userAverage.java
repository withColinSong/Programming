package Practice0927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class arr01 {

	public static void main(String[] args) throws IOException {
		// 사용자로부터 5명의 성적을 입력 받아서 평균을 구하는 배열을 이용하여 작성하기.
		int [] IntArray = new int[5];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int score = 0;
		int count = 0;
		int a = 0;
		
		for(int i=0; i<IntArray.length; i++) {
			System.out.print("성적을 입력하시오. : ");
			String str = br.readLine();
			a = Integer.parseInt(str);
			IntArray[i] = a; 
			score = score + a;
			count++;
		}
		
		System.out.println(score / count);
	}

}
