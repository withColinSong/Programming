```java
  package Day19;

  import java.util.Scanner;

  public class ExceptionCase6 {

    public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);

      try {
        System.out.println("a/b ....a?");
        int n1 = kb.nextInt();
        System.out.printf("%d \n", n1);
      }catch(Exception e) {
        e.getMessage();
      }finally {
        System.out.println("마무리");
      }

      System.out.println("끝.");
    }

  }
 ```
