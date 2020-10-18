# if문과 for문의 예제

## 실습예제01
```
package Ex_0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex01 {

	public static void main(String[] args) throws IOException {
	
		두개의 정수를 읽어 들여 같은 수이면 "Same" , 다른 수이면 "Different"를 출력하는 프로그램을 작성하시오.
		 
		 출력문
		 1번 정수를 입력 : 10;
		 2번 정수를 입력 : 20;
		 
		 두 수는 Different;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("1번 정수를 입력 : ");
		String res = br.readLine();
		int a = Integer.parseInt(res);
		
		
		System.out.print("2번 정수를 입력 : ");
		String res1 = br.readLine();
		int b = Integer.parseInt(res1);
		
		if( a == b) {
			System.out.print("Same");
		} else {
			System.out.print("Different");
		}
    
```		
		
## 선생님 코드
    
```		
//		java.util.scanner in = new java.util.Scanner(System.in);
//		
//		System.out.print("1번 정수를 입력 : ");
//		int a = in.nextIn();
//		
//		System.out.print("1번 정수를 입력 : ");
//		int b = in.nextIn();
//		
//		if(a == b) {
//			System.out.print("Same");
//		} 
//		
//		if(a != b){
//			System.out.print("Different");
//		}
		
		
	}

}

```

## 실습예제02
```
package Ex_0923;

import java.util.Scanner;

public class ex02 {

	public static void main(String[] args) {
	
	// 숫자 1개를 읽어 들여 짝수인지, 홀수 인지를 판별하는 프로그램을 작성하시오.

		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력 : ");
		int a = scan.nextInt();
		
		if(a % 2 == 0) {
			System.out.println("입력한 수는 짝수 입니다.");
		} else {
			System.out.println("입력한 수는 홀수 입니다.");
		}
		

//		if(a % 2 == 0);{
//			System.out.println("입력한 수는 짝수 입니다.");
//		} else {
//			System.out.println("입력한 수는 홀수 입니다.");
//		}
//		if의 세미콜론; 주의! 
	}

}

```

## 실습예제03

```
package Ex_0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex03 {

	public static void main(String[] args) throws IOException {
		
		// 1에서 50까지의 수의 합계를 구하는 프로그램을 작성하시오.
		
		int sum = 0;
		for(int i = 1; i <= 50; i++) {
			sum = sum + i;
		}
		
		System.out.println("1에서 50까지 수의 합계 : " + sum);
		
	}

}
```

## 실습예제04

```
package Ex_0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex04 {

	public static void main(String[] args) throws IOException {
		// 1에서 20까지의 수 중 짝수의 합을 구하시오.
		
		int sum = 0;
		for(int i = 2; i <= 20; i+=2) {
			sum = sum + i;
		}
		
		System.out.println("1에서 20까지의 수 중에 짝수 합계 : " + sum);
		
		
		//for문과 if문을 사용해보기
		
		int sum1 = 0;
		for(int i = 1; i <= 20; i++) {
			if(i % 2 == 0) {
				sum1 = sum1 + i;
			}
		}
		
		System.out.println("1에서 20까지의 수 중에 짝수 합계 : " +sum1);
		
	}

}
```

## 실습예제 05
```
package Ex_0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex05 {

	public static void main(String[] args) throws IOException {
		// 1에서 20까지의 수 중 홀수의 합을 구하시오.
		
		int sum = 0;
		for(int i = 1; i <= 20; i+=2) {
			sum = sum + i;
		}
		
		System.out.println("1에서 20까지의 수 중 홀수 합계 : " + sum);
		
		// 같은 방법
		int sum01 = 0;
		for(int i = 0; i <= 10; i++) {
			sum01 = sum01 + i;
					i++;
			System.out.println(i);
		}
		
		System.out.println(sum01);
         	}
 
	}
```

## 실습예제 06

```
package Ex_0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex06 {

	public static void main(String[] args) throws IOException {
		// 1에서 50까지의 수 중 3의 배수의 합계를 구하는 프로그램을 작성하시오.
		
		
		int sum = 0;
		for(int i = 3; i <= 50; i+=3) {
			sum = sum + i;
		}
		
		System.out.println("합계 : " + sum);
	    }	
	}
```

## 실습예제07

```
package Ex_0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex07 {

	public static void main(String[] args) throws IOException {
		// 1에서 10까지의 수의 곱을 구하는 프로그램을 작성하시오.
		
		int multi = 1;
		for(int i = 1; i <= 10; i++) {
			multi = multi * i;

		}
		
		System.out.println(multi);
	}

}
```

## 실습예제08
```
package Ex_0923;

public class ex08 {

	public static void main(String[] args) {
		// 1에서 50까지의 수 중 3의 배수의 갯수를 구하시오.
		
		
		int count = 3;
//		for(int i = 3; i <= 50; i+=3) {
//			count ++; // count = count + 1
//		}
//		
		
		
		for(int i = 1; i <= 50; i++) {
			i+=3;
			count ++;
		}
		System.out.println("총 " + count + "개");
	}

}
```

