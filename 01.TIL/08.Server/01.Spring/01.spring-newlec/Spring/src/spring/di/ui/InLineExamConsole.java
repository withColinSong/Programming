package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;

import spring.di.entity.Exam;

public class InLineExamConsole implements ExamConsole{
	private Exam exam;
	
	public InLineExamConsole() {
	
	}
	
	public InLineExamConsole(Exam exam) {
		this.exam = exam;
	}
	
	@Override
	public void print() {
		System.out.printf("total is InLine %d, %f\n", exam.total(), exam.avg());
		
	}
	
	@Autowired
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}

}
