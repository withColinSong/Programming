package aop_exam1;

public class BoardDao implements Dao{
	

	@Override
	public void select() {
		System.out.println("BoardDao");
		
	}
	
}
