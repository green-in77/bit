/*
 Ŭ���� == ���赵 == Ÿ��
 
 Ŭ������ ������� : �ʵ� + ������ + �Լ�
* �ʵ� >> ��������(����ȸ��, �𵨸�, ��, �ְ�ӵ� ��), ��������(����ӵ�, ����ȸ���� ��), ��������
* ������ >> �ʵ��� �ʱ�ȭ�� �������� �ϴ� �Լ�
* �Լ� >> ��� (�޼ҵ�) 
 
 Ŭ����, �ʵ�, ������, �Լ� : ���� �����ϱ� ���ؼ� (������, ������, ������)
 
>> public, private, default, protected(��ӿ���)


1. public class Test{} // ��𼭳� �� ����� �� ����.

2. class Test{} >> �����Ϸ��� ���������� default �����ڸ� ����. >> default class Test {}  // ���� default �� ���� �ʴ´�.
	>> default : ���� ���� �ȿ����� ���� ����, �ٸ� ������ ������ ���� ���� �Ұ�.
	>> ���� ���? �ǹ����� ���� ���� ����... ���� ��Ű��(����)������ ������������..
	
3. �ϳ��� �������� �ڹ������� �������� Ŭ������ ���� �� �ִ�. O
	��, public �� �ϳ��� class �� ���´�. ( �ַ� main... �������� default ) 
 
 
 ex) �ǽ�
 1. kr.or.bit.common ��Ű��(����) �ȿ� 
 	CommonClass >> public class >> 
 	Ex01_main �� CommonClass �� �ٸ� ��Ű��(����) �ȿ� �ִ�.
 	Ex01_main Ŭ�������� >> CommonClass �ڿ� ���� ����. >> public class ��.
 	
 	
 2. kr.or.bit.common ��Ű��(����) �ȿ�
	DcommonClass >> default class
	Ex01_main Ŭ�������� >> DcommonClass �ڿ� ���� �Ұ��� >> default class �� 
 
*/

class Test { // default ������ ( ���� ��Ű�� �ȿ����� ��밡��)
	int d_iv; // �����Ϸ��� �˾Ƽ� default ����. // default int d_iv;  
	public int p_iv; // ������ ���� ������ ��𼭳� �� ��밡��.
	private int pri_iv; // ��������... ĸ��ȭ����.... (getter, setter �� ���ؼ� ���)
}

public class Ex01_main {

	public static void main(String[] args) {
		kr.or.bit.common.CommonClass cc = new kr.or.bit.common.CommonClass();
		
		cc.p_iv = 100; // public ���� ����� �����̱� ������ -> public int p_iv;
		
		Test tt = new Test();
		tt.d_iv = 200; // default ���� ��Ű��(����)�� ���ٰ��� 
		tt.p_iv = 300; // public ��Ű��(����) ������� ���� ����
		//tt.pri_iv //private ���� �Ұ�.

		
	}

}
