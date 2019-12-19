/*
 추상클래스와 인터페이스(표준,약속만 정의, 구현이 없음) 공통점
 1. 스스로 객체생성 불가. ( new 불가 )
 2. 상속, 구현을 통해서만 사용가능. ( 메모리에 적재 가능 )
 3. 재정의 통한 강제적 구현 목적
 
 추상클래스와 인터페이스의 다른점
 1.인터페이스는 다중 구현이 가능. ( 하나의 클래스가 여러개의 인터페이스 사용가능)
 2. 추상클래스는 단일 상속 > 계층적 상속해야함.
 3. 추상클래스(완성된 코드 + 미완성(추상)코드)
 4. 인터페이스 상수를 제외한 나머지는 미완성(추상)코드 ... JDK 8 ( default, static 구현 )
 
 //주로 앞글자 대문자 I 사용...뒤에 able 를 붙임 (관용적표현)
  * 여러개의 약속을 합쳐서 큰 약속을 만들 수 있다. ( 약속의 확장 )
  * 인터페이스 간의 상속 가능. ( 다중 )
  interface Ib{}
  interface Ic{}
  interface Id{}
  
 interface If extends Ib, Ic, Id {}
 
 *하나의 클래스가 여러개의 인터페이스를 구현 가능하다.
 class Test extends Object implements Ia, Ib, Ic {}
 class Test implements Ia, Ib, Ic {}
 
 **개발자 입장**
 1. 인터페이스를 [다형성] 입장에서 접근 ( 인터페이스 부모타입 )
 2. 서로 연관성이 없는 클래스에 대해서 하나로 묶는 기능을 제공 ( 부모가 동일 )
 3. 인터페이스는 (~able ~할수있는) : 날 수 있는, 수리할 수 있는 ( 설계 )
 4. 객체간의 연결 고리 ( 객체의 소통 역할 )
  */

interface Irepairable {} // 수리할 수 있는...

class Unit2 {
	int hitpoint; // 에너지
	final int MAX_HP; // 상수 : 최대 에너지 
	
	Unit2(int hp) {
		this.MAX_HP = hp;
	}
}
//지상유닛
class GroundUnit extends Unit2{
	GroundUnit(int hp) {
		super(hp);
	}
}
//공중유닛
class AirUnit extends Unit2{
	AirUnit(int hp) {
		super(hp);
	}	
}

class Tank2 extends GroundUnit implements Irepairable { // 수리할 수 있는 interface
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
	// 다른 방식의 충전....
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
	// Scv 구체와, 특수화 고유한기능
	// 다른 유닛 수리 ( 수리하다 - repair )
	/*
	void repiar(Tank2 tank) {
		if(tank.hitpoint != this.MAX_HP) {
			tank.hitpoint += 5;
		}
	}
	void repiar(Scv scv) { // 함수 오버로딩 parameter Type 이 다름.
		if (scv.hitpoint != this.MAX_HP) {
			scv.hitpoint += 5;
		}
	}
	 */
	// Scv 가 repair Unit 증가되면 그 갯수만큼 repair 가 추가되어야 한다... // 비합리적.
	// 고민은 : 하나의 repair 가 다른 모든 유닛을 repair 하고 싶음.
	// 다형성 : 부모타입은 자식타입의 주소를 갖을 수 있다.
	// Unit2 <-  GroundUnit <- Tank2 , Marine2(repair 대상이 아님), Scv
	//void repair(Unit2 unit) {}
	//상속관계 부모타입으로는 해결불가능...
	//Interface
	// 2. 서로 연관성이 없는 클래스에 대해서 [하나로 묶는 기능]을 제공 ( 부모가 동일 )
	// 인터페이스도 하나의 데이터 타입이다★★★★★★
	//Tank2 extends GroundUnit implements Irepairable
	//CommendCenter implements Irepairable
	//Scv extends GroundUnit implements Irepairable
	void repair(Irepairable repairunit) {
		// repairunit 변수는 객체의 주소 ( Tank2, CommendCenter, Scv 주소 => 부모 Irepairable)
		// 부모타입... 자식의 주소를 받아 자신의 것만 볼 수 있다.......
		// downcasting -> 자식의 주소를 받아 자식의 것을 볼 수 있게......... -> Tank2 tank = (Tank2)repairunit (상위 타입을 하위타입으로..)
		
		//repair 하는 대상이 CommendCenter이 올 경우...(Unit2이 아님..) -> 충전의 방식이 다름.
		
		// 요약
		// Tank2 > GroundUnit > Unit2
		// Scv     > GroundUnit > Unit2
		// 공통점 Unit2 라는 부모를 갖고 있음.
		
		// CommendCenter > Unit2 가 아님.
		// Unit2으로 downcasting 불가.
		
		//parameter 들어온 객체가 Unit2 타입 이냐 아니냐
		// 객체의 타입을 비교해야함. ( instanceof ) >> true, false
		
		if(repairunit instanceof Unit2 ) { // pqrameter 가 Uni2 타입이니?
			Unit2 unit = (Unit2)repairunit; // downcasting 
			
			if( unit.hitpoint != unit.MAX_HP) {
				unit.hitpoint = unit.MAX_HP;
			} 
		}else {
				// Unit2 를 부모로 갖고있지 않으면
				//commendcenter
				System.out.println("Unit2 타입이 아니예요. 다른 repair 입니다.");
		}
	}
}



public class Ex03_Interface {
	public static void main(String[] args) {
		Tank2 tank = new Tank2();
		Marine2 marine = new Marine2();
		Scv scv = new Scv();
		
		//전투
		tank.hitpoint -= 20;
		System.out.println("Tank2 : " + tank.hitpoint);
		System.out.println("scv 수리요청");
		scv.repair(tank);
		System.out.println("Tank2 수리완료 : " + tank.hitpoint);
		
		CommendCenter center = new CommendCenter();
		scv.repair(center);
		

	}

}
