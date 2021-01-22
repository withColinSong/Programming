package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

public class Program {

	public static void main(String[] args) {
		

		Exam exam = new NewlecExam(1,1,1,1);
		
		//Proxy.newProxyInstance(loader, interfaces, h)
		//Proxy.newProxyInstance(인터페이스를 구현한 클래스, 인터페이스, 핸들러)
		Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), 
				new Class[] {Exam.class}, new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			
				long start = System.currentTimeMillis();
				
				//Object object = method.invoke(실제업무객체, args);
				Object result = method.invoke(exam, args);
				
				long end = System.currentTimeMillis();
				
				String message = (end-start) + "ms 시간이 걸렸습니다. ";
				System.out.println(message);
				
				return result;
			}
			
		});
		
		
		System.out.printf("proxy total  : %d\n", proxy.total());
		System.out.println("─────────────────────────────────");
		System.out.printf("proxy total  : %f\n", proxy.avg());
		System.out.println("─────────────────────────────────");
		System.out.printf("exam total  : %d\n", exam.total());
		System.out.println("─────────────────────────────────");
		System.out.printf("exam total  : %f\n", exam.avg());
	}

}
