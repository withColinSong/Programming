# 칭찬해!!!! 스스로 풀었다!

package Practice0926;

public class Practice02_01 {

	public static void main(String[] args) {
		// 22부터 76까지의 짝수의 개수와 그 합을 구하는 프로그램을 작성하시오.
		
		int sum = 0;
		int count = 0;
		
		for(int i=22; i<77; i+=2) {
			sum = sum + i;
			count++;
		}
		
		System.out.println("합계 : " + sum + "\n짝수의 개수 : " + count);
	}

}


package Practice0926;

public class Pratice02_02 {

	public static void main(String[] args) {
		//1부터 100사이의 합을 구하되 10단위마다 한번 씩 출력하시오.
		
		int sum = 0;
		int count = 0;
		
		for(int i=1; i<=100; i++) {
				sum = sum + i;
				count++;
				
				if(count % 10 == 0) {
					System.out.println(i + "번 출력 : " + sum);
				}
		}

	}

}
