# [목차](#목차)
- [목차](#목차)
- [1. 제어자(modifier)](#1-제어자modifier)
  - [1.1 Static](#11-static)
    - [1.1.1 사용](#111-사용)
    - [1.1.2 대상](#112-대상)
      - [멤버변수](#멤버변수)
      - [메서드](#메서드)
  - [1.2 final](#12-final)
    - [1.2.1 사용](#121-사용)
    - [1.2.2 대상](#122-대상)
      - [클래스](#클래스)
      - [메서드](#메서드-1)
      - [멤버변수, 지역변수](#멤버변수-지역변수)
  - [1.3 abstract](#13-abstract)
    - [1.3.1 사용](#131-사용)
    - [1.3.2 대상](#132-대상)
      - [클래스](#클래스-1)
      - [메서드](#메서드-2)

# 1. 제어자(modifier)

- 제어자는 클래스, 변수 또는 메서드의 선언부에 함께 사용되어 **부가적인 의미**를 부여한다.

접근제어자 : public, protected, (dafalut), private
그 외 : static, final, abstract, native, trasient, synchronized, volatile, stricifp

- 제어자는 클래스나 멤버변수, 메서드에 주로 사용
- 하나의 대상에 여러 제어자 조합하여 사용 가능.
  - 단, 접근제어자는 한 번에 네 가지 중 하나만 선택하여 사용할 수 있다.


 ## 1.1 Static

### 1.1.1 사용

- static이 사용될 수 있는 곳 : 멤버필드, 메서드, 초기화 블럭

### 1.1.2 대상

#### 멤버변수
- 모든 인스턴스에 공통적으로 사용되는 클래스 변수가 된다.
- 클래스가 메모리에 로드될 때 생성된다.
- 클래스 변수는 인스턴스를 생성하지 않고도 사용 가능하다.

#### 메서드
- 인스턴스를 생성하지 않고도 호출이 가능한 static메서드가 된다.
- static메서드 내에서는 인스턴스 멤버들을 직접 사용할 수 없다.

```java
class StaticTest {
  static int width = 200; // 클래스 변수(static변수)
  static int height = 200; // 클래스 변수(static변수)

  static {
    //static 변수의 복잡한 초기화 수행
  }

  static int max(int a, int b) { // 클래스 메서드(static메서드)
    return a > b ? a : b;
  }
}

```


## 1.2 final

### 1.2.1 사용
- final이 사용될 수 있는 곳 : 클래스, 메서드, 멤버변수, 지역변수

대표적인 예 :
- String 
- Math(메서드가 static)

### 1.2.2 대상

#### 클래스
- 변경될 수 없는 클래스, 확장될 수 없는 클래스가 된다.
- 즉, 다른 클래스의 조상이 될 수 없다.

#### 메서드
- 변경될 수 없는 메서드
- 즉 오버라이딩을 통해 재정의 될 수 없다.

#### 멤버변수, 지역변수
- 값을 변경할 수 없는 상수가 된다


```java
final class FinalTest {     // 조상이 될 수 없는 클래스
  final int MAX_SIZE = 10;  // 값을 변경할 수 없는 멤버변수(상수)

  final void getMaxSize() {   // 오버라이딩 할 수 없는 메서드(변경불가)
    final int LV = MAX_SIZE;  // 값을 변경할 수 없는 지역변수(상수)
    return MAX_SIZE;
  }
}
```

## 1.3 abstract

### 1.3.1 사용
- abstract가 사용될 수 있는 곳 - 클래스, 메서드 


### 1.3.2 대상

#### 클래스
- 클래스 내에 추상 메서드가 선언되어 있음을 의마한다.
  
#### 메서드 
- 선언부만 작성하고 구현부는 작성하지 않은 추상 메서드임을 알린다

```java
abstract class AbstractTest { // 추상 클래스(추상 메서드를 포함한 클래스)
  abstract void move();       // 추상메서드(구현부가 없는 메서드)
}

AbstractTest a = new AbstractTest() // 에러. 추상 클래스의 인스턴스 생성불가
```
- 추상 클래스를 상속 받아서 완전한 클래스를 만든 후에 객체 생성해야 한다.


## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.11.14
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
