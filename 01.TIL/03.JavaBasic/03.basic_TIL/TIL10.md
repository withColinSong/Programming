# [목차](#목차)
- [1. 패키지](#1-패키지)
- [2. 패키지 선언](#2-패키지-선언)
- [3. cmd창으로 class 파일 실행하기](#3-cmd창으로-class-파일-실행하기)
- [4. class path](#4-class-path)
- [Reference](#reference)

## 1. 패키지(package)
- 서로 관련된 클래스의 묶음
- 클래스는 클래스 파일(*.class), 패키지는 폴더. 하위 패키지는 하위폴더
- 클래스의 실제 이름(full name)은 패키지를 포함(java.lang.String)
- rt.jar는 클래스들을 압축한 파일(JDK설치경로\jre\lib에 위치)
	- rt : runtime
    - jar : 클래스 파일 묶어놓은 것.
	- Java 9부터 module 개념으로 rt.jar는 사라졌다.
    
## 2. 패키지 선언
```java
package 패키지명;
```

- 패키지는 소스파일의 첫 번째 문장으로 단 한번 선언
- 같은 소스 파일의 클래스들은 모두 같은 패키지에 속하게 된다.
- 패키지 선언이 없으면 이름없는(unnamed) 패키지에 속하게 된다.

## 3. cmd창으로 class 파일 실행하기
### 코드
```java
  package testPKG;

  public class cmd {

      public static void main(String[] args) {
          System.out.println("cmd runtime");
      }

  }
```
- 이클립스를 사용하지 않고 cmd창에서 class 파일을 실행시킬 때 아래와 같이 실행한다.

1. 이클립스에서 `cmd.java` 클래스를 만든다.
2. 패키지 `testPKG` 경로를 찾는다.
![](https://images.velog.io/images/withcolinsong/post/53c060a8-09f5-413f-a06d-96d1648949a9/image.png)

![](https://images.velog.io/images/withcolinsong/post/b0e3d5bd-58ee-4dc6-a673-dd455ab6ab30/image.png)

3. `testPKG` 경로에서 제일 가까운 `bin` 폴더를 찾는다.
4.  위에 `bin`  절대경로를 복사하여 cmd에 붙여넣는다.

5. cmd창 키기 (Window키 + R)
![](https://images.velog.io/images/withcolinsong/post/d6ddfd07-9b93-4446-aef2-68cdada34af8/image.png)

6.`java testPKG.cmd` 실행

![](https://images.velog.io/images/withcolinsong/post/92b1036f-43a6-4da0-a21b-fd65d7041545/image.png)


## 4. class path
- 매번 class를 실행시키기 위해 cmd 창에서 경로를 찾아가는게 불편하기 때문에 path경로를 설정해주는 것이다.
- 클래스 파일(*class)의 위치를 알려주는 경로(path)
- 환경변수(OS) classpath로 관리하며, 경로간의 구분자는 `;`를 사용
- classpath(환경변수)에 패키지의 루트를 등록해줘야 한다.


![](https://images.velog.io/images/withcolinsong/post/e3f0ca21-4dbd-4774-b41e-104fb85bf3b0/image.png)

### 4.1 Path 설정하기 
### 환경변수 -> 시스템변수 -> 새로만들기

- 변수이름 : classpath
- 변수 값 : workspace가 저장되어있는 디렉토리에서 `bin` 절대경로로 설정
- 저장된 classpath 경로 확인하기
- cmd창 -> `set classpath`

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 정리한 자료입니다.**
- 🎈2020.11.11
- 🎈노트정리

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
