import java.util.Scanner;

public class array01 {

	public static void main(String[] args) {

		방법1. 
		//		int[][] arrInt01 = 
			{{1,2,3,4}, //0.0/0,1/0,2/0,3/0,4;
			{4,5,6,8},// 1,0/1,1/1,2/1,3/1,4;
			{9,10,11,12}};//2,0/2,2/2,3/2,4;


			방법2.
			int [][] arrInt = new int[5][5];

			int i=0; 
			int j=0;

			for(i=0; i<arrInt.length; i++) {
				for(j=0; j<arrInt[i].length; j++) {
					arrInt[i][j] = 1+j;
					System.out.print(arrInt[i][j] + " ");
				}
			}
	}

}
