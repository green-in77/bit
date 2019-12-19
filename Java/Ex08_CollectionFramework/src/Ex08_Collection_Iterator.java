import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

// Collection Framework
// 나열된 자원에 대해 순차적으로 접근해서 값을 리턴하는 표준 정의
// Iterator 인터페이스
// 1. hasNext(), Next() ...구현해
// 2. Iterator : 순방향 데이터 Read 보장 (단방향)
// 3. ListIterator : 양방향 데이터 Read 보장 표준화
// 쓰지 않아도 데이터 조회 가능... [표준화]에 대해 고민해볼 필요가 있음. 누가봐도 명확하게 알 수 있게...

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
		
		//표준화 된 형식의 나열된 데이터 출력하기
		// Iterator 인터페이스
		// Collection { Iterator iterator(); //추상함수 }
		// List extends Collection
		// ArrayList implements List
		// ArrayList iterator() 를 강제구현. {실행블럭 코드 구현}
		// 부모타입인 Iterator 통해서 ArrayList 가 구현한 메모리에 접근
		
		Iterator it = list.iterator();
		while(it.hasNext()) { // hasNext (ArrayList 강제구현)  값이 있니? 있다면...
			System.out.println(it.next()); //next (ArratList 강제구현) 가져와
		}
		
		//int data = 100; // 값타입 int // int 참조형식 > Integer 클래스 (제너릭은 값타입은 쓸 수 없음, 객체타입만 올 수 있음)
		ArrayList<Integer> intlist = new ArrayList<Integer>(); // 정수값만 가능
		
		intlist.add(44);
		intlist.add(55);
		intlist.add(66);
		
		Iterator<Integer> list2 = intlist.listIterator(); // 제너릭 형태 =>Iterator 도 제너릭 써야함
		while ( list2.hasNext() ) {
			System.out.println(list2.next());
		}
		
		//역방향 for
		for ( int i = intlist.size()-1 ; i >= 0 ; i--) {
			System.out.println(intlist.get(i));
		}
		
		// Iterator 는 역방향은 불가( 순방향 조회만 가능함. )
		// 그래서 ListIterator !!(양방향)
		
		// 순방향 조회 했다가 역방향 조회
		// 바로 역방향 조회는 불가
		ListIterator<Integer> li2 = intlist.listIterator();
		// 순방향
		while ( li2.hasNext()) {
			System.out.println(li2.next()); // 포인터가 마지막으로 가있음.
		}
		
		// 역방향
		while (li2.hasPrevious()) { //이전값이 있니?
			System.out.println("["+li2.previous()+"]"); //이전값 출력
		}

	}
}
