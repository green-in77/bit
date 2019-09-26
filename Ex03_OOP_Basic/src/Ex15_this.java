//this
//1. 객체 자신을 가르키는 this  ( 앞으로 생성될 객체의 주소를 담을 곳이라고 가정하고 사용)
//2. this 객체 자신 ( 생성자를 호출) : 원칙 (생성자는 객체생성시 하나만 호출 가능) 
//		예외적으로 this 를 사용하면 여러개의 생성자를 호출 가능
class Test6 {
	int i;
	int j;
	Test6() { // default 생성자 // default Test6() { }
		
	}
	// parameter 의 변수명하고 instance variable  변수명을 다르게 사용하면 문제가 없지만....
	// 개발을 하다보니 (의미있는 변수명) >> 가독성 >> 유지보수 편하더라...
	// 변수명을 같이 쓰다보니....구분이 안감. 
	// int i; 앞으로 생성될 객체의 memberfield 가 아니냐 미리 가져다쓰자.
	// this 키워드 >> Test6 t = new Test6();
	Test6(int i, int j) {
		this.i = i;
		this.j = j;
		
		//i = i; i 가 어디의 i인지 알 수 없음.
		//j = j;
	}
}
//Today point (업그레이드 시킬 수 있는 코드..)
class soCar{ //member filed 가 private 가 아님.
	String color;
	String gearType;
	int door;
	
	soCar() { //생성자
		this.color = "RED";
		this.gearType = "auto";
		this.door = 2;
	}
	
	soCar(String color, String gearType, int door ) { //생성자 오버로딩
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
