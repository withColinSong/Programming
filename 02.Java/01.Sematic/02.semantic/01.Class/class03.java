package Ex0929;

class Test {
	private String name = "비어있음";
	int age = -1;
	
	void setName(String n) {
		name = n;
	} // t.setName("김자바");
	
	public Test() { //생성자
		System.out.println("Test() 생성자 시작");
	}
	
	void print() { //메소드
		System.out.println(name + ", " + age);
	}
}


public class Sample02 {
	public static void main(String[] args) {
		
		Test t = new Test(); //객체 생성
		
		t.setName("김자바"); //private의 접근제어자로 인해 setter를 사용한다.
		t.print(); 
		// 출력값 김자바, -1
    
		t.age = 29; //Test 클래스의 변수를 사용하고 싶을 
    
		t.print(); 
		//출력값 김자바, 29
    
	}
}
