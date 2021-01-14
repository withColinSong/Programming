package di_step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// 스프링이 제공해주는 DI의 기본
public class Assembler {
	DB db;
	
	public DB getDb() {
		// 객체 생성을 -> di_step4.xml한다.
		ApplicationContext context = new FileSystemXmlApplicationContext("src/di_step4/di_step4.xml"); // xml의 경로
		
		db = context.getBean("db", DB.class); // or db = (DB)context.getBean("db");
		
		return db;
	}
	
}
