/*
instance varriable [ ��ü���� ]  : class �ȿ� ��������� ����
local variable [ �������� ] : �Լ��ȿ� ��������� ���� 
static variable : �����ڿ�, ��ü���� ������ memory �ö󰡴� �ڿ� 
*/

class Variable {
	int iv; //default
	/*
	 1. member field , instance variable
	 2. Variable v = new Variable(); // heap �޸𸮿� iv�� ����....
	 	 Variable v2 = new Variable() ; // heap �޸𸮿� iv ����..
	 3.  ���� : ������ �������� �Ѵ�. ( ������ �´� Type ������ ������ �Ѵ�. )
	 				    - ����(�Ӽ�) >> ����, ����, ��ǰ(����)
	 				    - ������ ��ü���� �ٸ� ���� ���� �� �ִ�.
	 				    - �׷��� ������ ���� �ʱ�ȭ ���� ����(defalut ���� ������ ����).
	 				    
	 				    int >> 0 , float >> 0.0, boolean >> False
	 				    String >> ����(Ŭ����) >> null
	  4. �������� : new ��� �����ڸ� ���ؼ� heap �� ��ü�� ��������� ���� �ٷ� ���� ����
	 				    
	 */
	static int cv;
	/*
	 1. class variable (Ŭ���� ����) , static variable (��������)
	 2. ���� : ������ ��� ��. (�����Ǵ� ��� ��ü�� �����ϴ� �ڿ� = [��ü�� �����ڿ�]) 
	 		heap �� ������ ��ü���� �����ڿ�(�����ڿ�)
	 3. Ư¡ : ���ٹ��1 >> Ŭ���� �̸�.static ������ >> Variavle.cv ( ��ü�� ��������� ���� ��Ȳ������ ���� ����)
	 				ex) Math.Random() >>  Math m = new ...���� �ʾ���.
	 				���ٹ��2 >> ��������.static ������  (v.cv / v2.cv)
	 4. �������� : javac ������ >> java Variable (����) >> 
	 						class loader ���ؼ�
	 						1. Ŭ���� ����(metadata)�� �о �� ������ class area (method area , static area)�� �ø�.
	 							static �ڿ��� ���� memory  �ø�.
	 							>> static �ڿ��� ��ü���� ������ memory �ö󰡴� �ڿ�.
	 										
	 */
	
	void method () {
		int lv = 0;
		
		/*
		 	local variable ( �Լ��ȿ� �ִ� �������� : �ݵ�� �ʱ�ȭ)
		 	scope : �Լ��� ���۵Ǹ� ���� ~ �Լ��� ������ �Ҹ�
		 	
		 	�Լ��ȿ� if �� , for �� �� �� ���������� ���´�.
		 	  
		 */
	}
}

public class Ex04_Variable_Scope {

	public static void main(String[] args) {
		Variable.cv = 100; // static variable �� ���α׷� ���� �� method area �� �޸� �Ҵ�.
		Variable v = new Variable();
		Variable v2 = new Variable();
		
		//����
		System.out.println("v.cv : " + v.cv); // 100
		System.out.println("v2.cv : " +  v2.cv);
		
		v2.cv = 5000;
		System.out.println("variable.cv : " + Variable.cv);
		
	}

}
