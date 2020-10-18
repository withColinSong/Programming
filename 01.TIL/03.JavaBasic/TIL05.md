### 참조형 반환타입
- 반환타입이 참조형이라는 것은 반환 하는 값이 참조형이라는 얘기이며, 참조형 타입의 값은 
**"객체의 주소"** 이다.

```java
  class Data3 { 
      int x;
  }

  class Ex6_8 {
      public static void main(String[] args) {
          Data3 d = new Data();
          d.x = 10;
          
          Data3 d2 = copy(d); 
          System.out.println("d.x = " + d.x);
          System.out.println("d2.x = " + d2.x);
      }

      static Data3 copy(Data3 d) {
          Data3 tmp = new Data();
          tmp.x = d.x
          return tmp;
      }
  }
```
### 코드 분석
```java
Data d = new Data(); // 객체를 생성한다.
d.x = 10; // 초기화
Data3 d2 = copy(d); // copy(d)메소드를 d2에 대입한다.
``` 

![](https://images.velog.io/images/withcolinsong/post/8a14a28f-37d7-49c0-a889-9a31bab874a3/image.png)

copy메소드가 실행된다.
```java
  static Data3 copy(Data3 d) { //매개변수 Data3 d객체의 저장된 값을 복사해서 반환한다.
            Data3 tmp = new Data(); //tmp의 새로운 객체가 생성된다.
            tmp.x = d.x //d.x의 객체의 주소를 tmp.x객체의 주소값에 대입한다.
            return tmp; //tmp의 주소값을 리턴한다.
        }
```
![](https://images.velog.io/images/withcolinsong/post/7e14d519-2c5f-4c5d-88d8-d7c1d3d3e2ca/image.png)

![](https://images.velog.io/images/withcolinsong/post/fc8e50b5-a827-41f4-9001-a4c646bc5b79/image.png)

![](https://images.velog.io/images/withcolinsong/post/2c5da810-4168-49b1-82a0-b07dba67e928/image.png)

### console
```
d.x = 10;
d2.x = 10;
```

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.10.18
- 🎈노트정리 , iPad

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
