# 정보처리기사 실기문제

```java

public class Problem {

	public static int a = 1; //static 메모리에 저장되어있다.

	static void increase() {
		int b = 2; //지역변수이기 때문에 계속 리셋이 된다.
		System.out.printf("%d, %d\n", ++a, ++b);
	}
	
	public static void main(String[] args) {
		increase();
		increase();
	}
}

```


### console
```java
2, 3
3, 3
```
