package Practice0927;

public class array03 {

	public static void main(String[] args) {
		// 어떻게 하면 인터넷에서 판매되는 TV를 최소 가격으로 구할 수 있을까?
		
		int min = 5000000;
		int [] prices = {100000, 300, 500000, 300000, 50};
		
		for(int i=0; i<prices.length; i++) {
			if(min > prices[i]) {
				min = prices[i];
			}	
		}
		
		System.out.println("인터넷 TV 최소 가격은? " + min);
	}

}
