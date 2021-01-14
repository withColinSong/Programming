package di_step2;

import java.util.List;
import java.util.Vector;

// 이씨 개발자
public class MyDB implements DB {

	@Override
	public List<String> select(String findStr) {
		List<String> list = new Vector<>();
		list.add("MyDB");
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
