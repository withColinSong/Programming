package aop_exam2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	
	
	public Main() {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("src/aop_exam2/aop_exam2.xml");
		
		Product product = (Product) context.getBean("proxy");
		product.insert("song");
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
