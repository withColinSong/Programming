# [목차](#목차)
- [목차](#목차)
- [1. 접근제어자](#1-접근제어자)
  - [1.1. 접근제어자 종류](#11-접근제어자-종류)
      - [1.1.1 class 앞에 올 수 있는 접근제어자](#111-class-앞에-올-수-있는-접근제어자)
  - [1.2. 접근범위 순서](#12-접근범위-순서)
  - [1.3. 코드](#13-코드)
    - [1.3.1 같은 패키지 같은 클래스](#131-같은-패키지-같은-클래스)
    - [1.3.2 같은 패키지 다른 클래스](#132-같은-패키지-다른-클래스)
    - [1.3.3 다른 패키지 상속 받은 자손 클래스](#133-다른-패키지-상속-받은-자손-클래스)
    - [1.3.4 다른 패키지 다른 클래스](#134-다른-패키지-다른-클래스)



# 1. 접근제어자(access modifier)


## 1.1. 접근제어자 종류

1. **private** - 같은 클래스
2. **(default)** - 같은 패키지
3. **protected** - 같은 패키지 + 자손(다른 패키지)
4. **public** - 접근제한없음

### 1.1.1 class 앞에 올 수 있는 접근제어자
  - **public** - 접근제한없음
  - **defalut** - 같은 패키지
  
## 1.2. 접근범위 순서 

public > protected > default > private

|제어자|같은 클래스|같은 패키지|자손 클래스|전체
|:-:|:-:|:-:|:-:|:-:|
|**public**|O|O|O|O|O
|**protected**|O|O|O| |
|**(default)**|O|O| | |
|**private**|O| | | |


- 접근자가 **default**라는 것은 아무런 접근제어자가 붙지 않는 것이다.

## 1.3. 코드

### 1.3.1 같은 패키지 같은 클래스

```java

  package access1;

  public class Myparent {
      private int pri;
      int def;
      protected int pro;
      public int pub;

      public void printMember() {
          System.out.println(pri);
          System.out.println(def);
          System.out.println(pro);
          System.out.println(pub);
      }

      public static void main(String[] args) {
          Myparent p = new Myparent();

          System.out.println(p.pri); //OK
          System.out.println(p.def); //OK
          System.out.println(p.pro); //OK
          System.out.println(p.pub); //OK
      }
  }
```

### 1.3.2 같은 패키지 다른 클래스

```java

  package access1;

  public class Myparent {
      private int pri;
      int def;
      protected int pro;
      public int pub;

      public void printMember() {
          System.out.println(pri);
          System.out.println(def);
          System.out.println(pro);
          System.out.println(pub);
      }
  }

  class Mydef{
      public static void main(String[] args) {
          Myparent p = new Myparent();

          System.out.println(p.pri); //에러
          System.out.println(p.def); //OK
          System.out.println(p.pro); //OK
          System.out.println(p.pub); //OK
      }
  }
```

### 1.3.3 다른 패키지 상속 받은 자손 클래스

```java

  package access2;

  import access1.Myparent;

  public class Mypro extends Myparent {

      public void printMember() {
          System.out.println(pri); //에러
          System.out.println(def); //에러
          System.out.println(pro); //OK
          System.out.println(pub); //OK
      }
  }

```

### 1.3.4 다른 패키지 다른 클래스

```java

  package access2;

  import access1.Myparent;

  class MyTest {

      public static void main(String[] args) {

          Myparent p = new Myparent();

          System.out.println(p.pri); //에러
          System.out.println(p.def); //에러
          System.out.println(p.pro); //에러
          System.out.println(p.pub); //OK
      }
  }
```

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.11.14
- 🎈정리 : VScode

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
