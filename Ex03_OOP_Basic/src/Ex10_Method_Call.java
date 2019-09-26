class Data { // 클래스 == 타입 ( 큰타입)
	int i; //객체변수
}

// ★★★★★★method 의 parameter 로 기본8가지 타입(숫자,문자) + String(문자열) + 사용자가 생성한 class 타입(주소=참조값)을 받을 수 있다.

public class Ex10_Method_Call {

	public static void main(String[] args) {
		Data d = new Data();
		d.i = 100;
		System.out.println("d.i : " + d.i); // 100
		
		scall(d); // Point (d 변수에는 객체 Data 의 주소값(참조) 어떤 타입을 갖는 : Data)
		vcall(d.i);
		
		System.out.println("d.i : " + d.i); // 1111

	}
	static void scall (Data data) {  // class Data 타입의 data 변수  : 주소값 전달. 
		//data 라는 변수는 Data 라는 클래스의 주소값을 받으면 된다.
		//Data가 의미하는 것은 주소값.
		System.out.println("함수 : " + data.i); // 100
		data.i = 1111;
	}
	
	static void vcall(int x) { // 값전달.
		System.out.println( "before : " + x ); //1111
		x = 8888; // d.i 를 변경하는 것이 아니라 x의 값을 변경하는 것.
		System.out.println( "after : " + x ); //8888
	}
}
