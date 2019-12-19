import java.util.Scanner;

//���ɸ޴� �����ϱ�
//�Ʒ��� �޴� �� �ϳ��� �����ϼ���.
//1. ���
//2. ¥���
//3. �ƹ��ų�
// ���� �Է� ���� "�ٽ� �Է��ϼ���"

public class Ex09_do_while_static_Menu {
	static Scanner sc = new Scanner(System.in);
	static void inputRecord() {
		System.out.println("���� ������ �Է� : ");
	}
	static void deleteRecode() {
		System.out.println("���� ������ ����");
	}
	static void sortRecode() {
		System.out.println("���� ������ ����");
	}
	
	static int displayMenu() {
		System.out.println("*************");
		System.out.println("***��������***");
		System.out.println("1. �л����� �Է��ϱ�");
		System.out.println();
		System.out.println("2. �л����� �����ϱ�");
		System.out.println();
		System.out.println("3. �л����� �̸��� �����ϱ�");
		System.out.println();
		System.out.println("4. ���α׷� ����");
		System.out.println();
		
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if(menu >= 1 && menu <= 4) {
					break; // while �� ����Ż��
				}else {
					throw new Exception("�޴����� �����߻�");
				}
			}catch(Exception e) {
				System.out.println("�޴� ���� ����");
				System.out.println("�޴� 1~4 ���� ����");
			}
		}while(true); // for( ; ;) {} ���ѷ���
	
		return menu; // 1~4 ���� ��ȣ �� �ϳ��� return
	}
	
	public static void main(String[] args) {
		// ���� static �̱� ������ new ���� �ʰ� ��� ����.
		
		while(true) {
			switch (displayMenu()) {
			case 1: inputRecord();
				break;
			
			case 2: deleteRecode();
			break;
			
			case 3: sortRecode();
			break;
			
			case 4: System.out.println("���α׷��� �����մϴ�.");
						System.exit(0); // ���α׷� �������� //
			}
		}
	}
}
