package DI_05_Spring;

import java.io.ObjectInputStream.GetField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		
		//java
		/*
		MyBean mybean = new MyBean();
		MyBean mybean2 = new MyBean("hong");
		
		Singleton single = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		
		//주소값
		System.out.println("mybean : " + mybean);
		//DI_05_Spring.MyBean@15db9742
		System.out.println("mybean2 : " + mybean2);
		//DI_05_Spring.MyBean@6d06d69c
		
		System.out.println("single : " + single);
		//DI_05_Spring.Singleton@7852e922
		System.out.println("single2 : " + single2);
		//DI_05_Spring.Singleton@7852e922
		*/
		
		//Spring
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_05_Spring/DI05.xml");//타입변환을 하지 않는 컨테이너 //패키지안에 xml
		/*
		 	스프링 컨테이너가 구성되고 xml 파일을 read 해서 파싱한 후 객체 생성하고 생성된 객체를 조립(주입)
		 	
		 	>> 컨테이너 안에 객체가 생성되어 있음 -> 필요한 객체를 불러내서 사용
		 	getBean() : return Object Type 객체 >> down casting
		 	**주의 : getBean()은 호출시에 새로운 객체를 만들지 않는다. (특정 설정을 통해 만들게 할 수 있지만 거의 쓰이지 않음..)
		 	**스프링 컨테이너가 가지는 객체의 타입은 : default singleton
		 	*************예외적으로 getBean()가 객체를 생성하게 할 수 있다.
		 	
		*/
		MyBean mybean = context.getBean("mybean",MyBean.class);
		MyBean mybean2 = context.getBean("mybean",MyBean.class);
		MyBean mybean3 = context.getBean("mybean",MyBean.class);
		System.out.println(mybean + " / " + mybean2 + " / " + mybean3); //주소값 동일하다
		//객체가 만들어진 시점이 xml read이기 때문에... get은 만들어진 객체를 가져오는 것 : 모든 객체를 싱글톤처럼 생각함.
		
		MyBean mybean4 = context.getBean("mybean2",MyBean.class);
		System.out.println(mybean + " / " + mybean4); //주소값 다르다 / xml에서 별도로 생성된 다른 객체
		
		Singleton single = context.getBean("single",Singleton.class);
		Singleton single2 = context.getBean("single",Singleton.class);
		System.out.println(single + " / " + single2);
		
	}
}
