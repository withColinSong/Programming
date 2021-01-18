package aop_exam2;

import java.util.List;
import java.util.Vector;

public class SmartTVProduct implements Product {

	@Override
	public List<String> select(String findStr) {
		List<String> list = new Vector();
		list.add("SmartTVProduct : " + findStr);
		
		return list;
	}

	@Override
	public int insert(String name) {
		int IntReturn = 1+3;
		return IntReturn;
	}

	@Override
	public int update(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int serial) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
