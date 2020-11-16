package Day20.generics05;

class Box<T> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
	
}

public class BoxInBox {
	public static void main(String[] args) {
		//보안 때문에
		
		Box<String> sBox = new Box<>();
		sBox.set("I am so happy");
		
		Box<Box<String>> wBox = new Box<>();
		wBox.set(sBox);
		
		Box<Box<Box<String>>> zBox = new Box<>();
		zBox.set(wBox);
		
		System.out.println(zBox.get().get().get());
		
	}

}
