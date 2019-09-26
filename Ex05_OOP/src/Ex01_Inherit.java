/*
 OOP 특징
 1. 상속
 2. 캡슐화(은닉화)
 3. 다형성
 
 1. 상속
 java >> child extends Base
 c#    >> child : Base
 
 2. 상속 특징
 2.1 다중상속은 불가능
 2.2 단일상속 지원(여러개의 클래스를 상속받으려면 : 계층적 상속(되물림 / 할아버지 -> 아버지 -> 나 ))
 2.3 다중상속을 지원(유일하게 interface)
 
 3. 상속 의미
 진정한 의미 : 재사용성
 단점 : 초기비용(설계)
 
 재사용성 >> 설계 >> 비용(시간, 공통자원(분모, 추상화))
 
 4. 상속 관계에서 memory 순서
 		GrandFather >> Father >> Child 순서로 heap memory
 		
		사용자가 만드는 모든 클래스는 default object 상속.
		GrandFather extends Object 를 상속 >> 최상위가 늘 object 상속 / extends Object 
 	
 */

class GrandFather {
	public GrandFather () {
		System.out.println("할아버지 생성자");
	}
	public int gmoney = 5000;
	private int pmoney = 10000; //private 상속관계에서 접근 불가.
}

class Father extends GrandFather {
	public Father () {
		System.out.println("아버지 생성자");
	}
	public int fmoney = 1000;
}

class Child extends Father {
	public Child () {
		System.out.println("자식 생성자");
	}
	public int cmoney = 100;
}

public class Ex01_Inherit {

	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child.gmoney); // 할아버지 돈 내돈
		System.out.println(child.fmoney); // 아버지 돈 내돈
		System.out.println(child.cmoney); // 내 돈도 내돈
		

	}

}
