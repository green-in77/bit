package Quiz;

import java.io.Serializable;
import java.util.Scanner;


public class BMI implements Serializable{ //★★ 직렬화 매우 중요!!
	private double length = 0; // 키저장
	private double weight = 0; // 몸무게 저장
	private double result = 0; // BMI 수치 저장
	private String you = null; //BMI 결과값 저장
	
	public BMI input(BMI bmi){ //BMI 객체를 parameter로 받아서 값을 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("키를 입력하세요 : ");
		this.length = scan.nextInt();
		System.out.print("몸무게를 입력하세요 : ");
		
		this.weight = scan.nextInt();
		
		this.result = this.weight/((this.length/100.0)*(this.length/100.0)); // BMI 수치 계산해서 result 
		
		if(this.result<18.5){ // 할단된 BMI 수치를 기준으로 비교
			this.you = "체중 부족";
		}else if(18.5<=this.result && this.result<=22.9){
			this.you = "정상";
		}else if(23.0<=this.result && this.result<=24.9){
			this.you = "과체중";
		}else if(25.0<=this.result){
			this.you = "비만";
		}
		return bmi;
	}

	public double getLength() { // 키 getter
		return length;
	}

	public void setLength(double length) { // 키 수정할 수 있게 setter
		this.length = length;
	}

	public double getWeight() { // 몸무게 getter
		return weight;
	}

	public void setWeight(double weight) { //몸무게 수정할 수 있게 setter
		this.weight = weight;
	}

	public double getResult() { // BMI 수치 getter
		return result;
	}

	public void setResult(double result) { // result 수정할 수 있게 setter (왜있지??)
		this.result = result;
	}

	public String getYou() { // BMI 결과값 저장
		return you;
	}

	public void setYou(String you) {
		this.you = you;
	}

	@Override
	public String toString() { //한번에 출력해서 볼 수 있게 
		return length+"\t"+weight+"\t"+result+"\t"+you;
	}
	
	
}//class
