import java.util.Scanner;

public class Ex_print {

	public static void main(String[] args) {
		
		// ���ĺ�(A~Z) ���� ����ϴ� ���α׷��� �ۼ��ϼ���
		// (for ���� ����ϼ���)
		int count = 1; // count ���� �� �ʱ�ȭ.
		
		for(count = 65 ; count <= 90 ; count++) { // 65~90 ���� 1�� �����ϸ� ����
			System.out.print((char)count); // count �� �ش��ϴ� �ƽ�Ű �ڵ� ���� ���.
			
		}
		
		System.out.println();
		//1~100���� 10�� 10���� ����ϴ� ���α׷��� �ۼ��ϼ���
		//(for���� ����ϼ���)
		
		for( count=1 ; count <= 100 ; count++) { // 1���� 100���� 1�� �����ϸ� ����
			System.out.printf("%d ",count); // count ���
			if( (count % 10) == 0) { // count �� 10���� �������� 0�̸� ����
				System.out.println(); // �ٹٲ�
			}
		}
		System.out.println();
		
		// 1���� 20������ ���� �߿��� 2 �Ǵ� 3�� ����� �ƴ� ���� ������ ���ϴ� ���α׷�
		int sum=0; // �հ踦 ������ �� ���� ���� �� �ʱ�ȭ.
		
		for ( int i = 1; i <= 20 ; i++ ){ // 1~20 ���� 1�� �����ϸ� �ݺ�
			if( ((i%2) != 0) || ((i%3) != 0) ) { // 2�� ���� �������� 0�� �ƴϰų�(2�� ����� �ƴϰų�) 3���� ���� �������� 0�� �ƴϰų�( 3�� ����� �ƴϰų�)
				sum += i; // �հ�����
				System.out.printf("%d ",i);
			} 
			
		}
		System.out.printf("\n1~20���� ���� �� 2 �Ǵ� 3�� ����� �ƴ� ���� �� �� : %d",sum); // �հ� ���
		
		System.out.println();
		System.out.println();
		
		// �ΰ��� �ֻ����� ������ �� ���� ���� 6�� �Ǵ� ��� ����� ���� ����ϴ� ���α׷�
		
		for (int i = 1 ; i <= 6 ; i++ ) { // 1�� �ֻ��� 1~6���� 1�� �����ϸ鼭 �ݺ�
			for (int j = 1; j <= 6 ; j++) { // 2�� �ֻ��� 1~6���� 1�� �����ϸ鼭 �ݺ�
				if( ((i+j) == 6)) { // 1�� �ֻ��� + 2�� �ֻ��� = 6 �̸� ����
					System.out.printf("1�� �ֻ��� %d + 2�� �ֻ��� %d = %d\n", i,j,i+j); // ���
				}
			}				
		}
		
		System.out.println();
		
		
		//���� , ���� ,�� ���� �� ����� ���ؼ� �ۼ��ϼ��� (IF)
		// ex) ��ǻ�Ͱ� �ڵ����� ���� ���� , ���� , �� �� ���ؼ� ����ڰ� ���� �Է� �ؼ� ó�� �ϼ���		( ���� ��� : ����=> 1   , ���� => 2  , �� => 3)
		Scanner sc = new Scanner(System.in);
		int random = 1;
		String com = "";
		int pushnum = 0;
		
		/*
		do {
			random = (int)(Math.random()*10)+1;
		} while (random > 3);
		*/
		
		random = (int)(Math.random()*3)+1; // 1���� 3������ ���� �����Ҵ�
		//System.out.println(random);
				
		System.out.printf("����, ����, �� �� �Է��ϼ��� : ");
		
		String push = sc.nextLine(); //����� �� �Է¹ޱ�/
		
		if (random == 1) { // ���� ���� ����,����,�� �� ��ȯ 1�̸� ����, 2�̸� ����, ������ ��( ���� ���� 1~3 ������ ��µ�.
			com = "����";
		} else if (random == 2) {
			com = "����";
		} else { 
			com = "��";
		}
		
				
		if (push.equals("����")) { // �Է¹��� ���� ���� ������ ����
			pushnum = 1;
		} else if (push.equals("����")) {
			pushnum = 2;
		} else if ( push.equals("��")) {
			pushnum = 3;
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		
		System.out.printf("����� %s : ��ǻ�� %s \n", push, com); // ����� ��, ���� �� ���.
		
		if ( pushnum == random) // ���� ���� �� ���к�
		{
			System.out.println("�����ϴ�.");
		} else if ( (pushnum == 1 && random == 2) || (pushnum == 2 && random == 3) || (pushnum == 3 && random == 1 )) {
			System.out.println("����ڰ� �����ϴ�.");
		} else {
			System.out.println("����ڰ� �̰���ϴ�.");
		}		

	}

}
