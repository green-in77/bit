// Thread : �������� (state) ���ۿ���..(������,�ϴ���,�������..)
// state ������ ��ȯ : stop() ... ��� ��������.....  (�Ҹ�� ����)
// �ᵵ ū �������� : sleep() , join() , wait()

// join()
// ������ ����� �������� Thread �� ����� ����Ҷ�...
// ������ Thread ���� ���� ����� �����Ҷ�...

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
		// �����ϴ� Thread ( ��������� ����� ������)
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
		
		// 3���� Thread �� ������ ��� ( �� �ɸ� �ð� )
		System.out.println("3���� Thread �� �۾� �ð�");
		System.out.println(System.currentTimeMillis());
		System.out.println(starttime);
		System.out.println(System.currentTimeMillis()-starttime);
		System.out.println("Main END");
		
	}

}
