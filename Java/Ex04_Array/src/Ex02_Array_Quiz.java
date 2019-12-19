public class Ex02_Array_Quiz {
	public static void main(String[] args) {
		// 수학과 학생들의 기말고사 시험점수
		int[] score = new int[] {79,88,97,54,56,95};
		int max = score[0]; //79
		int min = score[0]; //79
		
		// 제어문을 사용해서 max 라는 변수에 시험점수 최대값, min 변수에 최소값.
		// max = 97, min = 54
		//단 for 문을 한번만 사용.
		
		for (int i = 1 ; i < score.length; i++) { // 1번방부터 5번방 까지 1씩 증가
			max = (max < score[i]) ? score[i] : max; // max 보다 score 방의 값이 크면 score/ 작으면 그대로 
			min = (min > score[i]) ? score[i] : min; // min 보다 score 방의 값이 작으면 score/ 크면 그대로
			
		}
		
		System.out.printf("max = %d , min = %d\n", max, min);
		
		int[] number = new int[10];
		//10개의 방의 값을 1~10 까지의 값으로 초기화
		
		for ( int i = 0 ; i < number.length ; i++ ) { // 0부터 9까지 1씩 증가
			number[i] = i+1; // number 방에 i+1 할당 
			System.out.printf("number[%d] = %d \t", i, number[i]);
		}
		
		System.out.println();
		//어느 학생의 기말고사 시험점수(5과목)
		int sum = 0;
		float average = 0f;
		int[] jumsu = {100,55,90,60,78};
		
		//1. 총 과목수
		//2. 과목의 합
		//3. 과목의 평균을 구하세요.
		// 단. 2, 3 하나의 for 사용
		
		for (int i = 0 ; i < jumsu.length ; i++) {
			sum += jumsu[i];
			average = (( i == jumsu.length-1) ? sum /(float) jumsu.length : 0);
			/*
			if( i == jumsu.length-1) {
				average = sum / (float)jumsu.length;
			}*/
		}
		
		//average = (float)sum / jumsu.length;
		
		System.out.printf("총 과목수 : [%d], 총점 : [%d], 평균 [%f]", jumsu.length, sum, average);
		

	}

}
