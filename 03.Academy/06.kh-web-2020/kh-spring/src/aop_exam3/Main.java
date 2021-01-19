package aop_exam3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public Main() {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("src/aop_exam3/aop_exam3.xml");
		Product product = (Product)context.getBean("RadioProduct");
	
		product.select("s");
		//product.insert("");
		
	}
	
	public static void main(String[] args) {
		new Main();
		
	}
	
	

}
