```
public class Ex23 {
  static int a = 10; // 멤버필드✌

  public static void main(String[] args) {
    
   //int a = 22; //지역변수☝
    
  //main 메소드에서 클래스 변수일 때 (= static) 
  //Local Variable을 찾은 후 a의 값이 없다면 멤버필드에서 값을 찾는다.
    
    
    System.out.println(a);
    
    
    final double PI = 3.14;
    System.out.println(PI);
    
  }
}   
