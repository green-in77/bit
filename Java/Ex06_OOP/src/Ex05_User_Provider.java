/****** Today Point *****
//User 사용자 : Provider 제공자

// class A{} , class B{}
// 관계 : A는 B를 사용합니다.

// 1. 상속 : A extends B
// 2. 포함 : A { B b; }
// 			부분과 전체 

class B{}
class A{ // Composition
	int i ;
	B b; // 참조변수
	A() {
		b = new B();
	}
}

class A{ // Aggregation
	int i ;
	B b; // 참조변수
	A(B b) {
		this.b = b;
	}
}

3. 포함 : 함수 내부에서 (method parameter) : 의존관계
 
class B{}
class A{ // Dependency //B b; //멤버필드에 B 가 없음.
	int i;
	
	void print(B b) {
	}
	B print() {
		B b = new B();
		return b;
	}
} 
 */

// 목적 : 의존관계에서 Interface 활용
interface Icall {
	void m();
}
class D implements Icall{
	@Override
	public void m() {
		System.out.println("D Icall 인터페이스의 m() 구현");
	}
}

class F implements Icall{
	@Override
	public void m() {
		System.out.println("F Icall 인터페이스의 m() 구현");
	}
}

//현대적인 프로그래밍 기법(Interface)
class C {
	void method(Icall ic) { //유연하다
		ic.m();
	}
}

public class Ex05_User_Provider {

	public static void main(String[] args) {
		C c = new C(); // method 함수가 있는 class
		c.method(new D()); // D Icall 인터페이스의 m() 구현
		
		F f = new F(); // F Icall 인터페이스의 m() 구현
		c.method(f);
		

	}

}
