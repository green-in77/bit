package kr.or.bit;

// 새의 공통사항 ( 추상화, 일반화)
// 날수있다, 빠르다.

public class Bird {
	// 공통기능구현
	public void fly() {
		System.out.println("날고있다");
	}
	//재정의를 해 주었으면 좋겠따............
	protected void moveFast() {
		fly();
	}

}
