package Day20.generics01;

class Apple{
	public String toString() {
		return "Apple";
	}
}

class Orange{
	public String toString() {
		return "Orange";
	}
	
}

class AppleBox {
	private Apple ap; //객체만 선언 // 멤버 필드

	public Apple getAp() {
		return ap;
	}

	public void setAp(Apple ap) {
		this.ap = ap;
	}
	
}

class OrangeBox {
	private Orange org;

	public Orange getOrg() {
		return org;
	}

	public void setOrg(Orange org) {
		this.org = org;
	}
	
}

public class FruitAndBox {
	public static void main(String[] args) {
		//과일 담는 박스 생성
		AppleBox aBox = new AppleBox();
		OrangeBox oBox = new OrangeBox();
		
		//과일을 박스에 담는다
		aBox.setAp(new Apple());
		oBox.setOrg(new Orange()); //객체 연결
		
		//박스에서 과일을 꺼낸다
		Apple ap = aBox.getAp();
		Orange org = oBox.getOrg();
		
		System.out.println(ap);
		System.out.println(org);
	}

}

### package Day20.generics02;

class Apple {
	public String toString() {
		return "I am an Apple.";
		
	}
}

class Orange {
	public String toString() {
		return "I am an Orange.";
		
	}
}

class Box {
	private Object ob; //object 모든 클래스의 조상
	
	public void set(Object o) {
		ob = o;
	}
	
	public Object get() {
		return ob;
	}
}

public class FruitAndBox2 {

	public static void main(String[] args) {
		Box aBox = new Box();
		Box oBox = new Box();
		
		//과일을 박스에 담는다
		aBox.set(new Apple());
		oBox.set(new Orange()); //객체 연결
		
		//박스에서 과일을 꺼낸다
		Apple ap = (Apple)aBox.get(); //형변환
		Orange og = (Orange)oBox.get();
		
		System.out.println(ap);
		System.out.println(og);
	}

}

### package Day20.generics03;

class Apple {
	public String toString() {
		return "I am an Apple.";

	}
}

class Orange {
	public String toString() {
		return "I am an Orange.";

	}
}

class Box<T> {
	//Box<Apple> , Box<Orange>
	private T ob;

	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

public class FruitAndBox3 {

	public static void main(String[] args) {
		Box<Apple> aBox = new Box<Apple>();
		Box<Orange> oBox = new Box<Orange>();

		//과일을 박스에 담는다
		aBox.set(new Apple());
		oBox.set(new Orange()); //객체 연결

		//박스에서 과일을 꺼낸다
		Apple ap = aBox.get(); 
		Orange og = oBox.get();

		System.out.println(ap);
		System.out.println(og);
	}

}
