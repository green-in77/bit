/*
 ���� <-> ���
 ��� : �ѹ� ���� �ʱ�ȭ�Ǹ� ���� �Ұ�.
 ����ڿ� : ������(�ֹι�ȣ, �ý����� ������ȣ, �������� �� PI ��)
 ����� ������ [ �빮�� ] 
  
java : final int NUM = 10;
c#   : const int NUM = 10;   

final Ű����
Ŭ���� �տ� : final class Car { } >> final Math >> ���������. 
�Լ� �տ� : public final void print() {} >> ��Ӱ��迡�� ������ ������. �������̵� ����.
					public static final void print() {}
 */

class Vcard {
	final String KIND = "heart";
	final int NUM = 10;
	
	
	void method() {
		// �ڹ� API �ý��� ��� 
		System.out.println(Math.PI);
		
	}	
}

// ������� ���� �ٲ� �� ����.
//�����Ǵ� ��ü���� ���� �ٸ��� �����ϰ� �ʹٸ� �����ڸ� ����ؼ� �ʱ�ȭ �Ѵ�.
// �ʱ�ȭ ���� ( �ѹ� ����) : new �Ҷ�.

class Vcard2 {
	final String KIND;
	final int NUM;

	/*
	Vcard2() {
		this.KIND = "heart";
		this.NUM = 1;
	}
	*/
	
	Vcard2(String kind, int num) { // ��ü���� �ٸ� ������� �� �� ����.�ڡڡ�
		this.KIND = kind;
		this.NUM = num;
	}

	@Override
	public String toString() {
		return "Vcard2 [KIND=" + KIND + ", NUM=" + NUM + "]";
	}
	
}

public class Ex07_Final {

	public static void main(String[] args) {
		Vcard vcard = new Vcard();
		System.out.println(vcard.KIND);
		// vcard.KIND = "AAAA"; ������ �Ұ�
		
		vcard.method();
		
		Vcard2 vcard2 = new Vcard2("heart", 1); //��ü ������ ������� ����.
		System.out.println(vcard2.toString());
		Vcard2 vcard3 = new Vcard2("dia",2);
		System.out.println(vcard3.toString());

	}

}
