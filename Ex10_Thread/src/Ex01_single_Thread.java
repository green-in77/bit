// 지금까지 배운건 싱글프로세스+싱글쓰레드 ( main 함수 )
// JVM >> Call stack 제공( 1개 )
// Ex01_single_Thread : 함수 10개를 가지고 있더라도
//											한번에 하나의 함수만 [순차적] 실행 - 동시실행될 수 없음.
//											stack 이 하나이기 때문에.


public class Ex01_single_Thread {

	public static void main(String[] args) {
		System.out.println("나 main 일꾼이야");
		worker();
		worker2();
		System.out.println("나 main 종료");

	}
	static void worker() {
		System.out.println("나 1번 일꾼이야");
	}
	static void worker2() {
		System.out.println("나 2번 일꾼이야");
	}
	
}
