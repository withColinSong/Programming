# 커피주문 프로그램 만들기

package Ex_0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class coffee01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int hot = 2500;
		int ice = 3000;
		int choco = 4000;
		
		for(;;) {
			System.out.println("메뉴판");
			System.out.println("1. 아메리카노(hot) " + hot + "원");
			System.out.println("2. 아메리카노(ice) " + ice + "원");
			System.out.println("3. 핫초코 " + choco + "원");
			System.out.println("4. 프로그램 종료");
			
			Scanner scan = new Scanner(System.in);
			System.out.print("메뉴선택 : ");
			int a = scan.nextInt();

			if(a == 1) {
				System.out.println("1번 눌렸습니다.");
				System.out.print("수량 : ");
				int b = scan.nextInt();
				int c = b * hot;
				System.out.println("결제 금액 : " + hot + "원 " + b +"잔은 " + c + "원이 맞습니까?");

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("맞으면 Y, 틀리면 N을 입력해주세요. ");
				String str = br.readLine();
				char res = str.charAt(0); 
						
				if(res == 'y' || res == 'Y') {
					System.out.println("결제가 완료되었습니다.");
				} else {
					System.out.println("결제가 실패하였습니다.");
				}
				break;
			} 
			
			if(a == 2) {
				System.out.println("1번 눌렸습니다.");
				System.out.print("수량 : ");
				int b = scan.nextInt();
				int c = b * ice;
				System.out.println("결제 금액 : " + ice + "원 " + b +"잔은 " + c + "원이 맞습니까?");

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("맞으면 Y, 틀리면 N을 입력해주세요. ");
				String str = br.readLine();
				char res = str.charAt(0); 
						
				if(res == 'y' || res == 'Y') {
					System.out.println("결제가 완료되었습니다.");
				} else {
					System.out.println("결제가 실패하였습니다.");
				}
				break;
			} 
			
			if(a == 3) {
				System.out.println("1번 눌렸습니다.");
				System.out.print("수량 : ");
				int b = scan.nextInt();
				int c = b * choco;
				System.out.println("결제 금액 : " + choco + "원 " + b +"잔은 " + c + "원이 맞습니까?");

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("맞으면 Y, 틀리면 N을 입력해주세요. ");
				String str = br.readLine();
				char res = str.charAt(0); 
						
				if(res == 'y' || res == 'Y') {
					System.out.println("결제가 완료되었습니다.");
				} else {
					System.out.println("결제가 실패하였습니다.");
				}
				break;
			} 
			
			if(a == 4) {
				System.out.println("프로그램 종료.");
				break;
			}

		}
	}
}
