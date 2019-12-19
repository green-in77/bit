// 데몬Thread(보조)
// Damon ...
// 한글 작업시 3초 작업내용 저장...
// 한글 작업 종료 ... 3초 간격 저장 같이 END
public class Ex08_Damon_Thread implements Runnable{
	static boolean autosave = false;
	public static void main(String[] args) {
		Thread th = new Thread(new Ex08_Damon_Thread());
		th.setDaemon(true); //th 라는 스레드는 main 스레드의 보조(damon)
												// main  하나의 스레드 (non - damon) //데몬하지 않는 스레드.
												// *** th 보조스레드는 main 스레드와 운명을 같이한다.
		
		th.start();
		
		for (int i = 0; i <= 30; i++) {
			try {
				Thread.sleep(1000); //1초
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("main Thread 동작" + i);
			if (i == 5) { // i 가 5가 되는 시점부터...
				System.out.println("i : " + i );
				autosave = true;
			}
		}
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(3000); // 3초 간격으로
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if ( autosave ) {
				autoSave();
			}
		}
	}
	
	public void autoSave() {
		System.out.println("문서가 3초 간격으로 자동 저장 되었습니다.");
	}
	
}