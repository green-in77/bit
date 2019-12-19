// 게임 : 스타크래프트
// 유닛(unit)

// unit 공통기능( 이동좌표, 이동, 멈춘다)
// unit 이동방법은 다르다. (이동방법은 unit 마다 별도의 구현) ....강제....
// abstract class 이름 {  abstract method 강제구현 }

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
	
	//Tank 특수한 기능(구체화)
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
		
		// 1. quiz 탱크 3대를 만들고 [같은 좌표] 로 이동
		// (객체 배열)★★★★★★★★★★★		
		Tank[] tank = {new Tank(), new Tank(), new Tank()};
		/*
		for (int i = 0 ; i < tank.length ; i++) {
			tank[i].move(300, 500);
		}
		*/
		for ( Tank ta : tank) {
			ta.move(100, 200);
		}
		
		// 2. ★★★★★★★★여러개의 Unit(Tank, Marine, DropShip)  [같은 좌표]로 이동
		// 전자제품 매장에서 구매하기..buy >> Cart 구현
		Unit[] unitlist = {new Tank(), new Marine(), new DropShip()};
		for ( Unit unit2 : unitlist) {
			unit2.move(1212, 3434);	
		}
		
		
	}
}
