class Data { // Ŭ���� == Ÿ�� ( ūŸ��)
	int i; //��ü����
}

// �ڡڡڡڡڡ�method �� parameter �� �⺻8���� Ÿ��(����,����) + String(���ڿ�) + ����ڰ� ������ class Ÿ��(�ּ�=������)�� ���� �� �ִ�.

public class Ex10_Method_Call {

	public static void main(String[] args) {
		Data d = new Data();
		d.i = 100;
		System.out.println("d.i : " + d.i); // 100
		
		scall(d); // Point (d �������� ��ü Data �� �ּҰ�(����) � Ÿ���� ���� : Data)
		vcall(d.i);
		
		System.out.println("d.i : " + d.i); // 1111

	}
	static void scall (Data data) {  // class Data Ÿ���� data ����  : �ּҰ� ����. 
		//data ��� ������ Data ��� Ŭ������ �ּҰ��� ������ �ȴ�.
		//Data�� �ǹ��ϴ� ���� �ּҰ�.
		System.out.println("�Լ� : " + data.i); // 100
		data.i = 1111;
	}
	
	static void vcall(int x) { // ������.
		System.out.println( "before : " + x ); //1111
		x = 8888; // d.i �� �����ϴ� ���� �ƴ϶� x�� ���� �����ϴ� ��.
		System.out.println( "after : " + x ); //8888
	}
}
