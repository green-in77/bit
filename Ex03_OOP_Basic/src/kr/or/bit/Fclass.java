package kr.or.bit;
/*
 함수(method) : 기능, 행위 의 최소단위 ★★★★★★★★ 함수는 하나의 기능만 구현한다 ★★★★★★★★★
 ex) 먹다, 걷는다, 잔다 등...
 
 클래스의 구성요소 : 필드, 생성자, 함수
 
 ex) 동전넣는 게임기 = 1번 , 동전넣는 캡슐뽑기 = 3번
 
 함수의 종류 ( 4가지 )
 1. void , parameter(O) : void print(String str) { 실행코드 }
 2. void , parameter(X) : void print() { 실행코드 }
 3. return Type , parameter(O) : int print(int data) {실행코드 + return 100; }
 4. return Type , parameter(X) : int print() { 실행코드 + return 200; } 
 
 * void : 리턴값이 없음. ( return value 가 없다.)
 * return Type : { [8가지 기본 타입] + String + 참조(객체의 주소) } + Array + Collection + Interface
 ** return Type 있으면 반드시!!!!!!!!!! { 블럭안에 return 키워드가 존재해야한다. } //없으면 컴파일 불가.
 * parameter (인자, 인수) : 동전구멍 (100원짜리, 1000원짜리 지폐), 동전구멍이 여러개


함수는 반드시 호출(Call) 되어야만 실행된다. : 누군가 그의 이름을 불러주었을때.....
 */
public class Fclass {
	public int data;
	
	//void m() //default 다른 패키지에서 사용불가.
	public void m() { 
		System.out.println("일반함수 : void , parameter(x)");
	}
	
	public void m2(int i) {
		System.out.println("parameter value : " + i );
		System.out.println("일반함수 : void ,  parameger(o)");
	}
	
	public int m3() {
		return 100;
	}
	
	public int m4(int data) {
		return data + 1;
	}
	
	//확장 (parameter 개수의 변화)
	public int sum(int i , int j , int k ) {
		return i + j + k;
	}
	
	//private ( 접근자, 한정자 ) 캡슐화
	// 1. 클래스 내부에서는 의미가 없다.
	// 2. 객체 입장에서는 private 보이지 않는다.(외부에서는 보이지 않음 / 캡슐화)
	
	//main 객체 fc에서는 안보임(사용할 수 없음) 왜 만들었나?
	//private 접근자를 가진 함수의 목적은 : 클래스 내부에서 [다른 함수]를 [도와줄 목적]으로 만드는 경우.
	//공통함수 : 여러개의 함수가 사용하는 [공통내용을 가지는 함수] (ex. 출력 전용 함수)
	private int operationMethod (int data) {
		return data * 200;
	}
	
	public int sum2(int data) {
		int result = operationMethod(data); // 다른 함수 호출하기. (넣어줄 변수 없이도 쓸 수 있지만.. 그러면 값을 사용할 수 없다.)
		if(result > 0 ) {
			return 1;
		}else {
			return -1;
		}
	}
	
	//Quiz // 제어문 안에 return 반복적 사용은 좋지 않다.
	// a와 b 둘 중에 큰 값을 리턴하는 함수 만들기.
	// Max(500,300) -> 500 리턴
	
	public int Max(int a, int b) { // parameter a, b 두개를 받는 함수.
		return (a < b) ? b : a ; // a와 b 를 비교해서 큰 값을 리턴. // 삼항 연산자. // 코드는 되도록 짧게만들기.
		
		// if 사용 할 시 리턴을 2번 쓰지 말고 변수 생성해서 값을 저장해서 마지막에 리턴 한번만 하기.
		/*int result2 = 0;
		if ( a > b ) {
			result2 = a;
		}else {
			result2 = b;
		}
		return result2;
		*/
	}
	
	public String concat (String s, String s2, String s3) {
		String result = s + "/" + s2 + "/" + s3;
		return result;
		// return s + "/" + s2 + "/" + s3;
	}
	
	//여기까지는 기본편.....
	//★★★★★★★★★★★★클래스는 타입이다.★★★★★★★★★★★★★★
	/*
	 public int call(){ int data = 100; return data; }
	 public Tv call() { Tv t = new Tv(); return t; }
	 public Tv call() { return new tv(); } //new Tv 를 Heap 에 올리고 주소를 return.
	 
	 [Today Point]
	 클래스는 memory에 올려야 사용할 수 있다. ( Tv t = new Tv(); // Tv 한대 만들어 졌다.(heap 메모리에 생성)
	 
	 public int call(Tv t) { } // t라는 변수는 TV타입(주소)을 받을 수 있다.
	 public Tv call() { } // Tv 타입의 주소값을 리턴한다.
	 
	 */	
	
	public Tv objMethod() {
		Tv t = new Tv(); // Tv 타입의 주소값 return 유일한 방법 new 생성.
		t.brand = "LG";
		return t; 
	}
	
	public Tv ojbMethod2() {
		return new Tv();
		//new 연산자는 heap 메모리에 Tv 객체를 만들고 주소를 생성하는 연산자.
		//return 값을 돌려줘 = 주소값.
	}
	
	public Tv objMathod3(Tv t) { // xx번지 받으면
		return t; // return 도 xx 번지
	}
	
}
