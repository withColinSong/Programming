package Practice0926;

public class Pratice02_03 {

	public static void main(String[] args) {
		// 1부터 100사이의 짝수를 출력하되 한 줄에 10개씩 출력하시오.

		int sum = 0;
		int count = 0;
		
		for(int i=2; i<=100; i+=2) {
			sum = i;
			count++;
			System.out.print(sum + " ");
			if(count % 10 == 0) {
				System.out.println();
			}

		}
	}

}
