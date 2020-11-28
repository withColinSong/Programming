# [목차](#목차)
- [목차](#목차)
- [1. 캡슐화(encapsulation)](#1-캡슐화encapsulation)
  - [1.1 접근 제어자를 사용하는 이유](#11-접근-제어자를-사용하는-이유)
    - [1.1.1 public](#111-public)
    - [1.1.2 private](#112-private)
  - [1.2 getter, setter](#12-getter-setter)
    - [1.2.1 상속](#121-상속)
    - [1.2.2 암묵적인 규칙](#122-암묵적인-규칙)


# 1. 캡슐화(encapsulation)

- 데이터가 유효한 값을 유지하기 위해
- 비밀번호와 같은 데이터를 외부에서 함부로 변경하지 못하도록 하기 위해
- 클래스 내에서만 사용되는, 멤버들을 클래스 내부에 감추기 위해서 
  - (내부 작업을 위해 임시로 사용되는 멤버변수나 부분작업을 처리하기 위한 메서드 등) 
- 데이터가 변경됐을 시 같은 클래스 내에서만 데이터를 확인하면 된다.

## 1.1 접근 제어자를 사용하는 이유
- 외부로부터 데이터를 보호하기 위해서
- 외부에는 불필요한, 내부적으로만 사용되는, 부분을 감추기 위해서


### 1.1.1 public

```java
public class Time {
  public int hour;
  public int minute;
  public int second
}

Time t = new Time();
t.hour = 25; // 멤버변수에 직접 접근
```

- 잘못된 값을 지정한다고 해도 이것을 막을 방법이 없다.

### 1.1.2 private

```java
  class Time {
    //접근 제어자를 private 하여 외부에서 직접 접근하지 못하도록 한다.
      private int hour; 
      private int minute;
      private int second;

      //hour setter, getter
      public void setHour(int hour) {
          if(hourMethod(hour)) {
              return;
          }
          this.hour = hour;
      }

      public int getHour() {
          return hour;
      }

      private boolean hourMethod(int hour) {
          return hour < 0 || hour > 23;
      }

      //Minute setter, getter
      public void setMinute(int minute) {
          if(minuteMethod(minute)) {
              return;
          }
          this.minute = minute;
      }


      public int getMinute() {
          return minute;
      }

      private boolean minuteMethod(int minute) {
          return minute < 0 || minute > 59;
      }


      //Second setter, getter
      public void setSecond(int second) {
          if(secondMethod(second)) {
              return;
          }
          this.second = second;
      }


      public int getSecond() {
          return second;
      }

      private boolean secondMethod(int second) {
          return second < 0 || second > 59;
      }

  }
```

```java
  public class Main {
      public static void main(String[] args) {

          Time t = new Time();

          t.setHour(22); 
          System.out.println(t.getHour()); //22

          t.setHour(25); 
          System.out.println(t.getHour()); //22

          t.setMinute(60);
          System.out.println(t.getMinute()); // 0

          t.setMinute(30); 
          System.out.println(t.getMinute()); //30

          t.setSecond(88); 
          System.out.println(t.getSecond()); //0

          t.setSecond(25);
          System.out.println(t.getSecond()); //25
      }		

  }
```

## 1.2 getter, setter

- get으로 시작하는 메서드는 단순히 멤버변수의 값을 반환
- set으로 시작하는 메서드는 매개변수에 지정된 값을 검사하여 조건에 맞는 값을 때만 멤버변수의 값을 변경하도록 작성

### 1.2.1 상속
- 상속을 통해 확장될 것이 예상되는 클래스는 private -> protected를 사용한다.
- private는 자손 클래스에서 접근 불가능

### 1.2.2 암묵적인 규칙
- `get멤버변수이름` : 멤버변수의 값을 읽는 메서드 -> getter
- `set멤버변수이름` : 멤버변수의 값을 변경하는 메서드의 이름 -> setter


## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.11.16
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
