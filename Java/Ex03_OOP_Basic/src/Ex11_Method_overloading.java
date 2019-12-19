/*
 객체지향언어
 1. 상속(재사용성)
 2. 캡슐화(private) -> 함수 (read, write)  : 간접할당 (자원보호) -> 캡슐화된 member field 를 read(get) , write(set) 전용함수
 								-> getter, setter -> 약속 getEmpno, setEmpno (get, set 을 붙이고 앞글자 대문자로)  
 3. 다형성
 
 [다형성의 한 부분]
 
 [ method overloading ]
 하나의 이름으로 여러가지 기능을 하는 함수.
 사용 : System.out.println()
 특징 : 오버로딩은 성능 향상에 도움을 안준다.
 			why > 편하게 사용하려고....... >> 개발자가..
 		    고민(설계도 어떤점을 생각하면) >> 함수의 활용이 많은 경우(다양한 parameter 를 사용)
 		    활용이 많다 -> static method 도 같이 생각해보기.
 
 문법 : 함수의 이름은 같고 parameter 의 갯수와 타입을 달리하는 방법.
 1. 함수의 이름은 같아야 한다.
 2. [parameter] 개수 또는 [Type] 달라야 한다.
 3. return type overloading 의 판단기준이 아니다(상관없음)
 4. parameter  의 순서가 다르다.
  
  */
class Human { // 설계도 = 타입
	String name;
	int age;
}

class OverTest {
	
	void add(Human h) { //갯수는 같지만 타입이 다름 오버로딩인정
			h.name = "홍길동";	// h  = Human 객체의 주소값을 받는다.;
			h.age = 100;
			System.out.println(h);
	}
	
	int add(int i) { // int add(int s) 같은 함수 -> 오버로딩 아님. 
		return 100+i;
	}
	
	String add(String s) { // 타입이 다르기 때문에 오버로딩 인정
		return "hello"+s;
	}
	
	int add(int i , int j) { // parameter 의 개수가 달라서 오버로딩 인정
		return i+j;
	}
	void add(int i, String s) { //type 이 달라서 오버로딩 인정
		System.out.println(i + " / " + s);
	}
		
	void add(String s, int i) { // parameter 의 순서가 달라서 오버로딩 인정
		System.out.println(i + "/" + s);
	}
	
	// 배열에 있는 Ex05_Array_Object 마치고 나서...
	//Array.. 배열은 객체다. >> 배열이 갖고있는 것은 주소값.
	
	int[] add(int[] param) { //param 변수가 받는 값은 주소값.. ( int 배열을 참조하는 주소값)
		int[] target = new int[param.length];
		for (int i = 0 ; i < param.length ; i++) {
			target[i] = param[i]+1;
		}
		return target; // 배열은 기본값이 null
	}
	
	int[] add(int[] so, int[] so2) {
		//자율코드...
		for ( int i = 0 ; i < so.length ; i++  ) {
			so[i] = so2[i];
			so2[i] = so[i]+1; 
			System.out.println(so[i]+" / " + so2[i]);
		}
		return null;
	}
	
	
	
}

public class Ex11_Method_overloading {

	public static void main(String[] args) {
		OverTest ot = new OverTest();
		int result = ot.add(100);
		System.out.println(result);
		
		String str = ot.add("홍길동");
		System.out.println(str);
		
		// 1
		Human m = new Human(); // m =  Human 객체의 주소값 
		System.out.println(m); // Human@15db9742
		ot.add(m); //Human@15db9742
		
		//2
		ot.add(new Human()); // heap 에 생성된 객체의 주소를 바로 전달.	
	
		//Array parameter 로 또는 return Type 사용
		//////////////////////////////////////////////////////////////////
		int[] source = {10,20,30,40,50};
		int[] target = ot.add(source);
		
		System.out.println(source == target);
		// 개선된 for문 : 배열 or Collection (다중값) 
		for (int value : target) {
			System.out.println(value);
		}
		/*
		 for (int i = 0; i < target.length ; i++) {
		 	System.out.println(target[i]);
		 } 
		 */
		//////////////////////////////////////////////////////////////////////
		
		int[] so = {10 , 20 , 30};
		int[] ta = {11 , 21 , 31};
		int[] ta2 = ot.add(so, ta);
	}

}
