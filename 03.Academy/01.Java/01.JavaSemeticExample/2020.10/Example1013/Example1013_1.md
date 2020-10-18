# 다른 패키지들의 동일 이름 클래스를 사용하려면?

```java

class Scanner{
	public Scanner() {
		System.out.println("내가 만든 Scanner");
	}
}


public class ScannerEx {

	public static void main(String[] args) {
		
		Scanner scan =  new Scanner();
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.println("숫자를 입력해주세요. ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = a + b;
		
		System.out.println(a + "+" + b + "=" +sum);
	}

}
```
