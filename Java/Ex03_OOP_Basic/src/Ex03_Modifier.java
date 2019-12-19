import kr.or.bit.Car;

/*
접근자(한정자) : modifier
public ( 공유 : package 구분 없이 사용가능
private (개인 : 클래스 내부 공유 / 객체 입장에서는 접근불가(사용불가)

객체지향언어 특징
1. 캡슐화(은닉화)
1.1 클래스 내부에 있는 자원(member field, method) 적용
		private int number; //instance variable(객체 변수)
		private void cal() {} // 내부(클래스)에서만 사용하는 공통자원
 1.2 캡슐화를 왜 쓰는 걸까? private 를 왜 쓸까? 
 											******* 직접 할당을 막고 간접할당을 통해서 자원 보호
 		직접할당
 		public class car { public int door; } >> Car c = new Car(); c.door = 10; 
 		
 		간접할당 : 누구를(==함수) 통해서 전달하고 받는 행위
 		public class car { private int door; //>> Car c = new Car(); c.door = 10;(x)
 									public void writeDoor(int data) {
 									if ( data >= 0 ) {door = data; } else { door = 0; }}} 
 									// Car c = new Car(); c.writeDoor(-1);
 		 
 		 
 		 불편
 		 1. private int number; // read, write
 		 	함수를 만들면 되요.(read 1개, write 1개)
 		 	  >> public void writeNumber ( int data ) { number = data; } // 캡슐화된 자원 쓰기.
 		 	  >> public int readNumver() {return number; } // 캡슐화된 자원 읽기.
 
 			그래서 java 에서는 특수한 목적의 함수를 만들었다.( 캡술화된 자원에 대해서 read , write 전용함수
 			 = 전용함수 setter 함수(write), getter 함수(read)
 			
 			private int age;
 			- setter , getter 모두 생성 가능
 			- setter  만 생성
 			- getter 만 생성
 			
 			
 */
public class Ex03_Modifier {

	public static void main(String[] args) {
		Car car = new Car();
		//car.window , car.speed (X)
		//간접제어
		
		int result = car.getWindow();
		System.out.println("result : " + result );
		
		car.setWindow(10);
		result = car.getWindow();
		System.out.println("result : " + result);
		
		System.out.println("현재 자동차 속도 : " + car.getSpeed());
		car.setSpeed(-100); // 간접할당
		System.out.println("현재 자동차 속도 : " + car.getSpeed());
		
		car.speedUp();
		car.speedUp();
		car.speedUp();
		car.speedUp();
		
		System.out.println("현재 자동차 속도 : " + car.getSpeed()); // 40

		car.speedDown();
		System.out.println("현재 자동차 속도 : " + car.getSpeed()); // 30
		car.speedDown();
		System.out.println("현재 자동차 속도 : " + car.getSpeed()); // 20
		car.speedDown();
		System.out.println("현재 자동차 속도 : " + car.getSpeed()); // 10
		car.speedDown();
		System.out.println("현재 자동차 속도 : " + car.getSpeed()); // 0
		car.speedDown();
		System.out.println("현재 자동차 속도 : " + car.getSpeed()); // 0
		car.speedDown();
		System.out.println("현재 자동차 속도 : " + car.getSpeed()); // 0
		car.speedDown();
		System.out.println("현재 자동차 속도 : " + car.getSpeed()); // 0
		
	}

}
