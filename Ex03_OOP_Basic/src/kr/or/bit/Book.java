package kr.or.bit;
/*
 å�� å�̸��� ������ �ְ�, ������ ������ �ִ�.
 å�� ���ǵǸ� �ݵ�� å �̸��� å�� ������ ������ �־�� �Ѵ�.
 å�� �̸��� ���� ������ Ư�� ����� ���ؼ��� �� �� �ְ�, ���ǵ� ���Ŀ��� ������ �� ����.
 å�̸��� ���������� ����Ȯ�� �� �� �ִ�.
 */

public class Book {
	private String bookname; // å�̸�
	private int bookprice; // å����

	public Book (String bookname, int bookprice) { // ������ �����ε� : Book ���� �� �̸��� ������ �ݵ�� �Է��ؾ� ��.
		this.bookname = bookname;
		this.bookprice = bookprice;
	}
	
	public void all_print() { // å�� �̸��� ������ ��� ��ȸ�ϴ� �Լ�
		System.out.printf("��ȸ�Ͻ� å�� �̸��� %s , ������ %d ���Դϴ�.\n", bookname, bookprice);
	}

	public String getBookname() { // å �̸��� �������� getter �Լ�	
		return bookname;
	}

	public int getBookprice() { // å ������ �������� getter �Լ�
		return bookprice;
	}
}
