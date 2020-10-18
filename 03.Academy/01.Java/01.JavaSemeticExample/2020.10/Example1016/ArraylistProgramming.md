# 1번을 입력하면 정보를 입력하고 2번을 누르면 출력하는 프로그램을 만들어라.

  ### Info class.java

  ```java
  public class Info {
    public Info() {}

    public String name;
    public int number;

  }
  ```

### main
  ```java
    package Day18;

    import java.util.*;
    public class Ex06 {

      public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Info> list = new ArrayList<Info>();
        Info in;
        int count = 0;

        while(true) {

          System.out.println("번호를 입력하세요.");
          int input = scan.nextInt();

          if(input == 1) {
            in = new Info();
            System.out.println("입력하세요. ");
            in.name = scan.next();
            in.number = scan.nextInt();
            list.add(in);
            count++;
          }

          if(input == 2) {
            System.out.println("출력합니다.");
            for(int i=0; i<count; i++) {
              System.out.println(list.get(i).name);
              System.out.println(list.get(i).number);
            }
          }

          if(input == 3) {
            System.out.println("프로그램이 종료됩니다.");
            break;
          }
        }
      }
  }
```
