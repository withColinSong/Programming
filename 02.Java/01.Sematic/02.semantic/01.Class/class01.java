```java
package Ex0929;

public class Sample01 {
	int a = 10;

	public static void main(String[] args) {
	
		System.out.println(a); // a의 변수를 찾을 수 없다고 한다.
		
	}

}

----------------------------------------------------------------

package Ex0929;

public class Sample01 {
	static int a = 10; 
  
//static을 붙이면 Class의 멤버필드를 사용 할 수 있다.main method에서 사용할 수 있다.

	public static void main(String[] args) {
	
		System.out.println(a);
		
	}

}
```
