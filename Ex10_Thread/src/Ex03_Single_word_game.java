import javax.swing.JOptionPane;

public class Ex03_Single_word_game {

	public static void main(String[] args) {
		String inputdata = JOptionPane.showInputDialog("값을 입력하세요");
																// 별도의 Thread
		System.out.println("입력값 : " + inputdata);
		
		timer();
	}
	static void timer() {
		for ( int i = 10 ; i > 0 ; i--) {
			try {
				System.out.println("남은시간 : " + i );
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
