package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InLineExamConsole;


public class Program {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		
		
		ExamConsole console = (ExamConsole)context.getBean("console");
		console.print();
		
		//List<Exam> exams = (List<Exam>)context.getBean("exams");//new ArrayList<>();
		//exams.add(new NewlecExam(1,2,3,4));
		
		// ArrayList(Collection C)
//		for(Exam e : exams) {
//			System.out.println("e : " + e);
//		}

	}

}
