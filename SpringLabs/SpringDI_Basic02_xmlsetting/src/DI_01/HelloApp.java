package DI_01;

public class HelloApp {
	public static void main(String[] args) {
		MessageBean messagebean = new MessageBean();
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
