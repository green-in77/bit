import java.util.Scanner;

//점심메뉴 설정하기
//아래의 메뉴 중 하나를 선택하세요.
//1. 백반
//2. 짜장면
//3. 아무거나
// 외의 입력 값은 "다시 입력하세요"

public class Ex09_do_while_static_Menu {
	static Scanner sc = new Scanner(System.in);
	static void inputRecord() {
		System.out.println("성적 데이터 입력 : ");
	}
	static void deleteRecode() {
		System.out.println("성적 데이터 삭제");
	}
	static void sortRecode() {
		System.out.println("성적 데이터 정렬");
	}
	
	static int displayMenu() {
		System.out.println("*************");
		System.out.println("***성적관리***");
		System.out.println("1. 학생성적 입력하기");
		System.out.println();
		System.out.println("2. 학생성적 삭제하기");
		System.out.println();
		System.out.println("3. 학생성적 이름순 정렬하기");
		System.out.println();
		System.out.println("4. 프로그램 종료");
		System.out.println();
		
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if(menu >= 1 && menu <= 4) {
					break; // while 문 강제탈출
				}else {
					throw new Exception("메뉴선택 문제발생");
				}
			}catch(Exception e) {
				System.out.println("메뉴 선택 문제");
				System.out.println("메뉴 1~4 부터 선택");
			}
		}while(true); // for( ; ;) {} 무한루프
	
		return menu; // 1~4 까지 번호 중 하나를 return
	}
	
	public static void main(String[] args) {
		// 전부 static 이기 때문에 new 하지 않고 사용 가능.
		
		while(true) {
			switch (displayMenu()) {
			case 1: inputRecord();
				break;
			
			case 2: deleteRecode();
			break;
			
			case 3: sortRecode();
			break;
			
			case 4: System.out.println("프로그램을 종료합니다.");
						System.exit(0); // 프로그램 강제종료 //
			}
		}
	}
}
