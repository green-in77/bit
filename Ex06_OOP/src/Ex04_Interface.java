/*
인터페이스
범용적 의미
1. 사회적인 표준, 규칙, 규격, 규약 을 만드는 행위
ex) 신발사이즈, 나사, 
ex) ISO 표준을 지키는 회사라면...

소프트웨어 개발
2. 개발 단계의 최상위 모델 >> 요구사항 >> 설계(고려 인터페이스)
설계표준 -> 사용하는 쪽에 이행( 수행 ) 강제..

Interface
1. 실제 구현부가 없다. : 실행블럭이 없다. : 이동약속 : void move(int x, int y); >> 추상메소드
2. 표준화된 설계를 보장 ( 완벽한 강제성 )
3. 공통설계서

JAVA API (개발자가 필요한 인터페이스를 가지고 있다 : 인터페이스 기반으로 클래스 생성)
>> Collection ( 동적배열 ) > Vector, ArrayList, HashSet, HashMap ....
>> 작은 인터페이스를 여러개 모아서 사용 ( 재사용성 )

1. 생성방법 : public 인 이유 -> 강제 구현이 목적이기 때문에. 무조건 쓰라고..
상수(final) : public static final int VERSION = 1; >> int VERSION = 1; ( public static final 생략 )
함수(method) : public abstract void run(); >> void run(); ( public abstract 생략 )
함수(method) : String move(int x, int y);

 interface {
 	int VERSION = 1; //public static final int VERSION = 1;
 	void run(); //public abstract void run();
 	String move(int x, int y); 
 }

인터페이스는 객체 생성 불가 ( 상수를 제외한 나머지자원이 추상자원 ) >> JDK8 default static 제외하면..
 - 구현을 통해서만 사용가능 class Test implements Ia
 - 인터페이스 끼리는 다중 상속 가능. ( interface Iable extends Ia, Ib, Ic
 -Today Point ★★★★★ 인터페이스도 타입이다( 다형성 ) >> 부모타입 ★★★★★  
*/

interface Ia {
	//상수
	//public static final
	int AGE = 100;
	
	
	String GENDER = "남";
	
	//public abstract
	String print();
	void message(String str);
}

interface Ib {
	int AGE = 10;
	void info();
	String val(String s);
}

class Test2 implements Ia, Ib {

	@Override
	public void info() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String val(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void message(String str) {
		// TODO Auto-generated method stub
		
	}
	
}

public class Ex04_Interface {

	public static void main(String[] args) {
		Test2 t = new Test2();
		Ia ia = t;
		System.out.println(ia.AGE);
		
		Ib ib = t;
		System.out.println(ib.AGE);
		

	}

}
