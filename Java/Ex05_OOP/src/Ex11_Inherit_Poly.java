//자바에서 다형성 상속관계....

class Pbase {
	int p = 100;
}

class Cbase extends Pbase {
	int c = 200;
}

class Dbase extends Pbase {
	
}

public class Ex11_Inherit_Poly {

	public static void main(String[] args) {
		Cbase c = new Cbase();
		System.out.println(c.toString());
		
		// 다형성 : 부모타입의 참조변수가 자식타입의 주소값을 가질 수 있다 (상속관계)
		// 단 생성된 모든 객체에 접근 하는 것이 아니라 자신 타입의 객체에만 접근 가능.
		
		Pbase p = c; // 다형성
		System.out.println("p 부모타입의 변수 : " + p);
		System.out.println("c 변수 : " + c);
		
		System.out.println(c.c + " / " + c.p);
		System.out.println("자신의 것(부모) 접근 : " + p.p);
		
		Dbase d = new Dbase();
		p = d; // p는 d의 부모이기 때문에 가능.
		// 하나의 참조변수 p가 c의 주소값도, d의 주소값도 갖을 수 있다. 
		
		Dbase dd = (Dbase)p; // 부모의 주소를 자식에게 는 불가능. //부모가 [상위타입] .... casting
		
		
		

	}

}
