public class Application_Stack {

	public static void main(String[] args) {
		
		final Stack<Integer> Stack = new StackImpl<>();
		
		Stack.push(10);
		Stack.push(20);
		Stack.push(30);
		Stack.push(40);
		Stack.push(50);
		Stack.push(60);
	
		System.out.println(Stack.pop()); //60
		System.out.println(Stack.pop()); //50
		System.out.println(Stack.pop()); //40
		System.out.println(Stack.pop()); //30
		System.out.println(Stack.pop()); //20
		System.out.println(Stack.pop()); //10
		System.out.println(Stack.pop()); null
		System.out.println(Stack.pop()); null
		
	
	}

}
