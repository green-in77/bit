import javax.swing.JOptionPane;

class WordTime extends Thread{
	@Override
	public void run() {
		for ( int i = 10 ; i > 0 ; i--) {
			System.out.println("�����ð� : " + i);
			try {
				Thread.sleep(1000); //���ǿ��� 1��
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
public class Ex04_Multi_Thread_Word_Game {

	public static void main(String[] args) {
		WordTime timer = new WordTime();
		timer.start();
		
		String inputdata = JOptionPane.showInputDialog("���� �Է��ϼ���");
		// ������ Thread
		System.out.println("�Է°� : " + inputdata);

	}

}
