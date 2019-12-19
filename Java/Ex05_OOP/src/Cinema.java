import java.util.Scanner;

//자리예매

public class Cinema {
	public static void Seat_Print(String[][] seat) { // 좌석상황 출력해주는 함수
		System.out.printf("    1  2  3  4  5\n");
		
		for (int i = 0 ; i < seat.length ; i++) { // 행의 값
			System.out.printf("%2d ",i+1);
			
			for(int j = 0 ; j < seat[i].length ; j++) { // 열의 값
				System.out.printf((seat[i][j] == null) ?"[_]" : "[O]"); // 자리출력
				
				if ( j == seat[i].length-1 ) { // 한 열의 값이 끝나면 줄바꿔주기. 
					System.out.println();	
				}	
			}
		}	
	}
	
	public static void reservation(String[][] seat) { // 좌석 예매하는 함수
		Scanner sc = new Scanner(System.in);
		int i = 0; // 선택한 행을 저장할 변수
		int j = 0; // 선택한 열을 저장할 변수
		
		System.out.println("예매할 자리를 선택하세요");
	
		System.out.printf("예매할 행 ( 1 ~ %d ) : ", seat.length);
		i = Integer.parseInt(sc.nextLine()); // 예매할 행 입력받아 숫자로 변환해서 변수 i에 할당
	
		if ( ((i-1) >=  0 )&& ((i-1) < seat.length) ) { // 1부터 받았기 때문에 배열 방의 값과 대조하기 위해 -1 처리.
			// 행이 0 ~ 배열의 길이보다 작으면 열 입력받기  
			System.out.printf("예매할 열 ( 1 ~ %d) : ", seat[i-1].length);
			j = Integer.parseInt(sc.nextLine()); // 예매할 열 입력받아 숫자로 변환해서 변수 j에 할당 
		
			if (((j-1) >=  0 )&& ((j-1) <= seat[i-1].length) ) {// 1부터 받았기 때문에 배열 방의 값과 대조하기 위해 -1 처리.
				// 열이 0~열의 길이보다 작으면 
				if ( seat [i-1][j-1] == null) { // 좌석이 비어있는지 확인
					seat[i-1][j-1] = "예매"; // 비어있으면 예매
					System.out.printf("\n★★선택하신 [%d][%d] 자리로 예매되었습니다.★★\n\n",i,j);
				}else { // 비어있지 않으면 메시지 출력
					System.out.printf("\n★이미 예매된 좌석입니다.★\n\n");
				}
			}else { // 열에 벗어나는 값을 입력하면 메시지 출력
				System.out.printf("※ 잘못입력하셨습니다.\n\n");
			}
		}else { // 행에 벗어나는 값을 입력하면 메시지 출력
			System.out.printf("※ 잘못입력하셨습니다.\n\n");
		}
	}
	public static void cancle_res(String[][] seat) { // 좌석 예매하는 함수
		Scanner sc = new Scanner(System.in);
		int i = 0; // 선택한 행을 저장할 변수
		int j = 0; // 선택한 열을 저장할 변수
		
		System.out.println("취소할 자리를 선택하세요");
	
		System.out.printf("취소할 행 ( 1 ~ %d ) : ", seat.length);
		i = Integer.parseInt(sc.nextLine()); // 예매할 행 입력받아 숫자로 변환해서 변수 i에 할당
	
		if ( ((i-1) >=  0 )&& ((i-1) < seat.length) ) { // 1부터 받았기 때문에 배열 방의 값과 대조하기 위해 -1 처리.
			// 행이 0 ~ 배열의 길이보다 작으면 열 입력받기  
			System.out.printf("취소할 열 ( 1 ~ %d) : ", seat[i-1].length);
			j = Integer.parseInt(sc.nextLine()); // 취소할 열 입력받아 숫자로 변환해서 변수 j에 할당 
		
			if (((j-1) >=  0 )&& ((j-1) <= seat[i-1].length) ) {// 1부터 받았기 때문에 배열 방의 값과 대조하기 위해 -1 처리.
				// 열이 0~열의 길이보다 작으면 
				if ( seat [i-1][j-1] == null) { // 좌석이 비어있는지 확인
					System.out.printf("\n★예매되지 않은 좌석입니다.★\n\n");
				}else { // 비어있지 않으면 메시지 출력
					seat[i-1][j-1] = null; // 취소처리
					System.out.printf("\n★★선택하신 [%d][%d] 자리는 취소되었습니다.★★\n\n",i,j);
				}
			}else { // 열에 벗어나는 값을 입력하면 메시지 출력
				System.out.printf("※ 잘못입력하셨습니다.\n\n");
			}
		}else { // 행에 벗어나는 값을 입력하면 메시지 출력
			System.out.printf("※ 잘못입력하셨습니다.\n\n");
		}
	}
	
	public static void main(String[] args) {
		//2차원배열
		Scanner sc = new Scanner(System.in);
		String[][] seat = new String[10][5]; // 자리만들기
		int choice = 0; // 선택한 메뉴를 할당받을 변수		
		
		do {
			Seat_Print(seat); // 자리 출력해주는 함수
			
			System.out.printf("★★★★★★★★★★★★★★\n메뉴를 선택하세요.\n1. 예매\n2. 취소\n3. 종료\n");
			choice = Integer.parseInt(sc.nextLine()); // 메뉴선택
			
			switch (choice) { //선택한 메뉴를 받아서
			case 1: { // 1 이면 예매호출
				reservation(seat); // 예매하는 함수
				break; // 예매 끝나면 switch 탈출
			}
			case 2:{ // 2 이면  예매취소
				cancle_res(seat); // 취소하는 함수
				break; // 취소 끝나면 switch 탈출
				}
			case 3:{ // 3이면 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			default : System.out.printf("\n잘못입력하셨습니다.\n\n"); // 그 외 번호 입력시 
			}
			} while(true);
	}
}
