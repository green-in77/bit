
import javax.swing.JOptionPane;

/*
 문제
 main 함수 제외한 Thread 2개 생성
 1. 시간(time) 제어하는 Thread
 2. 단어 입력을 처리하는 Thread

 main 함수 2개 실행
 단, 단어를 하나라도 입력해서 확인버튼을 누르면 시간을 멈추게....
 hint : 공유자원...(static)
 
 Thread 상태정보
 
 join() : 다른 Thread 에 종료를 기다림
 			계산작업을 하는 Thread 가 모든 계산작업을 마쳤을때 그 결과값을 처리해야 하는 경우


 */

class time extends Thread{
	@Override
	public void run() {
		
		for ( int i = 10 ; i > 0 ; i--) {
			if ( Ex05_WordGame.value ) {
				return; //run 함수 탈출 
			}
			
			System.out.println("남은시간 : " + i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class word extends Thread {	

	@Override
	public void run() {
		String inputdata = JOptionPane.showInputDialog("값을 입력하세요");
		
		if (inputdata != null && !inputdata.equals("")) {
			Ex05_WordGame.value= true;
		}
		System.out.println("입력값 : " + inputdata);
	}	
} 

public class Ex05_WordGame {
	static boolean value = false;
	
	public static void main(String[] args) {

		time time = new time();
		time.start();

		word word = new word();
		word.start();
		
		try {
			word.join(); // main Thread 에게 내가 끝날때까지 기다려죠......
			time.join();
			//join : 하나의 스레드가 다른스레드가 하는 일이 완료될때까지 기다리게 하는 것.
			//word, time 하는 일이 마칠때까지 멈추게 하는 것(pause) main 을....
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main END...............");

	}
}
