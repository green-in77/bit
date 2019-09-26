import java.util.Scanner; // ��Ű���� ���� scanner �� �� �ִ�.

public class Ex07_Printf_format {
	public static void main(String[] args) {
		
		//java : System.out.println();
		// C#  : Consol.writeLine();
		
		//System.our.println(); ����ȿ���� �ִ� ���
		System.out.print("B");
		System.out.print("C");
		System.out.println("D");
		
		int num = 100;
		System.out.println(num);
		System.out.println("num ���� :" + num + " �Դϴ�.");
		
		//����(format)
		
		System.out.printf("num ���� :%d �Դϴ�. \n", num);
		//fotmat ���� ����
		// %d (10���� ������ ����) >> d��� �ڸ���
		// %f (�Ǽ�)
		// %s (���ڿ�)
		// %c (����)
		// Ư������ : \t (tap), \n(�ٹٲ�) ��
		
		System.out.printf("num ���� [%d] �Դϴ�. �׸��� [%d] �� �־��.\n", num, 1000);
		float f = 3.14f;
		System.out.println(f); // 3.14 �� ���
		System.out.printf("f �������� %f �Դϴ�\n", f); // 3.140000 ���� ���
		
		//cmd(console) â���� �Է��� �� �о����
		//java.util.Scanner sc = new java.util.scanner(System.in);
		//import ���� ��� ... Scanner ���

		Scanner sc = new Scanner(System.in);
	/*
		System.out.println("���� �Է��ϼ���.");
		
		String value = sc.nextLine(); // �Է� ��� ���� - �Է��� �Ϸ�(����)�Ǹ� ���� / �ԷµǱ� �������� ���α׷��� ��� ������. / ���ڿ��� �����ϴ� �Լ�. - ���ڸ� �Է��ص� ���ڷ� �ν�
		System.out.println("�Է°� : " + value);
		
		int number = sc.nextInt(); // �������� �����ϴ� �Լ� , ���� �Է� �� ����. // ��Ŭ�������� ���� �� ���α׷��� ���� �� ����.
		System.out.println("������ : " + number);
		
		//sc.nextFloat(); // �Ǽ� �� �б�
		
		//������� : nextInt , nextFloat �Լ� ���ٴ� nextLine �� ������� - �����־
		//Today Point�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
		//���ڸ� ���ڷ� �ٲٱ�
		//Inter.parseInt �����κ���
		//Float.parseFloat �Ǽ��� ����
		//Double.parseDouble �Ǽ��� ����
		
		Integer.parseInt(value); // ������ ���ִ� ���ڿ��� ������ ��������.
	
		System.out.println("���� �Է��ϼ���.");
		int number = Integer.parseInt(sc.nextLine()); // �Է¹��� ���ڿ��� ������ �����ؼ� �ѹ��� �Ҵ�
		System.out.println("������ : " + number);
		
		//Tip
		//���ڸ� -> ���ڷ� (����)
		String data = String.valueOf(10000);
		System.out.println(data);
		
	*/
		System.out.println("����1�� �Է��ϼ���.");
		int number1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("�����ڸ� �Է��ϼ���(+,-,*,/)");
		String str = sc.nextLine();
		
		System.out.println("����2�� �Է��ϼ���.");
		int number2 = Integer.parseInt(sc.nextLine());
		
		int result = 0;
		
		if(str.equals("+")) {
			result = number1 + number2;
		}else if (str.equals("-")) {
			result = number1 - number2;
		}else if (str.equals("*")) {
			result = number1 * number2;
		}else if (str.equals("/")) {
			result = number1 / number2;
		}else {
			//System.out.println("�����ڸ� �߸��Է��ϼ̽��ϴ�.");
		}
		
		System.out.printf("%d %s %d = %d �Դϴ�.\n", number1, str, number2, result);
		
	}

}
