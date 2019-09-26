// ����� �� ���������� �����Ͱ� ���Եǰų�, ������ ��� �ſ� ��ȿ���� ( �ڸ��� �Ų���� )

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

// Today Point
public class Ex02_ArrayList {
	public static void main(String[] args) {
		ArrayList arraylist = new ArrayList();
		
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);
		
		System.out.println(arraylist);
		
		for (int i = 0; i < arraylist.size(); i++) {
			System.out.println(arraylist.get(i));
		}
		
		for ( Object obj : arraylist) {
			System.out.println(obj);
		}
		
		System.out.println("Ư�� �濡 �ִ� ��  : " + arraylist.get(0));
		
		//add ���������� �����͸� �迭�� �־���.
		//add �Լ� �����ε� : Ư����ġ�� �����͸� ���� �� �ְ�.
		
		arraylist.add(0, 111);// �����͸� ����� �ʰ�, �����͸� �޹����� �о����.
		System.out.println("Ư�� �濡 �ִ� �� : " + arraylist.get(0));
		System.out.println(arraylist); //[111, 100, 200, 300]
		
		// �� �������� �������� �߰�, ���� ArrayList ���ɻ� ���� ����.
		// �������� ������ �߰�, ������ ���� �ڷᱸ��.
		
		// �����͸� ���� ( add ) : ��ġ�� �����ؼ� ���԰���( �߰��� )  >> ��� �����Ͱ� �̵���.
		//add(index, element), remove()
		
		//ArrayList ������ �Լ� ����
		System.out.println(arraylist.contains(200)); // �ش� ���� ������ �ִ���.
		System.out.println(arraylist.contains(333));
		System.out.println(arraylist.isEmpty()); // ����ִ�??? false // true == size�� 0�� ��.
		

		arraylist.clear(); // ���� ���� ��� ���� ��. => size�� 0���� �����
		System.out.println(arraylist.isEmpty());
		
		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		System.out.println(arraylist);
		
		//���� (remove)
		System.out.println("������ : " + arraylist.size());
		Object value = arraylist.remove(0); //index 0���� �� ����// ����� �� return;
		System.out.println("������ ������ : " + value); // ������ ������
		System.out.println(arraylist);
		System.out.println("������ : " + arraylist.size());
		
		// Today Point
		//�ϻ�ٹݻ�.........
		List li = new ArrayList(); // �θ�� �ڽİ�ü�� ���� �� �ִ�...��Ӱ���
		//li �� List �� �͸� ���� ����.
		// li = new Vector(); // Vector �� List�� �����ϰ� �ֱ� ������!����
		
		li.add("��");
		li.add("��");
		li.add("��");
		li.add("��");
		
		List li4 = li.subList(0, 2); // 0������ 2�� �����ͼ� �� ��ü�� ���� �ּҰ��� li4 �� ����. // new ArrayList() >> add("��"), add("��")
		// subList return �ϴ� ���� ArrayList ��ü�� �ּҰ�
		System.out.println(li4);
		
		
		ArrayList alist = new ArrayList();
		alist.add(50);
		alist.add(1);
		alist.add(7);
		alist.add(40);
		alist.add(45);
		alist.add(3);
		alist.add(15);
		
		System.out.println("before : " + alist);
		
		Collections.sort(alist); //���� // list �迭�� ���� Ŭ����
		System.out.println("after : " + alist);
		
		
		
	}
}
