import kr.or.bit.Book;

import kr.or.bit.Airplane;
import kr.or.bit.Card;

public class Ex05_Static_CardMake {

	public static void main(String[] args) {
		
		/*
		 ó�� �䱸����		 
		Card c = new Card();
		c.number = 1;
		c.kind = "heart";
		c.cardInfor();
		
		Card c2 = new Card();
		c.number = 2;
		c.kind = "heart";
		c.cardInfor();
		*/
		// ... 53���� �������.
		// �� : ī��ũ��ũ�⺯���û : h = 70, w =50
		
		Card c = new Card();
		c.number = 1;
		c.kind = "heart";
		c.h = 70; // static �� �ٲٱ� // Card.h 
		c.w = 50; // static �� �ٲٱ� // Card.w
		c.cardInfor();
		
		Card c2 = new Card();
		c.number = 2;
		c.kind = "heart";
		c.cardInfor();
		
		//53���� ������ �ϱ⺸�� 1���� ��������... ( ��� ��ü���� �������� ���� ��.)
		
		System.out.println();
	/*	
		Airplane air = new Airplane();
		air.makeAir(171,"����");
		
		Airplane air2 = new Airplane();
		air2.makeAir(212,"����");
		
		Airplane air3 = new Airplane();
		air3.makeAir(848,"�̽�Ÿ");
			
		air3.airsumprint();
	*/	
		
		Airplane air1 = new Airplane("����",777);
		air1.air_print();
		
		Airplane air2 = new Airplane("����", 142);
		air2.air_print();
		
		Airplane air3 = new Airplane("�̽�Ÿ", 374);
		air3.air_print();
		
		air1.airsum_print();
		System.out.println();

		String book1name = null;
		String book2name = null;
		String book3name = null;
		
		int book1price = 0;
		int book2price = 0;
		int book3price = 0;
		
		Book book1 = new Book("����",30000); // book ���� �̸�, �������� �ʼ�
		book1.all_print(); // �̸�, ���� ��� ��ȸ
		//book1.bookname_print(); // �̸��� ��ȸ
		//book1.bookprice_print(); // ���ݸ� ��ȸ
		book1name = book1.getBookname();
		book1price = book1.getBookprice();
		
		Book book2 = new Book("���", 25000);
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
