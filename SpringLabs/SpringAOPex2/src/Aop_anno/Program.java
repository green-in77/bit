package Aop_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:Aop_anno/Ex.xml");
		
		Drink drink = context.getBean("coffe", Drink.class);
		drink.menu();
		
		System.out.println("--------------------");
		System.out.println("자판기 변경");
		System.out.println("--------------------");
		
		drink = context.getBean("tea", Drink.class);
		drink.menu();
	}
}