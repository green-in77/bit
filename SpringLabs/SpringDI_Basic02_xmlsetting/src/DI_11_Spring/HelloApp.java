package DI_11_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		
		//Spring
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_11_Spring/DI11.xml");//타입변환을 하지 않는 컨테이너 //패키지안에 xml
		DataSourceFactory factory = context.getBean("dataSourceFactory",DataSourceFactory.class);
		System.out.println(factory);
	}
}
