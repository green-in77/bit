import java.util.Scanner;

public class Ex08_Statement {

	public static void main(String[] args) {
	
		System.out.println("입력");
		Scanner sc = new Scanner(System.in);
				// Ctrl + Shift + 0 (import 자동생성하기)
		if(sc.hasNextInt()) { // 의문형 함수 > true or false 값을 반환 / has // 입력받은 값이 정수인가?
			System.out.println("정수값이야");		
		}else {
			System.out.println("다른값인데");
		}
		
		// sc.hasNextLine() 문자열 데이터인가? >> True or False
	 
		
		//제어문 (암기하자!!!!!)
		//조건문 ( if 3가지 - 단일, if-else, if-elseif-else), (switch(){case .... break})
		//반복문 ( for - 반복횟수 명확), (while - 반복횟수가 명확하지 않음. true, false), do~while()
		//분기문 ( break - 블럭탈출, continue -  아래구문 skip)
		
		int count = 0;
		if (count < 1) {
			System.out.println("True 입니다.");
		}
		//실행 블럭을 생략가능 - 
		//자바 - ; (세미콜론)은 문장의 끝. (해석의 단위) 
		if (count < 10)    // 한줄로 써도 상관없음. if (count < 10) System.out.println("{True}");
			System.out.println("{True}");
		
		//코드를 외우지 말고 시나리오를 외우기!!!!!
		
		char data = 'A';
		switch(data) { //switch 인자값 : int 숫자(정수), char 문자, String 문자열 가능)
			case 'A' : System.out.println("문자비교");
				break; // 탈출범위는 switch 블럭
			default : System.out.println("else 모든 것");
		}
		
		//반복문
		int sum = 0;
		for(int i = 1; i <= 10; i++) { // i는 1로 시작해서 i가 10보다 작거나 같으면 실행 시키고 i값 증가
			//System.out.println(i);
			//누적값
			sum += i; //sum = sum + i
		}
		
		System.out.println("sum 1~10 : " +  sum);
		
		// for 문을 사용해서 1~10 까지의 홀수의 합 구하기
		//단 for 하나만 쓰기.( for 문안에 if문 쓰지 말기)
		
		sum = 0;
		for (int i = 1; ( i <= 10 ) ; i+=2) { // 증가감 값을 변경해서
			sum += i;
		}
		
		System.out.println("1~10 중 홀수의 합: " +  sum);

		// 1~100 까지의 짝수의 합. (if 문 사용)
		int sum3=0;
		for (int i = 0; i <= 100 ; i++) {
			if( i %2 == 0 ) {
				sum3 += i;	// sum3 = sum3 + i
			}
		}
		System.out.println("1~100 까지의 짝수의 합 : " + sum3 );
		
		//입사시험 필수문제
		//구구단 짜기 (중첩 for 문 사용하기)
		//2단(1~9) ~ 9단(1~9) 연산
		
		for (int i = 2; i <= 9 ; i++){
			for (int j = 1 ; j <= 9 ; j++) {
				System.out.printf("%d x %d = %d \t", i,j,i*j);
			}
			System.out.println();
		}
		
		System.out.println();
		
		//key point : break - 탈출 , continue -스킵
		
		for (int i = 2; i <= 9 ; i++){
			for (int j = 1 ; j <= 9 ; j++) {
				if(i == j ) {
					break; // 안쪽 for 문 탈출 // 2*2 단 이후로 안나옴
				}
				System.out.printf("%s","*"); // 별1개, 2개, 3개, 4개 ~~ 8개까지 출력
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 2; i <= 9 ; i++){
			for (int j = 1 ; j <= 9 ; j++) {
				if(i == j ) continue; // 아래의 구문만 스킵	 // 2*2, 3*3만 안나오고 나머지는 나옴.
				System.out.printf("%d x %d = %d \t", i,j,i*j);
				//System.out.printf("%s","*"); // 별1개, 2개, 3개, 4개 ~~ 8개까지 출력
			}
			System.out.println();
		}
		
		for (int i = 100; i >= 0 ; i-- ){
			System.out.println(i);
		}
		
		System.out.println("피보나치수열");
		
		int a=0, b=1, c=0;
		
		for(int i = 0; i <10; i++) {
			a=b;
			b=c;
			c=a+b;
			System.out.println(c);
			
		}
	
		//많이 쓰이는 로직 (데이터 정렬할떄) 외워두기.
		for(int i = 2 ; i <= 9 ; i++) {
			for(int j = 1 ; j < i  ; j++) {  // j <= 9 
				System.out.print("*");
			}
			System.out.println();
		}
		
		

	}

}
