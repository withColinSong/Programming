package Day38;

import java.util.Arrays;

public class StackImpl<T> implements Stack<T> {

	private static final int DEFAULT_SIZE = 5;


	//제너릭에서 배열을 지원하지 않기 때문에 object로 배열을 만들었다.
	private Object[] array = new Object[DEFAULT_SIZE];
	private int top = 0;
	private int currentCapacity = DEFAULT_SIZE; //크기 지정하는 변수지정


	@Override
	public void push(T value) {
		ensureCapacity();
		array[top++] = value;
	}


	private void ensureCapacity() {
		// 1. 배열이 꽉찼는지 검사
		if( top >= DEFAULT_SIZE) {

			// 2. 꽉찬 배열을 늘림
			array = Arrays.copyOf(array, currentCapacity * 2);

			// 3. 현재 최대 용량 값 늘림
			currentCapacity *= 2;
		}
	}


	@SuppressWarnings("unchecked")
	//return (T) result에 대한 타입캐스팅에 오류를 알고있냐라고 물어봐서 그 알람을 잠재우는 역할;
	@Override

	public T pop() {
		if(top <= 0) {
			return null;
		}
		top -= 1;
		Object result = array[top];
		array[top] = null;
		return (T) result;
	}

	@Override
	public boolean isEmpty() {
		return array[0] == null;

	}


}
