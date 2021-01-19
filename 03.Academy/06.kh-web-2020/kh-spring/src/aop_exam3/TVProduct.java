package aop_exam3;

import java.util.ArrayList;
import java.util.List;

public class TVProduct implements Product {
	String name = "song";
	
	@Override
	public List<String> select(String findStr) {
		List<String> list = new ArrayList<>();
		list.add("TVProduct");
		System.out.println(list.add("TVProduct"));
		return list;
	}

	@Override
	public int insert(String name) {
		this.name = name;
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
