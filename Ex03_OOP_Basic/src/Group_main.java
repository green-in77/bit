import java.util.Scanner;

import kr.or.bit.Bitcamp_3;
import kr.or.bit.Department_4;
import kr.or.bit.Goods_2;

//(1�� - ���� / 2�� - �����̽� / 3�� - �Ƶ�ٽ�)
// ������ �Է��ϱ� ���� ����ڿ��� �� ���� �Է¹����� ������ ���ش�.
// ���� ���� ���̳� �߸��� ���� �Է����� �� �� ���� �ٽ� �����.
public class Group_main {

	public static void main(String[] args) {
		/*
		System.out.println("2��");
		//2�� ��ǰ--------------------------------------------------------------------------------------------
		Goods_2 g1 = new Goods_2(101010, 3000, "�����", "����", "�����λ�ǰ");
		g1.Goods_print();
		g1.setGoodsdiscount("���λ�ǰ");
		g1.setGoodsprice(2500);
		g1.Goods_print();
		//---------------------------------------------------------------------------------------------------------
		System.out.println();
		*/
		System.out.println("3��");
		//3�� ��ǰ--------------------------------------------------------------------------------------------
		Bitcamp_3 bit1 = new Bitcamp_3("������", "000-0000-0000");
		bit1.Bit_Print();
		bit1.Choice();
		
		Bitcamp_3 bit2 = new Bitcamp_3("������","111-1111-1111");			
		bit2.setCardnum("1111-1111-2222-2222");
		bit2.Bit_Print();
		bit2.Choice();
		
		//------------------------------------------------------------------------------------------------------
		System.out.println();
		
		
		/*
		System.out.println("4��");
		//4�� ��ȭ��----------------------------------------------------------------------
		Scanner sc = new Scanner(System.in);
		int input_floor = 0;
		
		Department_4 dep1 = new Department_4("����", 1);
		Department_4 dep2 = new Department_4("�����̽�", 2);
		Department_4 dep3 = new Department_4("�Ƶ�ٽ�", 3);
			
		do { // �� ���� ���� �� ����
			System.out.println("�� ���� �Է��Ͻðڽ��ϱ�? (1.1�� 2.2�� 3.3�� 4.����)");
			input_floor = Integer.parseInt(sc.nextLine());
			
			if ( input_floor==1) { // 1�̸� 
				dep1.Dep_print(); // 1�� ���
			} else if  (input_floor ==2) { // 2�̸�
				dep2.Dep_print(); // 2�� ���
			} else if ( input_floor ==3){ // 3�̸�
				dep3.Dep_print(); // 3�� ���
			} else if(input_floor == 4) { //4�̸� 
				System.out.println("���α׷��� ����˴ϴ�.");
				return; //����
			} else { // �߸��Է½� 
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		} while(true);
	//--------------------------------------------------------------------------------------*/		
	}
}
