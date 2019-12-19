import kr.or.bit.Singleton;

public class Ex14_Singleton_main {

	public static void main(String[] args) {
		//Singleton single = new Singleton();
		//The constructor Singleton() is not visible -> 생성자 안보임 (private)
		
		// 공유프린터, 복사기 를 다수의 사용자가 사용하는데 정해진 프린터 1대만 사용가능.
		
		Singleton single1 = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		Singleton single3 = Singleton.getInstance();
		Singleton single4 = Singleton.getInstance();
		
		System.out.println(single1 == single2);
		System.out.println(single2 == single3);
		System.out.println(single3 == single4);

	}

}
