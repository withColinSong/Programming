package aop_anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAdvice {
	
	@Before("execution(* insert(..)) || "
		  + "execution(* update(..)) || "
		  + "execution(* delete(..))")
	
	public Object check(JoinPoint point) {
		
		RadioProduct product = (RadioProduct)point.getTarget();
		
		System.out.println("beforeAdvice : " + product.name);
		System.out.println("사전에 로그인 체크를 마쳤습니다.");
		return true;
	}
	
	@After("execution(* select(..))")
	public Object log(JoinPoint point) {
		System.out.println("AfterAdvice() : ");
		return null;
	}
	
	@Around("execution(* select(..))")
	public Object log(ProceedingJoinPoint point) {
		System.out.println("AroundAdvice() : ");
		return null;
	}
}
