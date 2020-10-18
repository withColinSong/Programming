package chapter03;
// 출석부를 관리한다
import java.util.Scanner;

public class ClassRollDriver
{
   public static void main (String[] args)
   {
	   // 변수들
	   Scanner scan = new Scanner (System.in);
	   int choice;			// 사용자 선택
	   String coursename;	// 교과목명
	   String name;			// 이름
	   int number;			// 학번
	   Student student;		// Student 객체 참조변수

	   ClassRoll sbook= new ClassRoll();

       // 교과목명을 입력 받는다
	   System.out.print("교과목명을 입력하세요: ");
	   coursename = scan.next();

	   // 출석부의 교과목명을 입력 받은 입교과목명으로 변경한다
        	// 여기에 코드를 입력하세요

	   do {
		   // 사용자가 원하는 연산을 선택하게 한다
		   System.out.print("원하는 연산을 선택하세요:");
		   System.out.print("(1) 추가");
		   System.out.print("(2) 찾기");
		   System.out.println("(3) 종료");

		   choice = scan.nextInt();

           // 사용자의 선택에 따라 연산을 수행한다
		   if (choice == 1)
		   {
			   // 추가하는 학생의 학번과 이름을 입력 받은 후 그 학생을 출석부에 추가한다
        			// 여기에 코드를 입력하세요
		   }
		   else if (choice == 2)
		   {
			   // 찾는 학생의 학번을 입력 받은 후 그 학생의 이름을 출력한다
        			// 여기에 코드를 입력하세요
		   }
	   } while (choice != 3);
   }
}
