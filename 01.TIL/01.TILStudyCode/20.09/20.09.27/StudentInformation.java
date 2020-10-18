package Practice0927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample2 {

	public static void main(String[] args) throws IOException {
		// TODO 학생 신상 정보 입출력프로그램 제작하기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] name = new String[3];
		int[] age = new int[3];
		int[] number = new int[3];


		int i = 0;
		int n = 1;


		for(i=1; i<4; i++) {
			System.out.println("학생의 이름을 입력해주세요. : ");
			name[i-n] = br.readLine();

			System.out.println("학생의 나이를 입력해주세요. : ");
			String a = br.readLine();
			age[i-n] = Integer.parseInt(a);


			System.out.println("학생의 전화번호를 입력해주세요. : ");
			String b = br.readLine();
			number[i-n] = Integer.parseInt(b);
		}

		System.out.println();
		System.out.println("----학생 정보 ----");

		for(i=1; i<4; i++) {
			System.out.println("이름 : " + name[i-n]);
			System.out.println("나이 : " + age[i-n]);
			System.out.println("전화번호 : " + number[i-n]);
			System.out.println();
		}


		System.out.print("나이를 검색하세요. : ");
		String a = br.readLine();
		int findAge = Integer.parseInt(a);

    // 이 부분은 도움을 받아 작성했다. 아직 이해가 가지 않는 부분!
    
		for(i=0; i<3; i++) {
			if(findAge == age[i]) {
				System.out.println("검색된 아이 이름 : " + name[i]);
				break;
			} 
			if(i == 2) {
				System.out.println("검색된 결과가 없습니다.");
			}
		}
		//
    
		System.out.println("프로그램을 종료합니다. ");
		br.close();
	}
}
