
public class Ex08_Static_Method {

	public void method() {
		System.out.println("나 일반함수야");
	}
	public static void smethod() {
		System.out.println("나 static 함수야");
	}
	
	public static void main(String[] args) {
		System.out.println("나 static main 함수야");
		
		Ex08_Static_Method.smethod();
		
		Ex08_Static_Method mth = new Ex08_Static_Method();
		mth.method();
		mth.smethod();
		

	}

}
