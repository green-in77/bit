import kr.or.bit.Fclass;
import kr.or.bit.Tv;

public class Ex02_Mathod {
	public static void main(String[] args) {
		Fclass fc = new Fclass();
		fc.m(); // �̸��� �θ��� ����(call) : m() �Լ� ȣ��
		
		int input = 200;
		fc.m2(input);
		
		int result = fc.m3(); // return Ÿ���� �ִٸ� �� ���� ������ ��Ƽ� ���.
		System.out.println("fc.m3 �� return value : " + result );
		
		result = fc.m4(500);
		System.out.println("fc.m4�� return value : " + result );
		
		int sum = fc.sum(10, 20, 500); // parameter  3���� 3�� ������ �Է� / 2���� �Է�, 1���� �Է� �Ұ�
		System.out.println("sum : " + sum);
		
		int sum2 = fc.sum2(-10);
		System.out.println("sum2 : " + sum2);
		
		int max = fc.Max(400, -30);
		System.out.println("max : " + max);
		
		String str = fc.concat("�ȳ�", "�氡", "�����");
		System.out.println("concat : " + str);
		
		//main �Լ� ����
		Tv t = fc.objMethod();
		System.out.println("t : " + t);
		System.out.println("t.brand : " + t.brand);
		
		Tv t2 = fc.ojbMethod2();
		
		System.out.println( t == t2 );
		System.out.println("t2 : " + t2);

		//t�� �ּҰ��� t2 �� �ּҰ��� �ٸ�.
		
		Tv t3 = fc.objMathod3(t2); // F3 ������ �Լ��� �ٷ� �̵�.
		
		// t2 �ּҰ��� t3 �� �ּҰ��� ����.
		
		System.out.println(t2 == t3);
		System.out.println("t3 : " + t3 );
		
	}
}