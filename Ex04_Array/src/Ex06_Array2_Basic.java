import kr.or.bit.Emp;

public class Ex06_Array2_Basic {

	public static void main(String[] args) {
		//2차원(행과열)
		//[행][열]

		int[][] score = new int[3][2];
		System.out.println(score[0][0]);
		System.out.println(score[2][1]);
		
		score[0][0] = 100;
		score[0][1] = 200;
		
		score[1][0] = 300;
		score[1][1] = 400;
		
		score[2][0] = 500;
		score[2][1] = 600;
		
		//행의 수, 열의 수
		System.out.println(score.length); //행의 수
		System.out.println(score[0].length); //0행의 열의  수
		
		//행의 개수 : 배열이름.length 
		//열의 개수 : 배열이름[i].length ★★★
		
		for(int i = 0 ; i < score.length ; i++ ) {
			for (int j = 0 ; j < score[i].length ; j++) {
				System.out.printf("score[%d][%d] = %d\t", i, j, score[i][j]);
			}
			System.out.println();
		}
		
		//Today Point 
		//개선된 for 문, 향상된 for 문
		// JAVA : for ( Type 변수명 : 배열 or collection ) { 실행구문... 변수명으로  }
		// C#     : for ( Type 변수명 in 배열 or collection ) {  실행구문...변수명으로 }  
		// javascript : for ( Type 변수명 in 배열 or collection ) {  실행구문...변수명으로 }
		
		int[] arr3 = {5,6,7,8,9};
		/*
		for (int i = 0 ; i < arr3.length ; i++ ) {
			System.out.println(arr3[i]);
		}
		*/
		for (int value : arr3) {
			System.out.println(value);
		}
		
		String[] strarr = {"A","B","C","D","FFFF"};
		for ( String value : strarr ) {
			System.out.println(value);
		}
		
		Emp[] list = {new Emp(1,"A"), new Emp(2,"B"), new Emp(3,"C")};
		for ( Emp value : list) {
			value.empInfoPrint();
		}
		
		//모닝커피퀴즈
		int[][] score3 = new int[][] {
														{11,12},
														{13,14},
														{15,16}
		                                              };
		                                              
		//개선된 for 문 2차원 배열의 값 출력 
		                                              
		for ( int[] rows : score3 ) { // 행의 주소값 반환
			for (int value : rows) { // 주소값으로 열을 찾아감.
				System.out.println(value);
			}
		}
		
		
	}

}
