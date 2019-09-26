//클래스는 설계도이다 , 클래스는 타입이다
//클래스 == 설계도 == 타입
//클래스는 구체화(집을 짓는 행위) 해서 사용 
//프로그램 세계에서는 new 구체화 (memory) >> 인스턴스(객체)

//설계도를 작성
//클래스는 크게 2가지 (시작적(main) 가지는 클래스 , main 함수는 없는 클래스)

class Apt{
	int door=10;
	int window=100;
}

public class Ex04_Ref_Type { //main 함수가 있는 설계도
	public static void main(String[] args) {
		
		//Apt 설계도 구체화(아파트 ...)
		Apt lgapt = new Apt();
		//lgapt (참조변수 , 객체변수 : 주소를 가지고 있는 변수)
		System.out.println("주소값 : " + lgapt);
		
		//lgapt 녀석이 객체의 주소를 가지는 방법 (원칙적으로 new)
		
		Apt ssapt = lgapt; //할당도 방법중 하나다 ...
		ssapt.door = 1111;
		System.out.println("lgapt.door"+ lgapt.door);

	}

}
