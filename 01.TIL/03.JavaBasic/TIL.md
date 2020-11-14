# [목차](#목차)
- [목차](#목차)
- [2. import문의 선언](#2-import문의-선언)
  - [2.1 서로 다른 코드](#21-서로-다른-코드)
  - [2.2 이름이 같은 클래스](#22-이름이-같은-클래스)
- [3. static import문](#3-static-import문)

- # 1. import문
- 클래스를 사용할 때 패키지 이름을 생략할 수 있다.
- 컴파일러에게 클래스가 속한 패키지를 알려준다.

```java
	class ImportTest {
    java.util.Data today = new Java.util.Data();
	// ...

->

	import java.util.Data;
    class ImportTest( {
    	Data today = new Data();
    }

```


- java.lang패키지(기본패키지)의 클래스는 import하지 않고도 사용할 수 있다.
	- String, Object, System. Thread ...d

# 2. import문의 선언

```java
import 패키지명.클래스명;
  또는
import 패키지명.*;
```
- import문은 패키지문과 클래스 선언의 사이에 선언한다.
- import문은 컴파일 시에 처리되므로 **프로그램의 성능**에 영향이 없다.
```java
  import java.util.Calender;
  import java.util.Data;
  import java.util.ArrayList;

  -> 

  import java.util.*;
```

## 2.1 서로 다른 코드
- 다음의 두 코드는 서로 의미가 다르다.
```java
import java.util.*; //util의 모든 클래스
import java.text.*; //text의 모든 클래스

-> import java.*; // java 패키지의 모든 클래스 (패키지는 포함 안됨.)

```
## 2.2 이름이 같은 클래스
- 이름이 같은 클래스가 속한 두 패키지를 import 할 때는 클래스 앞에 패키지명을 붙여줘야 한다.
  
```java
import java.sql.*; // java.sql.Date
import java.util.*; //java.util.Data

public class ImportTest {
  public static.void.main(String[] args){
    java.util.Data today = new java.util.Data();
  }
}
```


# 3. static import문
- static멤버를 사용할 때 클래스 이름을 생략할 수 있다.
```java
import static java.lang.Integer.*; // Integet클래스의 모든 static 메서드
import static java.lang.Math.random; // Math.random()만. 괄호 안붙임
import static java.lang.System.out; // System.out을 out만으로 참조가능
```

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.11.14
- 🎈노트정리

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
