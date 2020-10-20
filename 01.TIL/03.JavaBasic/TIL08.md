## 변수의 초기화
- 변수를 선언하고 처음으로 값을 저장하는 것
- 경우에 따라서 필수적이기도 하고, 선택적이기도 하지만 선언과 동시에 적절한 값으로 초기화 하는 것이 바람직하다.
- **지역변수는 사용하기 전에 반드시 초기화해야 한다.**

```java
  class InitTest {
      int x; //인스턴스 변수
      int y = x; //인스턴스 변수

      void method() {
          int i;	//지역변수
          int j = i; //에러
      }
  }
```

## 멤버변수의 초기화
- 지역변수와 달리 멤버변수는 각 타입의 기본값으로 자동 초기화

1. 클래스 변수(cv)초기화 → 인스턴스 변수(iv) 초기화
2. 자동 초기화 → 명시적 초기화(간단) → 초기화 블럭, 생성자(복잡)

### 명시적 초기화
- 변수를 선언과 동시에 초기화 하는 것
```java
  class {
      int door = 4; // 기본형 변수의 초기화
      Engine e = new Engine(); //참조형 변수의 초기화

      //...
  }
```

### 초기화 블럭
1. 클래스 초기화 블럭 : 클래스 변수의 복잡한 초기화에 사용된다.
2. 인스턴스 초기화 블럭 : 인스턴스 변수의 복잡한 초기화에 사용된다.


```java

  class Ex {
      static {
          System.out.println("static() { }"); //클래스 초기화
      }

      {
          System.out.println("{ }"); // 인스턴스 초기화
      }

      public Ex() {
          System.out.println("생성자");
      }
  }


  public class test {
      public static void main(String[] args) {
          System.out.println("Ex bt = new Ex(); ");
          Ex bt = new Ex();

          System.out.println("Ex bt = new Ex(); ");
          Ex bt2 = new Ex();
      }
  }

```
#### cosole
```java
Ex bt = new Ex(); 
static() { }
{ }
생성자
Ex bt = new Ex(); 
{ }
생성자
```
- 클래스 초기화 블럭은 처음 메모리에 로딩 될 때 한 번만 수행.
- 인스턴스 초기화 블럭은 인스턴스가 생성될 때마다 수행.

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.10.20
- 🎈노트정리

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
