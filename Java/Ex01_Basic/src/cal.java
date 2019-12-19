/*
간단한 사칙 연산기 (+ , - , * , /)
입력값 3개 (입력값은 nextLine() 받아서 필요하다면 숫자 변환)
목적 : Integer.parseInt() ,  equals() 활용
화면
>입력값:숫자
>입력값(기호): +
>입력값:숫자 
>연산결과 :200

-------------
>입력값:100
>입력값(기호): -
>입력값:100
>연산결과 :0
*/

import java.util.Scanner;

public class cal {

	public static void main(String[] args) {
		
		//피드백 - 필요한 변수 상단에 미리 초기화선언하고 사용하기.★★★★
		
		Scanner sc = new Scanner(System.in); //스캐너 타입의 sc를 선언(입력받는것을 할 수 있는 )
		
		// Ctrl + Shift + 0 (import 자동생성하기)
		
		System.out.println("숫자1을 입력하세요.");
		int number1 = Integer.parseInt(sc.nextLine()); //문자열을 입력받아서 숫자로 변환해서 number1 에 할당.
		
		System.out.println("연산자를 입력하세요(+,-,*,/)");
		String str = sc.nextLine(); // 문자열을 입력받아 str에 할당 // 이것도 지역변수!
		
		System.out.println("숫자2를 입력하세요.");
		int number2 = Integer.parseInt(sc.nextLine()); //문자열을 입력받아서 숫자로 변환해서 number2 에 할당.
		
		int result1 = 0; // 연산의 결과값을 저장할 변수를 선언 및 초기화
		
		if(str.equals("+")) { // 문자열의 비교는 equals 를 쓰기 / == 을 쓸 경우 문자가 들어가있는 주소값을 비교하기 떄문에 문제가 생길 수 있음.
			result1 = number1 + number2;
			
		}else if (str.equals("-")) {
			result1 = number1 - number2;
			
			
		}else if (str.equals("*")) {
			result1 = number1 * number2;
			
			
		}else if (str.equals("/")) {
			result1 = number1 / number2;
		
		}
		else {
			System.out.println("연산자를 잘못입력하셨습니다.");
			return; // 반환할 값이 없음. 함수 종료 - 여기서는 main 을 종료함.
		}
		
		System.out.printf("%d %s %d = %d 입니다. \n", number1, str, number2, result1);
	
	}
}
