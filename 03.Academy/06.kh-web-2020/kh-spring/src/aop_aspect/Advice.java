package aop_aspect;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Advice {

	
	
	// before or after
	public boolean loginCheck(JoinPoint point) {
		// 로그인 여부를 판단하는 프로세스
		System.out.println("loginCheck()");
		
		return true;
	}
	
	// around(Insert 작업 시 around 타입으로 작업시간을 log로 출력)
	public Object around(ProceedingJoinPoint point) {
		System.out.println(log());
		Object object = null;
		
		try {
		
			 object = point.proceed();
			 System.out.println(object);
			 
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(log());
		
		return object;
	}
	
	public String log() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");
		return sdf.format(new Date());
	}
	
}
