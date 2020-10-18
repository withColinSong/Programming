# 1
package Ex1001;

public class Data {
	String name;
	public String main;  //멤버 필드에 public이라는 접근제어자를 입력하면 서로 다른 package 에서도 사용할 수 있다.
	int age;
	
```


# 2
import Ex1001.Data;

public class Test { //Test 클래스 안에서 Class Data의 멤버필드를 사용하고 싶을 때
	String name;
	int age;
	
	public static void main(String[] args) {
		
		Data a = new Data();
		a.main = "송";
    
	}
}


# 2-1
package Ex1001;

public class DataDriver {
	Data data = new Data(); //Data클래스의 멤버필드를 사용하기 위해 인스턴스를 생성했다.
	
	void print(String name, int age, String number) {
		data.name = name;
		data.age = age;
		System.out.println(data.name);
		System.out.println(data.age);
		System.out.println(number);
	}
	
}
