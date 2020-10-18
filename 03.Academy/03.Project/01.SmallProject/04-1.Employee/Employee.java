package chapter01;
//실습 7.1: Employee.java
//직원을 나타낸다.

public class Employee
{
 public String name;	// 이름
 // 직원의 번호와 나이
 public int age;
 public int number;
 
		// 여기에 코드를 삽입하세요

 // -------------------------------------------------------
 //  새로운 Employee 객체를 생성한다.
 // -------------------------------------------------------
	public Employee( )
	{

	}

	// 접근자 메소드 - 이름을 반환한다
	public String getName( )
	{
		return name;
	}

	// 접근자 메소드 - 번호을 반환한다
	public int getNumber( )
	{
		// 여기에 코드를 삽입하세요
		return number;
	}

	// 접근자 메소드 - 나이를 반환한다
	public int getAge( )
	{
		// 여기에 코드를 삽입하세요
		return age;
	}

 //  현 Employee 객체의 정보에 대한 문자열을 반환한다.
 public String toString ()
 {
		// 여기에 코드를 삽입하세요
	return "이름: " + getName() 
	+ " 나이: " + getAge() + " 번호: " + getNumber();
 }

	// 변경자 메소드 - 이름을 주어진 값으로 변경한다
	public void setName(String Name)
	{
		this.name = Name;
	}

	// 변경자 메소드 - 번호을 주어진 값으로 변경한다
	public void setNumber(int Number)
	{
		// 여기에 코드를 삽입하세요
		this.number = Number;
	}

	// 변경자 메소드 - 나이를 주어진 값으로 변경한다
	public void setAge(int Age)
	{
		// 여기에 코드를 삽입하세요
		this.age = Age;
	}
}
