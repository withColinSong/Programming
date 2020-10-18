
public class Pro01 {
	int a,b;
	
	static int divide(int a, int b) {
		return a/b;
	}
	
	static double divide(double a, double b) {
		return a/b;
	}
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = divide(10, 4);
		double result2 = divide(10.0, 4.0);
		
		System.out.println("result : " + result);
		System.out.println("result2 : " + result2);

	}

}
