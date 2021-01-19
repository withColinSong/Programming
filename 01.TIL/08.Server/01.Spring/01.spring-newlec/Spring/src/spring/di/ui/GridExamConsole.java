package spring.di.ui;

import spring.di.entity.Exam;

public class GridExamConsole implements ExamConsole {
	private Exam exam;
	
	public GridExamConsole() {
		
	}
	
	public GridExamConsole(Exam exam) {
		this.exam = exam;
	}
	
	@Override
	public void print() {
		System.out.println("┌──────────────────┐");
		System.out.println("│"+exam.total()+"│"+exam.avg()+"│");
		System.out.println("└──────────────────┘");
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}

}
