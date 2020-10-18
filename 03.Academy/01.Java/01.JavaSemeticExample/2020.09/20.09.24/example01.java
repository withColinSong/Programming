# Sample01

package Ex_0924;

public class Sample01 {

	public static void main(String[] args) {	
		// i를 전역변수로 선언했을 때와 지역변수 안에서의 차이
		int i;

		for(i = 1; i <= 50; i+=3) {
			System.out.println("반복하고 있습니다");
			System.out.println("for문 : " + i);
		}

		System.out.println(i);
		System.out.println("반복하고 끝났습니다.");
			
	}


}


# Sample02

package Ex_0924;

class Point {
	int x = 10;
}

class Student{
	String name = "xxx";
	int age = 0;
}

public class Sample02 {

	public static void main(String[] args) {

		//클래스의 배열
		
		Point[] p = new Point[3];
		
		
//		p[0] = new Point();
//		p[1] = new Point();
//		p[2] = new Point();

		// p[0].x = 22; 실행 시 오류 
		
		for(int i = 0; i < 3; i++) {
			p[i] =  new Point();
			p[0].x = 22; // 이 곳에 실행시 정상 작동. 시점이 중요하다!
			System.out.println(p[i].x);
		}
		
		
		Student[] a = new Student[3];
		
		for (int i = 0; i < 3; i++) {
			a[i] = new Student();
			a[0].age = 22;
			System.out.println(a[i].name);
			System.out.println(a[i].age);
		}
		
		
	}

}

# Sample03

package Ex_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sample03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("몇 개의 *를 출력 하시겠습니까?");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int num = Integer.parseInt(str);
		
		for(int i = 1; i <= num; i++) {
			System.out.println("*");
		}
		
	}

}


# Sample04

package Ex_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample04 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("숫자 몇까지의 합을 구하시겠습니까?");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine(); // 5
		int a = Integer.parseInt(str);
		
		int sum = 0;
		for(int i = 1; i <= a; i++) {
			sum += i;  // 
			
			System.out.println(i);
			System.out.println(sum);
		}
		
		System.out.println("1부터 " + a + "까지의 합은" + sum + "입니다.");
	}

}

# Sample05

package Ex_0924;

public class Sample05 {

	public static void main(String[] args) {

		//while 문
		int i = 1;
		
		while(i <= 5) {
			System.out.println(i + "번째 반복입니다.");
			i++;
		}
		
		System.out.println("반복이 끝났습니다.");

	}

}


# Sample06

package Ex_0924;

public class Sample06 {

	public static void main(String[] args) {
		// do while문 (실무에 잘 쓰이진 않는다.)

		int i = 1;
		do {
			System.out.println(i + "번째 반복입니다");
			i++;
		} while (i <= 5);
		System.out.println("반복이 끝났습니다.");
	}

}

# Sample07

package Ex_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample09 {

	public static void main(String[] args) throws IOException {
		// 

		System.out.println("몇 번째에서 루프를 빠져 나가시겠습니까? (1 ? 10) ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int res = Integer.parseInt(str);

		for(int i=1; i <= 10; i++) {
			System.out.println(i + "번째 처리입니다");  
			if(i == res) 
				break;
		}

		for(int i=1; i<=10; i++) {
			if(i == res) 
				continue;
			System.out.println(i + "번째 처리 입니다.");

		}

	}

}

