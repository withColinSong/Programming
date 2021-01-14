package di_step3;

public class Main {
	DB db;
	
	// 이 부분은 외부에 노출되면 안되는 코드
	// 생성자를 통한 주입
	// 외부 환경에 변화에 덜 민감해진다.
	// 순수 POJO : Plane Oid Java Object
	public Main(DB db) {
		this.db = db;
		System.out.println(db.select("hi"));
	}
	
	// 메서드를 통한 의존성 주입
	public void method(DB db) {
		this.db = db;
		System.out.println(db.select("song"));
	}
	
	
	public static void main(String[] args) {
		
		Assembler ass = new Assembler();
		DB db = ass.getDb();
		Main main = new Main(db);
		
		main.method(db);
	}
}
