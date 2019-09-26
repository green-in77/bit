import java.util.Scanner;

//반복문(while , do~while)
public class Ex10_Statement {

	public static void main(String[] args) {
		int i = 10;
		while( i >= 10) { // 조건이 true 무한반복 // (int i >= 10 ) while 문은 이렇게 쓰지 않음.
			System.out.println(i);
			//반드시 명시적인 증가감!!
			i--;
		}
		
		//while (1~100) 까지의 합
		
		int j = 1;
		int sum=0;
		
		while( j <= 100) {
			sum += j; //sum = sum + j;
			j++; //명시적인 증가감 // 주의 !! 연산작업 후 증가감하기
		}
		System.out.println("1~100까지의 합은 : "+sum);
		
		// while 구구단
		
		int k = 2;
		int p = 1;
		
		while ( k <= 9 ) {
			p = 1; // p를 다시 1로 할당.
			while ( p <= 9 ) {
				System.out.printf("%d x %d = %d \t",k,p,k*p);
				p++;
			}
			k++;
			System.out.println();
		}
		System.out.println(k);
		
		
		
		//do ~ while : 강제적 수행(실행) -> 무조건 1번은 실행하겠다.
		// do {실행문} while (조건)
		// 메뉴구성
		// 1. 인사업무 
		// 2. 급여업무
		// 당신이 원하는 업무 번호를 입력하세요. (무조건 한번...)
		// 3. 입력하면 조건에서 true 조건을 만들어서 다시 입력 받도록 강제하는 방법.
		
		Scanner sc = new Scanner(System.in); // 데이터를 입력받기 위한 것
		int inputdata=0;
		// 0~10 까지 입력받기 / 10보다 큰 값을 입력하면 다시 입력받는 것으로 돌아감.
		do {
			System.out.println("숫자입력해(0~10)");
			inputdata = Integer.parseInt(sc.nextLine());
		}while(inputdata > 10); // 조건 true 면 do 문을 계속 실행
		// 10보다 큳 값이 오면 true .. do 반복실행
		//0~10까지의 값이 입력되면 false while 탈출!
		System.out.println("당신이 입력한 값은 : " + inputdata);

		
		
		
	}

}
