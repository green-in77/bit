
public class Ex02_Exception {

	public static void main(String[] args) {
		int num = 100;
		int result = 0;
		
		try {
			for(int i = 0; i < 10 ; i++) {
				result = num / (int)(Math.random()*10);//0 ~ 9 까지 나올 수 있음.. 0으로 나눌 수 없음. 
				System.out.println("result : " + result + " i : " + i);
			}
		} catch (ArithmeticException e) { // ★★★ 객체의 주소값을 받는다(ArithmeticException) 
			System.out.println("연산 예외 발생 [관리자 메일보내기]");
			System.out.println(e.getMessage());
			// e.printStackTrace(); // 문제가 된 코드의 라인문구까지 가져와서 출력.
			
		} catch (Exception e2) { // 연산 이외의 나머지 예외는 내가 처리할께!! ( 작은 단위를 위로) // 다형성. Exception 은 모든 예외의 부모객체.(상속관계)
			// Exception 문제 없고 다 해결되지만...
			// 어떤 예외를 잡을지 알 수 없음... 코드의 가독성이 떨어짐..
			// 직접적인 예외를 명시해주는 것이 좋음....
		}
		
		System.out.println("Main 함수 종료");
		
	}
	//연산관련 예외 객체 발생 : java.lang.ArithmeticException
	// 예외가 발생하면 그 문제에 따른 객체를 생성한다.( new 하지 않아도 자동으로)
	//ArithmeticException aa = new ArithmeticException();
	// aa.setMessage("문제발생");
}
