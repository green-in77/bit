// 2. this ( 생성자를 호출하는 this)
// 원칙 : 생성자는 객체 생성시 한개만 호출가능
// this (앞으로 생성될 객체의 주소를 가지고 있음) : 여러개의 생성자 함수를 호출......

// *****                                             ******
class Zcar {
	String color;
	String geartype;
	int door;
	
	Zcar() {
		//this.color = "RED";
		//this.geartype = "auto";
		//this.door = 4;
		
		this("red", "autp", 4); // 나를 다시 부르는 것. //오버로딩 된 생성자로 튀어감. 함수이기때문에 갔다가 다시 와서 나머지 코드를 실행함.
		
		//new Zcar ("dd", "aaa", 10); 가정해서
		// this 는 객체 자신을 가르키기 때문에 다른 생성자를 호출할 수 있다.
		//확인차원
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
		System.out.println("overloading constructor param 2개");
	}
	
	Zcar3(String color, String geartype, int door) {
		this.color = color;
		this.geartype = geartype;
		this.door = door;
		System.out.println("overloading constructor param 3개");
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
