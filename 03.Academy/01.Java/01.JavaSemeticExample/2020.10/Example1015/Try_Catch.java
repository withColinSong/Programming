  package Day16;

  public class Sample02 {

    public static void main(String[] args) {
      try {
        int[] test;
        test = new int[5];

        System.out.println("test [10]에 값을 대입합니다.");

        test[10] = 80;
        System.out.println("test[10]에 80을 대입했습니다.");
      }
      catch(ArrayIndexOutOfBoundsException e) {
        System.out.println("배열 길이를 넘어섰습니다.");
      }
      System.out.println("무사히 종료했습니다.");
    }

  }
