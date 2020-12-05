# [목차](#목차)
- [목차](#목차)
- [추상 클래스 abstract class](#추상-클래스-abstract-class)
  - [1.1 추상 클래스](#11-추상-클래스)
    - [1.1.1 기본 형식](#111-기본-형식)
  - [1.2. 추상 메서드](#12-추상-메서드)
    - [1.2.1. 추상 메서드의 목적](#121-추상-메서드의-목적)
  - [References](#references)

# 추상 클래스 abstract class

## 1.1 추상 클래스

- 미완성 클래스
- 추상 클래스로 인스턴스는 생성할 수 없다. 
- 상속을 통해 추상 메서드를 완성해야 인스턴스 생성 가능.
- 생성자가 있어야 한다.
- 추상클래스 안에 인스턴스 메서드에 추상 메서드가 사용 가능하다.
- 미완성 메서드를 가지고 있다면 추상 클래스이다.

### 1.1.1 기본 형식
```java
abstract class 클래스이름 {

}
```

## 1.2. 추상 메서드
- 미완성 메서드
- 조상으로부터 상속 받은 추상 메서드 중 하나라도 구현하지 않는다면, 자손 클래스 역시 추상 클래스이다.

### 1.2.1. 추상 메서드의 목적
- 꼭 필요하지만 자손마다 다르게 구현될 것으로 예상하는 경우 필요하다.

```java
  abstract class Player {
      abstract void play(int pos);
      abstract void stop();
  }

  class AudioPlayer extends Player {
      void play(int pos) {
          // 구현 코드
      }

      void stop() {
          // 구현 코드
      }
  }

  abstract class AbstractPlayer extends Player {
      void play(int pos) { 
          // 구현 코드
      } 
  }
```

- Player의 메서드를 하나만 구현하면 AbstractPlayer는 추상 클래스이다.

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.12.05
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)