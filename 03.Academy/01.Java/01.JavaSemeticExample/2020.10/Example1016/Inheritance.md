
### People.java

```java
class People {
	public String name;
	public String ssn;
	public int studentNo;
	
	public People(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
}

class Child extends People {
	public Child(String name, String ssn, int studentNo) {
		super(name, ssn);
		this.studentNo = studentNo;
	}
}
```

### main.java

```java
public class Ex09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubB a = new SubB("", "123456-123456", 1);
	}
}
```


### 내가 작성했던 코드
```java
class People {
	public String name;
	public String ssn;
	public int studentNo;
}

class People extends SuperA {

	public SubB() {
		this("", "", 1);
	}

	public SubB(String name, String ssn, int studentNo) {
		this.name = name;
		this.ssn = ssn;
		this.studentNo = studentNo;
		print();
	}

	void print() {
		System.out.println("이름 : "  + name);
		System.out.println("ssn : "  + ssn);
		System.out.println("학생번호 : " + studentNo);
	}
}
```
