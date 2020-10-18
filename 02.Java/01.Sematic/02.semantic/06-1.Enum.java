// 스스로 코드 짜보고 이해하기

public class EnumExample {
	public static final String sinMinA = "SinMinA";
	public static final String gongyu = "Gongyu";
	
	public static void main(String[] args) {
		// 열거형
		
		String celebrityFinal;
		celebrityFinal = EnumExample.sinMinA;
		celebrityFinal = "JeonJiHyun"; // 값이 변한다.
		System.out.println(celebrityFinal);
		
		celebrity celebrityEnum;
		celebrityEnum = celebrity.sinMinA;
		celebrityEnum = celebrity.gongyu;
    celebrityEnum = "JeonJiHyun"; //컴파일 오류
		System.out.println(celebrityEnum);

	}
}
enum celebrity {
	sinMinA,gongyu;
}
