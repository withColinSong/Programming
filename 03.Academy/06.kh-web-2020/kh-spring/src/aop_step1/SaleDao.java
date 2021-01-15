package aop_step1;

import java.util.Date;
import java.text.SimpleDateFormat;

public class SaleDao implements Log{

	public SaleDao() {
		System.out.println("SaleDao() : " + logOut());
	}
	
	@Override
	public String logOut() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String r = sdf.format(new Date());
		return r;
	}

}
