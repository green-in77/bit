import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 Map 인터페이스
 Map > (키, 값)쌍의 구조를 갖는 배열
 ex) 지역번호 : (02, 서울)
 key : 중복불가 /  value : 중복가능
 
 Generic 형식 지원
 
 HashTable (구버전) - 동기화 보장O
 HashMap (신버전) - 동기화 보장X : 성능고려
 현재는 동기화 고민 X : Thread  쓰지 않으면.... >> 단일 >> 동기화 의미 X (순차실행)
 
 */

public class Ex11_Map_Interface {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		
		// ID, PW 관리에 활용 ( ID 는 중복이 없고, PW는 중복이 있음)
		map.put("Tiger", "1004");
		map.put("scott","1004");
		map.put("superman", "1007");
		
		// Collection 데이터 가질 수 있다. > 프로그램이 동작되는 동안만....
		// 휘발성 메모리 >> 프로그램종료 >> 데이터 보존(파일기반) >> 사원.txt, 회원.txt
		// 파일 데이터 다루기 힘들다 >> RDBMS( 관계형 데이터베이스)
		
		// containsKey -> key 의 포함여부 / 있니??? 
		// containsValue -> Value 의 포함여부
		System.out.println(map.containsKey("tiger")); //  false >> 자바는 대소문자를 구분함.
		System.out.println(map.containsKey("scott")); // true
		System.out.println(map.containsValue("1004")); //ture
		
		//(key, value)
		//key 값을 가지고 value 값을 얻어낸다
		// map.get -> 키값의 value 를 반환
		System.out.println(map.get("Tiger")); //1004
		System.out.println(map.get("hong")); // null // 해당되는 Key 가 없으면 value >> null
		
		//put
		map.put("Tiger", 1008); // Key 가 같은 경우에는 value 값을 덮어써버림.(overwrite) >> "1004" -> 1008
		System.out.println(map.get("Tiger")); //1008
		
		//remove - 
		Object returnvalue = map.remove("superman"); // 키+값 삭제.
		System.out.println(returnvalue); // 삭제한 키의 value return
		System.out.println("size : " + map.size());
		System.out.println(map);
		
		// keySet -> key 값만 뽑아서 set 타입으로 만듬.
		Set set = map.keySet(); // Set 구현한 HashSet ... 생성 data 를 넣고 그 주소를 return
		//key 는 중복X, 순서X 데이터의 집합
		
		Iterator it = set.iterator();
		while ( it.hasNext()) {
			System.out.println("key : " + it.next());
		}
		
		// values -> 키 값만 뽑아서 List 타입으로 만듬
		// values 는 중복O
		Collection list = map.values();
		System.out.println(list);
		
		Iterator it2 = list.iterator();
		while ( it2.hasNext()) {
			System.out.println("Value : "+it2.next());
		}
		
		
	}
}
