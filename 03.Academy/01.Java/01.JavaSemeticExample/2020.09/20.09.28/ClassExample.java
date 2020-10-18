package com.exarray;

import java.util.Scanner;

//클래스를 사용하지 않을 때

class Info{

	String name = "비어있음";
	int age = 0;

	public Info() {
		System.out.println(name + ", " + age);
	}

	void Input( ) {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 입력 : ");
		name = scan.next();
		System.out.println("나이 입력");
		age = scan.nextInt();
	}

	void Print() {
		System.out.println("print(): " + name + ", " + age);
	}
}



//main
public class test03 {

	public static void main(String[] args) {
		String name = "비어있음";
		int age = 0;

		System.out.println(name + ", " + age);


		Scanner scan = new Scanner(System.in);
		System.out.println("이름 입력 : ");
		name = scan.next();
		System.out.println("나이 입력");
		age = scan.nextInt();

		System.out.println("print(): " + name + ", " + age);
	}
}


//Class로 사용 시
package com.exarray;

import java.util.Scanner;

class Info02{

	String name = "비어있음";
	int age = 0;

	public Info02() {
		System.out.println(name + ", " + age);
	}

	void Input( ) {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 입력 : ");
		name = scan.next();
		System.out.println("나이 입력");
		age = scan.nextInt();
		Print();
	}

	void Print() {
		System.out.println("print(): " + name + ", " + age);
	}


}

//메인

class test03 {

	public static void main(String[] args) {
		Info02 info = new Info02();
		info.Print();
		info.Input();
	}
}
