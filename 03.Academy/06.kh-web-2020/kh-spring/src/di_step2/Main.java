package di_step2;

public class Main {
	
	
	public Main() {
		
		//step2의 문제점 : new 
		
		DB kim = new OracleDB();
		System.out.println(kim.select("kim"));
		
		DB song = new DataBase();
		System.out.println(song.select("song"));
		
		DB ju = new MyDB();
		System.out.println(ju.select("ju"));
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
