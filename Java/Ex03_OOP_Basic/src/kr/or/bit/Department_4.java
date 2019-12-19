package kr.or.bit;
/*
 백화점은 브랜드와 층을 가지고 있다.

백화점이 있으면 브랜드의 층이 존재해야한다.(단 한층에는 한개의 브랜드만 존재한다.)

층을 입력하면 그 층에 위치한 브랜드를 알 수 있다.

 (1층 - 샤넬 / 2층 - 리바이스 / 3층 - 아디다스)

백화점의 이름과 층은 한번에 확인할 수 있다.

층수를 입력하기 전에 사용자에게 몇 층을 입력받을지 질문을 해준다.

만약 없는 층이나 잘못된 값을 입력했을 시 층 수를 다시 물어본다.
*/
public class Department_4 {
	private String brandname; // 브랜드명
	private int floor; // 층
	
	public Department_4 (String brandname, int floor) { // 오버로딩 생성자 : 브랜드명과 층이 있다.
		this.brandname = brandname; 
		this.floor = floor;
	}	
	public void Dep_print() { // 이름과 층은 한번에 확인할 수 있다.
		System.out.println(this.floor + "층 - " + this.brandname);
	}
}
