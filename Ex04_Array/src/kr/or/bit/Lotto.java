package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

public class Lotto {
	private int[] numbers; // = new int[6]; 사용하지 않음/ 생성자에서 초기화.
	private Random r;
	private Scanner scanner;
	// 위 3가지 변수는 Lotto class 에 있는 모든 함수가 사용할 수 있다.
	
	public Lotto() {
		//[초기화] 는 [생성자] 에게.. 이쁜설계도.....
		numbers = new int[6]; //원칙적으로 초기화는 생성자에서.
		r = new Random();
		scanner  = new Scanner(System.in);
		
	}
	// 각 기능 분리 : 함수 : 함수 하나당 기능 하나.
	public void selectLottoNumber() {
loop_1:while(true) {
			String selection = showMenu(scanner);
			switch(selection) {
				case "1":
						do {
							makeLottoNumber(r,numbers);
						}while(!checkAverage(numbers));
						showNumbers(numbers);
						break;
				case "2": // 프로그램 종료 (return, System.exit(0), 함수 나가기 )
					System.out.println("Good Lucky");
					break loop_1;
				default : System.out.println("Not in Operation");
					break;
			}	
		}
	}
	
	//로또번호 만드는 함수.
	private void makeLottoNumber(Random r, int[] numbers) {
		
		for (int i = 0 ; i < numbers.length ; i++ ) { // 0부터 5까지 1씩 증가 / 방 6개 순환
			numbers[i] = r.nextInt(45) +1; // 방에 1~45 랜덤숫자 할당
			
			for (int j = 0; j  < i ; j++) { // 0부터 i보다 작을때 / 비교할 방. 0번부터비교. // j < i 채워진 갯수부터 비교.
				if( numbers[i] == numbers[j] ) { // 값 비교 시 같으면 
					i--; // i 감소 => i 방의 값 재할당을 위해. // 1번방 == 0번방 같으면 i는 0이 되고 올라가면서 i++되어 1번방에 랜덤숫자 재할당.
					break; // j가 걸린 for 문 탈출
				}
			}
		}
	}
	
	//규칙 (배열의 합의 평균 특정 범위 해당되면 추출... 그렇지 않으면 재추출)
	private boolean checkAverage (int[] numbers) {
		int sum = 0;
		int average = 0;
		for ( int i = 0 ; i < numbers.length ; i++) {
			sum+= numbers[i];
		}
		average = sum/numbers.length;
		System.out.println("평균 : " + average);
		return(average >= 15 && average <= 25);
	}
	
	private void showNumbers(int[] numbers) {
		System.out.println("[선택한 번호] ");
		
		for ( int j = numbers.length-1; j > 0 ; j-- ) {// 5부터 1까지 1씩 감소 / 비교하는 횟수 / 5,4,3,2,1
			
			for (int i = 0; i < j ; i++ ) { // 0부터 5 까지 1씩 증가 / 비교하는 방1 의 번호 / 0번방, 1번방, 2번방... ( 횟수가 반복될수록 비교하는 방이 줄어듬)
				
				if ( numbers[i] > numbers[i+1] ) { // 0번방과 1번방을 비교해서 0번방이 크면 1번방과 값 교체 / 1번 > 2번 , 2번 > 3번 ...
					int result = numbers[i+1];
					numbers[i+1] = numbers[i];
					numbers[i] = result;
				}
			}			
		}
		for (int i = 0 ; i < numbers.length ; i++) {
			System.out.printf("[%2d]",numbers[i]);
		}
		System.out.println();
	}
	

	// 메뉴 설정 기능 함수
	private String showMenu(Scanner scanner) {
		System.out.println("***********************");
		System.out.println("1. 당첨 예상 번호 추출하기 : ");
		System.out.println("2. 프로그램 종료^^");
		System.out.println("***********************");
		System.out.printf("원하는 작업 번호를 선택하세요 : ");
		String selection = scanner.nextLine();
		return selection;
	}
	
}
