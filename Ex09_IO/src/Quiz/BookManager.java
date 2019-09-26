package Quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BookManager {

	Scanner scan = new Scanner(System.in);

	HashMap<String, Book> book_dic = new HashMap<String, Book>();

	public void Run(){

		int key = 0;

		while((key = selectMenu())!=0){

			switch(key){

			case 1: addBook(); break;

			case 2: removeBook(); break;

			case 3: searchBook(); break;
			
			case 4: saveBook(); break;
			
			case 5: loadBook(); break;

			case 6: listBook(); break;

			case 7: listISBN(); break;

			default: System.out.println("�߸� �����Ͽ����ϴ�.");break;

			}

		}

		System.out.println("�����մϴ�...");

	}

	int selectMenu(){

		System.out.println("1:�߰� 2:���� 3:�˻� 4:���� 5:�ε� 6:���� ��� 7:ISBN ��� 0:����");

		int key = scan.nextInt();

		scan.nextLine();

		return key;

	}

	void addBook(){

		String isbn;           

		System.out.print("�߰��� ���� ISBN:");

		isbn = scan.nextLine();

		if(book_dic.containsKey(isbn)){

			System.out.println("�̹� �����ϴ� ISBN�Դϴ�.");

			return;

		}

		String title;

		int price;

		System.out.print("���� ����:");

		title = scan.nextLine();

		System.out.print("����:");

		price = scan.nextInt();

		scan.nextLine();

		Book book = new Book(isbn,title,price);

		book_dic.put(isbn, book);

		System.out.println(book.toString()+" �����Ͽ����ϴ�."); 



	}

	void removeBook(){

		String isbn;           

		System.out.print("������ ���� ISBN:");

		isbn = scan.nextLine();

		if(book_dic.containsKey(isbn)){

			book_dic.remove(isbn);

			System.out.println("�����Ͽ����ϴ�.");                 

		}

		else{

			System.out.println("�������� �ʽ��ϴ�.");               

		}             

	}

	void searchBook(){

		String isbn;           

		System.out.print("�˻��� ���� ISBN:");

		isbn = scan.nextLine();

		if(book_dic.containsKey(isbn)){

			Book book = book_dic.get(isbn);

			System.out.println("�˻� ���>>"+book.toString());                                           

		}

		else{

			System.out.println("�������� �ʽ��ϴ�.");               

		}

	}
	
	void saveBook() {
		File file =new File( "booklist.txt");
		FileOutputStream fo = null;
		ObjectOutputStream ob = null;
		try {
			fo = new FileOutputStream(file);
			ob = new ObjectOutputStream(fo);
			
			if (!file.exists()) {
				ob.writeObject(book_dic);
				ob.flush();
				System.out.println("����Ǿ����ϴ�.");
			}else {
				System.out.println("�̹� �����ϴ� �����Դϴ�.");
				System.out.println("1. ����� 2.���ư���");
				int choice = Integer.parseInt(scan.nextLine());
				switch (choice) {
				case 1:
					ob.writeObject(book_dic);
					ob.flush();
					System.out.println("����Ǿ����ϴ�.");
					break;
				case 2:
					System.out.println("ó���޴��� ���ư��ϴ�.");
					break;
				default:
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
					break;
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("���� �����ϱ⸦ �����߽��ϴ�.");
			e.printStackTrace();
		}finally {
			try {
				ob.close();
				fo.close();
			} catch (IOException e) {
				System.out.println("�����߻�!!");
				e.printStackTrace();
			}	
		}
		
	}
	
	void loadBook() {
		File file = new File("booklist.txt");
		FileInputStream fi = null;
		ObjectInputStream ob = null;
		
		try {
			fi = new FileInputStream(file);
			ob = new ObjectInputStream(fi);
			
			book_dic = (HashMap) ob.readObject();
			
			Set<String> set = book_dic.keySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				System.out.println(book_dic.get(it.next()).toString());
			}
			
		} catch (Exception e) {
			System.out.println("���� �ҷ����⸦ �����߽��ϴ�.");
			e.printStackTrace();
		}finally {
			try {
				ob.close();
				fi.close();
			} catch (IOException e) {
				System.out.println("�����߻�!!!!");
				e.printStackTrace();
			}
		}
	}

	void listBook(){

		System.out.println("���� ���");

		int cnt = book_dic.size();

		System.out.println("���� ��:"+cnt);

		for(Book book : book_dic.values()){

			System.out.println(book.toString());

		}
	}

	void listISBN(){

		System.out.println("ISBN ���");

		int cnt = book_dic.size();

		System.out.println("���� ��:"+cnt);

		for(String isbn : book_dic.keySet()){

			System.out.println(isbn);

		}

	}

}

