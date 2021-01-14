package di_step5;

import java.util.ArrayList;
import java.util.List;

// 개발자 김씨
public class OracleDB implements DB {

	@Override
	public List<String> select(String mid) {
		List<String> list = new ArrayList<>();
		list.add("OracleDB " + mid);
		return list;
	}

	@Override
	public String insert(String mid, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String mid, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String mid, String pw, int serial) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
}
