package di_step6;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// 개발자 송씨
public class DataBase implements DB{

	@Override
	public List<String> select(String mid) {
		List<String> list = new Vector<>();
		list.add("DataBase " + mid);
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
