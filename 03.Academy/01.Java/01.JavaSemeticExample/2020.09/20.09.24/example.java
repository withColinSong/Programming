
for / while 문

# example01

package Ex_0924;

public class ex01 {

	public static void main(String[] args) {
		// 1에서 20까지의 수 중 홀수의 합을 구하시오.
		
		int sum = 0;
		for(int i = 1; i <= 20; i+=2) {
			if (i % 2 != 0) {
				sum = sum + i;
			}
		} 
		System.out.println(sum);
		
		
		// 선생님코드
//		int sum = 0;
//		for(int i = 0; i < 21; i++) {
//			if (i % 2 == 1) {
//				sum = sum + i;
//			}
//		} 
		

	}

}


# example02
package Ex_0924;

public class ex02 {

	public static void main(String[] args) {
		// 1에서 20까지의 수 중 홀수의 합을 구하시오. (while + if)
		
		int sum = 0;
		int i = 1;
		while(i < 21) {
			if (i % 2 != 0) {
				sum = sum + i;
				i+=2;
			}
		}
		System.out.println("1에서 20까지의 수 중 홀수 합계 : " + sum);
		
		//선생님 코드	
//		int i = 0;
//		int sum = 0;
//		while(i < 21) {
//			if (i % 2 == 1) {
//				sum = sum + i
//			}
//			i++;
//		}
	}

}

#

