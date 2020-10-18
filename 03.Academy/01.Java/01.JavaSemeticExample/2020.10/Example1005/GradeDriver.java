package Project03;

import java.util.Scanner;

public class GradeDriver{

	Grade grade = new Grade();
	Grade[] arrGrade = new Grade[3];

	void input() {

		Scanner scan = new Scanner(System.in);

		for(int i=0; i<arrGrade.length; i++) {
			arrGrade[i] = new Grade();

			System.out.print((i+1)+"번 학생 이름을 입력해주세요. : ");
			arrGrade[i].name = scan.next(); 
			System.out.print((i+1)+"번 학생 점수를 입력해주세요. : ");
			arrGrade[i].score = scan.nextInt();
		}
		output();
	}	

	void output() {
		for(int i=0; i<arrGrade.length; i++) {
			System.out.println((i+1) + "번 학생 이름 : " + arrGrade[i].name);
			System.out.println((i+1) + "번 학생 점수 : " + arrGrade[i].score + "점");
		}

	}

}
