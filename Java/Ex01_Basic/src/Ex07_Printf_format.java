import java.util.Scanner; // 패키지명 없이 scanner 쓸 수 있다.

public class Ex07_Printf_format {
	public static void main(String[] args) {
		
		//java : System.out.println();
		// C#  : Consol.writeLine();
		
		//System.our.println(); 엔터효과가 있는 출력
		System.out.print("B");
		System.out.print("C");
		System.out.println("D");
		
		int num = 100;
		System.out.println(num);
		System.out.println("num 값은 :" + num + " 입니다.");
		
		//형식(format)
		
		System.out.printf("num 값은 :%d 입니다. \n", num);
		//fotmat 형식 문자
		// %d (10진수 형식의 정수) >> d라는 자리에
		// %f (실수)
		// %s (문자열)
		// %c (문자)
		// 특수문자 : \t (tap), \n(줄바꿈) 등
		
		System.out.printf("num 값은 [%d] 입니다. 그리고 [%d] 도 있어요.\n", num, 1000);
		float f = 3.14f;
		System.out.println(f); // 3.14 만 출력
		System.out.printf("f 변수값은 %f 입니다\n", f); // 3.140000 까지 출력
		
		//cmd(console) 창에서 입력한 값 읽어오기
		//java.util.Scanner sc = new java.util.scanner(System.in);
		//import 구문 사용 ... Scanner 사용

		Scanner sc = new Scanner(System.in);
	/*
		System.out.println("값을 입력하세요.");
		
		String value = sc.nextLine(); // 입력 대기 상태 - 입력이 완료(엔터)되면 종료 / 입력되기 전까지는 프로그램이 계속 실행중. / 문자열을 리턴하는 함수. - 숫자를 입력해도 문자로 인식
		System.out.println("입력값 : " + value);
		
		int number = sc.nextInt(); // 정수값을 리턴하는 함수 , 문자 입력 시 에러. // 이클립스에서 실행 시 프로그램이 죽을 수 있음.
		System.out.println("정수값 : " + number);
		
		//sc.nextFloat(); // 실수 값 읽기
		
		//권장사항 : nextInt , nextFloat 함수 보다는 nextLine 을 사용하자 - 버그있어서
		//Today Point★★★★★★★★★★★★★★★★★
		//문자를 숫자로 바꾸기
		//Inter.parseInt 정수로변경
		//Float.parseFloat 실수로 변경
		//Double.parseDouble 실수로 변경
		
		Integer.parseInt(value); // 변수에 들어가있는 문자열을 정수로 변경해줌.
	
		System.out.println("숫자 입력하세요.");
		int number = Integer.parseInt(sc.nextLine()); // 입력받은 문자열을 정수로 변경해서 넘버에 할당
		System.out.println("정수값 : " + number);
		
		//Tip
		//숫자를 -> 문자로 (가끔)
		String data = String.valueOf(10000);
		System.out.println(data);
		
	*/
		System.out.println("숫자1을 입력하세요.");
		int number1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("연산자를 입력하세요(+,-,*,/)");
		String str = sc.nextLine();
		
		System.out.println("숫자2를 입력하세요.");
		int number2 = Integer.parseInt(sc.nextLine());
		
		int result = 0;
		
		if(str.equals("+")) {
			result = number1 + number2;
		}else if (str.equals("-")) {
			result = number1 - number2;
		}else if (str.equals("*")) {
			result = number1 * number2;
		}else if (str.equals("/")) {
			result = number1 / number2;
		}else {
			//System.out.println("연산자를 잘못입력하셨습니다.");
		}
		
		System.out.printf("%d %s %d = %d 입니다.\n", number1, str, number2, result);
		
	}

}
