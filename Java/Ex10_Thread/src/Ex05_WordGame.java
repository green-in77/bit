
import javax.swing.JOptionPane;

/*
 ����
 main �Լ� ������ Thread 2�� ����
 1. �ð�(time) �����ϴ� Thread
 2. �ܾ� �Է��� ó���ϴ� Thread

 main �Լ� 2�� ����
 ��, �ܾ �ϳ��� �Է��ؼ� Ȯ�ι�ư�� ������ �ð��� ���߰�....
 hint : �����ڿ�...(static)
 
 Thread ��������
 
 join() : �ٸ� Thread �� ���Ḧ ��ٸ�
 			����۾��� �ϴ� Thread �� ��� ����۾��� �������� �� ������� ó���ؾ� �ϴ� ���


 */

class time extends Thread{
	@Override
	public void run() {
		
		for ( int i = 10 ; i > 0 ; i--) {
			if ( Ex05_WordGame.value ) {
				return; //run �Լ� Ż�� 
			}
			
			System.out.println("�����ð� : " + i);

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
		String inputdata = JOptionPane.showInputDialog("���� �Է��ϼ���");
		
		if (inputdata != null && !inputdata.equals("")) {
			Ex05_WordGame.value= true;
		}
		System.out.println("�Է°� : " + inputdata);
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
			word.join(); // main Thread ���� ���� ���������� ��ٷ���......
			time.join();
			//join : �ϳ��� �����尡 �ٸ������尡 �ϴ� ���� �Ϸ�ɶ����� ��ٸ��� �ϴ� ��.
			//word, time �ϴ� ���� ��ĥ������ ���߰� �ϴ� ��(pause) main ��....
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main END...............");

	}
}
