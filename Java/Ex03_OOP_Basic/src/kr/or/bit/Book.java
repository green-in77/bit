package kr.or.bit;
/*
 책은 책이름을 가지고 있고, 가격을 가지고 있다.
 책이 출판되면 반드시 책 이름과 책의 가격을 가지고 있어야 한다.
 책의 이름과 가격 정보는 특정 기능을 통해서만 볼 수 있고, 출판된 이후에서 수정할 수 없다.
 책이름과 가격정보는 각각확인 할 수 있다.
 */

public class Book {
	private String bookname; // 책이름
	private int bookprice; // 책가격

	public Book (String bookname, int bookprice) { // 생성자 오버로딩 : Book 생성 시 이름과 가격을 반드시 입력해야 함.
		this.bookname = bookname;
		this.bookprice = bookprice;
	}
	
	public void all_print() { // 책의 이름과 가격을 모두 조회하는 함수
		System.out.printf("조회하신 책의 이름은 %s , 가격은 %d 원입니다.\n", bookname, bookprice);
	}

	public String getBookname() { // 책 이름을 가져오는 getter 함수	
		return bookname;
	}

	public int getBookprice() { // 책 가격을 가져오는 getter 함수
		return bookprice;
	}
}
