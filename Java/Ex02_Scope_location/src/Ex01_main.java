/*
 클래스 == 설계도 == 타입
 
 클래스의 구성요소 : 필드 + 생성자 + 함수
* 필드 >> 고유정보(제조회사, 모델명, 색, 최고속도 등), 상태정보(현재속도, 엔진회전수 등), 참조정보
* 생성자 >> 필드의 초기화를 목적으로 하는 함수
* 함수 >> 기능 (메소드) 
 
 클래스, 필드, 생성자, 함수 : 범위 정의하기 위해서 (접근자, 한정자, 수정자)
 
>> public, private, default, protected(상속에서)


1. public class Test{} // 어디서나 다 사용할 수 있음.

2. class Test{} >> 컴파일러가 내부적으로 default 접근자를 붙임. >> default class Test {}  // 구지 default 를 쓰지 않는다.
	>> default : 같은 폴더 안에서는 접근 가능, 다른 폴더에 있으면 서버 접근 불가.
	>> 언제 사용? 실무에서 쓰는 일은 없음... 같은 패키지(폴더)내에서 연습목적으로..
	
3. 하나의 물리적인 자바파일은 여러개의 클래스를 가질 수 있다. O
	단, public 은 하나의 class 만 갖는다. ( 주로 main... 나머지는 default ) 
 
 
 ex) 실습
 1. kr.or.bit.common 패키지(폴더) 안에 
 	CommonClass >> public class >> 
 	Ex01_main 과 CommonClass 는 다른 패키지(폴더) 안에 있다.
 	Ex01_main 클래스에서 >> CommonClass 자원 접근 가능. >> public class 라서.
 	
 	
 2. kr.or.bit.common 패키지(폴더) 안에
	DcommonClass >> default class
	Ex01_main 클래스에서 >> DcommonClass 자원 접근 불가능 >> default class 라서 
 
*/

class Test { // default 접근자 ( 같은 패키지 안에서만 사용가능)
	int d_iv; // 컴파일러가 알아서 default 붙임. // default int d_iv;  
	public int p_iv; // 무조건 오픈 누구나 어디서나 다 사용가능.
	private int pri_iv; // 개인적인... 캡슐화구현.... (getter, setter 를 통해서 사용)
}

public class Ex01_main {

	public static void main(String[] args) {
		kr.or.bit.common.CommonClass cc = new kr.or.bit.common.CommonClass();
		
		cc.p_iv = 100; // public 으로 선언된 변수이기 때문에 -> public int p_iv;
		
		Test tt = new Test();
		tt.d_iv = 200; // default 같은 패키지(폴더)만 접근가증 
		tt.p_iv = 300; // public 패키지(폴더) 상관없이 접근 가능
		//tt.pri_iv //private 접근 불가.

		
	}

}
