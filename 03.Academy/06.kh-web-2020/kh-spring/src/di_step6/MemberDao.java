package di_step6;

public class MemberDao {
	DB db;
	
	public MemberDao() {}
	public MemberDao(DB db) {
		this.db = db;
		
	}
	
	public void setDb(DB db) {
		this.db = db;
		System.out.println("setDb : 메서드를 통해 주입받음");
		System.out.println(db.select("song"));
	}
}
