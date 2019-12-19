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
				return; // 문제 다 풀면 시간멈춤
			}
			System.out.println("남은시간 : " + i + "초");

			try {
				Thread.sleep(1000);  //1초 쉬고 나오기
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

		gugudan.quizCreate(); // 퀴즈생성

		Set keys = gugudan.quiz.keySet(); // 퀴즈의 key 값만 set 으로 가져오기 ( 문제뿌려주고, 답 찾아오려고)

		Iterator it = keys.iterator();

		while (it.hasNext()) {
			if (!Gugudan_Main.time) {
				//System.out.println(time);

				String key = (String) it.next(); // 가져온 key 값 저장
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
				//System.out.println("입력하신 답 : " + inputdata + " 채점 : " + ox);
			}
			else {
				return; // 시간이 다 지나갔을경우 함수종료
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
