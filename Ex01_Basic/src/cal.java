/*
������ ��Ģ ����� (+ , - , * , /)
�Է°� 3�� (�Է°��� nextLine() �޾Ƽ� �ʿ��ϴٸ� ���� ��ȯ)
���� : Integer.parseInt() ,  equals() Ȱ��
ȭ��
>�Է°�:����
>�Է°�(��ȣ): +
>�Է°�:���� 
>������ :200

-------------
>�Է°�:100
>�Է°�(��ȣ): -
>�Է°�:100
>������ :0
*/

import java.util.Scanner;

public class cal {

	public static void main(String[] args) {
		
		//�ǵ�� - �ʿ��� ���� ��ܿ� �̸� �ʱ�ȭ�����ϰ� ����ϱ�.�ڡڡڡ�
		
		Scanner sc = new Scanner(System.in); //��ĳ�� Ÿ���� sc�� ����(�Է¹޴°��� �� �� �ִ� )
		
		// Ctrl + Shift + 0 (import �ڵ������ϱ�)
		
		System.out.println("����1�� �Է��ϼ���.");
		int number1 = Integer.parseInt(sc.nextLine()); //���ڿ��� �Է¹޾Ƽ� ���ڷ� ��ȯ�ؼ� number1 �� �Ҵ�.
		
		System.out.println("�����ڸ� �Է��ϼ���(+,-,*,/)");
		String str = sc.nextLine(); // ���ڿ��� �Է¹޾� str�� �Ҵ� // �̰͵� ��������!
		
		System.out.println("����2�� �Է��ϼ���.");
		int number2 = Integer.parseInt(sc.nextLine()); //���ڿ��� �Է¹޾Ƽ� ���ڷ� ��ȯ�ؼ� number2 �� �Ҵ�.
		
		int result1 = 0; // ������ ������� ������ ������ ���� �� �ʱ�ȭ
		
		if(str.equals("+")) { // ���ڿ��� �񱳴� equals �� ���� / == �� �� ��� ���ڰ� ���ִ� �ּҰ��� ���ϱ� ������ ������ ���� �� ����.
			result1 = number1 + number2;
			
		}else if (str.equals("-")) {
			result1 = number1 - number2;
			
			
		}else if (str.equals("*")) {
			result1 = number1 * number2;
			
			
		}else if (str.equals("/")) {
			result1 = number1 / number2;
		
		}
		else {
			System.out.println("�����ڸ� �߸��Է��ϼ̽��ϴ�.");
			return; // ��ȯ�� ���� ����. �Լ� ���� - ���⼭�� main �� ������.
		}
		
		System.out.printf("%d %s %d = %d �Դϴ�. \n", number1, str, number2, result1);
	
	}
}
