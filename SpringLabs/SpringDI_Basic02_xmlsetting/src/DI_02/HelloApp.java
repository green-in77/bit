package DI_02;

public class HelloApp {
	public static void main(String[] args) {
//		//영문
//		MessageBean_en messagebean_en = new MessageBean_en();
//		messagebean_en.sayHello("hong");
//		
//		//한글
//		MessageBean_kr messagebean_kr = new MessageBean_kr();
//		messagebean_kr.sayHello("hong");
		
//--------------------------------------------------------------------
		
		//interface 하나의 참조변수가 여러개의 주소를 가질 수 있다.(다형성)
		MessageBean messagebean = new MessageBean_en();
		messagebean.sayHello("hong");
		
		messagebean = new MessageBean_kr();
		messagebean.sayHello("hong");

	}
}
/*
요구사항
영문버전(hong) : Hello hong!
한글버전(hong) : 안녕 hong!

MessageBean_kr > 함수 > sayHello
MessageBean_en > 함수 > sayHello

interface 기반 설계 >> kr, en 에서 구현하도록.
	MessageBean > sayHello()

*/
