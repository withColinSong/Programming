package com.ex01;

public class Class05 {
	
  // 메소드 오버로딩
  
	static void sum(int a, int b) {
		System.out.println(a + b);
		}
	
	void sum(int a, int b, int c) {
	System.out.println(a + b + c);
	}
  
	public static void main(String[] args) {
		
		sum(10,20); //static을 붙이면 main에서 직접적으로 사용가능하다.
    
    
    //void sum(int a, int b) {System.out.println(a + b);}	
    // 접근제어자가 없을 시 클래스 메소드에 접근하는 방법
    * 필수  Class05 sum = new Class05();
		        sum.sum(5, 10); 
		        sum.sum(10, 20, 30);

	}

}


package com.ex01;

public class Class06 {
	
	void sum(int a, int b) {
		System.out.println(a+b);
	}
	
	void sum(double a, double b) {
		System.out.println(a+b);
	}
	
	public static void main(String[] args) {
		//2개의 정수를 합을 구하는 sum()과 2개의 double형 실수의 합을 구하는 sum()을 메소드 오버로딩을
		//이용하여 정의하라.
		
		Class06 class01 = new Class06();
		
		class01.sum(10, 20);
		class01.sum(20.5, 30.3);

	}

}

