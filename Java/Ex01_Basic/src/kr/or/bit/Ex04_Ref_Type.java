package kr.or.bit;

/*
 * 클래스= 설계도= 타입
 * 프로그램 세계에서는 new로 구체화(memory) >> 인스턴스(객체)
 * 설계도는 무조건 4byte로 시작
 * 
 * 설계도를 작성
 */
public class Ex04_Ref_Type {

	public static void main(String[] args) {
		Apt lgApt= new Apt(); //참조변수: 주소를 갖는 변수
		System.out.println(lgApt);
		
		Apt ssApt= lgApt; //주소를 갖는방법은 원칙적으로 new 지만 할당도 방법 중 하나다.
		ssApt.door=1111;
		System.out.println(lgApt.door);
		
	}
}

class Apt{
	int door=10;
	int window=100;
}
