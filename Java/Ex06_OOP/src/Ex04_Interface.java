/*
�������̽�
������ �ǹ�
1. ��ȸ���� ǥ��, ��Ģ, �԰�, �Ծ� �� ����� ����
ex) �Ź߻�����, ����, 
ex) ISO ǥ���� ��Ű�� ȸ����...

����Ʈ���� ����
2. ���� �ܰ��� �ֻ��� �� >> �䱸���� >> ����(��� �������̽�)
����ǥ�� -> ����ϴ� �ʿ� ����( ���� ) ����..

Interface
1. ���� �����ΰ� ����. : ������� ����. : �̵���� : void move(int x, int y); >> �߻�޼ҵ�
2. ǥ��ȭ�� ���踦 ���� ( �Ϻ��� ������ )
3. ���뼳�輭

JAVA API (�����ڰ� �ʿ��� �������̽��� ������ �ִ� : �������̽� ������� Ŭ���� ����)
>> Collection ( �����迭 ) > Vector, ArrayList, HashSet, HashMap ....
>> ���� �������̽��� ������ ��Ƽ� ��� ( ���뼺 )

1. ������� : public �� ���� -> ���� ������ �����̱� ������. ������ �����..
���(final) : public static final int VERSION = 1; >> int VERSION = 1; ( public static final ���� )
�Լ�(method) : public abstract void run(); >> void run(); ( public abstract ���� )
�Լ�(method) : String move(int x, int y);

 interface {
 	int VERSION = 1; //public static final int VERSION = 1;
 	void run(); //public abstract void run();
 	String move(int x, int y); 
 }

�������̽��� ��ü ���� �Ұ� ( ����� ������ �������ڿ��� �߻��ڿ� ) >> JDK8 default static �����ϸ�..
 - ������ ���ؼ��� ��밡�� class Test implements Ia
 - �������̽� ������ ���� ��� ����. ( interface Iable extends Ia, Ib, Ic
 -Today Point �ڡڡڡڡ� �������̽��� Ÿ���̴�( ������ ) >> �θ�Ÿ�� �ڡڡڡڡ�  
*/

interface Ia {
	//���
	//public static final
	int AGE = 100;
	
	
	String GENDER = "��";
	
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
