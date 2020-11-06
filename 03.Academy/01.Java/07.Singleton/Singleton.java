import java.util.ArrayList;
import java.util.List;

public class Singleton {

	private static Singleton INSTANCE = new Singleton();
	
	private String name = "넹";
	private List<String> data = new ArrayList<>();
	
	private Singleton() {
		// 외부 생성 막기
		
	}
	
	public static Singleton getInstance() {
		return INSTANCE;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void addToList(String element) {
		data.add(element);
	}
	
	public void showList() {
		data.forEach(System.out::println);
	}
}
