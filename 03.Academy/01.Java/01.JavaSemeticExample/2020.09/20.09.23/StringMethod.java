package Ex_0923;

public class Sample5 {

	public static void main(String[] args) {

		String a = "hanna";
		String b = "point";
		String c = "hanna";
		
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		
		System.out.println(a.compareTo(b)); // 문자가 같으면 0
		System.out.println(a.compareTo(c)); //문자가 다르면 양수/음수
    
      String을 비교할 때 == 을 사용해선 안된다!

	}

}


package Ex_0923;

public class Sample6 {

	public static void main(String[] args) {
		
		String a =  new String("      C#");
		String b =  new String(", C++");
		
		System.out.println(a + "의 길이는 " + a.length());  //문자열의 길이
		System.out.println(a.contains("#")); //문자열을 포함하는지
		
		a = a.concat(b); //이어붙이기
		System.out.println(a);

		a = a.trim(); //공백 지우기
		System.out.println(a);
		
		a = a.replace("C#", "JAVA"); // 뒤바꾸기
		System.out.println(a);

	}

}
