package aop_exam3;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
	
	public Object check(JoinPoint point) {
		
		RadioProduct product = (RadioProduct)point.getTarget();
		
		System.out.println("beforeAdvice : " + product.name);
		System.out.println("사전에 로그인 체크를 마쳤습니다.");
		return true;
	}
}
