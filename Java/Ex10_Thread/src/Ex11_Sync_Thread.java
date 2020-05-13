// ������¸� �ϳ� ������ �ִ�.
// ���� ���¸� ���� �Ա�, ��� ó���� �� �� �ִ�.

//ģ�� 5�� �Ȱ��� ī�� ����
//���ÿ� ���¿��� ���� �ݾ��� ���

//���� 1000����
//ATM ��⿡  ���ÿ� ���ó��.....

//���ƾ��Ѵ�. �������� ����� ���� �����ϸ�...
//[��� ~ ���������� ] �ٸ������ �������� ���ϰ� ���ƾ���.
class Account { //����
	int balance = 1000; //�ܾ�
	synchronized void withDraw(int money) {
		System.out.println("���� : " + Thread.currentThread().getName());
		System.out.println("���� �ܾ� : " +  this.balance);
		
		if ( this.balance >= money ) {
			try {
				Thread.sleep(1000); //1�� // ȫ�浿 ���� �� 1�� ����...(����, ����޴� �ð���..)
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			this.balance -= money;
			System.out.println("����ݾ� : " + money);
		}
		
		System.out.println("���� �� �ܾ� : " + this.balance);
	}
}

class Bank implements Runnable {
	Account acc = new Account();
	
	@Override
	public void run() {
		while (acc.balance > 0 ) {
			int money =((int)(Math.random()*3)+1)*100;
			
			acc.withDraw(money);
		}
	}
}

public class Ex11_Sync_Thread {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		Thread th1 = new Thread(bank,"park");
		Thread th2 = new Thread(bank,"kim");
		Thread th3 = new Thread(bank,"lee");
		
		th1.start();
		th2.start();
		th3.start();

	}
}