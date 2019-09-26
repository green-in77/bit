import kr.or.bit.Emp;

class  Test2 {
	void print() {
		System.out.println("부모함수(Test2)");
	}
}

class Test3 extends Test2 {
	@Override
	void print() {
		System.out.println("자식함수(Test3)");
	}
	//오버로딩 ( 상속과 전혀 상관이 없다.)
	void print(String s) {
		System.out.println("오버로딩"+s);
	}
}

public class Ex05_Inherit_overraide {

	public static void main(String[] args) {
		Test3 t3 = new Test3();
		t3.print();
		t3.print("^^"); //오버로딩
		
		Emp emp = new Emp(7788,"홍길동");
		System.out.println(emp.toString());
		System.out.println(emp); // emp.toString() 같은 코드이다.
		
		

	}

}
