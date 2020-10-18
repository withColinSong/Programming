package Ex0929;

public class Sample01 {
	static int a = 10;
	
	// 메소드 만들기
	static void show() { //static을 붙이면 main method에서 직접적으로 사용할 수 있다.
		System.out.println(a); //Class 변수 사용
		System.out.println("Sample01 클래스  - show()");
	}
	public static void main(String[] args) {
	
	   show(); /
		
	}

}

-----------------------------------------------------------

package Ex0929;

public class Sample01 {
	static int a = 10;
	
	// 메소드 만들기

	/*static*/ void show() { //static 을 붙이지 않고, main 메소드에 사용시 생성자를 만든 후 해당 메소드를 사용할 수 있다.
		System.out.println(a);
		System.out.println("Sample01 클래스  - show()");
	}
	public static void main(String[] args) {
	
		Sample01 s = new Sample01(); //생성자

		s.show(); 
	  	 show(); //오류
		
	}

}
