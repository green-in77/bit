import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex10_Set_TreeSet {
	public static void main(String[] args) {
		// Set (����X, �ߺ���X)
		HashSet<String> hs = new HashSet<String>();
		hs.add("B");
		hs.add("A");
		hs.add("F");
		hs.add("K");
		hs.add("G");
		hs.add("D");
		hs.add("P");
		hs.add("A");
		
		System.out.println(hs); // toString() ���� //[P, A, B, D, F, G, K]
		
		// HashSet Ȯ�� > LinkedHashSet ( �������� -> ���� ���� ���� ) Linked(�ּҸ� ����) >>node Ȱ��
		Set<String> hs2 = new LinkedHashSet<String>();
		hs2.add("B");
		hs2.add("A");
		hs2.add("F");
		hs2.add("K");
		hs2.add("G");
		hs2.add("D");
		hs2.add("P");
		hs2.add("A");
		System.out.println(hs2); //[B, A, F, K, G, D, P] >> ���� ������ ����. �迭�ƴϰ� node !!!!!!!!!!
		
		//TreeSet
		// �ڷᱸ��(����X), �ߺ�(X), ����(O))
		// �˻��ϰų� ������ �ʿ�� �ϴ� �ڷᱸ���� �����͸�...
		// 1. ����� �������� ���� ���� ����
		// 2. ���� : ����Ʈ�� ( ������ �˻� ���� )
		//TreeSet
		
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		for ( int i = 0; lotto.size() < 6 ; i++) {
			lotto.add((int)(Math.random()*45)+1);
		}
		
		//System.out.println(lotto);
		
		Iterator<Integer> lo = lotto.iterator();
		while ( lo.hasNext()) {
			System.out.println(lo.next());
		}		

	}

}
