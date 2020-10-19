  package Day19;
  //20.10.19

  import java.net.URL;

  public class URLEx {
    public static void main(String[] args) {
      URLEx u = new URLEx();
      u.testURLExample("https://www.naver.com");
    }
    public void testURLExample(String urlStr) {
      System.out.println(urlStr);
      URL url;

      try {
        url = new URL(urlStr);
        System.out.println(url.getProtocol()); // https
        System.out.println(url.getPort()); // -1
        System.out.println(url.getHost()); //www.naver.com
        System.out.println(url.getFile()); 
        System.out.println(url.toExternalForm());// http://www.naver.com
      }catch (Exception e){
        e.printStackTrace();
      }
    }
  }
