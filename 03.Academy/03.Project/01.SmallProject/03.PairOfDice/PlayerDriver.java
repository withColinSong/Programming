package Day1010;

import java.util.Scanner;

public class PlayerDriver {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		PairOfDice d1 = new PairOfDice();
		
		Player p1 = new Player("Player1");
		System.out.print(p1.getName());
		p1.roll(d1);
		
		Player p2 = new Player("Player2");
		System.out.print(p2.getName());
		p2.roll(d1);
		
		
		if(p1.getTotal() > p2.getTotal()) {
			System.out.println("<" + p1.getName() + ">" + "이겼다.");
		}else if (p1.getTotal() == p2.getTotal()){
			System.out.println("둘이 비겼다.");
		}else {
			System.out.println("<" + p2.getName() + ">" + "이겼다.");
		}
		
		String b = "그만";
		System.out.println("게임을 계속하시겠습니까?");
		String a = scan.next();
		
		if(a.equals(b)){
			System.out.println("게임을 끝냅니다.");
		}

	}

}
