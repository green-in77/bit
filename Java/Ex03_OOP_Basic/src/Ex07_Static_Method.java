//*************static 함수 : 많이 사용한다면 편하게 사용하기 위해 생성 / 객체 생성 없이 (new 없이) 
class StaticClass {
	int iv ; //객체변수
	
	static int cv; //static 변수
	
	void m () { //일반 함수
		//1. iv 값을 처리 할 수 있다.
		//2. cv 값을 처리 할 수 있다. >> m 함수가 실행되기 전에 static 변수는 메모리에 생성되어 있다. // Today Point (생성시점)
		//static 자원은 일반자원보다 먼저 memory 에 올라간다.
		
		StaticClass.cv = 1000; // cv = 1000;		
	}
	
	static void sm() { // static 함수
		//1. iv 값을 처리 할 수 없다. 
		//			일반자원보다 먼저 메모리에 생성되기 때문에 객체변수는 사용할 수 없다. // 생성시점!!!
		// static 은 static 끼리 놀아라.( 그러면 error 는 없음)
		// 함수 입장에서 보면 iv 는 메모리에 없음.

		//2. cv 값을 처리 할 수 있다.
		StaticClass.cv = 2000;
		
	}
	
}

public class Ex07_Static_Method {

	public static void main(String[] args) {
		System.out.println(StaticClass.cv); // 0 - 함수는 불러야지만 실행됨.
		
		StaticClass.sm(); // new 하지 않아도 static 은 사용할 수 있다.
		System.out.println(StaticClass.cv); //2000
		
		StaticClass sc = new StaticClass();
		
		sc.m();
		System.out.println(sc.cv); // 1000
				
	}

}
