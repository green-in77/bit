import java.util.HashMap;
import java.util.Scanner;

/*
 HashMap �� Ȱ���� �α��� �ý���
 
 */
public class Ex12_HashMap {

	public static void main(String[] args) {
		//ȸ�� ������ �Ǿ���, ȸ���� ID,PW �����ϰ� �ִ�. �޸𸮷�....
		
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("soctt", "tiger");
		loginmap.put("lee", "kim1004");

		//�츮 �ý��ۿ� �α��� �ϴ� �ó�����...
		// ID(O), PW(O) ȸ�� ( ȯ�� )
		// ID(O), PW(X) ���� ( ����ٽ� �Է�)
		
		//ID(X), PW(O) ���� ( ó������ �ٽ�)
		//ID(X), PW(X) ���� ( ó������ �ٽ�)
		
		//��ĳ�ʸ� ���ؼ�..
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("ID, PW �Է��� �ּ���.");
			System.out.println("ID");
			String id = sc.nextLine().trim().toLowerCase(); // trim -> �� ���� ���� ���� / toLowerCase -> ���� �ҹ��ڷ� ��ȯ			
			
			System.out.println("PW");
			String pw = sc.nextLine().trim();
			
			if (!loginmap.containsKey(id)) {
				System.out.println("ID�� Ʋ����. ���Է��ϼ���.");
			}else {
				if ( loginmap.get(id).equals(pw)) {
					System.out.println("ȸ���� �氡�氡^^");
					break;
				}else {
					System.out.println("��� Ȯ���ϼ���~.");
				}			
			}
		}
		
		
		
		
		
	}
}
