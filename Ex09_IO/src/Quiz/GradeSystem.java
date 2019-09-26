package Quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class GradeSystem {
	private static HashMap<Integer, Grade> map;
	private static int count;
	private Scanner sc;
	private static File file;
	
	public GradeSystem() { // 생성자로 초기화..
		this.map = new HashMap<Integer, Grade>();
		this.count = 1;
		this.sc =  new Scanner(System.in);
		this.file = new File("grage.txt"); // 저장할 파일명 ( 덮어쓰기로 저장)
	}
	
	public int choice() { // 메뉴 선택
		int choice = Integer.parseInt(sc.nextLine());
		return choice;
	} //choice close
	
	public void add() { // 추가
		Grade grade = new Grade(); // map 에 넣을 grade 객체 생성
		this.map.put(count, grade.input(grade)); // map 에 키 = 번호, 값 = grade 객체 를 저장 
		this.count++; // 데이터 추가 후 key 값 1 증가
	} // add close
	
	public void del() { //삭제
		System.out.print("삭제하실 번호를 입력해주세요 : ");
		int num = Integer.parseInt(this.sc.nextLine()); //삭제할 키값을 받아서
		if ( this.map.containsKey(num) ) { //키가 있으면..
			this.map.remove(num);
			System.out.println("삭제되었습니다.");
		}else {
			System.out.println("번호를 잘못입력하셨습니다. 해당 번호가 없습니다.");
		}
	} //del close
	
	public void print() { // 콘솔출력
		Set<Integer> set =this.map.keySet();
		Iterator it = set.iterator();
		while ( it.hasNext() ) {
			int key = (int)it.next();
			System.out.println(key+" : " + this.map.get(key).toString());
		}	
	} // print close
	
	public void save() { // 파일로 저장
		FileOutputStream fo=null; 
		ObjectOutputStream ob=null; // 직렬화해서 객체를 파일로 저장하기 위해 사용.
		
		try {
			fo = new FileOutputStream(this.file);
			ob = new ObjectOutputStream(fo);
			
			ob.writeObject(this.map); // map 객체를 직렬화해서 내보냄.
			
			ob.flush(); // 직렬화된 map 객체를 파일에 씀.
			
		} catch (Exception e) {
			System.out.println("파일 저장하기를 실패했습니다.");
			e.printStackTrace();
		}finally {
			try { //다 썼으니까 닫아주고...
				ob.close(); 
				fo.close();
			} catch (IOException e) {
				System.out.println("에러!!");
				e.printStackTrace();
			}
		}
		System.out.println("파일로 저장되었습니다.");
	}// save close
	
	public void load() { // 파일읽어오기
		FileInputStream fi = null;
		ObjectInputStream ob = null;
		
		try {
			fi = new FileInputStream(this.file);
			ob = new ObjectInputStream(fi);
			
			this.map = (HashMap)ob.readObject(); // 직렬화 해서 내보냈던 객체 다시 읽어와서 map에 저장.
			
			Set<Integer> set = this.map.keySet(); // 키 값을 set 으로 return 해서..
			Iterator it = set.iterator();
			while (it.hasNext()) {
				int key = (int)it.next();
				System.out.println(key + " : " + this.map.get(key).toString());
			}
			
		} catch (Exception e) {
			System.out.println("파일 불러오기를 실패했습니다.");
			e.printStackTrace();
		} finally {
			try {
				ob.close();
				fi.close();
			} catch (IOException e) {
				System.out.println("에러발생!!");
				e.printStackTrace();
			}
			
		}		
	}//load close
	
}
