import java.util.ArrayList;

/*
 8���� �⺻ Ÿ�� ���� (�� Ÿ��)
 
 8���� �⺻ Ÿ�Կ� ���ؼ� ��ü ���·� ��밡�� �ϵ��� ���� ��(wrapper class)
 
 �⺻Ÿ�Ե� ���δ� ��ü���·� �ٷ������ �ϴ� ���
 1. �Ű������� ��ü�� �䱸�ɶ�
 2. �⺻�� ���� �ƴ� ��ü�� ����Ǿ���Ҷ�
 3. ��ü���� �񱳰� �ʿ��Ҷ�
 �̶� wrapper class �� �ʿ���.
*/
public class Ex10_Wrapper_Class {
	public static void main(String[] args) {
		// Integer.parseInt(s);
		// ArrayList<Integer> //���ʸ��� wrapper class ���
		int i = 100;
		
		//ArrayList<Boolean>
		//ArrayList<Character>
		
		Integer n = new Integer(500);
		System.out.println(n); // 500 ( �����δ� �ּҰ��� �־�� �ϳ� toString �������̵� �س��� : String Ŭ������ ����)
		
		// POINT
		// parameter �� �� Ÿ���� ��ü�� ���� ��
		// generic ����
		
		ArrayList<Integer> li = new ArrayList<Integer>();
		li.add(100);
		li.add(200);
		
		for ( int value : li) { // Integer ������ ������ ���� �����̱� ������ int ��� ����
			System.out.println(value);
		}
		
		Integer i2 = new Integer(100);
		Integer i3 = new Integer(100);
		
		System.out.println(i2 == i3); // false // == �ּҰ��� ���ϴ� �������̱� ������ ...
		System.out.println(i2.equals(i3)); // true
		// Object �� equals �� Integer Ŭ�������� ������ ( ���� ���� ���ϵ���...  100 == 100)
		
		Integer t = new Integer(500);
		integerMathod(t); // t��� ���������� �ּҰ��� ����
		intMethod(t); // t��� ���������� ������ �� ����
		
	}
	
	static void integerMathod(Integer i) {
		System.out.println("Integer param : " + i);
	}
	
	static void intMethod(int i) {
		System.out.println("int parma : " + i);
		i = 1000; // t ���� ������ ����. 
	}
	
}
