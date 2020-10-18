## 스택(Stack) 
- 밑이 막힌 상자. 위에 차곡차곡 쌓인다.
- 메서드 수행에 필요한 메모리가 제공되는 공간
- 메서드가 호출되면 호출스택에 메모리 할당, 종료되면 해제

![](https://images.velog.io/images/withcolinsong/post/14b21905-529f-45ea-8eba-f74de3187a67/image.png)

![](https://images.velog.io/images/withcolinsong/post/33660e60-0a8f-438f-be59-fa868ba8ed5a/image.png)

![](https://images.velog.io/images/withcolinsong/post/48bcbeb8-00c1-4a1b-8b0b-501ab22e8049/image.png)

- 3번을 2번과 1번 사이에 넣는 행위는 불가능하다.
- 1번을 먼저 꺼내는 행위 또한 불가능하다.

### _Example_

```java
  class Ex6_5 {
  public static void main(String[] args) {
      System.out.println("Hello);
  }
```

![](https://images.velog.io/images/withcolinsong/post/8eb06173-f895-480f-84a1-8cb2b2795187/image.png)

-  아래에 있는 메서드가 위의 메서드를 호출한 것.

![](https://images.velog.io/images/withcolinsong/post/63036fd0-9c38-4379-8024-f6e8bb272cae/image.png)

![](https://images.velog.io/images/withcolinsong/post/f623a87a-906f-4542-9e86-63150694d289/image.png)

- 맨 위의 메서드 하나만 실행 중, 나머지는 메서드들은 대기중이다.
- Thread 전까지는 싱글스택이다.

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS)
- 🎈2020.10.16
- 🎈노트정리 , iPad

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
