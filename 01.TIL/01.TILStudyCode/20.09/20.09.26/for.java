package Practice0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pratice01_01 {

	public static void main(String[] args) throws IOException {
		// 문자와 숫자를 입력받아 문자를 입력받은 숫자만큼 반복 출력하시오.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			
			System.out.print("\n문자를 입력 : ");
			String str = br.readLine();
			
			System.out.print("숫자를 입력 : ");
			String str01 = br.readLine();
			int int01 = Integer.parseInt(str01);
			
			System.out.print("실행결과 : ");

			for(int i=0; i<int01; i++) {
				System.out.print(str);
			}
			
			System.out.println("\n");
		}
	}
}
