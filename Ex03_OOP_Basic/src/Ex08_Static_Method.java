
public class Ex08_Static_Method {

	public void method() {
		System.out.println("�� �Ϲ��Լ���");
	}
	public static void smethod() {
		System.out.println("�� static �Լ���");
	}
	
	public static void main(String[] args) {
		System.out.println("�� static main �Լ���");
		
		Ex08_Static_Method.smethod();
		
		Ex08_Static_Method mth = new Ex08_Static_Method();
		mth.method();
		mth.smethod();
		

	}

}
