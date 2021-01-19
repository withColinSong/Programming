package aop_exam3;

import java.util.List;
import java.util.Vector;

public class RadioProduct implements Product{
	String name = "song";
	@Override
	public List<String> select(String findStr) {
		this.name = "ju";
		List<String> list = new Vector<>();
		list.add("RadioProduct");
		System.out.println("RadioProduct");
		return list;
		
	}

	@Override
	public int insert(String name) {
		this.name = name;
		System.out.println("Radio Insert");
		return 0;
	}

	@Override
	public int update(String name) {
		System.out.println("Radio update");
		return 0;
	}

	@Override
	public int delete(int serial) {
		System.out.println("Radio delete");
		return 0;
	}

}
