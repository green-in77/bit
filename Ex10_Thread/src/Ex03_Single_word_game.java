import javax.swing.JOptionPane;

public class Ex03_Single_word_game {

	public static void main(String[] args) {
		String inputdata = JOptionPane.showInputDialog("���� �Է��ϼ���");
																// ������ Thread
		System.out.println("�Է°� : " + inputdata);
		
		timer();
	}
	static void timer() {
		for ( int i = 10 ; i > 0 ; i--) {
			try {
				System.out.println("�����ð� : " + i );
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
