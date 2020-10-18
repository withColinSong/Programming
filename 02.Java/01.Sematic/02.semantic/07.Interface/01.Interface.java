interface Show {
	public void show();
	public void count();
}

class Test implements Show{
	public void show() {
		System.out.println("show 실행");
	}
	
	public void count() { //클래스에도 만들어줘야한다.
		System.out.println("count 실행");
	}
}


public class Sample02 {
	public static void main(String[] args) {
		//		Sample01 t = new Sample01();
		//		t.show();

		Show s =  new Show() {
			public void show() {
				System.out.println("무명 클래스 show 실행");
			}
			public void count() {
				System.out.println("무명 클래스 count 실행");
			}
		};

		s.show();
		s.count();
	}
}

colsole
무명 클래스 show 실행
무명 클래스 count 실행
