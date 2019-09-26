/****** Today Point *****
//User ����� : Provider ������

// class A{} , class B{}
// ���� : A�� B�� ����մϴ�.

// 1. ��� : A extends B
// 2. ���� : A { B b; }
// 			�κа� ��ü 

class B{}
class A{ // Composition
	int i ;
	B b; // ��������
	A() {
		b = new B();
	}
}

class A{ // Aggregation
	int i ;
	B b; // ��������
	A(B b) {
		this.b = b;
	}
}

3. ���� : �Լ� ���ο��� (method parameter) : ��������
 
class B{}
class A{ // Dependency //B b; //����ʵ忡 B �� ����.
	int i;
	
	void print(B b) {
	}
	B print() {
		B b = new B();
		return b;
	}
} 
 */

// ���� : �������迡�� Interface Ȱ��
interface Icall {
	void m();
}
class D implements Icall{
	@Override
	public void m() {
		System.out.println("D Icall �������̽��� m() ����");
	}
}

class F implements Icall{
	@Override
	public void m() {
		System.out.println("F Icall �������̽��� m() ����");
	}
}

//�������� ���α׷��� ���(Interface)
class C {
	void method(Icall ic) { //�����ϴ�
		ic.m();
	}
}

public class Ex05_User_Provider {

	public static void main(String[] args) {
		C c = new C(); // method �Լ��� �ִ� class
		c.method(new D()); // D Icall �������̽��� m() ����
		
		F f = new F(); // F Icall �������̽��� m() ����
		c.method(f);
		

	}

}
