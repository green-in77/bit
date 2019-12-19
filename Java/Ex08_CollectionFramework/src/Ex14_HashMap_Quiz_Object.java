import java.util.HashMap;
import java.util.Set;
/*
class QuizInfo {
    String question;
    String answer;
    String result;
    
    public QuizInfo(String question, String answer, String result) {
        this.question = question;
        this.answer = answer;
        this.result = result;
    }
    
    public String toString() {
        return "문제:"+this.question+" 쓴답:"+this.answer+" 채점:"+this.result;
    }
}
*/
public class Ex14_HashMap_Quiz_Object {
	public static void main(String[] args) {
		HashMap<String, String> quiz = new HashMap<>();
		quiz.put("1+1", "2");
		quiz.put("1+2", "3");
		quiz.put("1+3", "4");
		
		for(int i = 0 ; i < quiz.size() ; i++) {
			Set set =quiz.keySet(); // 키의 집합을 set 에 담음.
			Object[] obj= set.toArray(); // set에 담긴 키의 집합을 배열에 넣어줌.
			System.out.println(obj[i]); // 배열에 담긴 키 값 출력 ( 문제)
			//System.out.println(quiz.keySet().toArray()[i]);
			
			System.out.println(quiz.get(obj[i])); 
											// // map.get -> 키값의 value 를 반환 quiz.keySet().toArray()[i]
		}

	}

}
