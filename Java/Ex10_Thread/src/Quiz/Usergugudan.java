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
		return  "quiz : " + this.quiz + " / 정답 : " + this.answer + " / 입력하신 답 : " + this.useranswer + " / 정답여부 : " + this.ox;
	}	
}
