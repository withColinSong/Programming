package aop_exam2;

import java.util.ArrayList;
import java.util.List;

public class TVProduct implements Product{

	@Override
	public List<String> select(String findStr) {
		List<String> list = new ArrayList<>();
		list.add("TVProduct : " + findStr);
		return null;
	}

	@Override
	public int insert(String name) {
		int IntReturn = 1;
		return IntReturn;
	}

	@Override
	public int update(String name) {
		int IntReturn = 2;
		return IntReturn;
	}

	@Override
	public int delete(int serial) {
		int IntReturn = 3;
		return IntReturn;
	}

	
	

}
