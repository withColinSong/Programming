package Day19;
20.10.19

import java.net.InetAddress;
import java.util.Scanner;

public class TestInetAddress2 {

	public static void main(String[] args) throws Exception{
		
		do {
			System.out.println("호스트명 (종료 : none) : ");
			String host = new Scanner(System.in).next();
			if(host.equals("none") != true) {
				InetAddress[] ips = InetAddress.getAllByName(host);
				System.out.println(host + "가 가진 ip는 " + ips.length + "개 입니다.");

				for(InetAddress ip : ips) {
					System.out.println(ip.getHostAddress());
				}

			}else {
				break;
			}
			
		}while(true);
	}
}
