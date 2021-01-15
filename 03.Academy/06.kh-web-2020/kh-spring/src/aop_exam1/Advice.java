package aop_exam1;

public class Advice implements LogInCheck{
	Dao dao;

	
	public Advice(Dao dao) {
		this.dao = dao;
	}
	
	public void before() {
	
		if(logInCheck()) {
			dao.select();
		}else {
			System.out.println("로그인 필요합니다.");
		}
		
	}

	@Override
	public boolean logInCheck() {
		return false;
		//return true;
	}
	
}
