//*************static �Լ� : ���� ����Ѵٸ� ���ϰ� ����ϱ� ���� ���� / ��ü ���� ���� (new ����) 
class StaticClass {
	int iv ; //��ü����
	
	static int cv; //static ����
	
	void m () { //�Ϲ� �Լ�
		//1. iv ���� ó�� �� �� �ִ�.
		//2. cv ���� ó�� �� �� �ִ�. >> m �Լ��� ����Ǳ� ���� static ������ �޸𸮿� �����Ǿ� �ִ�. // Today Point (��������)
		//static �ڿ��� �Ϲ��ڿ����� ���� memory �� �ö󰣴�.
		
		StaticClass.cv = 1000; // cv = 1000;		
	}
	
	static void sm() { // static �Լ�
		//1. iv ���� ó�� �� �� ����. 
		//			�Ϲ��ڿ����� ���� �޸𸮿� �����Ǳ� ������ ��ü������ ����� �� ����. // ��������!!!
		// static �� static ���� ��ƶ�.( �׷��� error �� ����)
		// �Լ� ���忡�� ���� iv �� �޸𸮿� ����.

		//2. cv ���� ó�� �� �� �ִ�.
		StaticClass.cv = 2000;
		
	}
	
}

public class Ex07_Static_Method {

	public static void main(String[] args) {
		System.out.println(StaticClass.cv); // 0 - �Լ��� �ҷ������� �����.
		
		StaticClass.sm(); // new ���� �ʾƵ� static �� ����� �� �ִ�.
		System.out.println(StaticClass.cv); //2000
		
		StaticClass sc = new StaticClass();
		
		sc.m();
		System.out.println(sc.cv); // 1000
				
	}

}
