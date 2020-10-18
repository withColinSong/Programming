static을 붙이지 않으면 초기화가 된다.
프로그램 끝날 때 까지 존재.

package ex01_method;

class InstCnt {
	int instNum = 0;

	// static int instNum = 0; // 인스턴스3 
  
	InstCnt() {
		instNum++;  
		System.out.println("인스턴스 생성" + instNum);
	}
} 
public class ClassVar {
	public static void main(String[] args) {
		InstCnt cnt1 = new InstCnt();
		InstCnt cnt2 = new InstCnt();
		InstCnt cnt3 = new InstCnt();

	}
}
