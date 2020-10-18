import java.util.Scanner;

public class ClassArray {

	public String name;
	public int NumberSum;
	public String titleSong;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ClassArray[] array = new ClassArray[3]; // 저장 공간만 확보.
 
		
		array[0] = new ClassArray(); //확실하게 배열을 만든다. 
		array[1] = new ClassArray();
		array[2] = new ClassArray();
    array[3] = new ClassArray(); //array[3] 오류 

		for(int i=0; i<array.length; i++) {
			System.out.println("가수를 입력해주세요. ");
			array[i].name = scan.next();
		}
		
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i].name);
		} //출력

	}

}
