/*
 �߻�Ŭ������ �������̽�(ǥ��,��Ӹ� ����, ������ ����) ������
 1. ������ ��ü���� �Ұ�. ( new �Ұ� )
 2. ���, ������ ���ؼ��� ��밡��. ( �޸𸮿� ���� ���� )
 3. ������ ���� ������ ���� ����
 
 �߻�Ŭ������ �������̽��� �ٸ���
 1.�������̽��� ���� ������ ����. ( �ϳ��� Ŭ������ �������� �������̽� ��밡��)
 2. �߻�Ŭ������ ���� ��� > ������ ����ؾ���.
 3. �߻�Ŭ����(�ϼ��� �ڵ� + �̿ϼ�(�߻�)�ڵ�)
 4. �������̽� ����� ������ �������� �̿ϼ�(�߻�)�ڵ� ... JDK 8 ( default, static ���� )
 
 //�ַ� �ձ��� �빮�� I ���...�ڿ� able �� ���� (������ǥ��)
  * �������� ����� ���ļ� ū ����� ���� �� �ִ�. ( ����� Ȯ�� )
  * �������̽� ���� ��� ����. ( ���� )
  interface Ib{}
  interface Ic{}
  interface Id{}
  
 interface If extends Ib, Ic, Id {}
 
 *�ϳ��� Ŭ������ �������� �������̽��� ���� �����ϴ�.
 class Test extends Object implements Ia, Ib, Ic {}
 class Test implements Ia, Ib, Ic {}
 
 **������ ����**
 1. �������̽��� [������] ���忡�� ���� ( �������̽� �θ�Ÿ�� )
 2. ���� �������� ���� Ŭ������ ���ؼ� �ϳ��� ���� ����� ���� ( �θ� ���� )
 3. �������̽��� (~able ~�Ҽ��ִ�) : �� �� �ִ�, ������ �� �ִ� ( ���� )
 4. ��ü���� ���� �� ( ��ü�� ���� ���� )
  */

interface Irepairable {} // ������ �� �ִ�...

class Unit2 {
	int hitpoint; // ������
	final int MAX_HP; // ��� : �ִ� ������ 
	
	Unit2(int hp) {
		this.MAX_HP = hp;
	}
}
//��������
class GroundUnit extends Unit2{
	GroundUnit(int hp) {
		super(hp);
	}
}
//��������
class AirUnit extends Unit2{
	AirUnit(int hp) {
		super(hp);
	}	
}

class Tank2 extends GroundUnit implements Irepairable { // ������ �� �ִ� interface
	Tank2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}

	@Override
	public String toString() {
		return "Tank2";
	}
}

class Marine2 extends GroundUnit {
	Marine2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}
	@Override
	public String toString() {
		return "Marine2";
	}	
}

class CommendCenter implements Irepairable{
	// �ٸ� ����� ����....
}

class Scv extends GroundUnit implements Irepairable{
	Scv() {
		super(60);
		this.hitpoint = this.MAX_HP;
	}
	
	@Override
	public String toString() {
		return "Scv";
	}
	// Scv ��ü��, Ư��ȭ �����ѱ��
	// �ٸ� ���� ���� ( �����ϴ� - repair )
	/*
	void repiar(Tank2 tank) {
		if(tank.hitpoint != this.MAX_HP) {
			tank.hitpoint += 5;
		}
	}
	void repiar(Scv scv) { // �Լ� �����ε� parameter Type �� �ٸ�.
		if (scv.hitpoint != this.MAX_HP) {
			scv.hitpoint += 5;
		}
	}
	 */
	// Scv �� repair Unit �����Ǹ� �� ������ŭ repair �� �߰��Ǿ�� �Ѵ�... // ���ո���.
	// ����� : �ϳ��� repair �� �ٸ� ��� ������ repair �ϰ� ����.
	// ������ : �θ�Ÿ���� �ڽ�Ÿ���� �ּҸ� ���� �� �ִ�.
	// Unit2 <-  GroundUnit <- Tank2 , Marine2(repair ����� �ƴ�), Scv
	//void repair(Unit2 unit) {}
	//��Ӱ��� �θ�Ÿ�����δ� �ذ�Ұ���...
	//Interface
	// 2. ���� �������� ���� Ŭ������ ���ؼ� [�ϳ��� ���� ���]�� ���� ( �θ� ���� )
	// �������̽��� �ϳ��� ������ Ÿ���̴١ڡڡڡڡڡ�
	//Tank2 extends GroundUnit implements Irepairable
	//CommendCenter implements Irepairable
	//Scv extends GroundUnit implements Irepairable
	void repair(Irepairable repairunit) {
		// repairunit ������ ��ü�� �ּ� ( Tank2, CommendCenter, Scv �ּ� => �θ� Irepairable)
		// �θ�Ÿ��... �ڽ��� �ּҸ� �޾� �ڽ��� �͸� �� �� �ִ�.......
		// downcasting -> �ڽ��� �ּҸ� �޾� �ڽ��� ���� �� �� �ְ�......... -> Tank2 tank = (Tank2)repairunit (���� Ÿ���� ����Ÿ������..)
		
		//repair �ϴ� ����� CommendCenter�� �� ���...(Unit2�� �ƴ�..) -> ������ ����� �ٸ�.
		
		// ���
		// Tank2 > GroundUnit > Unit2
		// Scv     > GroundUnit > Unit2
		// ������ Unit2 ��� �θ� ���� ����.
		
		// CommendCenter > Unit2 �� �ƴ�.
		// Unit2���� downcasting �Ұ�.
		
		//parameter ���� ��ü�� Unit2 Ÿ�� �̳� �ƴϳ�
		// ��ü�� Ÿ���� ���ؾ���. ( instanceof ) >> true, false
		
		if(repairunit instanceof Unit2 ) { // pqrameter �� Uni2 Ÿ���̴�?
			Unit2 unit = (Unit2)repairunit; // downcasting 
			
			if( unit.hitpoint != unit.MAX_HP) {
				unit.hitpoint = unit.MAX_HP;
			} 
		}else {
				// Unit2 �� �θ�� �������� ������
				//commendcenter
				System.out.println("Unit2 Ÿ���� �ƴϿ���. �ٸ� repair �Դϴ�.");
		}
	}
}



public class Ex03_Interface {
	public static void main(String[] args) {
		Tank2 tank = new Tank2();
		Marine2 marine = new Marine2();
		Scv scv = new Scv();
		
		//����
		tank.hitpoint -= 20;
		System.out.println("Tank2 : " + tank.hitpoint);
		System.out.println("scv ������û");
		scv.repair(tank);
		System.out.println("Tank2 �����Ϸ� : " + tank.hitpoint);
		
		CommendCenter center = new CommendCenter();
		scv.repair(center);
		

	}

}
