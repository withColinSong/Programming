package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberDao {
	DB db;
	
	public MemberDao() {}
	
	@Autowired
	public MemberDao(DB db) {
		this.db = db;
		System.out.println(db.select("생성자"));
	}
	
	public void setDb(DB db) {
		this.db = db;
		System.out.println("setDb : 메서드를 통해 주입받음");
		System.out.println(db.select("song"));
	}
}
