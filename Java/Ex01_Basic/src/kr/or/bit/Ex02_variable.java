package kr.or.bit;

public class Ex02_variable {
/*
 * Tip) c# public static void Main() ....
 * static variable: �������� - ��ü�� �����ڿ�
 * instance variable: ��ü����
 * local variable: �������� - �޼ҵ尡 ȣ������� �����ƴٰ� �޼ҵ尡 ������ ���ÿ� �Ҹ�
 * local variable�� �ʱⰪ�� ���� ������ ����Ҽ������� instance variable�� �ʱⰪ�� ���� �ʾƵ�
 	0���� �ʱ�ȭ�ȴ�. ������?
 	��ü�� ������������� ������ ���� �����ϱ⶧���� ���� �ʱⰪ�� �ϳ��� ���ص� �ʿ䰡 ����.
 * ����Ǵ� �Լ��� ��� stack���� �ö�´�.
 */
	public static void main(String[] args) { // ���α׷��� ������
		int lv= 500;
		System.out.println("lv ������: " + lv);
		//����(javac ������ > java Ex02_variable�� ������� �޸𸮿� �ø� 
		int number=0; //�ʱ�ȭ ���� ���� ����X
		System.out.println(number); //�ʱ�ȭ ���ϰ� ����Ҷ� ����
		//���������� �ݵ�� �ʱ�ȭ
		Test t=new Test(); //stack�� t��� ������ ����� heap�� Test��ü�� ����� �׾ȿ� iv��� ������ ����
		System.out.println(t.iv);
	}

}

class Test {//class�� ���赵�̴� == class�� Type�̴�.(���� �������� Type�� �������ִ� ū Type�̴�)
	int iv=500;
}
