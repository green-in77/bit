package Quiz;

import java.util.Iterator;
import java.util.Set;

public class Usergugudan {
	String quiz;
	int answer;
	int useranswer;
	String ox;
	
	public Usergugudan(String quiz, int answer, int useranswer, String ox) {
		this.quiz =quiz;
		this.answer = answer;
		this.useranswer = useranswer;
		this.ox = ox;
	}
	
	@Override
	public String toString() {
		return  "quiz : " + this.quiz + " / ���� : " + this.answer + " / �Է��Ͻ� �� : " + this.useranswer + " / ���俩�� : " + this.ox;
	}	
}
