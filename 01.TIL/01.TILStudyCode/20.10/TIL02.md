
## Tv 클래스
  ```java
  class Tv {
    boolean power;
    int channel;


    public void power(boolean onOff) {
      if(onOff == true) {
        System.out.println("──────────TV ON──────────");
      } else {
        System.out.println("──────────TV OFF──────────");	
      }
    }

    public void channelUp() {
      channel++;
    }

    public void channelDown() {
      channel--;
    }


  }
  ```

## SmartTv 클래스

  ```java
    boolean caption; //자막

    public void caption(String text) {
      if(caption) {
        System.out.println(text);
      }
    }
  }
  ```

## Main 클래스
  ```java
  public class Ex7_1 {
    public static void main(String[] args) {
      SmartTv stv = new SmartTv();
      stv.power(true); // Tv On
      stv.channel = 11; //채널 11번

      stv.channelUp();
      System.out.println(stv.channel + "번 : MBC"); //12

      stv.channelDown();
      System.out.println(stv.channel + "번 : JTBC"); //11

      stv.caption("stv.caption(자막) = flase");
      stv.caption = true;
      stv.caption("stv.caption(자막) = true;");

      stv.power(false); //Tv Off
    }
  }
  ```

## References
- [남궁성 , 자바의정석(기초)](https://www.youtube.com/user/MasterNKS) : ** 강의를 듣고 스스로 코드로 구현.**
- 🎈2020.10.26 
- [상속] - TV/OFF

![](https://images.velog.io/images/withcolinsong/post/8dc5159f-5174-49f0-8cca-748d6cd38345/image.png)
