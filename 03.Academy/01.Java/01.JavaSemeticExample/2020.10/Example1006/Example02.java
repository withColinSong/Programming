7. 다음 프로그램에서 잘못된 부분을 모두 지적하고 올바르게 수정하시오. 그리고 수정된 후의 출력 결과를 쓰시오. 


class Television {
 private String model;
 void setModel(String b) { // 설정자
 model = b;
 }
 void getModel() { // 접근자
 return model;
 }
}


  public class TelevisionTest {
   public static void main(String[] args){
   Television t = new Television;
   t.setModel("STV-101");
   String b = getModel();
   }
  }



# 완성된 
package test02;

class Televison {
	private String model;
	
	void setModel(String b) {
		
		model = b;
	}
	
	String getModel() {
		return model;
	}
	
	
}

public class Ex07 {

	public static void main(String[] args) {
		Televison t = new Televison();
		
		t.setModel("STV-101");
		String b =  t.getModel();
		System.out.println(b);

	}

}
