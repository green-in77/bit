// 사용중 비 순차적으로 데이터가 삽입되거나, 삭제될 경우 매우 비효율적 ( 자리를 매꿔버림 )

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
		
		System.out.println("특정 방에 있는 값  : " + arraylist.get(0));
		
		//add 순차적으로 데이터를 배열에 넣어줌.
		//add 함수 오버로딩 : 특정위치에 데이터를 넣을 수 있게.
		
		arraylist.add(0, 111);// 데이터를 덮어쓰지 않고, 데이터를 뒷방으로 밀어버림.
		System.out.println("특정 방에 있는 값 : " + arraylist.get(0));
		System.out.println(arraylist); //[111, 100, 200, 300]
		
		// 비 순차적인 데이터의 추가, 삭제 ArrayList 성능상 좋지 않음.
		// 순차적인 데이터 추가, 삭제에 쓰는 자료구조.
		
		// 데이터를 삽입 ( add ) : 위치를 지정해서 삽입가능( 중간에 )  >> 모든 데이터가 이동됨.
		//add(index, element), remove()
		
		//ArrayList 가지는 함수 공부
		System.out.println(arraylist.contains(200)); // 해당 값을 가지고 있는지.
		System.out.println(arraylist.contains(333));
		System.out.println(arraylist.isEmpty()); // 비어있니??? false // true == size가 0인 것.
		

		arraylist.clear(); // 방의 값을 모두 비우는 것. => size를 0으로 만들기
		System.out.println(arraylist.isEmpty());
		
		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		System.out.println(arraylist);
		
		//삭제 (remove)
		System.out.println("삭제전 : " + arraylist.size());
		Object value = arraylist.remove(0); //index 0번방 값 삭제// 지우는 값 return;
		System.out.println("삭제된 데이터 : " + value); // 삭제된 데이터
		System.out.println(arraylist);
		System.out.println("삭제후 : " + arraylist.size());
		
		// Today Point
		//일상다반사.........
		List li = new ArrayList(); // 부모는 자식객체를 담을 수 있다...상속관계
		//li 는 List 의 것만 접근 가능.
		// li = new Vector(); // Vector 도 List를 구현하고 있기 때문에!가능
		
		li.add("가");
		li.add("나");
		li.add("다");
		li.add("라");
		
		List li4 = li.subList(0, 2); // 0번부터 2개 가져와서 새 객체를 만들어서 주소값을 li4 에 저장. // new ArrayList() >> add("가"), add("나")
		// subList return 하는 것은 ArrayList 객체의 주소값
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
		
		Collections.sort(alist); //정렬 // list 계열의 보조 클래스
		System.out.println("after : " + alist);
		
		
		
	}
}
