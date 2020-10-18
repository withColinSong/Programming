3시간 만에 풀었다!!!!!!!!!!!!!!!!!!!

package Practice0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Practice01_06 {

	public static void main(String[] args) throws IOException {
		// up & down 게임

		Scanner scan = new Scanner(System.in);

		int i = 59;
		int count = 0;

		while(true){
			
			System.out.print("정답을 추측하여 보시오. : ");
			int a = scan.nextInt();
			int b = a;
			
			
			if(b < i) {
				count++;
				System.out.println("제시한 정수가 낮습니다.");
				
			} else if ( b > i){
				count++;
				System.out.println("제시한 정수가 높습니다.");
				
			} else {
				count++;
				System.out.println("축하합니다. 시도횟수 " + count + "회");
				break;
			}

		}

	}
}
