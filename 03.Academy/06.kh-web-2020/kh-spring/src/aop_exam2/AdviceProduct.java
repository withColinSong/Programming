package aop_exam2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AdviceProduct implements MethodInterceptor{
	
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		

			log();
			Object object = invocation.proceed(); //pointCut
			System.out.println("object : " + object);
			log(); // weaving type : around type
		
		return object;
	}
	
	public void log() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
		String result = sdf.format(new Date());
		System.out.println(result);
		
	}
	
	
	
}
