package Quiz;

public static class Time extends Thread{
	@Override
	public void run() {
		for ( int i = 10 ; i > 0 ; i--) {
			if ( Gugudan_Main.value ) {
				return; // ������ ���� �ԷµǸ� �ð� ����
			}
			System.out.println("�����ð� : " + i + "��");
			
			try {
				Thread.sleep(1000);  //1�� ���� ������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}