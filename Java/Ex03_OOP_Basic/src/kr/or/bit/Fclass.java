package kr.or.bit;
/*
 �Լ�(method) : ���, ���� �� �ּҴ��� �ڡڡڡڡڡڡڡ� �Լ��� �ϳ��� ��ɸ� �����Ѵ� �ڡڡڡڡڡڡڡڡ�
 ex) �Դ�, �ȴ´�, �ܴ� ��...
 
 Ŭ������ ������� : �ʵ�, ������, �Լ�
 
 ex) �����ִ� ���ӱ� = 1�� , �����ִ� ĸ���̱� = 3��
 
 �Լ��� ���� ( 4���� )
 1. void , parameter(O) : void print(String str) { �����ڵ� }
 2. void , parameter(X) : void print() { �����ڵ� }
 3. return Type , parameter(O) : int print(int data) {�����ڵ� + return 100; }
 4. return Type , parameter(X) : int print() { �����ڵ� + return 200; } 
 
 * void : ���ϰ��� ����. ( return value �� ����.)
 * return Type : { [8���� �⺻ Ÿ��] + String + ����(��ü�� �ּ�) } + Array + Collection + Interface
 ** return Type ������ �ݵ��!!!!!!!!!! { ���ȿ� return Ű���尡 �����ؾ��Ѵ�. } //������ ������ �Ұ�.
 * parameter (����, �μ�) : �������� (100��¥��, 1000��¥�� ����), ���������� ������


�Լ��� �ݵ�� ȣ��(Call) �Ǿ�߸� ����ȴ�. : ������ ���� �̸��� �ҷ��־�����.....
 */
public class Fclass {
	public int data;
	
	//void m() //default �ٸ� ��Ű������ ���Ұ�.
	public void m() { 
		System.out.println("�Ϲ��Լ� : void , parameter(x)");
	}
	
	public void m2(int i) {
		System.out.println("parameter value : " + i );
		System.out.println("�Ϲ��Լ� : void ,  parameger(o)");
	}
	
	public int m3() {
		return 100;
	}
	
	public int m4(int data) {
		return data + 1;
	}
	
	//Ȯ�� (parameter ������ ��ȭ)
	public int sum(int i , int j , int k ) {
		return i + j + k;
	}
	
	//private ( ������, ������ ) ĸ��ȭ
	// 1. Ŭ���� ���ο����� �ǹ̰� ����.
	// 2. ��ü ���忡���� private ������ �ʴ´�.(�ܺο����� ������ ���� / ĸ��ȭ)
	
	//main ��ü fc������ �Ⱥ���(����� �� ����) �� �������?
	//private �����ڸ� ���� �Լ��� ������ : Ŭ���� ���ο��� [�ٸ� �Լ�]�� [������ ����]���� ����� ���.
	//�����Լ� : �������� �Լ��� ����ϴ� [���볻���� ������ �Լ�] (ex. ��� ���� �Լ�)
	private int operationMethod (int data) {
		return data * 200;
	}
	
	public int sum2(int data) {
		int result = operationMethod(data); // �ٸ� �Լ� ȣ���ϱ�. (�־��� ���� ���̵� �� �� ������.. �׷��� ���� ����� �� ����.)
		if(result > 0 ) {
			return 1;
		}else {
			return -1;
		}
	}
	
	//Quiz // ��� �ȿ� return �ݺ��� ����� ���� �ʴ�.
	// a�� b �� �߿� ū ���� �����ϴ� �Լ� �����.
	// Max(500,300) -> 500 ����
	
	public int Max(int a, int b) { // parameter a, b �ΰ��� �޴� �Լ�.
		return (a < b) ? b : a ; // a�� b �� ���ؼ� ū ���� ����. // ���� ������. // �ڵ�� �ǵ��� ª�Ը����.
		
		// if ��� �� �� ������ 2�� ���� ���� ���� �����ؼ� ���� �����ؼ� �������� ���� �ѹ��� �ϱ�.
		/*int result2 = 0;
		if ( a > b ) {
			result2 = a;
		}else {
			result2 = b;
		}
		return result2;
		*/
	}
	
	public String concat (String s, String s2, String s3) {
		String result = s + "/" + s2 + "/" + s3;
		return result;
		// return s + "/" + s2 + "/" + s3;
	}
	
	//��������� �⺻��.....
	//�ڡڡڡڡڡڡڡڡڡڡڡ�Ŭ������ Ÿ���̴�.�ڡڡڡڡڡڡڡڡڡڡڡڡڡ�
	/*
	 public int call(){ int data = 100; return data; }
	 public Tv call() { Tv t = new Tv(); return t; }
	 public Tv call() { return new tv(); } //new Tv �� Heap �� �ø��� �ּҸ� return.
	 
	 [Today Point]
	 Ŭ������ memory�� �÷��� ����� �� �ִ�. ( Tv t = new Tv(); // Tv �Ѵ� ����� ����.(heap �޸𸮿� ����)
	 
	 public int call(Tv t) { } // t��� ������ TVŸ��(�ּ�)�� ���� �� �ִ�.
	 public Tv call() { } // Tv Ÿ���� �ּҰ��� �����Ѵ�.
	 
	 */	
	
	public Tv objMethod() {
		Tv t = new Tv(); // Tv Ÿ���� �ּҰ� return ������ ��� new ����.
		t.brand = "LG";
		return t; 
	}
	
	public Tv ojbMethod2() {
		return new Tv();
		//new �����ڴ� heap �޸𸮿� Tv ��ü�� ����� �ּҸ� �����ϴ� ������.
		//return ���� ������ = �ּҰ�.
	}
	
	public Tv objMathod3(Tv t) { // xx���� ������
		return t; // return �� xx ����
	}
	
}
