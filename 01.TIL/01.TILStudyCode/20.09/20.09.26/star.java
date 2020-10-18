
public class star {

	public static void main(String[] args) {
		
		// 비교 연산자에 따라 범위 값을 여러가지 방법으로 지정할 수 있다.
		
		//1번 방법 
			for(int i=1; i<=5; i++){
			for(int j=1; j<=6-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//2번 방법
		for(int i=1; i<6; i++){
			for(int j=1; j<=6-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//3번 방법
		for(int i=1; i<7; i++){
			for(int j=1; j<7-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
    
    

    ```
    *****
    ****
    ***
    **
    *
    ```
