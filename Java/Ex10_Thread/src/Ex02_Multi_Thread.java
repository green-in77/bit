// Thread  : 프로세스에서 하나의 최소 실행단위 (Method)

// Thread 생성방법
// 1. Thread 클래스를 상속 -> class Test extends Thread {}
// [반드시] run() 함수 재정의 해야한다. -> 추상클래스가 아니기 때문에... 재정의 하지 않아도 문제없음..
// Thread 는 일반 class : Thread 스스로 객체 생성 가능

// 2. implements Runnable 구현 -> class Test implements Runnable {}
// 반드시 run() 구현(추상자원)
// Test 클래스는 Thread 가 아니다. -> Thread th = new Thread(new Test());

// why... 2가지 방법을 제공하고있을까?
// 단일상속밖에 안되기 때문에.... 이미 다른 객체를 상속받았을 경우 Thread 를 구현할 수 있게 하기 위해...
// class Test extends Car implements Runnable

//Thread 추상클래스로 설계(X) : run 을 구현한 Test 를 Thread 로 만들기 위해서...

class Thread_1 extends Thread {
	@Override // 반드시 run 오버라이드 해야함.
	public void run() { // Thread
		//run 함수가 main 과 같은 역할 // 새로운 stack 에 처음 올라가는 함수.
		for(int i = 0; i < 1000 ; i++) {
			System.out.println("Thread_1 : " + i + this.getName());
		}
		System.out.println("Thread_1 run() END");
	}
}


class Thread_2 implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 1000 ; i++) {
			System.out.println("Thread_2 : " + i);
		}
		System.out.println("Thread_2 run() END");	
	}
}

public class Ex02_Multi_Thread {
	public static void main(String[] args) { // 1개의 Thread
		
		// Thread 를 상속받은 클래스
		Thread_1 th = new Thread_1(); // 1개의 Thread
		th.start(); // POINT :  stack 생성하고 stack run 함수 올려놓기.
		
		
		// Runnable 구현한 클래스
		Thread_2 th2 = new Thread_2(); // Thread 아님.
		Thread thread = new Thread(th2); // Thread 로 만들어줌 ( Thread 를 추상클래스로 만들지 못함)		
		thread.start();
		
		
		for(int i = 0; i < 1000 ; i++) {
			System.out.println("main : " + i);
		}
		System.out.println("main END");

	}
}