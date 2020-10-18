package test;

import java.util.Scanner;

public class Student {
	String name;
	int subNumber;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student student = new Student();

		//변수
		int menu = 1;
		int i = 0;
		int count = 0;

		//subject 배열
		String[] subject = new String[3];
		subject[0] = "java";
		subject[1] = "python";
		subject[2] = "c++";

		Student[] stuName = new Student[10];

		while(true) {
			System.out.println("1. 학생 이름 추가");
			System.out.println("2. 학생 목록");
			System.out.println("3. 프로그램 종료");
			menu = scan.nextInt();

			if(menu == 1) {
				System.out.println("과목을 입력하세요. ");
				String sub = scan.next();

				for(i=0; i<subject.length; i++) { //name[0]...[2].name = 학생이름이 들어간다.
					if(sub.equals(subject[i])) {
						System.out.println("이름을 입력하세요. ");
						stuName[count] = new Student();
						stuName[count].name = scan.next();
						stuName[count].subNumber = i;
						count++;
					}
				}

			}

			if(menu == 2) {
				System.out.println("2. 학생 목록");
				for(i=0; i<count; i++) { //name[0]...[2].name = 학생이름이 들어간다.
					if(stuName[i].subNumber == 0) {
						System.out.println(subject[0] + " : " + stuName[i].name);
					}else if(stuName[i].subNumber == 1){
						System.out.println(subject[1] + " : " + stuName[i].name);
					}else if(stuName[i].subNumber == 2) {
						System.out.println(subject[2] + " : " + stuName[i].name);
					}
				}
			}

			if(menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}//if(menu == 3) {


		}//while(true) {
	}
}
