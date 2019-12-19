package kr.or.bit;

public class Ex03_DataType {
/*
 * 자바는 시스템에서 기본 8가지 기본타입을 제공(자료형)
 * 8가지 기본타입(값을 저장하는 타입)
 * 숫자 -> 정수(음의 정수, 양의 정수, 0) -> byte(-128~127) 
 * 											  -> char(한 문자를 표현하는 자료형)
 * 													unicode 형식
 * 											  ->short
 * 											  ->**int(-21억~21억, 4바이트): 자바 정수 연산의 기본타입**
 * 											  ->long(인트보다 큰값, 8바이트)
 * 		-> 실수(부동소수점) -> float(4byte), double(8byte)
 * 								>>** 정밀도(표현범위가 크다) >> double -> java 실수연산의 기본타입**
 * 논리 -> 참, 거짓 -> boolean >> 프로그램 논리의 흐름제어
 * String은 참조타입(클래스)
 * 문자: '가'. char c= 'A'; -> char는 정수타입으로 정수가 들어간다. 즉 실제론 'A'의 정수타입인 65가 저장됨
 */
	public static void main(String[] args) {
		Car car=new Car(); //변수 car는 Car의 주솟값을 갖고 stack에 쌓이고 new Car()는 heap에 쌓임
		Car car2=new Car();
		Car car3=car; //주솟값 할당
		car3.color="black";
		System.out.println(car);
		System.out.println(car2);
		System.out.println(car3);
		System.out.println(car.color);
		//long num= 10000000000 -> 에러, 리터럴값은 기본적으로 int 범위만 들어간다
		int intch= 'A'; //묵시적 형변환
		char ch='가';
		System.out.println(intch);
		System.out.println((int)ch);
		char ch2= 65;
		System.out.println(ch2);
		System.out.println((char)(ch2+1));
		int ch3=(int) ch2;
		
		System.out.println(ch3);
		
		int intch2= 129; //값을 보지말고 Type을 보자^^^^^^^^^
		char ch4= (char)intch2; //명시적, 강제 형변환
		System.out.println(ch4);
		/*
		 * ***Point***
		 * 변수가 갖고있는 값을 보지말고 변수의 타입을 보자.
		 * 변수의 타입 크기를 확인하자.
		 * 큰 타입에는 작은 타입 값을 넣을 수 있다. 작은 타입에 큰 타입 값을 넣을 순 없다.
		 * char <- int >>> char <- (char)int
		 * int <- char 가능(내부적으로 변환) >>> int <-(int)char
		 */
		
		int intaValue= 465464;
		byte byteValue=(byte)intaValue;
		System.out.println(byteValue + "(쓰레기값)");
		
		/*
		 * Tip java에서 특수문자 사용하기
		 * 문자를 인지 시키기 위해서: \ 
		 * char sing='''; - > '\'';
		 * String은 값 타입이 아니고 클래스 타입(new를 통해서 메모리에 올리고 사용)
		 */
		System.out.println('\'');
		System.out.println("홍\"길\"동");
		System.out.println("100" + 100 + 100 + 100 + 100 + 100);
		System.out.println("C:\\temp");
		System.out.println("	t");
		System.out.println("\tt");
		
		float f=3.14f;
		float f2=1.123456789f;//소수이하 7자리, 반올림 처리
		System.out.println(f2);
		double d=1.123456789123456789; //소수이하 16자리표현, 반올림 처리
		System.out.println(d);
		/*
		 * 작은타입 + 큰타입 = 큰타입
		 * 타입간 변환은 변수가 가지는 값을 보지말고 변수의 타입을 보고 판단.
		 * 명시적 형변환(casting) (int)
		 */
		
		
	}
}

class Car { 
	String color;
	int window;
}
