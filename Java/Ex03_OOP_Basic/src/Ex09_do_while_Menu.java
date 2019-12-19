import java.util.Scanner;

//점심메뉴 설정하기
//아래의 메뉴 중 하나를 선택하세요.
//1. 백반
//2. 짜장면
//3. 아무거나
// 외의 입력 값은 "다시 입력하세요"

public class Ex09_do_while_Menu {
	Scanner sc = new Scanner(System.in);
	
	void inputRecord() {
		System.out.println("성적 데이터 입력 : ");
	}
	void deleteRecode() {
		System.out.println("성적 데이터 삭제");
	}
	void sortRecode() {
		System.out.println("성적 데이터 정렬");
	}
	
	int displayMenu() {
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
		
		Ex09_do_while_Menu menu = new Ex09_do_while_Menu();
		
		while(true) {
			switch (menu.displayMenu()) {
			case 1: menu.inputRecord();
				break;
			
			case 2:menu.deleteRecode();
			break;
			
			case 3: menu.sortRecode();
			break;
			
			case 4: System.out.println("프로그램을 종료합니다.");
						System.exit(0); // 프로그램 강제종료 //
			}
		}
	}
}
