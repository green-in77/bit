//this
//1. ��ü �ڽ��� ����Ű�� this  ( ������ ������ ��ü�� �ּҸ� ���� ���̶�� �����ϰ� ���)
//2. this ��ü �ڽ� ( �����ڸ� ȣ��) : ��Ģ (�����ڴ� ��ü������ �ϳ��� ȣ�� ����) 
//		���������� this �� ����ϸ� �������� �����ڸ� ȣ�� ����
class Test6 {
	int i;
	int j;
	Test6() { // default ������ // default Test6() { }
		
	}
	// parameter �� �������ϰ� instance variable  �������� �ٸ��� ����ϸ� ������ ������....
	// ������ �ϴٺ��� (�ǹ��ִ� ������) >> ������ >> �������� ���ϴ���...
	// �������� ���� ���ٺ���....������ �Ȱ�. 
	// int i; ������ ������ ��ü�� memberfield �� �ƴϳ� �̸� �����پ���.
	// this Ű���� >> Test6 t = new Test6();
	Test6(int i, int j) {
		this.i = i;
		this.j = j;
		
		//i = i; i �� ����� i���� �� �� ����.
		//j = j;
	}
}
//Today point (���׷��̵� ��ų �� �ִ� �ڵ�..)
class soCar{ //member filed �� private �� �ƴ�.
	String color;
	String gearType;
	int door;
	
	soCar() { //������
		this.color = "RED";
		this.gearType = "auto";
		this.door = 2;
	}
	
	soCar(String color, String gearType, int door ) { //������ �����ε�
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	void print() {
		System.out.println(this.color + "/" + this.gearType + "/" + this.door);
	}
}


public class Ex15_this {

	public static void main(String[] args) {
		Test6 t6 = new Test6();
		Test6 t7 = new Test6(100, 200);
		
		System.out.println(t7.i + "/ " + t7.j);

		soCar so = new soCar();
		so.print();
		
		soCar so2 = new soCar("Green","auto", 4);
		so2.print();

	}

}
