/*
 this : 객체 자신을 가르키는 this (this.empno ...)
 this : 생성자를 호출하는 this ( this(100,"홍길동") ) 
 
 상속
 부모 : 자식
 super (자식입장에서 보는 [부모의 주소] ): 상속관계에서 부모자원에 접근할 수 있는 키워드
 this 와 역할이 동일.
 
 super
 1. 상속관계에서 부모자원 접근
 2. 상속관계에서 부모 자원의 생성자 명시적으로 호출

TIP) C# >> base()
 
 */

class Base {
	String basename;
	
	Base() {
		System.out.println("Base 기본 생성자 호출");
	}
	
	Base(String basename){
		this.basename = basename;
		System.out.println("basename : " + this.basename);
	}
	void baseMethod() {
		System.out.println("baseMethod()");
	}
}

class Derived extends Base {
	String dname;
	
	Derived() {
		System.out.println("Derived 기본 생성자 호출");
	}
	Derived (String dname) {
		
		//super
		super(dname); // 부모인 base 에서 default 생성자가 실행되지 않고 오버로딩된 생성자가 실행됨.
		
		this.dname = dname;
		System.out.println("dname : " + this.dname);
	}
	
	void derivedMethod() {
		System.out.println("deribedMethod()");
	}
	
	//부모가 가지는 baseMethod() 재정의 (override)
	@Override
	void baseMethod() {
		//함수 내용은 자율.
		System.out.println("부모 함수 override");
	}
	
	void p_Method() {
		//super 부모객체의 주소를 이용해서 자원에 접근
		super.baseMethod(); //부모함수 호출)
	}
		
}
public class Ex06_Inherit_super {

	public static void main(String[] args) {
	//	Derived d = new Derived();
		//d.baseMethod();
		//d.derivdeMethod();
		
		Derived d2 = new Derived("홍길동");
		// 부모쪽에도 내가 처리하는 홍길동 넘겨서 overloading 된 
		d2.baseMethod(); // 재정의 한 함수만 호출
		
		//부모의 자원을 쓰고싶음. super 사용 (자식 클래스 내부에서 만들어 놔야함)
		d2.p_Method();
		
		

	}

}
