import kr.or.bit.Emp;

class  Test2 {
	void print() {
		System.out.println("�θ��Լ�(Test2)");
	}
}

class Test3 extends Test2 {
	@Override
	void print() {
		System.out.println("�ڽ��Լ�(Test3)");
	}
	//�����ε� ( ��Ӱ� ���� ����� ����.)
	void print(String s) {
		System.out.println("�����ε�"+s);
	}
}

public class Ex05_Inherit_overraide {

	public static void main(String[] args) {
		Test3 t3 = new Test3();
		t3.print();
		t3.print("^^"); //�����ε�
		
		Emp emp = new Emp(7788,"ȫ�浿");
		System.out.println(emp.toString());
		System.out.println(emp); // emp.toString() ���� �ڵ��̴�.
		
		

	}

}
