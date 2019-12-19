// 5개의 스레드 생성 >> 동작 >> CPU 점유율에 따라서....
// default : 우선순위 5 >> 최소 1~ 최대 10 까지

class Pth extends Thread {
	@Override
	public void run() {
		for ( int i = 0 ; i < 1000 ; i++) {
			System.out.println("------------");
		}
	}
}

class Pth2 extends Thread {
	@Override
	public void run() {
		for ( int i = 0 ; i < 1000 ; i++) {
			System.out.println("|||||||||||||||||");
		}
	}
}

class Pth3 extends Thread {
	@Override
	public void run() {
		for ( int i = 0 ; i < 1000 ; i++) {
			System.out.println("*****************");
		}
	}
}
public class Ex07_priority {

	public static void main(String[] args) {
		Pth pth = new Pth();
		Pth2 pth2 = new Pth2();
		Pth3 pth3 = new Pth3();
		
		System.out.println(pth.getPriority());
		System.out.println(pth2.getPriority());
		System.out.println(pth3.getPriority());
		
		pth.setPriority(10); // 먼저 END 확률을 높여줌
		pth3.setPriority(1);
		
		pth.start();
		pth2.start();
		pth3.start();
		
				

	}

}
