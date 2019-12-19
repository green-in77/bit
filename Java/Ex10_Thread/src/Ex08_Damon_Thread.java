// ����Thread(����)
// Damon ...
// �ѱ� �۾��� 3�� �۾����� ����...
// �ѱ� �۾� ���� ... 3�� ���� ���� ���� END
public class Ex08_Damon_Thread implements Runnable{
	static boolean autosave = false;
	public static void main(String[] args) {
		Thread th = new Thread(new Ex08_Damon_Thread());
		th.setDaemon(true); //th ��� ������� main �������� ����(damon)
												// main  �ϳ��� ������ (non - damon) //�������� �ʴ� ������.
												// *** th ����������� main ������� ����� �����Ѵ�.
		
		th.start();
		
		for (int i = 0; i <= 30; i++) {
			try {
				Thread.sleep(1000); //1��
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("main Thread ����" + i);
			if (i == 5) { // i �� 5�� �Ǵ� ��������...
				System.out.println("i : " + i );
				autosave = true;
			}
		}
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(3000); // 3�� ��������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if ( autosave ) {
				autoSave();
			}
		}
	}
	
	public void autoSave() {
		System.out.println("������ 3�� �������� �ڵ� ���� �Ǿ����ϴ�.");
	}
	
}