package kr.or.bit;
import kr.or.bit.Car_Mark;
/*
��Ʈ�ڵ����� �����ϴ� â���̴�.		
		
��Ʈ�ڵ����� ����(smart, web, java)�� ���ݰ� ��ũ�� ������ �ִ�.		
	��ũ�� �������� ���еǾ��ִ�.	
	1. smart	��
	2. web	��
	3. java	��
		
�ڵ����� �԰�� �� �ݵ�� ������ ������ �Է��ؾ� �Ѵ�.		
	�Է��� ������ ���� ���� �� �Է��� �������� �����ְ� �߸� �Է������� �˷��ְ� ���α׷��� ����ȴ�.	
		
�ڵ����� ������ ������ Ư�� ����� ���ؼ��� �� �� �ְ�, �԰�� ���� ������ �� ����.		
	��ȸ ���� �� ������ũ�� ��5�ٷ� ��µǰ� �� �Ʒ��� ������ ��ũ�� ������ ��µǾ���Ѵ�.	
	1. smart	��
	2. web	��
	3. java	��
		
������ �̸��� ������ ���� Ȯ���� �� �ִ�.		
�������(��,������) �� Ȯ���ϴ� ����� �ִ�.		
 */

public class Ex_Bitcar {
	
	private String cname; // ��������
	private int cprice; // ����
	private Car_Mark Mark; //��ũ
	private static int carsum; // �� �������
	private static int ssum; // smart �������
	private static int wsum; // wsum �������
	private static int jsum; //jsum �������
	
	public Ex_Bitcar(String cname, int cprice) { // ������ �����ε� : �԰� �� �ݵ�� ������ ������ �Է�.
		carsum++; //�� ������� ����
		
		if ( !cname.equals("smart") && !cname.equals("web") && !cname.equals("java") ) { // ������ 3���� �ܿ� �ٸ����� �Էµ� ���
			System.out.println("�Է��Ͻ� ���� : " +cname); // ���Է��� ���� ���
			System.out.println("�Է��� �߸��ϼ̽��ϴ�."); // �����޽���
			System.exit(0); // ���α׷� ����
		} else { // ������ �°� ���� ���
			this.cname = cname; // �Է¹��� �������� �� �Ҵ�
			this.cprice = cprice; // �Է¹��� �������� �� �Ҵ�
		}
		if (this.cname.equals("smart")) { // ���� �� ��������� ����.
			ssum++;
		} else if (this.cname.equals("web")) {
			wsum++;
		}else {
			jsum++;
		}
	}
	
	public String getCname() { // ������ �θ� �� �ִ� �Լ�.
		return cname;
	}

	public int getCprice() { // ������ �θ� �� �ִ� �Լ�.
		return cprice;
	}
		
	public void car_print() { //������ ���� ��� ���
		
		if(this.cname.equals("smart")) { // ����Ʈ �϶� �� �� ��� �� 
		
			for (int Line = 1; Line <= 5 ; Line++ ) { //1���� 8���� 1�� �����ϸ� �ݺ�. Line ���� 5�� �Ǹ� ��.(���� 5���� ��ڴ�.)
				
				for (int Null = 5 ; Null >= Line ; Null--) { // 5�� Line ���� ���������� 1�� �����ϸ� �ݺ�. Null ���� Line ������ ������ ��.(Null ���� Line �� �ɶ����� �������/Line 1 �̸� 5��, 2�̸� 4,...)
					System.out.print(" "); //�������
				}
				
				for (int Star = 1; Star <= (2*Line)-1 ; Star++){ //1���� Ȧ�������� 1�� �����ϸ� �ݺ�(2*1)-1 = 1, (2*2)-1 = 3... (Ȧ����ŭ �����)
					System.out.print("*"); //�����
				}
				
				System.out.println(); //�� ���� ��� �� �ٹٲٱ�
			}
			
			System.out.println(this.cname +" " + Car_Mark.getSmark() + " " + this.cprice); // smart ����
			
		}else if(this.cname.equals("web")) {
			
			for (int Line = 1; Line <= 5 ; Line++ ) { //1���� 5���� 1�� �����ϸ� �ݺ�. Line ���� 5�� �Ǹ� ��.(���� 5���� ��ڴ�.)
				
				for (int Null = 1 ; Null <= Line ; Null++) { // 5�� Line ���� Ŀ�������� 1�� �����ϸ� �ݺ�. Null ���� Line ������ ũ�� ��.(Null ���� Line �� �ɶ����� �������/Line 1 �̸� 1��, 2�̸� 2,...)
					System.out.print(" "); //�������
				}
				
				for (int Star = 9; Star >= (2*Line)-1 ; Star--){ //9���� Ȧ�������� 1�� �����ϸ� �ݺ�(2*1)-1 = 1, (2*2)-1 = 3... (Ȧ����ŭ �����)
					System.out.print("*"); //�����
				}
				System.out.println(); // �� ���� ��� �� �ٹٲ�
			}
			
			System.out.println(this.cname + " " + Car_Mark.getWmark() + " " + this.cprice); // web ����
			
		}else {
			
			for ( int Line = 1; Line <= 5 ; Line++ ) { // 1���� 5���� 1�� �����ϸ� �ݺ� 
				for(int Star = 1; Star <=15 ; Star++) { // 1���� 15���� 1�� �����ϸ� �ݺ� 
					System.out.print("*"); // �����
				}
				System.out.println(); // �� ���� ��� �� �ٹٲ�
			}
			System.out.println(this.cname + " " + Car_Mark.getJmark() + " " + this.cprice); // java ����
		}
		
	}
	
	public void carsum_print() { // ������� ��� �Լ�
		System.out.printf("�� ��������� %d �� �Դϴ�.\n\n",carsum);
	}
	
	public void ssum_print() { // smart ���� ��� �Լ�
		System.out.printf("smart��  ��������� %d �� �Դϴ�.\n\n",ssum);
	}
	
	public void wsum_print() { // wsum ���� ��� �Լ�
		System.out.printf("web��  ��������� %d �� �Դϴ�.\n\n",wsum);
	}
	
	public void jsum_print() { // jsum ���� ��� �Լ�
		System.out.printf("java��  ��������� %d �� �Դϴ�.\n\n",jsum);
	}
}

