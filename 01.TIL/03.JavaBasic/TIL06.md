## 생성자
- 인스턴스가 생성될 때마다 호출되는 **인스턴스 초기화 메서드**
- iv(Instance Variable) 초기화 메소드

```java
Time t = new Time(); //기본 생성자
t.hour = 12;
t.minute = 34;
t.second = 56;

Time t = new Time(12, 34, 56);
```
![](https://images.velog.io/images/withcolinsong/post/2fd69a31-779e-4ca8-9e3d-bdd31a9f20d4/image.png)

- 이름이 클래스와 이름이 같아야 한다.
- 리턴값이 없다. (void 안붙임)
- 모든 클래스는 반드시 생성자를 가져야 한다.

```java
클래스이름(타입 변수명, 타입 변수명, ...) {
	// 인스턴스 생성 시 수행될 코드
    // 주로 인스턴스 변수의 초기화 코드를 적는다.
}
```
```java
  class Card {
      ...
      Card() { // 매개변수 없는 생성자
          //인스턴스 초기화 작업
      }
      
      Card(String kind, int number) { // 매개변수 있는 생성자
          //인스턴스 초기화 작업
      }    
  }
  ```

### 기본 생성자(default constructor)
- 매개변수가 없는 생성자
- 생성자가 하나도 없을 때만, 컴파일러가 자동추가

```java
클래스이름() { } // 기본생성자
Point() { } // Point클래스의 기본 생성자
```

```java
class Data_1 {
	int value;
}

class Data_2 {
	int value;
    
    Data_2(int x) { // 매개변수가 있는 생성자
    	value = x;
    }
}

class Ex{
	public static void main(String[] args) {
    	Data_1 d1 = new Data_1();
        Data_2 d2 = new Data_2(); //compile error발생
    }
}
```
#### compile error
- 기본 생성자를 꼭 만들어주자!
```java
  class Data_1 {
      int value;
      
      Data_1() { } // ++추가해주자.
  }
  
  class Data_2 {
      int value;

      Data_2() { } // ++반드시 추가해야함.
      Data_2(int x) { // 매개변수가 있는 생성자
          value = x;
      }
  }
```


### 매개변수가 있는 생성자
```java
  class Car {
      String color; // 색상
      String gearType; // 변속기 종류 - auto(자동), manual(수동)
      int door; // 문의 개수

      Car() { } //기본 생성자
      Car(String c, String g, int d) {
          color = c;
          gearType = g;
          door = d;
      }
  }
```
```java
Car c = new Car();
c.color = "White";
c.gearType = "auto";
c.door = 4;
```
#### 생성자로 출력 시
```java
Car c = new Car("White", "auto", 4); 생성자 출력 시 코드가 줄어든다.
````
![](https://images.velog.io/images/withcolinsong/post/28ef5285-a85e-4e6d-8aea-83df2b3ab028/image.png)

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.10.19
- 🎈노트정리 , iPad

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
