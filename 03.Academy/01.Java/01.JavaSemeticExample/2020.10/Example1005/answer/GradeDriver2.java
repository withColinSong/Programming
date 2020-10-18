package Project03;

import java.util.Scanner;

public class GradeDriver2{

	Grade[] grade = new Grade[3];
	int count = 0;
	public GradeDriver2() {
		System.out.println("프로그램을 시작하겠습니다.");
		input() ;
	}
	
	void input() {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < grade.length; i++) {
			grade[i]= new Grade();
			System.out.print((i+1) + "번 학생 이름을 입력해주세요. : ");
			grade[i].name = scan.next();
			System.out.print((i+1) + "번 학생 점수를 입력해주세요. : ");
			grade[i].score = scan.nextInt();
			output();
			count++;
		}
	}

	void output() {
		System.out.println((count + 1) + "번 학생 이름 : " + grade[count].name  );
		System.out.println((count + 1) + "번 학생 점수 : " + grade[count].score+ "점");
	}
}


