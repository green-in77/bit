// Thread  : ���μ������� �ϳ��� �ּ� ������� (Method)

// Thread �������
// 1. Thread Ŭ������ ��� -> class Test extends Thread {}
// [�ݵ��] run() �Լ� ������ �ؾ��Ѵ�. -> �߻�Ŭ������ �ƴϱ� ������... ������ ���� �ʾƵ� ��������..
// Thread �� �Ϲ� class : Thread ������ ��ü ���� ����

// 2. implements Runnable ���� -> class Test implements Runnable {}
// �ݵ�� run() ����(�߻��ڿ�)
// Test Ŭ������ Thread �� �ƴϴ�. -> Thread th = new Thread(new Test());

// why... 2���� ����� �����ϰ�������?
// ���ϻ�ӹۿ� �ȵǱ� ������.... �̹� �ٸ� ��ü�� ��ӹ޾��� ��� Thread �� ������ �� �ְ� �ϱ� ����...
// class Test extends Car implements Runnable

//Thread �߻�Ŭ������ ����(X) : run �� ������ Test �� Thread �� ����� ���ؼ�...

class Thread_1 extends Thread {
	@Override // �ݵ�� run �������̵� �ؾ���.
	public void run() { // Thread
		//run �Լ��� main �� ���� ���� // ���ο� stack �� ó�� �ö󰡴� �Լ�.
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
	public static void main(String[] args) { // 1���� Thread
		
		// Thread �� ��ӹ��� Ŭ����
		Thread_1 th = new Thread_1(); // 1���� Thread
		th.start(); // POINT :  stack �����ϰ� stack run �Լ� �÷�����.
		
		
		// Runnable ������ Ŭ����
		Thread_2 th2 = new Thread_2(); // Thread �ƴ�.
		Thread thread = new Thread(th2); // Thread �� ������� ( Thread �� �߻�Ŭ������ ������ ����)		
		thread.start();
		
		
		for(int i = 0; i < 1000 ; i++) {
			System.out.println("main : " + i);
		}
		System.out.println("main END");

	}
}