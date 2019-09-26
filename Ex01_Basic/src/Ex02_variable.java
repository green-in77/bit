//1. Ex02_variable 클래스
//2. 특수한 main 함수를 가지고 있는 클래스
//3. static void main(String[] args) :프로그램의 시작점 ,진입점

//4. main 함수가 없는 클래스 (lib) : 다른 클래스를 도와주는 클래스

//Tip)c# public static void Main() ....

//변수 : variable
//변수 scope (유효범위) :선언되는 위치 
//1. instance variable : 객체변수 class Test { int age }
//2. local variable    : 지역변수(함수안에 있는 변수) class Test { public void run(){ int age } }
//2.1 함수안에 if 블럭 , for 블럭  안에 있는 변수도 지역변수 scope  블럭 ....안에서만
//3. static variable   : 공유변수(자원) : 객체간 공유 자원

//원칙 : 하나의 java 파일  하나의 클래스 >> Test.java >> class Test {}
//연습용 : 하나의 java 파일 안에 여러개의 클래스를 만들어 사용 (단 class 중에 하나만 public 가진다)

//class 는 설계도이다  == class는  Type 이다 (작은 여러개의 타입을 가지고 있는 큰타입)
class Test{
	int iv = 500;
	//instance variable
	//이 변수는 초기화 하지 않아도 된다 (기본값:default)를 가지고 있다
	//Why 초기화를 하지 않아도 사용 가능 할까요 (hint : 설계도 하나 여러개의 아파트 ..... 창문의 개수는 다를 수 도있다)
	//답) 객체마다 다른 값을 가질 수 있다
	
	int window; //default => 0
	
	Test(){ //생성자 (constructor)  //목적 : member field 초기화  //객체 생성과 동시에 호출
		
	}
	Test(int data){ //오버로딩(overloading): 하나의 이름으로 여러가지 기능을 수행
	   window = data;	
	}
	
	void write() {
		int num =100; //local variable	
		              //함수가 호출되면 그때 메모리에 생성되고 함수가 종료되면 메모리에 사라진다 (num 이)
		iv = 6666;
	}
	void print() {
		//System.out.println(num);  사용불가 (print 함수 실행시 num 존재하지 않아요)
		System.out.println("Test.iv :" + iv);
	} 
}



public class Ex02_variable {
	public static void main(String[] args) {
		int lv = 500; //local 
		System.out.println("lv 변수값 : " + lv);
        //실행 (javac 컴파일 >> java Ex02_variable ) 단축키 (ctrl + F11)
		
		//int number; //선언 
		//초기화를 하지 않은 변수를 사용할때)
		//System.out.println(number);
		//The local variable number may not have been initialized
		
		int number=0;
		System.out.println("초기화 number : " + number);
		//1. 지역변수는 반드시 초기화 하고 사용해야 한다(처음 값을 입력하는 것을 초기화)
		//2. 약속 (함수안에 있는 변수 반드시 초기화)
		
		int num; //선언
		System.out.println("졸려요");
		System.out.println("나두 졸려요");
		num = 200;// 선언과 할당은 분리 .....
		System.out.println("num :" + num);
		
		
		//클래스도 타입니다
		//Test t = new Test();
		//System.out.println(t.iv);
		
		Test apt = new Test();
		System.out.println("창문의 개수 : " + apt.window);
		
		Test apt2 = new Test(10);
		System.out.println("창문의 개수 :" + apt2.window);
		
		apt2.write();
		apt2.print();
		
		System.out.println("주소값 :" + apt);
		//주소값 :Test@15db9742
		
	}

}



