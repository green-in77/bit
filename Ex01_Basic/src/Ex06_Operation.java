
public class Ex06_Operation {

	public static void main(String[] args) {
		/*int sum = 0;
		// 대입연산자 (+=, -=, *= ) 습관적으로
		sum += 1; // sum = sum + 1;
		sum -= 1; // sum = sum -1;
		System.out.println("sum:" + sum);

		// 간단한 학점 계산기
		// 학점... A+, A-, B+, B- (score)
		// 점수... 94점
		// 95점 이상이면 A+
		// 그 외는 A-

		// 90점 이상이면 A 인데... 95점 이상이면 A+ , 93은 A-

		int score = 90;
		String grade = ""; // 문자열 초기화 (빈문자)
		System.out.println("당신의 점수는 : " + score);

		if (score >= 90) {
			grade = "A";
			if (score >= 95) {
				grade += "+"; // grade = grade + "+"; // A+
			} else {
				grade += "-"; // grade = grade + "-" // A-
			}
		} else if (score >= 80) {
			grade = "B";
			if (score >= 85) {
				grade += "+"; // grade = grade + "+"; // A+
			} else {
				grade += "-"; // grade = grade + "-" // A-
			}

		} else if (score >= 70) {
			grade = "C";
			if (score >= 75) {
				grade += "+"; // grade = grade + "+"; // A+
			} else {
				grade += "-"; // grade = grade + "-" // A-
			}
		} else {
			grade = "F";
		}

		System.out.println("당신의 학점은 : " + grade + "입니다");

		// syso + ctrl + space 출력 자동완성
		// 코드 정렬하기 ctrl+a -> ctrl + shift + F
		
		int data = 55;
		switch (data) { // switch (인자값) //값을 한정해서 조건확인 // 너 이 값이야?
			case 100: System.out.println("100입니다."); //case 조건 : 맞으면 실행
				break; // switch 탈출 (끝) // 없으면 모든 조건을 다 태움.
			case 90: System.out.println("90입니다."); //case 조건 : 맞으면 실행
				break;
			case 80: System.out.println("80입니다."); //case 조건 : 맞으면 실행
				break;
			default: System.out.println("default");
		}
		
		//brake 는 강제는 아님, 필요에 따라 사용.\
		//case 조건 만족하는 이후로 모두 실행★★★★★
		data = 80;
		switch (data) { // switch (인자값) //값을 한정해서 조건확인 // 너 이 값이야?
			case 100: System.out.println("100입니다~"); 
			case 90: System.out.println("90입니다~"); 				
			case 80: System.out.println("80입니다~"); 
			default: System.out.println("default~");
		}
		
		int month = 2;
		String res = "";
		switch (month) {
			case 1: System.out.println("1");
			case 3: System.out.println("3");
			case 5: System.out.println("5");
			case 7: System.out.println("7");
			case 8: System.out.println("8");
			case 10: System.out.println("10");
			case 12:res = "31";
			break;
			
			case 4: 
			case 6: 
			case 9:
			case 11: res="30";
			break;
			
			case 2: res="29";
			break;
			
			default : res="월이 아닙니다.";
		}
		
		System.out.println(month + "월은 " + res + "일까지 입니다.");
		
		//난수(랜덤값 : 임의의 추출값)
		//java.lang.Math (Math 클래스)
		
		//default > java.lang.Math
		//java 페이지에서 default 로 열어놓은 폴더가 있음 = java.lang >> import java.lang.* // lang 폴더 밑의 모든 자원은 import 없이 사용가능함.
		//페이지 상단에 import java.lang.Math // 원칙적 사용선언
		
		//Math.Random()
		//static random() 객체 생성 없이도 사용 가능.(static 함수 자주 사용하니까)
		//Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
		//결과 : 0.0 <= random < 1.0 // 같은 값이 나올 수 있따.
		
		System.out.println("Math.random() : " + Math.random());
		System.out.println("Math.random() * 10 : " + Math.random()*10);
		System.out.println("(int)(Math.random()*10) : " + (int)(Math.random()*10)); //0~9까지의 정수값만 실수->강제적 형변환
		System.out.println("(int)(Math.random()*10+1) : " + ((int)(Math.random()*10)+1)); //1~10까지의 정수값.
		*/
		/*
		우리는 백화점 경품 시스템을 만들려고 한다.
		경품 시스템은 나오는 점수에 따라 경품을 지급하는 시스템이다.
		경품으로 Tv Notebook, 냉장고, 한우세트, 휴지
		 경품 추첨시
		 경품 1000점 - Tv, Notebook, 냉장고, 한우세트, 휴지
		 경품 900점 - Notebook, 냉장고, 한우세트, 휴지
		 경품 800점 - 냉장고, 한우세트, 휴지
		 경품 700점 - 한우세트, 휴지		 
		 경품 600점 - 휴지
		 그 외 점수는 100~500 - 칫솔
		 
		 경품시스템 점수의 범위는 100~1000 까지 한정되어 있고
		  
		사용자가 경품 시스템을 사용시 랜덤하게 100 ~ 1000까지의 값이 나오게 되어있다.
		*/
		
		int number = ((int)(Math.random()*10)+1)*100;
		System.out.println("경품 점수 : " + number);
		System.out.print("지급경품 : ");
		String msg=""; //초기화
				
		switch (number) {
			case 1000: msg+="TV ";
			case 900: msg+="NateBook ";
			case 800: msg+="냉장고 ";
			case 700: msg+="한우세트 ";
			case 600: msg+="휴지 ";
			break;
			default : msg+="칫솔";
		}
		System.out.println(msg);
		
		
		/*
		if(number == 1000) {
			System.out.println("Tv, Notebook, 냉장고, 한우세트, 휴지");
		}else if (number >= 900) {
			System.out.println("Notebook, 냉장고, 한우세트, 휴지");
		}else if (number >=800) {
			System.out.println("냉장고, 한우세트, 휴지");
		}else if (number >= 700) {
			System.out.println("한우세트, 휴지");
		}else if (number >= 599) {
			System.out.println("휴지");
		}else System.out.println("칫솔");
		*/
		
		
		
	}

}
