package di_step2;

import java.util.ArrayList;
import java.util.List;

// 개발자 송씨
public class DataBase implements DB{

	@Override
	public List<String> select(String findStr) {
		
		List<String> list = new ArrayList<>();
		list.add("오라클에서 처리된 결과");
		
		return list;
	}

	@Override
	public String insert(String mid, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(String mid, int serial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String mid, String pwd, int serial) {
		// TODO Auto-generated method stub
		return 0;
	}

}
