import kr.or.bit.Fclass;
import kr.or.bit.Tv;

public class Ex02_Mathod {
	public static void main(String[] args) {
		Fclass fc = new Fclass();
		fc.m(); // 이름을 부르는 행위(call) : m() 함수 호출
		
		int input = 200;
		fc.m2(input);
		
		int result = fc.m3(); // return 타입이 있다면 그 값을 변수에 담아서 사용.
		System.out.println("fc.m3 의 return value : " + result );
		
		result = fc.m4(500);
		System.out.println("fc.m4의 return value : " + result );
		
		int sum = fc.sum(10, 20, 500); // parameter  3개면 3개 무조건 입력 / 2개만 입력, 1개만 입력 불가
		System.out.println("sum : " + sum);
		
		int sum2 = fc.sum2(-10);
		System.out.println("sum2 : " + sum2);
		
		int max = fc.Max(400, -30);
		System.out.println("max : " + max);
		
		String str = fc.concat("안녕", "방가", "배고파");
		System.out.println("concat : " + str);
		
		//main 함수 시작
		Tv t = fc.objMethod();
		System.out.println("t : " + t);
		System.out.println("t.brand : " + t.brand);
		
		Tv t2 = fc.ojbMethod2();
		
		System.out.println( t == t2 );
		System.out.println("t2 : " + t2);

		//t의 주소값과 t2 의 주소값은 다름.
		
		Tv t3 = fc.objMathod3(t2); // F3 누르면 함수로 바로 이동.
		
		// t2 주소값과 t3 의 주소값은 같음.
		
		System.out.println(t2 == t3);
		System.out.println("t3 : " + t3 );
		
	}
}