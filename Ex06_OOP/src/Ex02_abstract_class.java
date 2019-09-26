// ���� : ��Ÿũ����Ʈ
// ����(unit)

// unit ������( �̵���ǥ, �̵�, �����)
// unit �̵������ �ٸ���. (�̵������ unit ���� ������ ����) ....����....
// abstract class �̸� {  abstract method �������� }

abstract class Unit {
	int x = 100,y = 100;
	
	void stop() {
		System.out.println("Unit stop");
	}
	abstract void move(int x, int y);
}

//Tank
class Tank extends Unit {

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Tank move : " + this.x + this.y);
	}
	
	//Tank Ư���� ���(��üȭ)
	void changMode( ) {
		System.out.println("Tank Chang Mode");
	}
	
}

class Marine extends Unit{

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Marine move : " + this.x + this.y);
	}
	
	void stimpack() {
		System.out.println("stimpack");
	}
	
}

class DropShip extends Unit {

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("DropShip move : " + this.x + this.y);
	}
	
	void load() {
		System.out.println("Unit load");
	}
	
	void unload() {
		System.out.println("Unit unload");
	}
	
	
}

public class Ex02_abstract_class {

	public static void main(String[] args) {
		Tank t = new Tank();
		t.move(500,200);
		t.stop();
		t.changMode();
		
		Marine m = new Marine();
		m.move(300, 500);
		m.stop();
		m.stimpack();
		
		DropShip d = new DropShip();
		d.move(500, 300);
		d.stop();
		d.load();
		d.stop();
		d.unload();
		
		// 1. quiz ��ũ 3�븦 ����� [���� ��ǥ] �� �̵�
		// (��ü �迭)�ڡڡڡڡڡڡڡڡڡڡ�		
		Tank[] tank = {new Tank(), new Tank(), new Tank()};
		/*
		for (int i = 0 ; i < tank.length ; i++) {
			tank[i].move(300, 500);
		}
		*/
		for ( Tank ta : tank) {
			ta.move(100, 200);
		}
		
		// 2. �ڡڡڡڡڡڡڡڿ������� Unit(Tank, Marine, DropShip)  [���� ��ǥ]�� �̵�
		// ������ǰ ���忡�� �����ϱ�..buy >> Cart ����
		Unit[] unitlist = {new Tank(), new Marine(), new DropShip()};
		for ( Unit unit2 : unitlist) {
			unit2.move(1212, 3434);	
		}
		
		
	}
}
