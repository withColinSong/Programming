# 6-17 연습문제(method)
## 다음과 같이 메서드 정의하기

```java
- 메서드명 : shuffle
- 기 능 : 
  - 주어진 배열에 담긴 값의 위치를 바꾸는 작업을 반복하여 뒤섞이게 한다. 
  - 처리한 배열을 반환한다.
- 반환타입 : int[]
- 매개변수 : int[] arr - 정수값이 담긴 배열
- [참고] Math.random()을 사용하는 경우 실행결과와 다를 수 있음.
````

```java
  class shuffle {
      /*
      (1) shuffle 메서드를 작성하시오.
      */
  }

      public static void main(String[] args) {

      int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9}
      System.out.println(java.util.Arrays.toString(original));

      int[] result = shuffle(original)
      System.out.println(java.util.Arrays.toString(result));

      }

```

### 풀이
```java
  public class shuffle {
  
  1. 메서드 정의하기
  
      public static int[] shuffle(int[] arr) {

          for(int i = 0; i < arr.length; i++) {
              int j = (int)(Math.random()*arr.length);

              // arr[i]와 arr[j]의 값을 서로 바꾼다.
              int tmp = arr[i]; 
              arr[i] = arr[j];
              arr[j] = tmp;
          }
          return arr;
      }


2. Main 메서드

      public static void main(String[] args) {

          int[] original = new int[9];
          
          //original 배열에 순서대로 1부터 9까지 값 넣기
          for(int i = 0; i < original.length; i++) {
              original[i] = i+1;
          }
          
          int[] result = shuffle(original); 
          System.out.println(java.util.Arrays.toString(result));

      }
  }


```
## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : **스스로 풀어보기**
- 🎈2020.11.10
- p214 6-17 예제문제

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
