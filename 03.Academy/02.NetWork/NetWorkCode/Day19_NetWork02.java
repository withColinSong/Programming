  package Day19;
  20.10.19

  import java.net.InetAddress;
  import java.net.UnknownHostException;

  public class InetAddressEx {
    InetAddress ip = null;
    String ip1 = null;
    String ip2 = null;

    public void testInetAddress() throws UnknownHostException  { //throw 던져주다
      //오류를 처리해주는 조상 Exception
      ip = InetAddress.getLocalHost(); //IP주소 얻어온다.	
      System.out.println(ip); //로컬 호스트 주소
      ip1 = ip.getHostAddress();
      System.out.println("ip1 : "+ip1); //호스트 주소
      System.out.println("------");
      ip2 = ip.getHostAddress();
      System.out.println("ip2 : "+ip2);

  //		System.out.println(ip.getHostName());
  //		System.out.println(ip.getHostAddress());
      System.out.println("ip.toString() : " +ip.toString());
      System.out.println("ip1.toString() : "+ ip1.toString());
      System.out.println("ip2.toString() : "+ ip2.toString());
    }


    @Override
    public String toString() { 
  //		return "InetAddressEx [ip=" + ip + ", ip1=" + ip1 + "]";
      return "ip주소 확인하는 중 ....";
    }


    public static void main(String[] args) throws UnknownHostException{
  //		InetAddressEx inet = new InetAddressEx().testInetAddress; //1번 방법
  //		inet.testInetAddress();
  //		System.out.println(inet.toString());
      new InetAddressEx().testInetAddress(); //2번 방법 생성자.메소드
    }
  }
