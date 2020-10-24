
## Math.round()

- 아래는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다.
<br>만일 변수 num의 값이 '456'이라면 '400'이 돠고, '111'이라면 '100'이 된다.
<br>알맞은 코드를 작성하시오.

### 문제
```java
  pubulic class Math_ {
      public static void main(String[] args) {

          int num = 456;
          System.out.print(*1.코드입력*);
          
          int num1 = 111;
          System.out.print(*2. 코드입력*);
      }
  }

결과값
num1 : 400
num2 : 100
```


### 코드
```java
  pubulic class Math_ {
      public static void main(String[] args) {

          int num = 456;
          System.out.print("num: " + Math.round((num/100)*100);
          
          int num1 = 100;
          System.out.print("num1 : " + Math.round((num/100)*100);
      }
  }

```


## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : 책 보고 문제 풀어보기
- 🎈2020.10.24
- p95 3-3문제
