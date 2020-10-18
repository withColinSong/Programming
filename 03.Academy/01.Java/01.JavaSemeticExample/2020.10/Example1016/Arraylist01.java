  import java.util.*;
  public class Ex06 {

    public static void main(String[] args) {
      ArrayList<Info> list = new ArrayList<Info>();
      Info in = new Info();
      in.name = "sinMinA";
      in.number = 1234;
      list.add(in);

      System.out.println(list.get(0).name);
      System.out.println(list.get(0).number);

      Info in1 = new Info();
      in1.name = "sinMinA";
      in1.number = 1234;
      list.add(in1);

      System.out.println(list.get(1).name);
      System.out.println(list.get(1).number);
    }
  }
