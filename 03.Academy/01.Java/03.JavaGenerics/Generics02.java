package Day20.generics04;

import java.util.ArrayList;

//클래스 기반으로 작성되는 제네릭
//형변환을 자동으로 해준다.

class DBox<L, R> extends Object { //<매개변수> 클래스만 매개변수로 받을 수 있다.
	private L left; // 왼쪽 수납공간
	private R right; //오른쪽 수납공간
	
	public void set (L o, R r) {
		left = o;
		right = r;
	}
	
	@Override
	public String toString() {
		return left + " & "  + right;
	}
}

public class MultiTypeParam {
	public static void main(String[] args) {
		DBox<String, Integer> box;
		box = new DBox<String, Integer>();
		//DBox<String, Integer> box = new DBox<생략가능>();
		box.set("Apple", 25);
		System.out.println(box.toString());
		
		ArrayList<DBox> arr = new ArrayList<DBox>();
		arr.add(box);
		System.out.println(arr.get(0));
	}
}
