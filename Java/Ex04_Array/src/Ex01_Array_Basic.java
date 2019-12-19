import java.util.Arrays;

//배열은 객체다.
// new 로 생성, 생성되는 메모리는 heap.
//고정(정적) 배열 ( 크기가 고정) >> 단점 때문에 collection (동적배열)
public class Ex01_Array_Basic {
	public static void main(String[] args) {
		//int score  = 10, score2=20, score3=30, score4=40...; //값 타입 선언 및 초기화.
		int[] score = new int[3]; // score 는 주소값을 갖는 참조변수
		System.out.println("score 변수(heap 메모리 score 주소) "+score);
		//score 배열의 시작 주소값을 갖음.
		//Array 는 각각의 방을 가지고 있다. (방은 int 크기)
		//각각의 방은 접근 : 첨자, index >> 0부터 시작 >> 시작값 0
		//배열은 타입의 기본값을 초기값으로 갖는다. (int = 0)
		
		System.out.println(score[0]); //0
		System.out.println(score[1]); //0
		System.out.println(score[2]); //0
		
		score[1] = 1111; // 배열의 1방에 가서 값을 1111로 변경
		
		System.out.println(score[1]); //1111
		
		//score[3] = 5000;
		//java.lang.ArrayIndexOutOfBoundsException : 3 -> 배열의 방 범위를 넘었다.
		// 예외가 발생했습니다. .... 그래서 프로그램을 강제로 종료하겠습니다.
		//try catch ..-> 오류를 수정하는 것이 아니라 프로그램의 강제종료를 막음.
		
		//Array 궁합이 제일 좋은 제어문 = for문 
		for ( int i = 0; i < 3; i++) {
			System.out.printf("[%d] = %d\t",i , score[i]);
		}
		
		System.out.println();
		
		for (int i = 0 ; i < score.length ; i++  ) { // scre.length = 배열의 방 갯수
			System.out.printf("[%d] = %d\t", i, score[i]);
		}
		
		System.out.println();
		
		// Tip Array 도와주는 보조클래스 ( helper class)
		String result = Arrays.toString(score); // 처음 하는 사람은 금기...
		System.out.println(result); // [ 0, 1111, 0]
		
		Arrays.sort(score); // 정렬 작은 -> 큰
		result = Arrays.toString(score);
		System.out.println("sort : " + result); // [0, 0, 1111]
		
		// Today Point
		// 배열을 만드는 방법 3가지 (정적배열, 고정배열)
		int[] arr1 = new int[5]; // 기본 ( 방의 갯수를 지정)
		int[] arr2 = new int[] {100,200,300}; // 초기값이 명확할때 초기값 셋팅
		int[] arr3 = {11,22,33,44,55}; // 컴파일러가 알아서 new 자동생성..
		// javascript : let cars = [11,22,33,44,55]
		// 방의 갯수가 처음 정해지면 추가로 더 만들거나 없애거나 할 수 없음.
		
		for (int i = 0 ; i < arr3.length ; i++ ) {
			System.out.println(arr3[i]);
		}
		
		//객체 선언 할당을 분리
		// Car c; // 선언
		// c = new Car(); //할당
		
		//배열은 객체다
		int[] arr4; //선언
		arr4 = new int[] {21,22,23,24,25}; //할당 : arr4 라는 변수에 주소값을 넘기는 것.
		
		int[] arr5 = arr4; // 주소값 할당
				
		System.out.println(arr5 == arr4);
		
		String[] strarray = new String[] {"가", "나", "다라마"};
		char[] ch = new char[10]; // 기본값 빈문자 '\u0000'
		for (int j = 0 ; j < ch.length; j++) {
			System.out.println(">" + ch[j] + "<");
		}
		
		// 8가지 기본타입 + String			Array 생성가능
		//★★★★★★★★★★★★ 클래스도 배열 생성 가능 ★★★★★★★★★
		// 클래스 == 설계도 == 타입
		//자동차 10대
		// Car[] c = new Car[10];
		
	}
}
