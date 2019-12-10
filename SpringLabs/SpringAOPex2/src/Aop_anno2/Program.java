package Aop_anno2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		
		Drink drink = context.getBean("coffe", Drink.class);
		drink.menu();
		
		System.out.println("--------------------");
		System.out.println("자판기 변경");
		System.out.println("--------------------");
		
		drink = context.getBean("tea", Drink.class);
		drink.menu();
	}
}