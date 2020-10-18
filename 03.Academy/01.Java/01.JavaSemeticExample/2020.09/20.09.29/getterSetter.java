
package com.ex01;

public class Data {

	private String name;
	int age;
	
	public Data() {
		//없어도 자동으로 생김.
		System.out.println("Data 클래스 생성자 동작.");
		System.out.println(getName());
	}
	
	public String getName() { //같은 클래스 내에서는 private도 사용할 수 있다.)
		return name;
	}
	
	public void setName(String name) { // String name을 받아서 다시 저장할 필요가 없다.
		this.name = name; //같은 이름이지만 Data 안에 name을 쓴다.
	 //	name = name
		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

    //메인
	public static void main(String[] args) {

		Data d = new Data();
		d.setAge(10);
		d.setName("김자바"); 
		
		d.name = "송자바";  // private일 때 쓸 수 없다.
		d.age = 13; 
		System.out.println(d.getAge()); //private의 가져올 때 getter
		System.out.println(d.getName());
	}

}
