
# 실행결과를 보고 코드를 작성하기.

![](https://images.velog.io/images/withcolinsong/post/cdd53b83-c7c0-4da1-b54c-20205e700323/image.png)


## 주어진 코드 1

```java
public class Human {
	private String name;
	private int height;
	private int weight;
	
	void gainWeight(int w) {
		weight += w;
	}
	
	void reduceWeigth(int w) {
		weight -= w;
	}
}
```

## 주어진 코드 2
```java

public class HumanTester {

	public static void main(String[] args) {
		Human gildong = new Human("길동", 170, 60);
		Human chulsu = new Human("철수", 166, 72);
		
		gildong.gainWeight(3); //길동이 3키로 쪘다.
		chulsu.reduceWeigth(5); //철수가 5키로 빠졌다.
		
		System.out.println("이름 : " + gildong.getName());
		System.out.println("키 : " + gildong.getheight() + "cm");
		System.out.println("몸무게 : " + gildong.getWeight() + "kg");
		
		System.out.println();
	
		System.out.println("이름 : " + chulsu.getName());
		System.out.println("키 : " + chulsu.getheight() + "cm");
		System.out.println("몸무게 : " + chulsu.getWeight() + "kg");

	
	}
}
```
