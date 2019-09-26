/*
 추상클래스
 미완성 클래스 (미완성 설계도)
 1. 완성된 코드 + 미완성된 코드
 2. 완성(함수) : 실행블럭 있는 것 + 미완성(함수) : 실행블럭이 없는 것. public void print();  (실행불가)
 3. 완성과 미완성의 차이 ( new 객체 ( 완성) / new 객체X (미완성) )
 
 정리 )
 1. 추상(미완성) 클래스 스스로 객체 생성 불가 ( new 사용불가)
 2. 추상클래스는 결국 완성된 클래스로 만들어서 사용 목적 -> 상속을 목적으로 하는 클래스
 3.상속 관계에서 미완성 된 자원 ( 추상자원) 완성해라 ( 구현 ) -> 재정의 ( override)
 
 why ) 추상클래스 >> 설계자가 바라보는 진정한 의미 >> 강제적 구현 ( 재정의 강제 )
 ★★★★★★ 상속관계에서 강제적 구현을 목적으로 하는 것.★★★★★★
 */

abstract class ABclass { // 추상 클래스
	int pos;

	//완성된 코드
	void run() {
		pos++;
	}
	
	//미완성된 코드 = 추상자원 {} 실행블럭이 없음.
	abstract void stop();
	
	
}
//추상 클래스는 상속을 통해서만 완성자원으로...
class Child extends ABclass {

	@Override
	void stop() {
		this.pos = 0;
		System.out.println("stop : "+this.pos);
	}
	
}

public class Ex01_abstract_class {
	public static void main(String[] args) {
		// ABclass ab = new ABclass();  //Cannot instantiate the type ABclass // 추상클래스 미완성이라 new 불가.
		Child ch = new Child();
		ch.run();
		ch.run();
		System.out.println("현재 pos 값은 : " + ch.pos);
		ch.stop();
		
		//다형성 개념 ( 상속은 다형성을 다 가지고 있음)
		
		ABclass ab = ch; // ABclass 부모타입 -> 부모는 자식타입의 주소를 갖을 수 있다.  
		ab.run();
		ab.stop(); // 접근은 부모의 stop 로 갔으나 override 되어있어서 자식의 자원으로 이동★★★★★★★★★★★
		

	}

}
