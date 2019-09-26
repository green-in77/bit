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
	
	public GradeSystem() { // �����ڷ� �ʱ�ȭ..
		this.map = new HashMap<Integer, Grade>();
		this.count = 1;
		this.sc =  new Scanner(System.in);
		this.file = new File("grage.txt"); // ������ ���ϸ� ( ������ ����)
	}
	
	public int choice() { // �޴� ����
		int choice = Integer.parseInt(sc.nextLine());
		return choice;
	} //choice close
	
	public void add() { // �߰�
		Grade grade = new Grade(); // map �� ���� grade ��ü ����
		this.map.put(count, grade.input(grade)); // map �� Ű = ��ȣ, �� = grade ��ü �� ���� 
		this.count++; // ������ �߰� �� key �� 1 ����
	} // add close
	
	public void del() { //����
		System.out.print("�����Ͻ� ��ȣ�� �Է����ּ��� : ");
		int num = Integer.parseInt(this.sc.nextLine()); //������ Ű���� �޾Ƽ�
		if ( this.map.containsKey(num) ) { //Ű�� ������..
			this.map.remove(num);
			System.out.println("�����Ǿ����ϴ�.");
		}else {
			System.out.println("��ȣ�� �߸��Է��ϼ̽��ϴ�. �ش� ��ȣ�� �����ϴ�.");
		}
	} //del close
	
	public void print() { // �ܼ����
		Set<Integer> set =this.map.keySet();
		Iterator it = set.iterator();
		while ( it.hasNext() ) {
			int key = (int)it.next();
			System.out.println(key+" : " + this.map.get(key).toString());
		}	
	} // print close
	
	public void save() { // ���Ϸ� ����
		FileOutputStream fo=null; 
		ObjectOutputStream ob=null; // ����ȭ�ؼ� ��ü�� ���Ϸ� �����ϱ� ���� ���.
		
		try {
			fo = new FileOutputStream(this.file);
			ob = new ObjectOutputStream(fo);
			
			ob.writeObject(this.map); // map ��ü�� ����ȭ�ؼ� ������.
			
			ob.flush(); // ����ȭ�� map ��ü�� ���Ͽ� ��.
			
		} catch (Exception e) {
			System.out.println("���� �����ϱ⸦ �����߽��ϴ�.");
			e.printStackTrace();
		}finally {
			try { //�� �����ϱ� �ݾ��ְ�...
				ob.close(); 
				fo.close();
			} catch (IOException e) {
				System.out.println("����!!");
				e.printStackTrace();
			}
		}
		System.out.println("���Ϸ� ����Ǿ����ϴ�.");
	}// save close
	
	public void load() { // �����о����
		FileInputStream fi = null;
		ObjectInputStream ob = null;
		
		try {
			fi = new FileInputStream(this.file);
			ob = new ObjectInputStream(fi);
			
			this.map = (HashMap)ob.readObject(); // ����ȭ �ؼ� �����´� ��ü �ٽ� �о�ͼ� map�� ����.
			
			Set<Integer> set = this.map.keySet(); // Ű ���� set ���� return �ؼ�..
			Iterator it = set.iterator();
			while (it.hasNext()) {
				int key = (int)it.next();
				System.out.println(key + " : " + this.map.get(key).toString());
			}
			
		} catch (Exception e) {
			System.out.println("���� �ҷ����⸦ �����߽��ϴ�.");
			e.printStackTrace();
		} finally {
			try {
				ob.close();
				fi.close();
			} catch (IOException e) {
				System.out.println("�����߻�!!");
				e.printStackTrace();
			}
			
		}		
	}//load close
	
}
