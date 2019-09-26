import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex10_Set_TreeSet {
	public static void main(String[] args) {
		// Set (순서X, 중복값X)
		HashSet<String> hs = new HashSet<String>();
		hs.add("B");
		hs.add("A");
		hs.add("F");
		hs.add("K");
		hs.add("G");
		hs.add("D");
		hs.add("P");
		hs.add("A");
		
		System.out.println(hs); // toString() 생략 //[P, A, B, D, F, G, K]
		
		// HashSet 확장 > LinkedHashSet ( 순서유지 -> 값을 넣은 순서 ) Linked(주소를 관리) >>node 활용
		Set<String> hs2 = new LinkedHashSet<String>();
		hs2.add("B");
		hs2.add("A");
		hs2.add("F");
		hs2.add("K");
		hs2.add("G");
		hs2.add("D");
		hs2.add("P");
		hs2.add("A");
		System.out.println(hs2); //[B, A, F, K, G, D, P] >> 넣은 순서를 보장. 배열아니고 node !!!!!!!!!!
		
		//TreeSet
		// 자료구조(순서X), 중복(X), 정렬(O))
		// 검색하거나 정렬을 필요로 하는 자료구조의 데이터를...
		// 1. 저장된 데이터의 값에 따라서 정렬
		// 2. 원리 : 이진트리 ( 데이터 검색 용이 )
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
