# 생성자 초기화란?

```
class CalculatorEx {
	// 필드변수 선언
	int a;
	int b;
	public CalculatorEx() { // 기본 생성자
		// 필드변수 초기화
		a = 10;
		b = 20;
	}
	public CalculatorEx(int num1, int num2) { // 생성자 오버로딩
		// 매개값 이용 필드변수 초기화
		a = num1;
		b = num2;
	}
	public void sum() { // 메소드
		System.out.println("합계 : " + (a + b));
	}
}
public class ConstructorEx04 {
	public static void main(String[] args) {
		CalculatorEx cc = new CalculatorEx();
		cc.sum(); // 결과 : 30
		CalculatorEx cc2 = new CalculatorEx(0, 10);
		cc2.sum(); // 결과 : 10
	}
}
```

참조🎈<br>
블로그(https://m.blog.naver.com/heartflow89/220955879645])
