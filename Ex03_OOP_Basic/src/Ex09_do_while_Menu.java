import java.util.Scanner;

//���ɸ޴� �����ϱ�
//�Ʒ��� �޴� �� �ϳ��� �����ϼ���.
//1. ���
//2. ¥���
//3. �ƹ��ų�
// ���� �Է� ���� "�ٽ� �Է��ϼ���"

public class Ex09_do_while_Menu {
	Scanner sc = new Scanner(System.in);
	
	void inputRecord() {
		System.out.println("���� ������ �Է� : ");
	}
	void deleteRecode() {
		System.out.println("���� ������ ����");
	}
	void sortRecode() {
		System.out.println("���� ������ ����");
	}
	
	int displayMenu() {
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
		
		Ex09_do_while_Menu menu = new Ex09_do_while_Menu();
		
		while(true) {
			switch (menu.displayMenu()) {
			case 1: menu.inputRecord();
				break;
			
			case 2:menu.deleteRecode();
			break;
			
			case 3: menu.sortRecode();
			break;
			
			case 4: System.out.println("���α׷��� �����մϴ�.");
						System.exit(0); // ���α׷� �������� //
			}
		}
	}
}
