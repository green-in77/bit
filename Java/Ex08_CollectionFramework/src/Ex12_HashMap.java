import java.util.HashMap;
import java.util.Scanner;

/*
 HashMap 을 활용한 로그인 시스템
 
 */
public class Ex12_HashMap {

	public static void main(String[] args) {
		//회원 가입이 되었고, 회원의 ID,PW 관리하고 있다. 메모리로....
		
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("soctt", "tiger");
		loginmap.put("lee", "kim1004");

		//우리 시스템에 로그인 하는 시나리오...
		// ID(O), PW(O) 회원 ( 환영 )
		// ID(O), PW(X) 실패 ( 비번다시 입력)
		
		//ID(X), PW(O) 실패 ( 처음부터 다시)
		//ID(X), PW(X) 실패 ( 처음부터 다시)
		
		//스캐너를 통해서..
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("ID, PW 입력해 주세요.");
			System.out.println("ID");
			String id = sc.nextLine().trim().toLowerCase(); // trim -> 양 옆의 공백 제거 / toLowerCase -> 전부 소문자로 변환			
			
			System.out.println("PW");
			String pw = sc.nextLine().trim();
			
			if (!loginmap.containsKey(id)) {
				System.out.println("ID가 틀려요. 재입력하세요.");
			}else {
				if ( loginmap.get(id).equals(pw)) {
					System.out.println("회원님 방가방가^^");
					break;
				}else {
					System.out.println("비번 확인하세요~.");
				}			
			}
		}
		
		
		
		
		
	}
}
