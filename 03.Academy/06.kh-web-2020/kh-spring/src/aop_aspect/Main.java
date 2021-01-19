package aop_aspect;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	
	public Main() {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/aop_aspect/aop_aspect.xml");
		
		Dao dao = (Dao)context.getBean("bDao"); // 이 구문이 실행하면, xml bean들이 메모리에 싱글톤으로 올라간다.
		List<String> result2 = dao.select();
		//System.out.println(result2);
		//String result = dao.insert();
		//System.out.println(result);
		//String str = dao.insert();
		
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
