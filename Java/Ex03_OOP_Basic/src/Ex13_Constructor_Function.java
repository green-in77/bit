/*
 ������ �Լ�(constructor)
 1. �Լ� ( Ư���� ������ �Լ�)
 2. Ư���� ���� ( member field �ʱ�ȭ)
 
 Tip) static  >> static {} ,  �Ϲݺ��� >> {}
 
 3. �Ϲ��Լ��� �ٸ���
 3.1 �Լ��� �̸��� ���� ( class �̸��� ���� )
 3.2 ������� ������ : return type �� ����, void > default void ����
 3.3 ������� : ��ü ������ ȣ�� : �׷��� ���� ������ ������ ����.
 
 4. ���� : �����Ǵ� ��ü���� �ٸ� �ʱⰪ�� �ο��ϱ�.
 
 class Car { int door=5; }
 
 5. ������ �Լ��� overloading �� �����ϴ�.
 
 **************** �������� �ǵ� *****************
 * ���������� overloading �� ������ �Լ��� �ϳ��� �����Ѵٸ� �����Ϸ��� �ڵ����� default ������ �Լ��� ������ �ʴ´�.
 * ���� default ������ �Լ��� ����ϰ� �ʹٸ� ���� ����.
 * why? �������� ������ �ǵ��� ��� �ִ� ��.
  
 �Ϲ� �Լ����� �ڵ差�� ����.....
  */

class Car {
	String name;
	//Car() {} ������� ������ complile���� Car() {} �ִٰ� �����ϰ� �����մϴ�. //�����ڰ� ��� �ִٰ� �����ϰ� ����.
}

class Car2 {
	String carname;
	Car2 () { // default constructor (����Ʈ ������)
		System.out.println("�� ������ �Լ���");
		carname = "pony"; //member field �� �ʱ�ȭ
	}
}

class Car3 {
	int number;
	
	Car3() {
		System.out.println("member field �ʱ�ȭ");
		//number=10;	
	}		
}

////////////////////////////////////////////////////
class Car4 {
	int door;
	int wheel;
	
	Car4() { // default 
		System.out.println("default");
	}
	//�����ε�
	Car4(int num) { //overloading (�����ڵ� �����ε��� �����ϴ�. �Լ��̱� ������)
		door = num;
		System.out.println("overloading door" + door); 
	}
	//�����ε� parameter ������ �ٸ�
	Car4(int num, int num2){
		door = num;
		wheel = num2;
		System.out.println("overloading wheel / door : " + wheel + " / " + door);
	}
}

class House {
	String doorcolor;
	
	House(){ // default �� ����ϰ� �ʹٸ� ���������ض�.
		doorcolor = "YELLOW";
		
	}
	House(String color){
		doorcolor = color;
	}
	
}


public class Ex13_Constructor_Function {

	public static void main(String[] args) {
		//Car c = new Car(); // Car() �Լ��� ȣ��
		//Car2 c2 = new Car2(); // ������ �Լ��� ��ü ������ �Բ� ȣ��ȴ�.
		//Car2 c22 = new Car2();
		Car4 car4 = new Car4(10, 50);
		Car4 car5 = new Car4(5,66);
		
		House home = new House("RED");
		System.out.println(home.doorcolor);
		
		House home2 = new House("BLUE");
		System.out.println(home2.doorcolor);
		
		House home3 = new House();
		System.out.println(home3.doorcolor);
		
		
	}

}
