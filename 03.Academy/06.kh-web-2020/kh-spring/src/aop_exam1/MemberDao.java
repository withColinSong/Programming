package aop_exam1;

public class MemberDao implements Dao{

	@Override
	public void select() {
		System.out.println("MemberDao()");
		
	}

}
