import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.Vector;


//Set �������̽� ����
//Set : ����X( �迭X ), �ߺ���X ������ ����...
// HashSet, TreeSet
public class Ex09_Set_Interface {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(1);
		hs.add(100);
		boolean bo2 = hs.add(55);
		System.out.println(bo2); // true > ���������� ���� ��
		
		System.out.println(hs.toString());
		
		boolean bo = hs.add(1); // �����Ͱ� �߰����� ����/ �ߺ����� ������ ����. // boolean return
		System.out.println(bo);  //false > ������ ���� �����Ͱ� ����
		
		hs.add(2);
		System.out.println(hs.toString()); // 1,2,100,55 > ������ ����.
		
		HashSet<String> hs2 = new HashSet<String>();
		hs2.add("b");
		hs2.add("A");
		hs2.add("F");
		hs2.add("c");
		hs2.add("z");
		
		System.out.println(hs2.toString());
		
		// 1. �ߺ� ������(X) 
		String[] obj = {"A", "B","A","C","D","B","A"};
		
		HashSet<String> hs3 = new HashSet<String>();
		for ( int i =0 ; i < obj.length ; i++) {
			hs3.add(obj[i]);
		}
		System.out.println(hs3.toString());
		
		//Quiz
		//HashSet ����ؼ� 1~45 ���� ���� 6���� ��������.
		// �� �ߺ����� ������ �ȵ�.
		//(int)( Math.raandom()*45)+1

		HashSet<Integer> Lotto = new HashSet<Integer>();
		System.out.println(Lotto.size());
		int index=0;
		/*
		for ( int i = 0 ; Lotto.size() < 6 ; i++) {
			index++; // 6���� �ֱ����� ����� ���ҳ�??
			int num = (int)(Math.random()*45)+1;
			Lotto.add(num);
		}
		System.out.println(Lotto.toString());
		System.out.println(index);
		*/
		
		while ( Lotto.size()< 6 ) {
			index++;
			int num = (int)(Math.random()*45)+1;
			Lotto.add(num);
		}
		System.out.println(Lotto.toString());
		System.out.println(index);
		
		
		HashSet<String> set3 = new HashSet<String>();
		set3.add("AA");
		set3.add("DD");
		set3.add("ABC");
		set3.add("FFFF");
		
		System.out.println(set3.toString());
		
		Iterator<String> it3 = set3.iterator();
		while ( it3.hasNext()) {
			System.out.println(it3.next());
		} // ������ �������� ����.
		
		// Collections.sort(list); // parameter �δ� list interface �� �����ϰ� �ִ� ��ü�� �ּҸ� �ü�����.
		//									Vector, ArrayList, Stack >> �迭�� �Ǿ��־ ������ �ٲ� �� ����.
		// HashSet >> �迭�� �ƴ�X (������ ���� ����)�� �ڸ��� ������ �� ��� ������ �� �� ����.
		//Collections.reverse(list); ������...( sort > 1,2,3,4.... ===>>> reverse > ...4,3,2,1 )
		
		// Set ���վȿ� �ִ� �����͸� ������ �ְ����...
		// 1. ���屸���� Array �� �ٲ�.
		
		List list = new ArrayList(set3);
		System.out.println("before ������ : "+list);
		
		Collections.sort(list);
		System.out.println("after ���� : "+list);
		
		Collections.reverse(list);
		System.out.println("reverse ���� : "+list);
		
	}
}
