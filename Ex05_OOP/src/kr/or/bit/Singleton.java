package kr.or.bit;
// ������ ���� ( �������� ) >> ��ü�� ����� ��.
// singleton >> ��ü �ϳ��� ���� ����..

//���� : static 


public class Singleton {
	private static Singleton p;
	
	private Singleton() { // ��ü ������ ���ϰ� new �� ���ϰ�...	
	}
	
	public static Singleton getInstance() {
		if( p  == null) {
			p = new Singleton(); // ������ ȣ�� ��ü ����..( class ���ο��� public, private ������ ����)
		}	
		return p; // singleton ��ü�� �ּҸ� ��ȯ.
	}

	
}
