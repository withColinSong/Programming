package aop_step3;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	
	public Main() {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/aop_step3/aop_step3.xml");
		
		Dao dao = (Dao)context.getBean("proxy"); // 이 구문이 실행하면, xml bean들이 메모리에 싱글톤으로 올라간다.
		String result = dao.insert();
		System.out.println(result);
		//List<String> result2 = dao.select();
		//System.out.println(result2);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
