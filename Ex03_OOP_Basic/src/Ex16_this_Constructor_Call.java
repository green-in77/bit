// 2. this ( �����ڸ� ȣ���ϴ� this)
// ��Ģ : �����ڴ� ��ü ������ �Ѱ��� ȣ�Ⱑ��
// this (������ ������ ��ü�� �ּҸ� ������ ����) : �������� ������ �Լ��� ȣ��......

// *****                                             ******
class Zcar {
	String color;
	String geartype;
	int door;
	
	Zcar() {
		//this.color = "RED";
		//this.geartype = "auto";
		//this.door = 4;
		
		this("red", "autp", 4); // ���� �ٽ� �θ��� ��. //�����ε� �� �����ڷ� Ƣ�. �Լ��̱⶧���� ���ٰ� �ٽ� �ͼ� ������ �ڵ带 ������.
		
		//new Zcar ("dd", "aaa", 10); �����ؼ�
		// this �� ��ü �ڽ��� ����Ű�� ������ �ٸ� �����ڸ� ȣ���� �� �ִ�.
		//Ȯ������
		System.out.println("default constructor");
		
	}
	
	Zcar(String color, String geartype, int door) {
		this.color = color;
		this.geartype = geartype;
		this.door = door;
		System.out.println("overloading constructor");
	}
	
	void print() {
		System.out.println(this.color + "/" + this.geartype + "/" + this.door);
	}
}

class Zcar3 {
	String color;
	String geartype;
	int door;
	
	Zcar3 () {
		this("red", 1);
		System.out.println("default constructor");
	}
	Zcar3(String color, int door) {
		this(color, "auto",door);
		System.out.println("overloading constructor param 2��");
	}
	
	Zcar3(String color, String geartype, int door) {
		this.color = color;
		this.geartype = geartype;
		this.door = door;
		System.out.println("overloading constructor param 3��");
	}
	
	void print() {
		System.out.println(this.color + "/" + this.geartype + "/" + this.door);
	}
	
}

public class Ex16_this_Constructor_Call {

	public static void main(String[] args) {
		//Zcar z1 = new Zcar();
		//z1.print();
		
		//Zcar z2 = new Zcar("green", "auto",10);
		//z2.print();
		
		Zcar3 z3 = new Zcar3();
		z3.print();
		
		Zcar3 z4 = new Zcar3("gold", 2);
		z4.print();
		

	}

}
