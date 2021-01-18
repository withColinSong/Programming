package aop_exam2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AdviceProduct implements MethodInterceptor{
	
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object object = null;
		
		
			log();
			object = invocation.proceed(); //pointCut
			System.out.println(object);
			log(); // weaving type : around type
		
		
		return object;
	}
	
	public void log() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
		String log = sdf.format(new Date());
		System.out.println(log);
	}
	
	
	
}
