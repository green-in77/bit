package kr.or.bit;

public class Ex02_variable {
/*
 * Tip) c# public static void Main() ....
 * static variable: 공유변수 - 객체간 공유자원
 * instance variable: 객체변수
 * local variable: 지역변수 - 메소드가 호출됐을때 생성됐다가 메소드가 끝남과 동시에 소멸
 * local variable은 초기값을 주지 않으면 사용할수없지만 instance variable은 초기값을 주지 않아도
 	0으로 초기화된다. 이유는?
 	객체가 만들어질때마다 어차피 값이 들어가야하기때문에 굳이 초기값을 하나로 정해둘 필요가 없다.
 * 실행되는 함수는 모두 stack으로 올라온다.
 */
	public static void main(String[] args) { // 프로그램의 시작점
		int lv= 500;
		System.out.println("lv 변수값: " + lv);
		//실행(javac 컴파일 > java Ex02_variable을 실행시켜 메모리에 올림 
		int number=0; //초기화 없이 선언 에러X
		System.out.println(number); //초기화 안하고 사용할때 에러
		//지역변수는 반드시 초기화
		Test t=new Test(); //stack에 t라는 변수가 생기고 heap에 Test객체가 생기고 그안에 iv라는 변수가 생김
		System.out.println(t.iv);
	}

}

class Test {//class는 설계도이다 == class는 Type이다.(작은 여러개의 Type을 가지고있는 큰 Type이다)
	int iv=500;
}
