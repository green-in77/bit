//�ڹٿ��� ������ ��Ӱ���....

class Pbase {
	int p = 100;
}

class Cbase extends Pbase {
	int c = 200;
}

class Dbase extends Pbase {
	
}

public class Ex11_Inherit_Poly {

	public static void main(String[] args) {
		Cbase c = new Cbase();
		System.out.println(c.toString());
		
		// ������ : �θ�Ÿ���� ���������� �ڽ�Ÿ���� �ּҰ��� ���� �� �ִ� (��Ӱ���)
		// �� ������ ��� ��ü�� ���� �ϴ� ���� �ƴ϶� �ڽ� Ÿ���� ��ü���� ���� ����.
		
		Pbase p = c; // ������
		System.out.println("p �θ�Ÿ���� ���� : " + p);
		System.out.println("c ���� : " + c);
		
		System.out.println(c.c + " / " + c.p);
		System.out.println("�ڽ��� ��(�θ�) ���� : " + p.p);
		
		Dbase d = new Dbase();
		p = d; // p�� d�� �θ��̱� ������ ����.
		// �ϳ��� �������� p�� c�� �ּҰ���, d�� �ּҰ��� ���� �� �ִ�. 
		
		Dbase dd = (Dbase)p; // �θ��� �ּҸ� �ڽĿ��� �� �Ұ���. //�θ� [����Ÿ��] .... casting
		
		
		

	}

}
