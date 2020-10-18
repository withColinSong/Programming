package Ex0929;

public class Sample03 {
	String name;
	int age;


	public static void main(String[] args) {

		Sample03 spl = new Sample03();

		// class 멤버 변수의 값을 정의해놓음.
		
		spl.name = "김자바"; 
		spl.age = 30; 

		// 출력
		System.out.println(spl.name);
		System.out.println(spl.age);

	}
}
