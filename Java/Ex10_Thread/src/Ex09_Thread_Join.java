// Thread : 상태정보 (state) 동작여부..(쉬는지,하는지,멈췄는지..)
// state 강제로 변환 : stop() ... 등등 하지마라.....  (소멸될 예정)
// 써도 큰 문제없어 : sleep() , join() , wait()

// join()
// 복잡한 계산을 여러개의 Thread 로 나누어서 계산할때...
// 각각의 Thread 에서 만든 결과를 취합할때...

class Thread_join extends Thread {
	@Override
	public void run() {
		for ( int i = 0 ; i < 3000 ; i++ ) {
			System.out.println("------------");
		}
	}
}

class Thread_join2 extends Thread {
	@Override
	public void run() {
		for ( int i = 0 ; i < 3000 ; i++ ) {
			System.out.println("|||||||||||||||");
		}
	}
}

public class Ex09_Thread_Join {
	public static void main(String[] args) {
		// 취합하는 Thread ( 최종결과를 만드는 스레드)
		Thread_join th = new Thread_join();
		Thread_join2 th2 = new Thread_join2();
		
		th.start();
		th2.start();

		long starttime = System.currentTimeMillis();
		
		try {
			th.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0 ; i < 3000 ; i++) {
			System.out.println("^^^^^^^^^^^^^^^");
		}
		
		// 3개의 Thread 가 실행한 결과 ( 총 걸린 시간 )
		System.out.println("3개의 Thread 총 작업 시간");
		System.out.println(System.currentTimeMillis());
		System.out.println(starttime);
		System.out.println(System.currentTimeMillis()-starttime);
		System.out.println("Main END");
		
	}

}
