  package Day16;

  import java.io.BufferedReader;
  import java.io.IOException;
  import java.io.InputStreamReader;

  public class Sample04 {

    public static void main(String[] args) {

      System.out.println("문자열을 입력하시오. ");

      try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(str + "(이)가 입력되었습니다.");
      }
      catch(IOException e) {
        System.out.println("입출력 에러가 발생했습니다.");
      }
    }

  }
