package Aop_anno2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		
		Person person = context.getBean("boy", Person.class);
		person.something();
		System.out.println();
		
		person = context.getBean("girl", Person.class);
		person.something();
				
	}

}
