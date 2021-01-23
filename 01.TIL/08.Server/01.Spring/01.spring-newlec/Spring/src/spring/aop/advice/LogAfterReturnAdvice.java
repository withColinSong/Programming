package spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfterReturnAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("────────────────────────────afterReturning()시작────────────────────────────");
		System.out.println("returnValue → " + returnValue );
		System.out.println("Method → " + method);		
		System.out.println("args → " + args);
		System.out.println("target → " + target);
		
		System.out.println("────────────────────────────afterReturning()끝────────────────────────────\n");
				
	}
	
}
