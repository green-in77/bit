
public class Ex06_Operation {

	public static void main(String[] args) {
		/*int sum = 0;
		// ���Կ����� (+=, -=, *= ) ����������
		sum += 1; // sum = sum + 1;
		sum -= 1; // sum = sum -1;
		System.out.println("sum:" + sum);

		// ������ ���� ����
		// ����... A+, A-, B+, B- (score)
		// ����... 94��
		// 95�� �̻��̸� A+
		// �� �ܴ� A-

		// 90�� �̻��̸� A �ε�... 95�� �̻��̸� A+ , 93�� A-

		int score = 90;
		String grade = ""; // ���ڿ� �ʱ�ȭ (����)
		System.out.println("����� ������ : " + score);

		if (score >= 90) {
			grade = "A";
			if (score >= 95) {
				grade += "+"; // grade = grade + "+"; // A+
			} else {
				grade += "-"; // grade = grade + "-" // A-
			}
		} else if (score >= 80) {
			grade = "B";
			if (score >= 85) {
				grade += "+"; // grade = grade + "+"; // A+
			} else {
				grade += "-"; // grade = grade + "-" // A-
			}

		} else if (score >= 70) {
			grade = "C";
			if (score >= 75) {
				grade += "+"; // grade = grade + "+"; // A+
			} else {
				grade += "-"; // grade = grade + "-" // A-
			}
		} else {
			grade = "F";
		}

		System.out.println("����� ������ : " + grade + "�Դϴ�");

		// syso + ctrl + space ��� �ڵ��ϼ�
		// �ڵ� �����ϱ� ctrl+a -> ctrl + shift + F
		
		int data = 55;
		switch (data) { // switch (���ڰ�) //���� �����ؼ� ����Ȯ�� // �� �� ���̾�?
			case 100: System.out.println("100�Դϴ�."); //case ���� : ������ ����
				break; // switch Ż�� (��) // ������ ��� ������ �� �¿�.
			case 90: System.out.println("90�Դϴ�."); //case ���� : ������ ����
				break;
			case 80: System.out.println("80�Դϴ�."); //case ���� : ������ ����
				break;
			default: System.out.println("default");
		}
		
		//brake �� ������ �ƴ�, �ʿ信 ���� ���.\
		//case ���� �����ϴ� ���ķ� ��� ����ڡڡڡڡ�
		data = 80;
		switch (data) { // switch (���ڰ�) //���� �����ؼ� ����Ȯ�� // �� �� ���̾�?
			case 100: System.out.println("100�Դϴ�~"); 
			case 90: System.out.println("90�Դϴ�~"); 				
			case 80: System.out.println("80�Դϴ�~"); 
			default: System.out.println("default~");
		}
		
		int month = 2;
		String res = "";
		switch (month) {
			case 1: System.out.println("1");
			case 3: System.out.println("3");
			case 5: System.out.println("5");
			case 7: System.out.println("7");
			case 8: System.out.println("8");
			case 10: System.out.println("10");
			case 12:res = "31";
			break;
			
			case 4: 
			case 6: 
			case 9:
			case 11: res="30";
			break;
			
			case 2: res="29";
			break;
			
			default : res="���� �ƴմϴ�.";
		}
		
		System.out.println(month + "���� " + res + "�ϱ��� �Դϴ�.");
		
		//����(������ : ������ ���Ⱚ)
		//java.lang.Math (Math Ŭ����)
		
		//default > java.lang.Math
		//java ���������� default �� ������� ������ ���� = java.lang >> import java.lang.* // lang ���� ���� ��� �ڿ��� import ���� ��밡����.
		//������ ��ܿ� import java.lang.Math // ��Ģ�� ��뼱��
		
		//Math.Random()
		//static random() ��ü ���� ���̵� ��� ����.(static �Լ� ���� ����ϴϱ�)
		//Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
		//��� : 0.0 <= random < 1.0 // ���� ���� ���� �� �ֵ�.
		
		System.out.println("Math.random() : " + Math.random());
		System.out.println("Math.random() * 10 : " + Math.random()*10);
		System.out.println("(int)(Math.random()*10) : " + (int)(Math.random()*10)); //0~9������ �������� �Ǽ�->������ ����ȯ
		System.out.println("(int)(Math.random()*10+1) : " + ((int)(Math.random()*10)+1)); //1~10������ ������.
		*/
		/*
		�츮�� ��ȭ�� ��ǰ �ý����� ������� �Ѵ�.
		��ǰ �ý����� ������ ������ ���� ��ǰ�� �����ϴ� �ý����̴�.
		��ǰ���� Tv Notebook, �����, �ѿ켼Ʈ, ����
		 ��ǰ ��÷��
		 ��ǰ 1000�� - Tv, Notebook, �����, �ѿ켼Ʈ, ����
		 ��ǰ 900�� - Notebook, �����, �ѿ켼Ʈ, ����
		 ��ǰ 800�� - �����, �ѿ켼Ʈ, ����
		 ��ǰ 700�� - �ѿ켼Ʈ, ����		 
		 ��ǰ 600�� - ����
		 �� �� ������ 100~500 - ĩ��
		 
		 ��ǰ�ý��� ������ ������ 100~1000 ���� �����Ǿ� �ְ�
		  
		����ڰ� ��ǰ �ý����� ���� �����ϰ� 100 ~ 1000������ ���� ������ �Ǿ��ִ�.
		*/
		
		int number = ((int)(Math.random()*10)+1)*100;
		System.out.println("��ǰ ���� : " + number);
		System.out.print("���ް�ǰ : ");
		String msg=""; //�ʱ�ȭ
				
		switch (number) {
			case 1000: msg+="TV ";
			case 900: msg+="NateBook ";
			case 800: msg+="����� ";
			case 700: msg+="�ѿ켼Ʈ ";
			case 600: msg+="���� ";
			break;
			default : msg+="ĩ��";
		}
		System.out.println(msg);
		
		
		/*
		if(number == 1000) {
			System.out.println("Tv, Notebook, �����, �ѿ켼Ʈ, ����");
		}else if (number >= 900) {
			System.out.println("Notebook, �����, �ѿ켼Ʈ, ����");
		}else if (number >=800) {
			System.out.println("�����, �ѿ켼Ʈ, ����");
		}else if (number >= 700) {
			System.out.println("�ѿ켼Ʈ, ����");
		}else if (number >= 599) {
			System.out.println("����");
		}else System.out.println("ĩ��");
		*/
		
		
		
	}

}
