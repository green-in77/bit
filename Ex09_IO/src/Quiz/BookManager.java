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

			default: System.out.println("잘못 선택하였습니다.");break;

			}

		}

		System.out.println("종료합니다...");

	}

	int selectMenu(){

		System.out.println("1:추가 2:삭제 3:검색 4:저장 5:로드 6:도서 목록 7:ISBN 목록 0:종료");

		int key = scan.nextInt();

		scan.nextLine();

		return key;

	}

	void addBook(){

		String isbn;           

		System.out.print("추가할 도서 ISBN:");

		isbn = scan.nextLine();

		if(book_dic.containsKey(isbn)){

			System.out.println("이미 존재하는 ISBN입니다.");

			return;

		}

		String title;

		int price;

		System.out.print("도서 제목:");

		title = scan.nextLine();

		System.out.print("가격:");

		price = scan.nextInt();

		scan.nextLine();

		Book book = new Book(isbn,title,price);

		book_dic.put(isbn, book);

		System.out.println(book.toString()+" 생성하였습니다."); 



	}

	void removeBook(){

		String isbn;           

		System.out.print("삭제할 도서 ISBN:");

		isbn = scan.nextLine();

		if(book_dic.containsKey(isbn)){

			book_dic.remove(isbn);

			System.out.println("삭제하였습니다.");                 

		}

		else{

			System.out.println("존재하지 않습니다.");               

		}             

	}

	void searchBook(){

		String isbn;           

		System.out.print("검색할 도서 ISBN:");

		isbn = scan.nextLine();

		if(book_dic.containsKey(isbn)){

			Book book = book_dic.get(isbn);

			System.out.println("검색 결과>>"+book.toString());                                           

		}

		else{

			System.out.println("존재하지 않습니다.");               

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
				System.out.println("저장되었습니다.");
			}else {
				System.out.println("이미 존재하는 파일입니다.");
				System.out.println("1. 덮어쓰기 2.돌아가기");
				int choice = Integer.parseInt(scan.nextLine());
				switch (choice) {
				case 1:
					ob.writeObject(book_dic);
					ob.flush();
					System.out.println("저장되었습니다.");
					break;
				case 2:
					System.out.println("처음메뉴로 돌아갑니다.");
					break;
				default:
					System.out.println("잘못입력하셨습니다.");
					break;
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("파일 저장하기를 실패했습니다.");
			e.printStackTrace();
		}finally {
			try {
				ob.close();
				fo.close();
			} catch (IOException e) {
				System.out.println("에러발생!!");
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
			System.out.println("파일 불러오기를 실패했습니다.");
			e.printStackTrace();
		}finally {
			try {
				ob.close();
				fi.close();
			} catch (IOException e) {
				System.out.println("에러발생!!!!");
				e.printStackTrace();
			}
		}
	}

	void listBook(){

		System.out.println("도서 목록");

		int cnt = book_dic.size();

		System.out.println("도서 수:"+cnt);

		for(Book book : book_dic.values()){

			System.out.println(book.toString());

		}
	}

	void listISBN(){

		System.out.println("ISBN 목록");

		int cnt = book_dic.size();

		System.out.println("도서 수:"+cnt);

		for(String isbn : book_dic.keySet()){

			System.out.println(isbn);

		}

	}

}

