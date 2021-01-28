package spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("before() 시작");
		/* 
		System.out.println("────────────────────────────before()시작────────────────────────────");
		System.out.println("Method " + method);
		System.out.println("args " + args);
		System.out.println("target : " + target);
		System.out.println("────────────────────────────before()끝────────────────────────────\n");
		 */
		
		
		
	}

}
