package Practice0926;

public class Pratice01_03 {

	public static void main(String[] args) {
		// 1 + 1/2 + 1/3 + ... 1/10의 합을 구하는 프로그램을 작성하시오.
		
		double sum = 0;
		for(int i=1; i<=10; i++) {
			sum = sum + (1/(double)i);
		
		}
		
		System.out.println(sum);
	}

}


package Practice0926;

public class Pratice01_05 {

	public static void main(String[] args) {
		// 100+97+94+91 ... +1 의 합을 구하는 프로그램을 작성하시오.
		
		int sum = 0;

		for(int i=100; i>=1; i-=3) {
			sum = sum + i;
			System.out.println( i + " = " + sum);
		}
		
		System.out.println("합계 : " + sum);
		
	}

}


