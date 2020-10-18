### charAt();

- 문자열 안의 값을 하나씩 얻어온다.

### replace("" , "");

```java
String oldStr = "자바 프로그래밍"; //String pool 영역에 저장
<br>                             //String pool 과 stack 영역은 비슷한 개념이라고 보면 된다.
String newStr = oldStr.replace("자바", "Java"); //Heap 영역에 저장

Console 
: Java Programming

- 객체는 2개 생성된다.
```
