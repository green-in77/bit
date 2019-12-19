package kr.or.bit;

public class Ex03_DataType {
/*
 * �ڹٴ� �ý��ۿ��� �⺻ 8���� �⺻Ÿ���� ����(�ڷ���)
 * 8���� �⺻Ÿ��(���� �����ϴ� Ÿ��)
 * ���� -> ����(���� ����, ���� ����, 0) -> byte(-128~127) 
 * 											  -> char(�� ���ڸ� ǥ���ϴ� �ڷ���)
 * 													unicode ����
 * 											  ->short
 * 											  ->**int(-21��~21��, 4����Ʈ): �ڹ� ���� ������ �⺻Ÿ��**
 * 											  ->long(��Ʈ���� ū��, 8����Ʈ)
 * 		-> �Ǽ�(�ε��Ҽ���) -> float(4byte), double(8byte)
 * 								>>** ���е�(ǥ�������� ũ��) >> double -> java �Ǽ������� �⺻Ÿ��**
 * �� -> ��, ���� -> boolean >> ���α׷� ���� �帧����
 * String�� ����Ÿ��(Ŭ����)
 * ����: '��'. char c= 'A'; -> char�� ����Ÿ������ ������ ����. �� ������ 'A'�� ����Ÿ���� 65�� �����
 */
	public static void main(String[] args) {
		Car car=new Car(); //���� car�� Car�� �ּڰ��� ���� stack�� ���̰� new Car()�� heap�� ����
		Car car2=new Car();
		Car car3=car; //�ּڰ� �Ҵ�
		car3.color="black";
		System.out.println(car);
		System.out.println(car2);
		System.out.println(car3);
		System.out.println(car.color);
		//long num= 10000000000 -> ����, ���ͷ����� �⺻������ int ������ ����
		int intch= 'A'; //������ ����ȯ
		char ch='��';
		System.out.println(intch);
		System.out.println((int)ch);
		char ch2= 65;
		System.out.println(ch2);
		System.out.println((char)(ch2+1));
		int ch3=(int) ch2;
		
		System.out.println(ch3);
		
		int intch2= 129; //���� �������� Type�� ����^^^^^^^^^
		char ch4= (char)intch2; //�����, ���� ����ȯ
		System.out.println(ch4);
		/*
		 * ***Point***
		 * ������ �����ִ� ���� �������� ������ Ÿ���� ����.
		 * ������ Ÿ�� ũ�⸦ Ȯ������.
		 * ū Ÿ�Կ��� ���� Ÿ�� ���� ���� �� �ִ�. ���� Ÿ�Կ� ū Ÿ�� ���� ���� �� ����.
		 * char <- int >>> char <- (char)int
		 * int <- char ����(���������� ��ȯ) >>> int <-(int)char
		 */
		
		int intaValue= 465464;
		byte byteValue=(byte)intaValue;
		System.out.println(byteValue + "(�����Ⱚ)");
		
		/*
		 * Tip java���� Ư������ ����ϱ�
		 * ���ڸ� ���� ��Ű�� ���ؼ�: \ 
		 * char sing='''; - > '\'';
		 * String�� �� Ÿ���� �ƴϰ� Ŭ���� Ÿ��(new�� ���ؼ� �޸𸮿� �ø��� ���)
		 */
		System.out.println('\'');
		System.out.println("ȫ\"��\"��");
		System.out.println("100" + 100 + 100 + 100 + 100 + 100);
		System.out.println("C:\\temp");
		System.out.println("	t");
		System.out.println("\tt");
		
		float f=3.14f;
		float f2=1.123456789f;//�Ҽ����� 7�ڸ�, �ݿø� ó��
		System.out.println(f2);
		double d=1.123456789123456789; //�Ҽ����� 16�ڸ�ǥ��, �ݿø� ó��
		System.out.println(d);
		/*
		 * ����Ÿ�� + ūŸ�� = ūŸ��
		 * Ÿ�԰� ��ȯ�� ������ ������ ���� �������� ������ Ÿ���� ���� �Ǵ�.
		 * ����� ����ȯ(casting) (int)
		 */
		
		
	}
}

class Car { 
	String color;
	int window;
}
