/*
 생성자 함수(constructor)
 1. 함수 ( 특수한 목적의 함수)
 2. 특수한 목적 ( member field 초기화)
 
 Tip) static  >> static {} ,  일반변수 >> {}
 
 3. 일반함수와 다른점
 3.1 함수의 이름이 고정 ( class 이름과 동일 )
 3.2 실행시점 때문에 : return type 이 없음, void > default void 생략
 3.3 실행시점 : 객체 생성시 호출 : 그래서 값을 돌려줄 변수가 없음.
 
 4. 목적 : 생성되는 객체마다 다른 초기값을 부여하기.
 
 class Car { int door=5; }
 
 5. 생성자 함수는 overloading 이 가능하다.
 
 **************** 개발자의 의도 *****************
 * 예외적으로 overloading 된 생성자 함수가 하나라도 존재한다면 컴파일러는 자동으로 default 생성자 함수를 만들지 않는다.
 * 만약 default 생성자 함수를 사용하고 싶다면 강제 구현.
 * why? 개발자의 강제적 의도가 들어 있는 것.
  
 일반 함수보다 코드량의 감소.....
  */

class Car {
	String name;
	//Car() {} 명시하지 않으면 complile러가 Car() {} 있다고 생각하고 실행합니다. //생성자가 없어도 있다고 생각하고 돌림.
}

class Car2 {
	String carname;
	Car2 () { // default constructor (디폴트 생성자)
		System.out.println("나 생성자 함수야");
		carname = "pony"; //member field 의 초기화
	}
}

class Car3 {
	int number;
	
	Car3() {
		System.out.println("member field 초기화");
		//number=10;	
	}		
}

////////////////////////////////////////////////////
class Car4 {
	int door;
	int wheel;
	
	Car4() { // default 
		System.out.println("default");
	}
	//오버로딩
	Car4(int num) { //overloading (생성자도 오버로딩이 가능하다. 함수이기 때문에)
		door = num;
		System.out.println("overloading door" + door); 
	}
	//오버로딩 parameter 갯수가 다름
	Car4(int num, int num2){
		door = num;
		wheel = num2;
		System.out.println("overloading wheel / door : " + wheel + " / " + door);
	}
}

class House {
	String doorcolor;
	
	House(){ // default 를 사용하고 싶다면 강제구현해라.
		doorcolor = "YELLOW";
		
	}
	House(String color){
		doorcolor = color;
	}
	
}


public class Ex13_Constructor_Function {

	public static void main(String[] args) {
		//Car c = new Car(); // Car() 함수를 호출
		//Car2 c2 = new Car2(); // 생성자 함수는 객체 생성과 함께 호출된다.
		//Car2 c22 = new Car2();
		Car4 car4 = new Car4(10, 50);
		Car4 car5 = new Car4(5,66);
		
		House home = new House("RED");
		System.out.println(home.doorcolor);
		
		House home2 = new House("BLUE");
		System.out.println(home2.doorcolor);
		
		House home3 = new House();
		System.out.println(home3.doorcolor);
		
		
	}

}
