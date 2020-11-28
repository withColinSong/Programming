## 상속
 - 자손은 조상의 모든 멤버를 상속받는다. (생성자, 초기화 블럭 제외)
 - 자손의 멤버 개수는 조상보다 적을 수 없다. (같거나 많다.)
 - 부모를 상속 받아 확장한 자식 클래스는 부모의 데이터가 변할 때 영향을 받는다.
 - 자손의 변경은 조상에 영향을 미치지 않는다.
 
 
``` java
   class Parent {
      int age;
   }

   class Child Extends Parent{ } //현재 멤버는 1개
 
 ```
 
```java
     class Parent {
        int age;
     }
     
	 class Child Extends Parent{ //Parent를 확장해서 child 클래스를 만들겠다란 의미.
       void play() {
       System.out.println("play");
       } //자신 멤버는 1개, 상속 받은 멤버 1개
     } 
```    
```java
  class Point {
      int x;
      int y;
  }

  class Point3D { 1번 : Point 클래스와 관계가 없는 클래스
      int x;
      int y;
      int z;
  }

  class Point3D extends Point {//2번 : Point를 상속 받아 확장한 자식 클래스
      int z;
  }
```

## 결과값 : 
- 위에 클래스들을 그림으로 나타내보면 아래와 같다.
![](https://images.velog.io/images/withcolinsong/post/84bf5c19-331f-4d8b-b24e-4ee3243ac790/image.png)

**Point3D의 객체를 만들면 1번과 2번의 멤버는 결과적으로 똑같다.** 


## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS)
 
- 🎈2020.10.15 
- 🎈그림 : 아이패드로 그림
