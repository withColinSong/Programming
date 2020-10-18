### 참조형 매개변수
- 변수의 값을 읽고 변경할 수 있다. (read & write)

```java
  class Data { 
      int x;
  }

  class Ex6_7 {
      public static void main(String[] args) {
          Data d = new Data();
          d.x = 10;
          System.out.println("main() : x = " + d.x);

          change(d);
          System.out.println("----After change(d)----");
          System.out.println("main() : x = " + d.x);
      }


      static void change(int x) {
          d.x = 1000;
          System.out.println("change() : x = " + d.x);
      }
  }
```
println문이 스택에 저장되는 건 따로 표현하지 않았다.

```java
Data d = new Data(); // 객체를 생성한다.
d.x = 10; // 초기화
```         
![](https://images.velog.io/images/withcolinsong/post/4b95328d-bcf6-4c13-8b1b-d22a5a9c2dda/image.png)
```java
change(d); 
static void change(int x) {
          d.x = 1000; //
          System.out.println("change() : x = " + d.x);
      }
```
![](https://images.velog.io/images/withcolinsong/post/845abc10-9a69-4d60-a5a3-244e9a6369b8/image.png)

```java
System.out.println("----After change(d)----");
System.out.println("main() : x = " + d.x);
```
![](https://images.velog.io/images/withcolinsong/post/0236c799-eb66-477a-ade7-c57d83a6f76f/image.png)

1. change메소드가 호출되면서 참조변수 d의 값(주소)이 매개변수 d에 복사됨
	이제 매개변수 d에 저장된 주소값을 x에 접근 가능.
    
2. change메소드에서 매개변수 d로 x의 값을 1000으로 변경
3. change메소드가 종료되면 매개변수 x는 스택에서 제거됨

### console
```
main() : x = 10
change() : x = 1000
----After change(d.x)----
main() : x = 1000
```

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.10.16
- 🎈노트정리 , iPad

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
