import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.Vector;


//Set 인터페이스 구현
//Set : 순서X( 배열X ), 중복값X 데이터 집합...
// HashSet, TreeSet
public class Ex09_Set_Interface {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(1);
		hs.add(100);
		boolean bo2 = hs.add(55);
		System.out.println(bo2); // true > 정상적으로 값이 들어감
		
		System.out.println(hs.toString());
		
		boolean bo = hs.add(1); // 데이터가 추가되지 않음/ 중복값이 없음을 보장. // boolean return
		System.out.println(bo);  //false > 기존에 같은 데이터가 있음
		
		hs.add(2);
		System.out.println(hs.toString()); // 1,2,100,55 > 순서가 없음.
		
		HashSet<String> hs2 = new HashSet<String>();
		hs2.add("b");
		hs2.add("A");
		hs2.add("F");
		hs2.add("c");
		hs2.add("z");
		
		System.out.println(hs2.toString());
		
		// 1. 중복 데이터(X) 
		String[] obj = {"A", "B","A","C","D","B","A"};
		
		HashSet<String> hs3 = new HashSet<String>();
		for ( int i =0 ; i < obj.length ; i++) {
			hs3.add(obj[i]);
		}
		System.out.println(hs3.toString());
		
		//Quiz
		//HashSet 사용해서 1~45 까지 난수 6개를 넣으세요.
		// 단 중복값이 있으면 안됨.
		//(int)( Math.raandom()*45)+1

		HashSet<Integer> Lotto = new HashSet<Integer>();
		System.out.println(Lotto.size());
		int index=0;
		/*
		for ( int i = 0 ; Lotto.size() < 6 ; i++) {
			index++; // 6개를 넣기위해 몇번을 돌았나??
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
		} // 순서를 보장하지 않음.
		
		// Collections.sort(list); // parameter 로는 list interface 를 구현하고 있는 객체의 주소만 올수있음.
		//									Vector, ArrayList, Stack >> 배열로 되어있어서 순서를 바꿀 수 있음.
		// HashSet >> 배열이 아님X (순서가 없기 때문)에 자리를 지정할 수 없어서 정렬을 할 수 없음.
		//Collections.reverse(list); 뒤집기...( sort > 1,2,3,4.... ===>>> reverse > ...4,3,2,1 )
		
		// Set 집합안에 있는 데이터를 순서를 주고싶음...
		// 1. 저장구조를 Array 로 바꿈.
		
		List list = new ArrayList(set3);
		System.out.println("before 무작위 : "+list);
		
		Collections.sort(list);
		System.out.println("after 정렬 : "+list);
		
		Collections.reverse(list);
		System.out.println("reverse 정렬 : "+list);
		
	}
}
