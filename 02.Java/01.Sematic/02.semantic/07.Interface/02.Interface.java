package Day16;

interface Show {
	public void show();
}

class Test implements Show{
	public void show() {
		System.out.println("show 실행");
	}
}


public class Sample02 {
	public static void main(String[] args) {
		Sample01 t = new Sample01(); //1번방법
		t.show();

		Show s =  new Show() { //2번방법 
			public void show() {
				System.out.println("무명 클래스 show 실행");
			}
		};

		s.show();
	}
}

1번 방법 == 2번 방법

1. 인터페이스를 사용하려면 무명 클래스를 매번 재정의 해야한다.
2. 추상클래스는 3개 클래스 중 2개만 완성하고 1개만 미완성하는 점이 인터페이스와 다르다.
