# 클래스 채우기 (문제)

package test01;

class Circle {
  //코드를 입력하시오.
}

public class Test01 {

	public static void main(String[] args) {
		
		Circle pizza;
		pizza = new Circle();
		pizza.radius = 10; //에러
		pizza.name = "자바피자"; //에러
		double area = pizza.getArea(); //에러
		System.out.println(pizza.name + "의 면적은" + area);

	}
}


# After

package test01;

class Circle {

	int radius;
	String name;
	
	public double getArea() {
	 return 3.14 * radius * radius;
	}
	
	public Circle() {
		
	}
	
}

public class Test01 {

	public static void main(String[] args) {
		
		Circle pizza;
		pizza = new Circle();
		pizza.radius = 10;
		pizza.name = "자바피자";
		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은" + area);

	}

}
