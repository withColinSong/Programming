# SUPER() 조상의 생성자

### Point 클래스
```java
  class Point {
      int x;
      int y;

      public Point(int x, int y) {
          this.x = x;
          this.y = y;
      }

      String getLocation() {
          return "x : " + x + ", y : " + y;
      }

  }
```

### Point3D 클래스
```java
  class Point3D extends Point {
      int z;

      public Point3D (int x, int y, int z){ //에러
          this.x = x;
          this.y = y;
          this.z = z;
      }

      String getLocation() {
          return "x : " + x + ", y : " + y;
      }
  }
```

### Main 클래스
```java
  public class Ex7_4 {
      public static void main(String[] args) {
          Point3D p = new Point3D(1,2,3);
      }
  }
```



### 컴파일 오류
```java
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
Implicit super constructor Point() is undefined. 
Must explicitly invoke another constructorat 
chap7_4.Point3D.<init>(Ex7_4.java:22)
at chap7_4.Ex7_4.main(Ex7_4.java:38)
```
### 해결방법
1. Point 클래스에 기본 생성자를 생성한다. `public Point(){}`
2. Point3D 클래스에 super() 생성자를 사용한다.

```java
class Point3D extends Point {
	int z;
    
    Point3D(int x, int y, int z) {
    	super(x, y); //Point (int x, int y)를 호출
        this.z = z;
    }
}
```

## 꼭 기억하기!
#### 1. 모든 생성자는 첫줄에 다른 생성자를 호출해야 한다. 
#### 2. 조상의 멤버는 조상의 생성자를 통해 초기화 하는 것이 바람직하다.
#### 3. 생성자 만들 때 기본 생성자 필수!

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.10.31
- 🎈노트정리

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
