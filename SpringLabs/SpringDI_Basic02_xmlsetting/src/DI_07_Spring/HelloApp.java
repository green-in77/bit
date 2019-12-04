package DI_07_Spring;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		/*
		ProtocolHandler handler = new ProtocolHandler();
		
		List<MyFilter> list = new ArrayList<MyFilter>();
		list.add(new EncFilter());
		list.add(new HeaderFilter());
		list.add(new ZipFilter());
		
		handler.setFilters(list); //List 주입(setter)
		
		System.out.println(handler.filter_length());
		*/
		
		//Spring
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_07_Spring/DI07.xml");//타입변환을 하지 않는 컨테이너 //패키지안에 xml
		ProtocolHandler handler = context.getBean("handler",ProtocolHandler.class);
		System.out.println(handler.filter_length());
		
	}
}
