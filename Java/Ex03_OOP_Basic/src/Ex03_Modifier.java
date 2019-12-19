import kr.or.bit.Car;

/*
������(������) : modifier
public ( ���� : package ���� ���� ��밡��
private (���� : Ŭ���� ���� ���� / ��ü ���忡���� ���ٺҰ�(���Ұ�)

��ü������ Ư¡
1. ĸ��ȭ(����ȭ)
1.1 Ŭ���� ���ο� �ִ� �ڿ�(member field, method) ����
		private int number; //instance variable(��ü ����)
		private void cal() {} // ����(Ŭ����)������ ����ϴ� �����ڿ�
 1.2 ĸ��ȭ�� �� ���� �ɱ�? private �� �� ����? 
 											******* ���� �Ҵ��� ���� �����Ҵ��� ���ؼ� �ڿ� ��ȣ
 		�����Ҵ�
 		public class car { public int door; } >> Car c = new Car(); c.door = 10; 
 		
 		�����Ҵ� : ������(==�Լ�) ���ؼ� �����ϰ� �޴� ����
 		public class car { private int door; //>> Car c = new Car(); c.door = 10;(x)
 									public void writeDoor(int data) {
 									if ( data >= 0 ) {door = data; } else { door = 0; }}} 
 									// Car c = new Car(); c.writeDoor(-1);
 		 
 		 
 		 ����
 		 1. private int number; // read, write
 		 	�Լ��� ����� �ǿ�.(read 1��, write 1��)
 		 	  >> public void writeNumber ( int data ) { number = data; } // ĸ��ȭ�� �ڿ� ����.
 		 	  >> public int readNumver() {return number; } // ĸ��ȭ�� �ڿ� �б�.
 
 			�׷��� java ������ Ư���� ������ �Լ��� �������.( ĸ��ȭ�� �ڿ��� ���ؼ� read , write �����Լ�
 			 = �����Լ� setter �Լ�(write), getter �Լ�(read)
 			
 			private int age;
 			- setter , getter ��� ���� ����
 			- setter  �� ����
 			- getter �� ����
 			
 			
 */
public class Ex03_Modifier {

	public static void main(String[] args) {
		Car car = new Car();
		//car.window , car.speed (X)
		//��������
		
		int result = car.getWindow();
		System.out.println("result : " + result );
		
		car.setWindow(10);
		result = car.getWindow();
		System.out.println("result : " + result);
		
		System.out.println("���� �ڵ��� �ӵ� : " + car.getSpeed());
		car.setSpeed(-100); // �����Ҵ�
		System.out.println("���� �ڵ��� �ӵ� : " + car.getSpeed());
		
		car.speedUp();
		car.speedUp();
		car.speedUp();
		car.speedUp();
		
		System.out.println("���� �ڵ��� �ӵ� : " + car.getSpeed()); // 40

		car.speedDown();
		System.out.println("���� �ڵ��� �ӵ� : " + car.getSpeed()); // 30
		car.speedDown();
		System.out.println("���� �ڵ��� �ӵ� : " + car.getSpeed()); // 20
		car.speedDown();
		System.out.println("���� �ڵ��� �ӵ� : " + car.getSpeed()); // 10
		car.speedDown();
		System.out.println("���� �ڵ��� �ӵ� : " + car.getSpeed()); // 0
		car.speedDown();
		System.out.println("���� �ڵ��� �ӵ� : " + car.getSpeed()); // 0
		car.speedDown();
		System.out.println("���� �ڵ��� �ӵ� : " + car.getSpeed()); // 0
		car.speedDown();
		System.out.println("���� �ڵ��� �ӵ� : " + car.getSpeed()); // 0
		
	}

}
