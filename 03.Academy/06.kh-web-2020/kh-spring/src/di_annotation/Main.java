package di_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {

		ApplicationContext context = new FileSystemXmlApplicationContext("src/di_annotation/di_anno.xml");
		MemberDao dao = context.getBean("dao", MemberDao.class);
		
	}
}
