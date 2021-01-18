package aop_step3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardDao implements Dao{
	
	@Override
	public List<String> select() {
		List<String> list = new ArrayList<>();
		list.add("BoardDao List<String> list");
		
		return list;
	}
	@Override
	public String insert() {
		
		return "BoardDao.insert()";
	}
	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String repl() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
