package Ex0928_yj;

public class PraticeArr03 {

	public static void main(String[] args) {
		// 거꾸로 출력하기
		int a[] = new int[10];
		int b[] = new int[10];
		
		int i=0;
		for(i=0; i<a.length; i++) {
			a[i] = i + 1;
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		
		for(i=9; i>-1; i--) {
			b[i] = a[i];
			System.out.print(b[i] + " ");
		}

	}

}
