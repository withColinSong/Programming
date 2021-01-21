package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InLineExamConsole implements ExamConsole{
	
	@Autowired
	private Exam exam;
	
	
	public InLineExamConsole() {
		System.out.println("Constructor");
	}
	
	public InLineExamConsole(Exam exam) {
		System.out.println("Overloaded Constructor");
		this.exam = exam;
	}
	
	@Override
	public void print() {
		if(exam == null)
			System.out.printf("total is InLine exam = null %d, %f\n", 0, 0.0);
		else 
			System.out.printf("total is InLine %d, %f\n", exam.total(), exam.avg());
	}
	
	
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter Constructor");
		this.exam = exam;
		
	}

}
