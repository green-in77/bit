package kr.or.bit;
// 클래스 == 설계도 == Type
// 설계도는 구체화(메모리에 올려서)를 통해서 객체로 생성되어야 한다.
// 구체화된 것을 >> 객체(인스턴스)
// 설계도가 가지는 기본적인 구성요소 (필드 + 생성자 + 함수)

// class Tire { }
// class Car { Tier tire; }
// class Window { int i; }

public class Person {
	public String name; // instance variable (객체변수) 초기화를 하지 않아도 된다. 기본값(default)이 있음. // String = Null
	public int age; // 접근자(public) // 기본값 int = 0
	
	public void print() { // 기능(행위=메소드=함수)
		System.out.println( name + " / " + age );
	}
}
