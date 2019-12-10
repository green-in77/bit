package Aop_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {

		ApplicationContext context = new GenericXmlApplicationContext("classpath:Aop_anno/Ex.xml");
		
		Person person = context.getBean("boy", Person.class);
		person.something();
		System.out.println();
		
		person = context.getBean("girl", Person.class);
		person.something();
				
	}

}
