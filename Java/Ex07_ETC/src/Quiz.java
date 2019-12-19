import java.util.Scanner;

//주민번호 : 뒷번호 첫자리 : 1,3 남자 , 2,4 여자 라고 출력 ...
//main 함수 Scanner  사용 주민번호 입력받고
//앞:6자리 뒷:7자리
//입력값 : 123456-1234567 
//1. 자리수 체크 (기능)함수 (14 ok)
//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수
//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수
//3개의 함수 static 

public class Quiz {
	static boolean number_lenght(String jumin) { // 받은 문자의 길이를 체크하는 함수.
		return jumin.length() == 14 ? true : false;
		/*
		if ( jumin.length() == 14 ) { // 14자리이면
			return true;
		}else { // 14자리가 아니면
			System.out.println("14자리를 입력하세요.");
			return false;
		}*/
	}
	static boolean result_check(String jumin) { // 뒷번호 첫번째 자리를 체크하는 함수.
		int num = Integer.parseInt(jumin.substring(7,8)); // 숫자로 변환시켜서 범위로 체크.
		if ( num > 0 && num <5) {
		//if ((jumin.substring(7,8).equals("1"))|| (jumin.substring(7,8).equals("3"))||(jumin.substring(7,8).equals("2"))|| (jumin.substring(7,8).equals("4"))) {//1~4까지 비교 맞으면
			return true;
		}else {//1~4가 아니면
			System.out.println("주민번호 뒷번호 첫자리는 1~4까지 입력 가능합니다.");
			return false;
		}
	}
	static void gender(String jumin) { // 성별 구분해주는 함수.
		 if(Integer.parseInt(jumin.substring(7,8))%2==0) { // 2로 나눠서 나머지가 0이면 짝수 = 여자
             System.out.println("여자");
		 }else System.out.println("남자"); // 아니면 남자.
		 
		/*if ( (jumin.substring(7,8).equals("1"))|| (jumin.substring(7,8).equals("3")) ){ // 1,3 이면 남자  
			System.out.println("남자");
		} else if ((jumin.substring(7,8).equals("2"))|| (jumin.substring(7,8).equals("4"))){ // 2,4 이면 여자
			System.out.println("여자");
		}*/
		 
	}
	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		String jumin;
		//boolean result = false;
		
		do {
			System.out.println("주민번호를 입력하세요.(ex. 123456-1234567)");
			jumin = sc.nextLine(); // 주민번호 입력받기
			
		/*	result = number_lenght(jumin); // 주민번호가 14자리인지 체크해주는 함수 호출해서 true / false 반환받음
			if( result ) 	result = result_check(jumin); // 주민번호가 14자리인지 맞으면 뒷번호 첫번째 자리를 체크해주는 함수 호출해서 true / false 반환받음
			if ( result ) gender(jumin); // 뒷자리 첫번째 자리가 1~4 이면 성별 체크해주는 함수 호출*/
			
		}while(!number_lenght(jumin) || !result_check(jumin)); // 반환된 값이 false 면 무한루프.
		
		gender(jumin);
	}
}
