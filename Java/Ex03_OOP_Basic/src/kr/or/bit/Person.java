package kr.or.bit;
// Ŭ���� == ���赵 == Type
// ���赵�� ��üȭ(�޸𸮿� �÷���)�� ���ؼ� ��ü�� �����Ǿ�� �Ѵ�.
// ��üȭ�� ���� >> ��ü(�ν��Ͻ�)
// ���赵�� ������ �⺻���� ������� (�ʵ� + ������ + �Լ�)

// class Tire { }
// class Car { Tier tire; }
// class Window { int i; }

public class Person {
	public String name; // instance variable (��ü����) �ʱ�ȭ�� ���� �ʾƵ� �ȴ�. �⺻��(default)�� ����. // String = Null
	public int age; // ������(public) // �⺻�� int = 0
	
	public void print() { // ���(����=�޼ҵ�=�Լ�)
		System.out.println( name + " / " + age );
	}
}
