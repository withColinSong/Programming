package com.exarray;

class Info {
	
	//멤버필드
	int age = -1;
	
	//생성자
	public Info() {
		System.out.println("생성자");
	}
	
	//메소드
	void print() {
		System.out.println("age 출력 " + age);
	}
	
}

public class test2 {
	public static void main(String[ ]args) {
		
		new Info01();
	
	}
}
