package Day20.generics06;

class Box<T extends Number> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
}

public class BoundedBox {

	public static void main(String[] args) {
		Box<Integer> iBox = new Box<>();
		iBox.set(24);
		System.out.println(iBox.get());
	}
}
