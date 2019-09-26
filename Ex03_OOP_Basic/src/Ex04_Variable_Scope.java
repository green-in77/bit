/*
instance varriable [ 객체변수 ]  : class 안에 만들어지는 변수
local variable [ 지역변수 ] : 함수안에 만들어지는 변수 
static variable : 공유자원, 객체생성 이전에 memory 올라가는 자원 
*/

class Variable {
	int iv; //default
	/*
	 1. member field , instance variable
	 2. Variable v = new Variable(); // heap 메모리에 iv가 생성....
	 	 Variable v2 = new Variable() ; // heap 메모리에 iv 생성..
	 3.  목적 : 정보를 담으려고 한다. ( 정보에 맞는 Type 정보를 가져야 한다. )
	 				    - 정보(속성) >> 고유, 상태, 부품(참조)
	 				    - 정보는 객체마다 다른 값을 가질 수 있다.
	 				    - 그러기 때문에 구지 초기화 하지 않음(defalut 값을 가지고 있음).
	 				    
	 				    int >> 0 , float >> 0.0, boolean >> False
	 				    String >> 참조(클래스) >> null
	  4. 생성시점 : new 라는 연산자를 통해서 heap 에 객체가 만들어지고 나서 바로 변수 생성
	 				    
	 */
	static int cv;
	/*
	 1. class variable (클래스 변수) , static variable (공유변수)
	 2. 목적 : 정보를 담는 것. (생성되는 모든 객체가 공유하는 자원 = [객체간 공유자원]) 
	 		heap 에 생성된 객체들의 공통자원(공유자원)
	 3. 특징 : 접근방법1 >> 클래스 이름.static 변수명 >> Variavle.cv ( 객체가 만들어지지 않은 상황에서도 접근 가능)
	 				ex) Math.Random() >>  Math m = new ...하지 않았음.
	 				접근방법2 >> 참조변수.static 변수명  (v.cv / v2.cv)
	 4. 생성시점 : javac 컴파일 >> java Variable (실행) >> 
	 						class loader 의해서
	 						1. 클래스 정보(metadata)를 읽어서 그 내역을 class area (method area , static area)에 올림.
	 							static 자원을 먼저 memory  올림.
	 							>> static 자원은 객체생성 이전에 memory 올라가는 자원.
	 										
	 */
	
	void method () {
		int lv = 0;
		
		/*
		 	local variable ( 함수안에 있는 지역변수 : 반드시 초기화)
		 	scope : 함수가 시작되면 생성 ~ 함수가 끝나면 소멸
		 	
		 	함수안에 if 블럭 , for 블럭 등 도 지역변수를 갖는다.
		 	  
		 */
	}
}

public class Ex04_Variable_Scope {

	public static void main(String[] args) {
		Variable.cv = 100; // static variable 은 프로그램 실행 시 method area 에 메모리 할당.
		Variable v = new Variable();
		Variable v2 = new Variable();
		
		//검증
		System.out.println("v.cv : " + v.cv); // 100
		System.out.println("v2.cv : " +  v2.cv);
		
		v2.cv = 5000;
		System.out.println("variable.cv : " + Variable.cv);
		
	}

}
