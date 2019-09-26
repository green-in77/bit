/*
 this : ��ü �ڽ��� ����Ű�� this (this.empno ...)
 this : �����ڸ� ȣ���ϴ� this ( this(100,"ȫ�浿") ) 
 
 ���
 �θ� : �ڽ�
 super (�ڽ����忡�� ���� [�θ��� �ּ�] ): ��Ӱ��迡�� �θ��ڿ��� ������ �� �ִ� Ű����
 this �� ������ ����.
 
 super
 1. ��Ӱ��迡�� �θ��ڿ� ����
 2. ��Ӱ��迡�� �θ� �ڿ��� ������ ��������� ȣ��

TIP) C# >> base()
 
 */

class Base {
	String basename;
	
	Base() {
		System.out.println("Base �⺻ ������ ȣ��");
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
		System.out.println("Derived �⺻ ������ ȣ��");
	}
	Derived (String dname) {
		
		//super
		super(dname); // �θ��� base ���� default �����ڰ� ������� �ʰ� �����ε��� �����ڰ� �����.
		
		this.dname = dname;
		System.out.println("dname : " + this.dname);
	}
	
	void derivedMethod() {
		System.out.println("deribedMethod()");
	}
	
	//�θ� ������ baseMethod() ������ (override)
	@Override
	void baseMethod() {
		//�Լ� ������ ����.
		System.out.println("�θ� �Լ� override");
	}
	
	void p_Method() {
		//super �θ�ü�� �ּҸ� �̿��ؼ� �ڿ��� ����
		super.baseMethod(); //�θ��Լ� ȣ��)
	}
		
}
public class Ex06_Inherit_super {

	public static void main(String[] args) {
	//	Derived d = new Derived();
		//d.baseMethod();
		//d.derivdeMethod();
		
		Derived d2 = new Derived("ȫ�浿");
		// �θ��ʿ��� ���� ó���ϴ� ȫ�浿 �Ѱܼ� overloading �� 
		d2.baseMethod(); // ������ �� �Լ��� ȣ��
		
		//�θ��� �ڿ��� �������. super ��� (�ڽ� Ŭ���� ���ο��� ����� ������)
		d2.p_Method();
		
		

	}

}
