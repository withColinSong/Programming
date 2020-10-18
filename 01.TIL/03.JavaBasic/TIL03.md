### 기본형 매개변수
- 변수의 값을 읽기만 할 수 있다. (변경 불가)

```java
  class Data { 
      int x;
  }

  class Ex6_6 {
      public static void main(String[] args) {
          Data d = new Data(); 
          d.x = 10; 
          System.out.println("main() : x = " + d.x); 
          change(d.x); 
          System.out.println("----After change(d.x)----"); 
          System.out.println("main() : x = " + d.x);
      }


      static void change(int x) {
          x = 1000;
          System.out.println("change() : x = " + x);
      }
  }
```

**강의를 듣고 위에 코드를 분석하여 아래 그림으로 나타내보았다.**


```java
Data d = new Data(); //1번 객체생성
d.x = 10; //x의 값을 초기화
```
![](https://images.velog.io/images/withcolinsong/post/2d096c7a-0485-4657-b035-3d4f1a72f714/image.png)

```java
System.out.println("main() : x " + d.x); 
- d.x의 값을 출력한다.

change(d.x);
- 실행되면 아래 메소드로 내려간다.
 
   static void change(int x) { 
            x = 1000; 
            System.out.println("change() : x " + x);
	}
    
  - 현재 d.x = 10 이므로 (int x)가 d.x를 매개변수로 받았고,
  - 이 값이 중괄호 안 영역에서 x에 대입된다.
 ```
 
![](https://images.velog.io/images/withcolinsong/post/7f000906-8526-4b89-9036-9305c9d60185/image.png)

```java
  - 메소드가 끝난 후 실행 위치로 다시 와서, 아래 코드를 실행한다.
   System.out.println("----After change(d.x)----");
   System.out.println("main() : x " + d.x);

```
![](https://images.velog.io/images/withcolinsong/post/92e5c573-0d49-462f-baaf-88a5fd74ada8/image.png)

main 메소드까지 끝나면 프로그램이 종료된다.

## console
```
main() : x = 10
change() : x = 1000
----After change(d.x)----
main() : x = 10
```

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.10.16
- 🎈노트정리 , iPad

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)

