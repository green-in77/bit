package DI_09_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		/*
		ProtocolHandlerFactory factory = new ProtocolHandlerFactory();
		Map<String, ProtocolHandler> map = new HashMap<String, ProtocolHandler>();
		map.put("rss", new RssHandler());
		map.put("Rest", new RestHandler());
		
		factory.setHandlers(map);
		*/
		//Spring
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_09_Spring/DI09.xml");//타입변환을 하지 않는 컨테이너 //패키지안에 xml
		
	}
}
