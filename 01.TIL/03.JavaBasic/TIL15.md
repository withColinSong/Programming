# [목차](#목차)
- [목차](#목차)
- [1. 다형성(polymorphism)](#1-다형성polymorphism)
  - [1.1. Example](#11-example)
  - [1.2. 자손타입의 참조변수 조상타입의 인스턴스 참조](#12-자손타입의-참조변수-조상타입의-인스턴스-참조)
  - [References](#references)

# 1. 다형성(polymorphism)

- 조상클래스 타입의 참조변수를 자손클래스의 인스턴스 변수를 참조할 수 있도록 하는 것.
- 여러가지 형태를 가질 수 있는 능력

## 1.1. Example

```java
class Tv {
	boolean power;
	int channel;
	
	void power() {};
	void channel() {};
	void channelDown() {};
	
}


public class SmartTv extends Tv {
	
	String text;
	void caption() {};
	
	public static void main(String[] args) {
		
		Tv t = new SmartTv(); // 타입 불일치. 조상클래스 타입의 참조변수를 자손클래스의 인스턴스 변수를 참조

	}
}

```

- 참조변수 t는 SmartTv타입이라 할지라도, 인스턴스의 모든 멤버를 사용할 수 없다.
  - Tv클래스에 정의 되지 않은 멤버, text와 caption()은 참조변수 t로 사용이 불가능하다.
- 둘 다 같은 타입의 인스턴스지만 참조변수의 타입에 따라 사용 할 수 있는 멤버의 개수가 달라짐



## 1.2. 자손타입의 참조변수 조상타입의 인스턴스 참조

- 조상타입의 참조변수로 자손타입의 인스턴스를 참조할 수 있다.
- 반대로 자손타입의 참조변수로 조상타입의 인스턴스를 참조할 수 없다.

```java
Tv t = new SmartTv();
SmartTv s = new SmartTv(); // 에러
```

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.11.17
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
