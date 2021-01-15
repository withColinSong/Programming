package aop_step2;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class Advice implements Log{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");	
	Dao dao;
	
	public Advice (Dao dao) {
		this.dao = dao;
	}

	@Override
	public String logOut() {
		String r = sdf.format(new Date());
		return r;
	}
	

	public List<String> before() { //Before advice
		String log = logOut();
		System.out.println(log);
		
		List<String> r = dao.select();
		return r;
	}
	
	public void after() {
		List<String> r = dao.select();
		System.out.println(r);
		
		
		String log = logOut();
		System.out.println(log);

	}
	
	public void around() {
		String log = logOut();
		System.out.println(log);
		
		List<String> r = dao.select();
		System.out.println(r);
		
		String log2 = logOut();
		System.out.println(log2);
		
	}
	
	
}
