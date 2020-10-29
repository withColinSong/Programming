package Day1010;

import java.util.Scanner;


class StringName {
	String name;
	int score;

}

public class Review02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		//과목 이름을 입력받아 해당 과목 점수를 출력해주는 프로그램을 작성해보자. 
		StringName[] className = new StringName[3];

		int i=0;
		int number = 0;
		
		while(true) {
			System.out.println("1. 과목을 입력해주세요. ");
			System.out.println("2. 점수를 입력해주세요. ");
			System.out.println("3. 점수 확인");
			System.out.println("번호를 입력하세요.");

			number = scan.nextInt();

			if(number == 1) {
				System.out.println("과목을 입력해주세요. "); //과목 추가
				for(i=0; i<className.length; i++) {
					className[i] = new StringName();
					className[i].name = scan.next();
				}
			}

			if(number == 2) {
				System.out.println("과목 점수를 입력해주세요. "); //과목 입력
				for(i=0; i<className.length; i++) {
					className[i].score = scan.nextInt();
				}
			}

			if(number == 3) {
				System.out.println("점수를 확인 할 과목명을 입력하세요."); //점수 확인
				String name = scan.next();
				for(i=0; i<className.length; i++) {
					if(!className[i].name.equals(name)) {
						System.out.println("과목을 다시 확인해주세요.");
					}else {
						System.out.println(className[i].name + "의 점수 : " + className[i].score + "점");
					}
				}
			}
		}
	}
}
