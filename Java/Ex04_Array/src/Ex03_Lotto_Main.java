/*
 1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요
 2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요.
 3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요. (정렬 : 자리바꿈)
 4. 위 결과를 담고있는 배열을 출력하세요.
 
 추후에는 별도의 클래스를 분리해서 Lotto.java 로 분리 / 현재는 main 안에서 연습...
 */
public class Ex03_Lotto_Main {

	public static void main(String[] args) {
		int[] lotto = new int[6]; //로또 번호를 저장할 6개의 방을 생성.
		
		for (int i = 0 ; i < lotto.length ; i++ ) { // 0부터 5까지 1씩 증가 / 방 6개 순환
			lotto[i] = (int)(Math.random()*45)+1; // 방에 1~45 랜덤숫자 할당
			
			for (int j = 0; j  < i ; j++) { // 0부터 i보다 작을때 / 비교할 방. 0번부터비교. // j < i 채워진 갯수부터 비교.
				if( lotto[i] == lotto[j] ) { // 값 비교 시 같으면 
					i--; // i 감소 => i 방의 값 재할당을 위해. // 1번방 == 0번방 같으면 i는 0이 되고 올라가면서 i++되어 1번방에 랜덤숫자 재할당.
					break; // j가 걸린 for 문 탈출
				}
			}
		}
		
		//------------------------------------정렬 (방이 다 채워진 이후)
		
		//--------------------------------------버블정렬
		for ( int j = lotto.length-1; j > 0 ; j-- ) {// 5부터 1까지 1씩 감소 / 비교하는 횟수 / 5,4,3,2,1
			
			for (int i = 0; i < j ; i++ ) { // 0부터 5 까지 1씩 증가 / 비교하는 방1 의 번호 / 0번방, 1번방, 2번방... ( 횟수가 반복될수록 비교하는 방이 줄어듬)
				
				if ( lotto[i] > lotto[i+1] ) { // 0번방과 1번방을 비교해서 0번방이 크면 1번방과 값 교체 / 1번 > 2번 , 2번 > 3번 ...
					int result = lotto[i+1];
					lotto[i+1] = lotto[i];
					lotto[i] = result;
				}
				
			}
			
		}
		
		//swap 정렬
		for ( int i = 0 ; i < lotto.length ; i++ ) {
			for ( int j = i+1 ; j < lotto.length ; j++) {
				if ( lotto[i] > lotto[j] ) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		for (int i = 0 ; i < lotto.length; i++) {
			System.out.printf("lotto[%d] %d \t", i, lotto[i]);
		}

	}
}
