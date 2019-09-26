import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

// Collection Framework
// ������ �ڿ��� ���� ���������� �����ؼ� ���� �����ϴ� ǥ�� ����
// Iterator �������̽�
// 1. hasNext(), Next() ...������
// 2. Iterator : ������ ������ Read ���� (�ܹ���)
// 3. ListIterator : ����� ������ Read ���� ǥ��ȭ
// ���� �ʾƵ� ������ ��ȸ ����... [ǥ��ȭ]�� ���� ����غ� �ʿ䰡 ����. �������� ��Ȯ�ϰ� �� �� �ְ�...

public class Ex08_Collection_Iterator {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		
		for ( int i = 0 ; i < list.size() ; i++) {
			System.out.println("[" + list.get(i) + "]");
		}
		
		for ( Object o : list) {
			System.out.println(o);
		}
		
		//ǥ��ȭ �� ������ ������ ������ ����ϱ�
		// Iterator �������̽�
		// Collection { Iterator iterator(); //�߻��Լ� }
		// List extends Collection
		// ArrayList implements List
		// ArrayList iterator() �� ��������. {����� �ڵ� ����}
		// �θ�Ÿ���� Iterator ���ؼ� ArrayList �� ������ �޸𸮿� ����
		
		Iterator it = list.iterator();
		while(it.hasNext()) { // hasNext (ArrayList ��������)  ���� �ִ�? �ִٸ�...
			System.out.println(it.next()); //next (ArratList ��������) ������
		}
		
		//int data = 100; // ��Ÿ�� int // int �������� > Integer Ŭ���� (���ʸ��� ��Ÿ���� �� �� ����, ��üŸ�Ը� �� �� ����)
		ArrayList<Integer> intlist = new ArrayList<Integer>(); // �������� ����
		
		intlist.add(44);
		intlist.add(55);
		intlist.add(66);
		
		Iterator<Integer> list2 = intlist.listIterator(); // ���ʸ� ���� =>Iterator �� ���ʸ� �����
		while ( list2.hasNext() ) {
			System.out.println(list2.next());
		}
		
		//������ for
		for ( int i = intlist.size()-1 ; i >= 0 ; i--) {
			System.out.println(intlist.get(i));
		}
		
		// Iterator �� �������� �Ұ�( ������ ��ȸ�� ������. )
		// �׷��� ListIterator !!(�����)
		
		// ������ ��ȸ �ߴٰ� ������ ��ȸ
		// �ٷ� ������ ��ȸ�� �Ұ�
		ListIterator<Integer> li2 = intlist.listIterator();
		// ������
		while ( li2.hasNext()) {
			System.out.println(li2.next()); // �����Ͱ� ���������� ������.
		}
		
		// ������
		while (li2.hasPrevious()) { //�������� �ִ�?
			System.out.println("["+li2.previous()+"]"); //������ ���
		}

	}
}
