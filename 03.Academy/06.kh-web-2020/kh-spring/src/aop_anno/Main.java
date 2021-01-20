package aop_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public Main() {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("src/aop_anno/aop_anno.xml");
		Product product = (Product)context.getBean("RadioProduct");
		
		System.out.println("──────────────────────");
		product.select("s");
		System.out.println("──────────────────────");
		product.insert("");
		System.out.println("──────────────────────");	
	}
	
	public static void main(String[] args) {
		new Main();
		
	}
	
	

}
