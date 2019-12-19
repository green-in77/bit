import kr.or.bit.Book;

import kr.or.bit.Airplane;
import kr.or.bit.Card;

public class Ex05_Static_CardMake {

	public static void main(String[] args) {
		
		/*
		 처음 요구사항		 
		Card c = new Card();
		c.number = 1;
		c.kind = "heart";
		c.cardInfor();
		
		Card c2 = new Card();
		c.number = 2;
		c.kind = "heart";
		c.cardInfor();
		*/
		// ... 53장을 만들었다.
		// 고객 : 카드크기크기변경요청 : h = 70, w =50
		
		Card c = new Card();
		c.number = 1;
		c.kind = "heart";
		c.h = 70; // static 값 바꾸기 // Card.h 
		c.w = 50; // static 값 바꾸기 // Card.w
		c.cardInfor();
		
		Card c2 = new Card();
		c.number = 2;
		c.kind = "heart";
		c.cardInfor();
		
		//53번의 수정을 하기보다 1번의 수정으로... ( 모든 객체에서 공통으로 쓰는 값.)
		
		System.out.println();
	/*	
		Airplane air = new Airplane();
		air.makeAir(171,"대한");
		
		Airplane air2 = new Airplane();
		air2.makeAir(212,"제주");
		
		Airplane air3 = new Airplane();
		air3.makeAir(848,"이스타");
			
		air3.airsumprint();
	*/	
		
		Airplane air1 = new Airplane("대한",777);
		air1.air_print();
		
		Airplane air2 = new Airplane("제주", 142);
		air2.air_print();
		
		Airplane air3 = new Airplane("이스타", 374);
		air3.air_print();
		
		air1.airsum_print();
		System.out.println();

		String book1name = null;
		String book2name = null;
		String book3name = null;
		
		int book1price = 0;
		int book2price = 0;
		int book3price = 0;
		
		Book book1 = new Book("나나",30000); // book 생성 이름, 가격지정 필수
		book1.all_print(); // 이름, 가격 모두 조회
		//book1.bookname_print(); // 이름만 조회
		//book1.bookprice_print(); // 가격만 조회
		book1name = book1.getBookname();
		book1price = book1.getBookprice();
		
		Book book2 = new Book("모모", 25000);
		book2.all_print();
		//book2.bookname_print();
		//book2.bookPrice_print();
		book2name = book2.getBookname();
		book2price = book2.getBookprice();
		
		Book book3 = new Book("Java", 28000);
		book3.all_print();
		//book3.bookname_print();
		//book3.bookPrice_print();
		book3name = book3.getBookname();
		book3price = book3.getBookprice();
		
		
	}

}
