import java.util.Scanner;

public class Ex_print {

	public static void main(String[] args) {
		
		// 알파벳(A~Z) 까지 출력하는 프로그램을 작성하세요
		// (for 문을 사용하세요)
		int count = 1; // count 선언 및 초기화.
		
		for(count = 65 ; count <= 90 ; count++) { // 65~90 까지 1씩 증가하며 실행
			System.out.print((char)count); // count 에 해당하는 아스키 코드 문자 출력.
			
		}
		
		System.out.println();
		//1~100까지 10행 10열로 출력하는 프로그램을 작성하세요
		//(for문을 사용하세요)
		
		for( count=1 ; count <= 100 ; count++) { // 1부터 100까지 1씩 증가하며 실행
			System.out.printf("%d ",count); // count 출력
			if( (count % 10) == 0) { // count 가 10으로 나눴을때 0이면 실행
				System.out.println(); // 줄바꿈
			}
		}
		System.out.println();
		
		// 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하는 프로그램
		int sum=0; // 합계를 저장해 줄 변수 선언 및 초기화.
		
		for ( int i = 1; i <= 20 ; i++ ){ // 1~20 까지 1씩 증가하며 반복
			if( ((i%2) != 0) || ((i%3) != 0) ) { // 2로 나눈 나머지가 0이 아니거나(2의 배수가 아니거나) 3으로 나눈 나머지가 0이 아니거나( 3의 배수가 아니거나)
				sum += i; // 합계저장
				System.out.printf("%d ",i);
			} 
			
		}
		System.out.printf("\n1~20까지 정수 중 2 또는 3의 배수가 아닌 수의 총 합 : %d",sum); // 합계 출력
		
		System.out.println();
		System.out.println();
		
		// 두개의 주사위를 던졌을 때 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램
		
		for (int i = 1 ; i <= 6 ; i++ ) { // 1번 주사위 1~6까지 1씩 증가하면서 반복
			for (int j = 1; j <= 6 ; j++) { // 2번 주사위 1~6까지 1씩 증가하면서 반복
				if( ((i+j) == 6)) { // 1번 주사위 + 2번 주사위 = 6 이면 실행
					System.out.printf("1번 주사위 %d + 2번 주사위 %d = %d\n", i,j,i+j); // 출력
				}
			}				
		}
		
		System.out.println();
		
		
		//가위 , 바위 ,보 게임 또 제어문을 통해서 작성하세요 (IF)
		// ex) 컴퓨터가 자동으로 나온 가위 , 바위 , 보 에 대해서 사용자가 값을 입력 해서 처리 하세요		( 예를 들면 : 가위=> 1   , 바위 => 2  , 보 => 3)
		Scanner sc = new Scanner(System.in);
		int random = 1;
		String com = "";
		int pushnum = 0;
		
		/*
		do {
			random = (int)(Math.random()*10)+1;
		} while (random > 3);
		*/
		
		random = (int)(Math.random()*3)+1; // 1부터 3까지의 정수 랜덤할당
		//System.out.println(random);
				
		System.out.printf("가위, 바위, 보 를 입력하세요 : ");
		
		String push = sc.nextLine(); //사용자 값 입력받기/
		
		if (random == 1) { // 랜덤 값을 가위,바위,보 로 변환 1이면 가위, 2이면 바위, 나머지 보( 랜덤 숫자 1~3 까지만 출력됨.
			com = "가위";
		} else if (random == 2) {
			com = "바위";
		} else { 
			com = "보";
		}
		
				
		if (push.equals("가위")) { // 입력받은 값에 따라 정수로 변경
			pushnum = 1;
		} else if (push.equals("바위")) {
			pushnum = 2;
		} else if ( push.equals("보")) {
			pushnum = 3;
		} else {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		
		System.out.printf("사용자 %s : 컴퓨터 %s \n", push, com); // 사용자 값, 랜덤 값 출력.
		
		if ( pushnum == random) // 가위 바위 보 승패비교
		{
			System.out.println("비겼습니다.");
		} else if ( (pushnum == 1 && random == 2) || (pushnum == 2 && random == 3) || (pushnum == 3 && random == 1 )) {
			System.out.println("사용자가 졌습니다.");
		} else {
			System.out.println("사용자가 이겼습니다.");
		}		

	}

}
