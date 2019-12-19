// ����ȭ
// �Ѱ� ������� ȭ���(�����ڿ�) : �������� �����(10��) : Thread 10��
// �����ġ(lock)
// �Լ����� lock

// �ݴ�
//�Ѱ� ����� ����( �����ڿ� ) �������� ����

class Wroom {
	synchronized void openDoor (String name) { // ����ȭ...
		System.out.println(name + "�� ȭ��� ����^^");
		for ( int i = 0; i <100; i++) {
			System.out.println(name + "��� : " + i );
			if ( i == 10) {
				System.out.println(name + "�� ��!!");
			}
		}
		System.out.println("�ÿ��ϴ�^^!");
	}
}

class User extends Thread {
	Wroom wr;
	String who;
	User(String name, Wroom w){
		this.who = name;
		this.wr = w;
	}
	
	@Override
	public void run() {
		wr.openDoor(this.who);
	}
}

public class Ex10_Sync_Thread {
	public static void main(String[] args) {
		// �Ѱ���ġ
		Wroom w = new Wroom();
		
		//�����
		User kim = new User("�达", w);
		User lee = new User("�̾�", w);
		User park = new User("�ھ�", w);
		
		//�谡���Ŀ�
		kim.start();
		lee.start();
		park.start();
		
	}
}
