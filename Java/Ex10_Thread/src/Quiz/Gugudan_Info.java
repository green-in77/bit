package Quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;

public class Gugudan_Info {
	public HashMap<String, Integer> quiz;
	
	public Gugudan_Info() {
		this.quiz = new HashMap<String, Integer>();
	}
	
	public void quizCreate() {
		for (int i = 2 ; i <= 9; i+=2) {
			for ( int j = 3; j<=9; j+=3) {
				String quiz = i+"*"+j;
				int answer= i*j;
				this.quiz.put(quiz,answer);
				
				String userAnswer = JOptionPane.showInputDialog(quiz);
				
				
			}
		}
	}

}
