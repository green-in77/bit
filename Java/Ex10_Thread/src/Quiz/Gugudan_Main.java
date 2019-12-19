package Quiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;

class Time extends Thread{
	@Override
	public void run() {
		for ( int i = 5 ; i > 0 ; i--) {
			if ( Gugudan_Main.value ) {
				return; // ���� �� Ǯ�� �ð�����
			}
			System.out.println("�����ð� : " + i + "��");

			try {
				Thread.sleep(1000);  //1�� ���� ������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Gugudan_Main.time = true;
	}
}

class Quiz extends Thread {
	Gugudan_Info gugudan;
	ArrayList<Usergugudan> usergugudan;

	public Quiz(){
		this.gugudan = new Gugudan_Info();
		this.usergugudan = new ArrayList<Usergugudan>();
	}

	@Override
	public void run() {

		gugudan.quizCreate(); // �������

		Set keys = gugudan.quiz.keySet(); // ������ key ���� set ���� �������� ( �����ѷ��ְ�, �� ã�ƿ�����)

		Iterator it = keys.iterator();

		while (it.hasNext()) {
			if (!Gugudan_Main.time) {
				//System.out.println(time);

				String key = (String) it.next(); // ������ key �� ����
				int answer = gugudan.quiz.get(key);

				String inputdata = JOptionPane.showInputDialog(key);

				int useranswer = Integer.parseInt(inputdata);

				String ox = "";
				if ( gugudan.quiz.get(key).equals(useranswer)) {
					ox = "O";

				}else {
					ox = "X";
				}
				this.usergugudan.add(new Usergugudan(key, answer , useranswer, ox));
				//System.out.println("�Է��Ͻ� �� : " + inputdata + " ä�� : " + ox);
			}
			else {
				return; // �ð��� �� ����������� �Լ�����
			}
		}
		Gugudan_Main.value = true;
	}
	public void userPrint() {
		for ( Usergugudan user : usergugudan) {
			System.out.println(user.toString());
		}
	}
}

public class Gugudan_Main {
	static boolean value = false;
	static boolean time = false;

	public static void main(String[] args) {

		Time time = new Time();
		time.start();

		Quiz quiz = new Quiz();
		quiz.start();

		try {
			quiz.join();
			time.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		quiz.userPrint();

	}

}
