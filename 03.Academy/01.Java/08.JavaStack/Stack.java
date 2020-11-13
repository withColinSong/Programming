package Day38;

public interface Stack<T> {
	
	//@param value 값을 넣는다
	void push(T value);
	
	
	
	
	// @ return 꼭대기에 있는 값을 꺼낸다
	T pop();
	
	
	
	// @ return 비어있으면 true
	boolean isEmpty();
	
	
}

/*

# 스택연산
- void push(T value)
- T pop()

# 스택 연산 동작 과정

push(10)
push(20)
push(30)

pop() - 30
pop() - 20
pop() - 10


*/
