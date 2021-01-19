package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InLineExamConsole;


public class Program {

	public static void main(String[] args) {
		
		/* 스프링에게 지시하는 방법으로 코드를 변경
		Exam exam = new NewlecExam();
		
		ExamConsole console = new GridExamConsole();
		
		console.setExam(exam);
		
		*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		// id명
		ExamConsole console = (ExamConsole)context.getBean("console"); // 어떠한 객체인지 알 수 없기에 object 형식으로 꺼내옴.
		
		//자료형 명
		//ExamConsole console = context.getBean(ExamConsole.class);
		console.print();

	}

}
