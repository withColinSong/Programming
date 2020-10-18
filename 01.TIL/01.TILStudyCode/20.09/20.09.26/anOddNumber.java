package Practice0926;

public class Pratice02 {

	public static void main(String[] args) {
		// 1에서 20까지의 수 중 홀수의 합을 구하시오. (for와 if문 사용)


		//for문으로 만
		int sum = 0;
		for(int i=1; i<21; i+=2) {
			sum = sum + i;
      
      //console창에 띄우지 않고 생각해봄
			//i를 0으로 시작했을 때.
			// 0 + 0 = 0; 
			// 0 + 1 = 1;
			// 1 + 2 = 3;
			// 3 + 3 = 6;

			//i를 1로 시작했을 때.
			// 0 + 1 = 1;
			// 1 + 1 = 2;
			// 2 + 2 = 4;

			//i를 1로 시작하고 i+=2로 했을 때.
			// 0 + 1 = 1;
			// 1 + 2 = 3;
			// 3 + 4 = 7;
			// 7 + 6 = 11; ....
		}

		System.out.println("1에서 20까지의 수 중 홀수 합계 : " + sum);


  //for + if
		int sum01 = 0;
		for(int i = 1; i<21; i++ ) {
			if(i % 2 != 0) {
				sum01 = sum01 + i;
			}

		}
		System.out.println("1에서 20까지의 수 중 홀수 합계 : " + sum01);
	}

}
