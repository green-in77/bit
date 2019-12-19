package Quiz;

public class GradeMain {

	public static void main(String[] args) {
		GradeSystem gsystem = new GradeSystem();
		do {
			System.out.println("성적관리 시스템입니다.");
			System.out.print("<1> 추가 <2> 삭제 <3>출력 <4>저장 <5>로드 <6>종료 : ");
			
			switch (gsystem.choice()) {
				case 1: gsystem.add(); // 추가				
					break;
					
				case 2: gsystem.del(); // 삭제
					break;
					
				case 3: gsystem.print(); // 콘솔출력
					break;
					
				case 4: gsystem.save(); // 저장
					break;
				
				case 5: gsystem.load(); // 로드
					break;
				
				case 6:
					System.out.println("프로그램이 종료됩니다.");
					System.exit(0); // 종료

			default: System.out.println("잘못입력하셨습니다.");
				break;
			}
		}while (true);

	}
}
