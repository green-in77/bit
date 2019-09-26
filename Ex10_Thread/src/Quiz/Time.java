package Quiz;

public static class Time extends Thread{
	@Override
	public void run() {
		for ( int i = 10 ; i > 0 ; i--) {
			if ( Gugudan_Main.value ) {
				return; // 문제의 답이 입력되면 시간 멈춤
			}
			System.out.println("남은시간 : " + i + "초");
			
			try {
				Thread.sleep(1000);  //1초 쉬고 나오기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}