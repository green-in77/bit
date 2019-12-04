package DI_Annotation_02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		//1. java 코드 구현
		/*
		MonitorViewer viewer = new MonitorViewer();
		Recoder recoder = new Recoder();
		viewer.setRecoder(recoder);
		System.out.println(viewer.getRecoder());
		*/
		
		//2. Spring xml 구현
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_Annotation_02/DI_Annotation_02.xml");//타입변환을 하지 않는 컨테이너 //패키지안에 xml
		MonitorViewer viewer = context.getBean("monitorViewer", MonitorViewer.class);
		System.out.println(viewer.getRecoder());
		
		

	}

}
