package kr.or.bit;

import java.util.Scanner;

/*
 ��Ʈķ�� ������û
1. ������û�ڴ� �ݵ�� �̸�, �޴�����ȣ�� ������ �ִ�. 

2. ������û�� �����ϱ� ���ؼ��� �ݵ�� ���Ϲ�� ī���ȣ�� ������ �־�� �Ѵ�. 

3. ���� ���� ���ī�尡 ������ ���� ��û�� �Ұ����ϴٴ� ������ ��µȴ�.

4. ������û���� ����(�̸�, �޴�����ȣ,(���� ���ī�� ��ȣ))���� ����� �� �ִ� Ư�� ����� �ִ�.

5. ���� ��û�� ������ ����� ���ǹ�ȣ(1. java 2. python 3. c)�� Ư�� ����� ���ؼ� ������ �� �ִ�. 
���� �ݵ�� �־��� ��Ͽ��� �����ؾ� �Ѵ�.
���ǿ� ���� �п� ����(1. java - ����(�Ӱ�� ����Ԣ�.��) 2. python-���ʺ��� 3. c-����)�� �ο��ȴ�.

6. ���� �־��� ��Ͽ��� ��� ���Ǹ� ������ ���, �ٽ� ���Ǹ� �缱���� �� �ִ�.

7. �̸�, �޴�����ȣ, ī���ȣ ������ ���� Ȯ���� �� �ִ�.

8. �޴�����ȣ�� ���Ŀ� ������ �� �ִ�. 
 */
public class Bitcamp_3 {
	private String name; // �̸�
	private String phone; //�޴���
	private String cardnum; //ī���ȣ
	
	public Bitcamp_3 (String name, String phone) { //������û�ڴ� �ݵ�� �̸��� �޴�����ȣ�� ������ �ִ�.
		this.name = name;
		this.phone = phone;
	}
	
	public void setCardnum(String cardnum) { //���Ϲ�� ī���ȣ �Է�.
		this.cardnum = cardnum;
	}

	public void Bit_Print() { //�̸�, �޴�����ȣ, ī���ȣ ��� ���
		if (this.cardnum == null) {
			System.out.printf("�̸� : %s, �޴�����ȣ : %s\n", this.name, this.phone);
		}else {
			System.out.printf("�̸� : %s, �޴�����ȣ : %s, ī���ȣ : %s\n", this.name, this.phone, this.cardnum);
		}
	}
	
	public void Choice() { //������û
		Scanner sc = new Scanner(System.in);
		int input_num = 0; //�Է��� ��ȣ�� ������ ���� 
		
		if ( this.cardnum == null ) { // ī���ȣ�� ������ 
			System.out.printf("���Ϲ��ī�尡 ���� ������û �Ͻ� �� �����ϴ�.\n\n"); //������û �Ұ� 
		}else { //ī���ȣ�� ������
			
			do { // ���� �޴� ���
				System.out.println("1. java 2. python 3. c");
				System.out.printf("���Ͻô� ���� ��ȣ�� �Է��ϼ���. : ");
				input_num = Integer.parseInt(sc.nextLine());
				
				if( input_num == 1) { // 1�� �����ϸ�
					System.out.println("1.java - ����(�Ӱ�� ����Ԣ�.��");
					return;
				} else if( input_num == 2 ) { // 2�� �����ϸ�
					System.out.println("python-���ʺ���");
					return;
				}else if ( input_num == 3 ) { // 3�� �����ϸ�
					System.out.println("c-����");
					return;
				} else { // �� �� �Է½�.
					System.out.printf("�Է��� �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.\n\n");
				}
			}while(true);
		}
		
	}

	public String getPhone() { //�޴�����ȣ Ȯ��
		return phone;
	}

	public void setPhone(String phone) { // �޴�����ȣ ������
		this.phone = phone;
	}

	public String getName() { //�̸� Ȯ��
		return name;
	}

	public String getCardnum() { // ī���ȣ Ȯ��
		return cardnum;
	}	
}
