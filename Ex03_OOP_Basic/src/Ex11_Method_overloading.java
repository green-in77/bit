/*
 ��ü������
 1. ���(���뼺)
 2. ĸ��ȭ(private) -> �Լ� (read, write)  : �����Ҵ� (�ڿ���ȣ) -> ĸ��ȭ�� member field �� read(get) , write(set) �����Լ�
 								-> getter, setter -> ��� getEmpno, setEmpno (get, set �� ���̰� �ձ��� �빮�ڷ�)  
 3. ������
 
 [�������� �� �κ�]
 
 [ method overloading ]
 �ϳ��� �̸����� �������� ����� �ϴ� �Լ�.
 ��� : System.out.println()
 Ư¡ : �����ε��� ���� ��� ������ ���ش�.
 			why > ���ϰ� ����Ϸ���....... >> �����ڰ�..
 		    ���(���赵 ����� �����ϸ�) >> �Լ��� Ȱ���� ���� ���(�پ��� parameter �� ���)
 		    Ȱ���� ���� -> static method �� ���� �����غ���.
 
 ���� : �Լ��� �̸��� ���� parameter �� ������ Ÿ���� �޸��ϴ� ���.
 1. �Լ��� �̸��� ���ƾ� �Ѵ�.
 2. [parameter] ���� �Ǵ� [Type] �޶�� �Ѵ�.
 3. return type overloading �� �Ǵܱ����� �ƴϴ�(�������)
 4. parameter  �� ������ �ٸ���.
  
  */
class Human { // ���赵 = Ÿ��
	String name;
	int age;
}

class OverTest {
	
	void add(Human h) { //������ ������ Ÿ���� �ٸ� �����ε�����
			h.name = "ȫ�浿";	// h  = Human ��ü�� �ּҰ��� �޴´�.;
			h.age = 100;
			System.out.println(h);
	}
	
	int add(int i) { // int add(int s) ���� �Լ� -> �����ε� �ƴ�. 
		return 100+i;
	}
	
	String add(String s) { // Ÿ���� �ٸ��� ������ �����ε� ����
		return "hello"+s;
	}
	
	int add(int i , int j) { // parameter �� ������ �޶� �����ε� ����
		return i+j;
	}
	void add(int i, String s) { //type �� �޶� �����ε� ����
		System.out.println(i + " / " + s);
	}
		
	void add(String s, int i) { // parameter �� ������ �޶� �����ε� ����
		System.out.println(i + "/" + s);
	}
	
	// �迭�� �ִ� Ex05_Array_Object ��ġ�� ����...
	//Array.. �迭�� ��ü��. >> �迭�� �����ִ� ���� �ּҰ�.
	
	int[] add(int[] param) { //param ������ �޴� ���� �ּҰ�.. ( int �迭�� �����ϴ� �ּҰ�)
		int[] target = new int[param.length];
		for (int i = 0 ; i < param.length ; i++) {
			target[i] = param[i]+1;
		}
		return target; // �迭�� �⺻���� null
	}
	
	int[] add(int[] so, int[] so2) {
		//�����ڵ�...
		for ( int i = 0 ; i < so.length ; i++  ) {
			so[i] = so2[i];
			so2[i] = so[i]+1; 
			System.out.println(so[i]+" / " + so2[i]);
		}
		return null;
	}
	
	
	
}

public class Ex11_Method_overloading {

	public static void main(String[] args) {
		OverTest ot = new OverTest();
		int result = ot.add(100);
		System.out.println(result);
		
		String str = ot.add("ȫ�浿");
		System.out.println(str);
		
		// 1
		Human m = new Human(); // m =  Human ��ü�� �ּҰ� 
		System.out.println(m); // Human@15db9742
		ot.add(m); //Human@15db9742
		
		//2
		ot.add(new Human()); // heap �� ������ ��ü�� �ּҸ� �ٷ� ����.	
	
		//Array parameter �� �Ǵ� return Type ���
		//////////////////////////////////////////////////////////////////
		int[] source = {10,20,30,40,50};
		int[] target = ot.add(source);
		
		System.out.println(source == target);
		// ������ for�� : �迭 or Collection (���߰�) 
		for (int value : target) {
			System.out.println(value);
		}
		/*
		 for (int i = 0; i < target.length ; i++) {
		 	System.out.println(target[i]);
		 } 
		 */
		//////////////////////////////////////////////////////////////////////
		
		int[] so = {10 , 20 , 30};
		int[] ta = {11 , 21 , 31};
		int[] ta2 = ot.add(so, ta);
	}

}
