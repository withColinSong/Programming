## 클래스와 연관된 문제

### 연습문제01

1. 다음과 같은 멤버변수를 갖는 Student 클래스를 정의하시오.

![](https://images.velog.io/images/withcolinsong/post/adc85907-982c-4b21-b052-441dc598e742/image.png)


```java
class Student{

    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

}
```
### 연습문제01-1
2. 다음과 같은 실행결과를 얻도록 Student 클래스에 생성자와 info()를 추가하시오

```java
public class Exercise {
	public static void main(String[] args){
    
    Student s = new Student("홍길동", 1, 1, 100, 60, 76);
    String str = s.info();
    System.out.println(str);
    }
}

class Student {
		/*
        (1) 알맞은 코드를 넣어 완성하시오
        */
}
```
### console
```
홍길동, 1, 1, 100, 60, 76, 236, 78.7
```

### 내가 작성한 코드
```java

  public class Main {
      String name;
      int ban;
      int no;
      int kor;
      int eng;
      int math;

      public Main(String name, int ban, int no, int kor, int eng, int math) {
          this.name = name;
          this.ban = ban;
          this.no = no;
          this.kor = kor;
          this.eng = eng;
          this.math = math;

      }

      public String info() {
          int sum = kor + eng + math;
          return name + ", " + ban +", "  + no +
          ", " + kor +", " + eng + ", " + math + ", " + 
          (sum + ", " + Math.round(sum*10/3.00) * 0.1);
      }

      public static void main(String[] args) {
          Main m = new Main("홍길동", 1, 1, 100, 60, 76);
          String str = m.info();
          System.out.println(str);
      }
  }
```
## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : **강의를 듣고 정리한 자료입니다.**
- 🎈2020.10.21
- p207 6-1, 6-2 예제문제

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
