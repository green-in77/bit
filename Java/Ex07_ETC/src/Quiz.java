import java.util.Scanner;

//�ֹι�ȣ : �޹�ȣ ù�ڸ� : 1,3 ���� , 2,4 ���� ��� ��� ...
//main �Լ� Scanner  ��� �ֹι�ȣ �Է¹ް�
//��:6�ڸ� ��:7�ڸ�
//�Է°� : 123456-1234567 
//1. �ڸ��� üũ (���)�Լ� (14 ok)
//2. �޹�ȣ ù��° �ڸ��� 1~4������ ���� ��� ����Լ�
//3. �޹�ȣ ù��° �ڸ����� ������ 1,3 ���� , 2,4 ���� ��� ����Լ�
//3���� �Լ� static 

public class Quiz {
	static boolean number_lenght(String jumin) { // ���� ������ ���̸� üũ�ϴ� �Լ�.
		return jumin.length() == 14 ? true : false;
		/*
		if ( jumin.length() == 14 ) { // 14�ڸ��̸�
			return true;
		}else { // 14�ڸ��� �ƴϸ�
			System.out.println("14�ڸ��� �Է��ϼ���.");
			return false;
		}*/
	}
	static boolean result_check(String jumin) { // �޹�ȣ ù��° �ڸ��� üũ�ϴ� �Լ�.
		int num = Integer.parseInt(jumin.substring(7,8)); // ���ڷ� ��ȯ���Ѽ� ������ üũ.
		if ( num > 0 && num <5) {
		//if ((jumin.substring(7,8).equals("1"))|| (jumin.substring(7,8).equals("3"))||(jumin.substring(7,8).equals("2"))|| (jumin.substring(7,8).equals("4"))) {//1~4���� �� ������
			return true;
		}else {//1~4�� �ƴϸ�
			System.out.println("�ֹι�ȣ �޹�ȣ ù�ڸ��� 1~4���� �Է� �����մϴ�.");
			return false;
		}
	}
	static void gender(String jumin) { // ���� �������ִ� �Լ�.
		 if(Integer.parseInt(jumin.substring(7,8))%2==0) { // 2�� ������ �������� 0�̸� ¦�� = ����
             System.out.println("����");
		 }else System.out.println("����"); // �ƴϸ� ����.
		 
		/*if ( (jumin.substring(7,8).equals("1"))|| (jumin.substring(7,8).equals("3")) ){ // 1,3 �̸� ����  
			System.out.println("����");
		} else if ((jumin.substring(7,8).equals("2"))|| (jumin.substring(7,8).equals("4"))){ // 2,4 �̸� ����
			System.out.println("����");
		}*/
		 
	}
	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		String jumin;
		//boolean result = false;
		
		do {
			System.out.println("�ֹι�ȣ�� �Է��ϼ���.(ex. 123456-1234567)");
			jumin = sc.nextLine(); // �ֹι�ȣ �Է¹ޱ�
			
		/*	result = number_lenght(jumin); // �ֹι�ȣ�� 14�ڸ����� üũ���ִ� �Լ� ȣ���ؼ� true / false ��ȯ����
			if( result ) 	result = result_check(jumin); // �ֹι�ȣ�� 14�ڸ����� ������ �޹�ȣ ù��° �ڸ��� üũ���ִ� �Լ� ȣ���ؼ� true / false ��ȯ����
			if ( result ) gender(jumin); // ���ڸ� ù��° �ڸ��� 1~4 �̸� ���� üũ���ִ� �Լ� ȣ��*/
			
		}while(!number_lenght(jumin) || !result_check(jumin)); // ��ȯ�� ���� false �� ���ѷ���.
		
		gender(jumin);
	}
}
