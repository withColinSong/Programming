[목차](#목차)
- [1. 참조변수의 형변환](#1-참조변수의-형변환)
	- [1.1 형변환](#11-형변환)
		- [1.2.1. CODE](#121-code)
	- [1.2 참조변수의 형변환 예제](#12-참조변수의-형변환-예제)
- [2.instanceof 연산자](#2instanceof-연산자)
	- [1.1. 형변환 조건](#11-형변환-조건)
		- [1.1.1. instanceof](#111-instanceof)
	- [References](#references)

# 1. 참조변수의 형변환

- 사용할 수 있는 멤버의 갯수를 조절하는 것
- **조상 자손 관계의 참조변수는 서로 형변환 가능**

다운캐스팅 : 부모 -> 자식
업캐스팅 : 자식 -> 부모 

## 1.1 형변환

### 1.2.1. CODE

Car 클래스
```java
class Car {
	String color;
	int door;
	
	public void drive() {
		System.out.println("drive!");
	}
	
	public void stop() {
		System.out.println("Stop!");
	}
	
}

```

FireEngine 클래스

```java
class FireEngine extends Car {
	public void water() {
		System.out.println("water!");
	}
}
```

```java
FireEngine f = new FireEngine();

Car c = (Car)f; //OK. 조상인 Car타입으로 형변환(생략가능)
FireEngine f2 = (FireEngine)c; //OK. 자손인 FireEngine타입으로 형변환(생략불가)
Ambulance a = (Ambulance)f; //에러. 상속관계가 아닌 클래스 간의 형변환 불가
```

`FireEngine f = new FireEngine();`
f -> 객체를 사용할 수 있는 멤버 5개
`Car c = (Car)f;`
s -> 객체를 사용할 수 있는 멤버 4개
`FireEngine f2 = (FireEngine)c;`
f2 -> 객체를 사용할 수 있는 멤버 5개

## 1.2 참조변수의 형변환 예제

Car 클래스
```java
class Car {
	String color;
	int door;
	
	public void drive() {
		System.out.println("drive!");
	}
	
	public void stop() {
		System.out.println("Stop!");
	}
	
}

```

FireEngine 클래스
```java
class FireEngine extends Car {
	public void water() {
		System.out.println("water!");
	}
}
```

ReferenceVariable 클래스
```java
public class ReferenceVariable {

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe2;
		car.water(); // 컴파일 에러! Car타입의 참조변수로는 water()를 호출할 수 없다.
		fe2 = (FireEngine)car; // 자손타입 <- 조상타입 형변환 생략 불가
		fe2.water();
	}

}
```
# 2.instanceof 연산자

## 1.1. 형변환 조건
1. 참조변수의 형변환 가능여부에 확인에 사용. 가능하면 ture 반환
2. 형변환 전에 반드시 instanceof로 확인해야 함.


### 1.1.1. instanceof 
```java
void doWork(Car c) { //Car의 자손은 다 올 수 있다.
	if (c instanceof FireEngine) {
    FireEngine fe = (FireEngine)c;
    fe.water();
}
```

- 어떤 타입에 대한 instanceof 연산의 결과가 true라는 것은 검사한 타입으로 형변환이 가능하다는 것을 뜻한다.

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.11.18
- 🎈2020.12.02 add instanceof 
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)