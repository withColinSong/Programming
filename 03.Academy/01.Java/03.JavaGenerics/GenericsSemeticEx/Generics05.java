package Day20.generics07;

interface Eatable {
	public String eat(); //인터페이스
}

class Apple implements Eatable { // 인터페이스를 구현한 Apple
	public String toString() {
		return "I am an Apple.";
	}
	
	@Override
	public String eat() {
		return "It tastes so good!";
	}
}

class Box<T extends Eatable> { //Eatable를 상속받은 T
	//인터페이스는 상속 받을 수 없다.
	//Eatable를 구현받은 클래스만 올 수 있다.
	
	private T ob;
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
	
}

public class BoudendInterfaceBox {

	public static void main(String[] args) {
		Box<Apple> box = new Box<>();
		//아직은 Apple은 안만들어짐
		
//		private Apple ob;
//		public void set(Apple o) {
//			ob = o;
//		}
//		
//		public Apple get() {
//			return ob;
//		}
		
		box.set(new Apple());
		//이 때 만들어진다.
		
		Apple ap = box.get();
		System.out.println(ap);
		
	}

}
