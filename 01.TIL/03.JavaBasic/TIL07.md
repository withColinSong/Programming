## 생성자 this()
- 생성자에서 다른 생성자 호출할 때 사용
- 다른 생성자 호출 시 첫 줄에서만 사용 가능

```java
  class Car2 {
      String color;
      String gearType;
      int door;

      Car2() {
          this("White", "auto", 4);
      }

      Car2(String color) {
          this(color, "auto", 4);
      }

      Car2(String color, String gearType, int door) {
          this.color = color;
          this.gearType = gearType;
          this.door = door;
      }
  }
```

#### 중복코드

```java
  class Car {
      String color;
      String gearType;
      int door;

      Car() {
          color = "White";
          gearType = "auto";
          door = 4;
      }
      
      Car(String c, String g, int d) {
          color = color;
          gearType = gearType;
          door = door;
      }
  }
```
#### 위의 코드를 중복 제거한 코드
```java
  Car() {
      this("White", "auto", 4);
  }
```

## 참조변수 this 
- 인스턴스 자신을 가리키는 참조변수
- this()생성자와 연관이 없다.
- 인스턴스 메서드(생성자 포함)에서 사용가능
- 지역변수(lv)와 인스턴스 변수(iv)를 구별할 때 사용

#### 같은 클래스 안에서는 this 생략 가능

```java
  Car(String c, String g, int d) {
      color = c;
      gearType = g;
      door = d;
  }
```
#### lv와 iv 변수이름이 같을 때

```java
  Car(String color, String gearType, int door) {
      this.color = color;
      this.gearType = gearType;
      this.door = door;
  }
```

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.10.19
- 🎈노트정리

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
