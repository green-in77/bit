/*
 변수 <-> 상수
 상수 : 한번 값이 초기화되면 변경 불가.
 상수자원 : 고유값(주민번호, 시스템의 고유번호, 수학적인 값 PI 등)
 상수는 관용적 [ 대문자 ] 
  
java : final int NUM = 10;
c#   : const int NUM = 10;   

final 키워드
클래스 앞에 : final class Car { } >> final Math >> 상속하지마. 
함수 앞에 : public final void print() {} >> 상속관계에서 재정의 하지마. 오버라이드 금지.
					public static final void print() {}
 */

class Vcard {
	final String KIND = "heart";
	final int NUM = 10;
	
	
	void method() {
		// 자바 API 시스템 상수 
		System.out.println(Math.PI);
		
	}	
}

// 상수값은 값을 바꿀 수 없다.
//생성되는 객체마다 값을 다르게 고정하고 싶다면 생성자를 사용해서 초기화 한다.
// 초기화 시점 ( 한번 설정) : new 할때.

class Vcard2 {
	final String KIND;
	final int NUM;

	/*
	Vcard2() {
		this.KIND = "heart";
		this.NUM = 1;
	}
	*/
	
	Vcard2(String kind, int num) { // 객체마다 다른 상수값을 줄 수 있음.★★★
		this.KIND = kind;
		this.NUM = num;
	}

	@Override
	public String toString() {
		return "Vcard2 [KIND=" + KIND + ", NUM=" + NUM + "]";
	}
	
}

public class Ex07_Final {

	public static void main(String[] args) {
		Vcard vcard = new Vcard();
		System.out.println(vcard.KIND);
		// vcard.KIND = "AAAA"; 컴파일 불가
		
		vcard.method();
		
		Vcard2 vcard2 = new Vcard2("heart", 1); //객체 생성시 상수값을 제공.
		System.out.println(vcard2.toString());
		Vcard2 vcard3 = new Vcard2("dia",2);
		System.out.println(vcard3.toString());

	}

}
