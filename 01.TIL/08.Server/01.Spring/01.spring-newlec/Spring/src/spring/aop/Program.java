package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;



public class Program {

	public static void main(String[] args) {

		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/aop/entity/setting.xml");
		
		Exam proxy = (Exam) context.getBean("proxy");
		
		
		System.out.printf("proxy total  : %d\n", proxy.total());
		System.out.println("─────────────────────────────────");
		System.out.printf("proxy avg  : %f\n", proxy.avg());
		System.out.println("─────────────────────────────────");
		
		
		/*
		Exam exam = (Exam) context.getBean("target");
		
		System.out.printf("exam total  : %d\n", exam.total());
		System.out.println("─────────────────────────────────");
		System.out.printf("exam total  : %f\n", exam.avg());
		
		*/
		
	}

}
