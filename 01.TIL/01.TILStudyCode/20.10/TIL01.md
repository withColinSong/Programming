# Arraylist<Student> 로 작성한 학생 입력 프로그램

## Student class
```java
  import java.util.*;

  class Student {
    public String name;
    public String subject;

    public void setNew(ArrayList list) {

      Scanner scan = new Scanner(System.in);
      System.out.println("이름을 입력해주세요. ");
      this.name = scan.next();
      System.out.println("과목을 입력해주세요. ");
      this.subject = scan.next();
    }

    @Override

    public String toString() {
      return "학생 이름 : " + name + ", 과목 : " + subject;
    }
  }
```

## Main
```java 
  public class Main {

    public static void main(String[] args) {

      Scanner scan = new Scanner(System.in);
      ArrayList<Student> list = new ArrayList<>();

      Student stu = new Student();
      Student stu1 = new Student();

      while(true) {

        System.out.println("1. 입력  2. 출력");
        int menu =  scan.nextInt();

        if(menu == 1) {			

          System.out.println("──────입력을 누르셨습니다──────");
          //새로운 객체생성
          stu.setNew(list);
          stu1.setNew(list);
          list.add(stu);
          list.add(stu1);
        }

        // 리스트 추가
        if(menu == 2) {
          System.out.println("──────출력을 누르셨습니다──────");
          for(int i=1; i<=list.size(); i++) {
            System.out.println(list.get(list.size()-i).toString());
          }
        }
      }
    }
  }
```


## 보완하고 싶은 점, 아쉬운 점
- 출력문을 메소드로 만들고 싶다.
- 출력을 순서대로 출력하고 싶다.
```java
System.out.println(list.get(list.size()-i).toString()); // 출력시 list.stu1이 먼저 출력되는 부분
```
