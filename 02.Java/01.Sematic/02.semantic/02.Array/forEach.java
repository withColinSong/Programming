package Ex0930;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
  
		Scanner scan  = new Scanner(System.in);
		
		String[] numbers = new String[3]; //배열 선언
    
		for(int i=0; i<numbers.length; i++) {
			System.out.println("이름을 입력해주세요.");
			numbers[i] = scan.next(); //배열값 저장
		}
		
		System.out.println();
		System.out.println("이름 목록");
		
		for(String number: numbers) {
		    System.out.println(number);
		}
	}
}




<Console> 
이름을 입력해주세요.
송자바
이름을 입력해주세요.
김자바
이름을 입력해주세요.
최자바

이름 목록
송자바
김자바
최자바

