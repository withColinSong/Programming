package Ex0928_yj;

public class PracticeArr04 {

	public static void main(String[] args) {
		// A와 B의 배열의 합을 C배열 자리에 입력하기.
		 int[] A = {1,2,3,4,5,6,7,8,9,10};
		 int[] B = {1,5,3,4,5,6,7,8,9,10};
		 int[] C = new int[10];
		 
		 int sum = 0;
		 int i=0;
	
		 
		 for(i=0; i<A.length; i++) {
			 C[i] = A[i] + B[i];
			 System.out.println(A[i] + " + " + B[i] + " = " + C[i] );
		 }
		 
		 
	}

}
