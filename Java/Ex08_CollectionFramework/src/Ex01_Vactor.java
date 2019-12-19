import java.util.Vector;

/*
CollectionFramework ( 집합 데이터를 다루는 라이브러리의 모음 )
[다수의 데이터]를 다루는 [표준화된 인터페이스]를 구현하고 있는 클래스의 집합

 Collection 인터페이스 <- List(상속) (인터페이스 끼리 상속가능 - 더 큰 약속) < ---- 구현 ArrayList(★) .....
 											줄을서시오 -> 순서가있고, 중복가능
 									   <- Set(상속) (인터페이스 끼리 상속가능 - 더 큰 약속) <---- 구현 HashSet, TreeSet ......
 									   		원으로들어가!-> 순서가 없고, 중복불가

Map 인터페이스 (Key, Value) <---- 구현 HashMap(★)
-----------------------------------------------------------------------------------------
List interface = 줄을서시오 >> Vector , ArrayList
 : 순서(번호)가 있고, 중복가능 >> 내부적으로 데이터(자료,객체) 배열로 관리. >> Array[0][1]...
 
 1. Vector (구버전) - 현재는 잘 사용하지 않음. -> 동기화(멀티쓰레드) -> lock (보호) -> 성능이 떨어질 수 있음 : 한강화장실
 2. ArrayList (신버전) -> 동기화(멀티쓰레드) -> lock(x) -> 필요에 따라 lock 가능 -> 성능고려 : 비빔밥
 
 Array (배열)
 방의 개수가 고정(한번 방의 크기를 정하면 변경 불가)
 int [] arr = new int[10]
 int [] arr = {10,20,30}
 
 Array (고정)
 1. 배열의 크기가 고정 : Car[] cars = {new Car(), new Car()} : 방 2개
 2. 접근방법 : index(첨자) 접근 >> cars[0]... cars[0].color = "red";
 3. 초기 설정한 크기는 변경 불가
 
 List 인터페이스를 구현한 클래스
 1. 배열의 크기를 동적으로 확장, 축소가 가능 >> 배열의 재할당!! ( 새로 만들어서 이사시킴)
 2. 순서를 유지 (Array) , 순서 (index), 중복값 허용
 3. 데이터 저장공간 (Array)
 4. List 인터페이스 구현하는 클래스는 (new 통해서 객체 생성 사용)
 5. 구현한 클래스의 데이터 저장 공간의 타입 : int[] list = new int[10], Emp[] elist = {}
 	 default Type : Object Type >> 최상위 타입 >> 장점 : [모든 타입]을 데이터로 사용가능
 	>> Object[] obj = new Object[10]; >> obj[0] = 10, obj[1] = new car() 등등..
 	>> 단점 : 타입체크...casting >> 해결 (Object 타입 단점극복) - 제너릭(generic) 타입
 	>> 제너릭(generic) : 타입을 강제해서 하나의 타입만 넣게하는 방법

 */
public class Ex01_Vactor {
	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("초기 default 용량 : "+v.capacity()); // 초기 방 10개 기본셋팅
		v.add("AA");
		v.add("BB");
		v.add("AA");
		v.add(100);
		
		System.out.println(v);// toString()생략 >> Object >> 재정의(overrice) toString()
		
		//size -> 값이 있는 방의 갯수.
		for ( int i = 0; i < v.size(); i++) { // 정적배열은 length , Vector은 size 로 배열 길이확인( 값이 들어있는 방의 길이만큼만 )
			System.out.println(v.get(i)); // get 함수 -> i 배열의 값을 리턴 : return Type = Object
		}
		
		//개선된 for
		for (Object obj : v)  {
			System.out.println(obj);
		}
		
		//제너릭 >> 타입을 강제하는 것.
		Vector<String> v2 = new Vector<String>(); // <넣을타입>
		v2.add("Hello");
		v2.add("World");
		v2.add("King");
		//v2.add(1); String 타입이 아니기 때문에 에러
		
		for ( String str : v2) {
			System.out.println(str);
		}
		System.out.println(v2);
		System.out.println(v2.get(2));
		System.out.println("size(실 데이터 개수) : " + v2.size());
		System.out.println("capacity(배열방의 크기) : " + v2.capacity()); //기본 10개
		
		Vector v3 = new Vector();
		System.out.println(v3.capacity());
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		System.out.println("10개 : " + v3.capacity()); // 10
		
		v3.add("A");
		System.out.println("11개 : " + v3.capacity()); //20
		System.out.println("size : " + v3.size()); //11

	}
}
