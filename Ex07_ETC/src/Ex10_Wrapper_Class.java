import java.util.ArrayList;

/*
 8가지 기본 타입 제공 (값 타입)
 
 8가지 기본 타입에 대해서 객체 형태로 사용가능 하도록 만든 것(wrapper class)
 
 기본타입도 때로는 객체형태로 다루어져야 하는 경우
 1. 매개변수로 객체가 요구될때
 2. 기본형 값이 아닌 객체로 저장되어야할때
 3. 객체간의 비교가 필요할때
 이때 wrapper class 가 필요함.
*/
public class Ex10_Wrapper_Class {
	public static void main(String[] args) {
		// Integer.parseInt(s);
		// ArrayList<Integer> //제너릭은 wrapper class 사용
		int i = 100;
		
		//ArrayList<Boolean>
		//ArrayList<Character>
		
		Integer n = new Integer(500);
		System.out.println(n); // 500 ( 실제로는 주소값이 있어야 하나 toString 오버라이드 해놨음 : String 클래스와 같음)
		
		// POINT
		// parameter 로 값 타입이 객체로 사용될 때
		// generic 사용시
		
		ArrayList<Integer> li = new ArrayList<Integer>();
		li.add(100);
		li.add(200);
		
		for ( int value : li) { // Integer 이지만 나오는 값이 정수이기 때문에 int 사용 가능
			System.out.println(value);
		}
		
		Integer i2 = new Integer(100);
		Integer i3 = new Integer(100);
		
		System.out.println(i2 == i3); // false // == 주소값을 비교하는 연산자이기 때문에 ...
		System.out.println(i2.equals(i3)); // true
		// Object 의 equals 를 Integer 클래스에서 재정의 ( 실제 값을 비교하도록...  100 == 100)
		
		Integer t = new Integer(500);
		integerMathod(t); // t라는 참조변수의 주소값을 전달
		intMethod(t); // t라는 참조변수가 가지는 값 전달
		
	}
	
	static void integerMathod(Integer i) {
		System.out.println("Integer param : " + i);
	}
	
	static void intMethod(int i) {
		System.out.println("int parma : " + i);
		i = 1000; // t 값은 변하지 않음. 
	}
	
}
