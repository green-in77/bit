import java.util.Scanner;

//�ڸ�����

public class Cinema {
	public static void Seat_Print(String[][] seat) { // �¼���Ȳ ������ִ� �Լ�
		System.out.printf("    1  2  3  4  5\n");
		
		for (int i = 0 ; i < seat.length ; i++) { // ���� ��
			System.out.printf("%2d ",i+1);
			
			for(int j = 0 ; j < seat[i].length ; j++) { // ���� ��
				System.out.printf((seat[i][j] == null) ?"[_]" : "[O]"); // �ڸ����
				
				if ( j == seat[i].length-1 ) { // �� ���� ���� ������ �ٹٲ��ֱ�. 
					System.out.println();	
				}	
			}
		}	
	}
	
	public static void reservation(String[][] seat) { // �¼� �����ϴ� �Լ�
		Scanner sc = new Scanner(System.in);
		int i = 0; // ������ ���� ������ ����
		int j = 0; // ������ ���� ������ ����
		
		System.out.println("������ �ڸ��� �����ϼ���");
	
		System.out.printf("������ �� ( 1 ~ %d ) : ", seat.length);
		i = Integer.parseInt(sc.nextLine()); // ������ �� �Է¹޾� ���ڷ� ��ȯ�ؼ� ���� i�� �Ҵ�
	
		if ( ((i-1) >=  0 )&& ((i-1) < seat.length) ) { // 1���� �޾ұ� ������ �迭 ���� ���� �����ϱ� ���� -1 ó��.
			// ���� 0 ~ �迭�� ���̺��� ������ �� �Է¹ޱ�  
			System.out.printf("������ �� ( 1 ~ %d) : ", seat[i-1].length);
			j = Integer.parseInt(sc.nextLine()); // ������ �� �Է¹޾� ���ڷ� ��ȯ�ؼ� ���� j�� �Ҵ� 
		
			if (((j-1) >=  0 )&& ((j-1) <= seat[i-1].length) ) {// 1���� �޾ұ� ������ �迭 ���� ���� �����ϱ� ���� -1 ó��.
				// ���� 0~���� ���̺��� ������ 
				if ( seat [i-1][j-1] == null) { // �¼��� ����ִ��� Ȯ��
					seat[i-1][j-1] = "����"; // ��������� ����
					System.out.printf("\n�ڡڼ����Ͻ� [%d][%d] �ڸ��� ���ŵǾ����ϴ�.�ڡ�\n\n",i,j);
				}else { // ������� ������ �޽��� ���
					System.out.printf("\n���̹� ���ŵ� �¼��Դϴ�.��\n\n");
				}
			}else { // ���� ����� ���� �Է��ϸ� �޽��� ���
				System.out.printf("�� �߸��Է��ϼ̽��ϴ�.\n\n");
			}
		}else { // �࿡ ����� ���� �Է��ϸ� �޽��� ���
			System.out.printf("�� �߸��Է��ϼ̽��ϴ�.\n\n");
		}
	}
	public static void cancle_res(String[][] seat) { // �¼� �����ϴ� �Լ�
		Scanner sc = new Scanner(System.in);
		int i = 0; // ������ ���� ������ ����
		int j = 0; // ������ ���� ������ ����
		
		System.out.println("����� �ڸ��� �����ϼ���");
	
		System.out.printf("����� �� ( 1 ~ %d ) : ", seat.length);
		i = Integer.parseInt(sc.nextLine()); // ������ �� �Է¹޾� ���ڷ� ��ȯ�ؼ� ���� i�� �Ҵ�
	
		if ( ((i-1) >=  0 )&& ((i-1) < seat.length) ) { // 1���� �޾ұ� ������ �迭 ���� ���� �����ϱ� ���� -1 ó��.
			// ���� 0 ~ �迭�� ���̺��� ������ �� �Է¹ޱ�  
			System.out.printf("����� �� ( 1 ~ %d) : ", seat[i-1].length);
			j = Integer.parseInt(sc.nextLine()); // ����� �� �Է¹޾� ���ڷ� ��ȯ�ؼ� ���� j�� �Ҵ� 
		
			if (((j-1) >=  0 )&& ((j-1) <= seat[i-1].length) ) {// 1���� �޾ұ� ������ �迭 ���� ���� �����ϱ� ���� -1 ó��.
				// ���� 0~���� ���̺��� ������ 
				if ( seat [i-1][j-1] == null) { // �¼��� ����ִ��� Ȯ��
					System.out.printf("\n�ڿ��ŵ��� ���� �¼��Դϴ�.��\n\n");
				}else { // ������� ������ �޽��� ���
					seat[i-1][j-1] = null; // ���ó��
					System.out.printf("\n�ڡڼ����Ͻ� [%d][%d] �ڸ��� ��ҵǾ����ϴ�.�ڡ�\n\n",i,j);
				}
			}else { // ���� ����� ���� �Է��ϸ� �޽��� ���
				System.out.printf("�� �߸��Է��ϼ̽��ϴ�.\n\n");
			}
		}else { // �࿡ ����� ���� �Է��ϸ� �޽��� ���
			System.out.printf("�� �߸��Է��ϼ̽��ϴ�.\n\n");
		}
	}
	
	public static void main(String[] args) {
		//2�����迭
		Scanner sc = new Scanner(System.in);
		String[][] seat = new String[10][5]; // �ڸ������
		int choice = 0; // ������ �޴��� �Ҵ���� ����		
		
		do {
			Seat_Print(seat); // �ڸ� ������ִ� �Լ�
			
			System.out.printf("�ڡڡڡڡڡڡڡڡڡڡڡڡڡ�\n�޴��� �����ϼ���.\n1. ����\n2. ���\n3. ����\n");
			choice = Integer.parseInt(sc.nextLine()); // �޴�����
			
			switch (choice) { //������ �޴��� �޾Ƽ�
			case 1: { // 1 �̸� ����ȣ��
				reservation(seat); // �����ϴ� �Լ�
				break; // ���� ������ switch Ż��
			}
			case 2:{ // 2 �̸�  �������
				cancle_res(seat); // ����ϴ� �Լ�
				break; // ��� ������ switch Ż��
				}
			case 3:{ // 3�̸� ���α׷� ����
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
			default : System.out.printf("\n�߸��Է��ϼ̽��ϴ�.\n\n"); // �� �� ��ȣ �Է½� 
			}
			} while(true);
	}
}
