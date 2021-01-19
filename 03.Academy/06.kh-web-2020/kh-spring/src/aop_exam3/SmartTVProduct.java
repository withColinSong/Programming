package aop_exam3;

import java.util.ArrayList;
import java.util.List;

public class SmartTVProduct implements Product{

	@Override
	public List<String> select(String findStr) {
		List<String> list = new ArrayList<>();
		System.out.println(list.add("SmartTVProduct"));
		return list;
	}

	@Override
	public int insert(String name) {
		// TODO Auto-generated method stub
		return 0;
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
