package di_step1;


// 개발자 팀장 코드
public class Main {
	
	public Main() {
		// 개발자 김씨
		OracleDB kim = new OracleDB();
		String r = kim.find();
		System.out.println(r);
		
		// 개발자 송씨
		DataBase song = new DataBase();
		String s = song.select();
		System.out.println(s);
		
		// 개발자 주씨
		MyDB a = new MyDB();
		a.search();
		
	}
	
	public static void main(String[] args) {
		
		new Main();
	}
}
