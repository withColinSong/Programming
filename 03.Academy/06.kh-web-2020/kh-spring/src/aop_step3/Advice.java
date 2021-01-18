package aop_step3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// 특정 메서드가 호출됐을 때 실행이 되기 전에 뭔가 작업을 시키고 특정 메서드를 실행한다.
public class Advice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object object = null;
		
		if(loginCheck()) {
			// String rs = (String)invocation.proceed(); // Joinpoint 클래스의 object 반환형
			// List<String> list = (List<String>)invocation.proceed();
			// return list;
			System.out.println("invoke");
			object = invocation.proceed(); // proceed를 실행하면 dao.의 특정 메서드를 실행하는구나 생각하면 된다.
		}
		
		return object;
	}
	
	public boolean loginCheck() {
		// 로그인 여부를 판단하는 프로세스
		return true;
	}
	
	
}
