/*
 OOP Ư¡
 1. ���
 2. ĸ��ȭ(����ȭ)
 3. ������
 
 1. ���
 java >> child extends Base
 c#    >> child : Base
 
 2. ��� Ư¡
 2.1 ���߻���� �Ұ���
 2.2 ���ϻ�� ����(�������� Ŭ������ ��ӹ������� : ������ ���(�ǹ��� / �Ҿƹ��� -> �ƹ��� -> �� ))
 2.3 ���߻���� ����(�����ϰ� interface)
 
 3. ��� �ǹ�
 ������ �ǹ� : ���뼺
 ���� : �ʱ���(����)
 
 ���뼺 >> ���� >> ���(�ð�, �����ڿ�(�и�, �߻�ȭ))
 
 4. ��� ���迡�� memory ����
 		GrandFather >> Father >> Child ������ heap memory
 		
		����ڰ� ����� ��� Ŭ������ default object ���.
		GrandFather extends Object �� ��� >> �ֻ����� �� object ��� / extends Object 
 	
 */

class GrandFather {
	public GrandFather () {
		System.out.println("�Ҿƹ��� ������");
	}
	public int gmoney = 5000;
	private int pmoney = 10000; //private ��Ӱ��迡�� ���� �Ұ�.
}

class Father extends GrandFather {
	public Father () {
		System.out.println("�ƹ��� ������");
	}
	public int fmoney = 1000;
}

class Child extends Father {
	public Child () {
		System.out.println("�ڽ� ������");
	}
	public int cmoney = 100;
}

public class Ex01_Inherit {

	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child.gmoney); // �Ҿƹ��� �� ����
		System.out.println(child.fmoney); // �ƹ��� �� ����
		System.out.println(child.cmoney); // �� ���� ����
		

	}

}
