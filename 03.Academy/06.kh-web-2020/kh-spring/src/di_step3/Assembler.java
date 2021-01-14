package di_step3;


// 외부에서 노출되는 코드
// 외부 조립기

public class Assembler {
	DB db;

	public DB getDb() {
		db = new OracleDB();
		// db = new MyDB(); 
		// db = new DataBase();
		return db;
	}
}
