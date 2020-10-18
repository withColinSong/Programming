
import java.util.Scanner;

public class Student {
	String name;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] subject = new String[3];
		subject[0] = "java";
		subject[1] = "python";
		subject[2] = "c++";

		Student[] stu = new Student[10];
		int menu = 1;
		int i = 0;

		while(true) {

			System.out.println("1. 학생 이름 추가");
			System.out.println("2. 학생 목록 표시");
			System.out.println("3. 프로그램 종료");

			menu = scan.nextInt();

			if(menu == 1) {

				System.out.println("과목을 입력하세요. ");
				String subject1 = scan.next();

				for(i=0; i<3; i++) {
					if(subject1.equals(subject[i])) {
						for(int j=0; j<3; j++) {
							System.out.println("학생 이름을 추가해주세요.");
							stu[j] = new Student();
							stu[j].name = scan.next();
						}
					}
				}
			}

			if(menu == 2) {
				System.out.println("과목을 입력하세요. ");
				String subject1 = scan.next();
				for(i=0; i<3; i++) {
					if(subject1.equals(subject[i])) {
						for(int j=0; j<3; j++) {
							System.out.println(stu[j].name);
						}
					}
				}

			}

			if(menu == 3) {
				System.out.println("프로그램 종료");
				break;
			}
		}

	}
}
