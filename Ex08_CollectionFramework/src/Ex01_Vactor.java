import java.util.Vector;

/*
CollectionFramework ( ���� �����͸� �ٷ�� ���̺귯���� ���� )
[�ټ��� ������]�� �ٷ�� [ǥ��ȭ�� �������̽�]�� �����ϰ� �ִ� Ŭ������ ����

 Collection �������̽� <- List(���) (�������̽� ���� ��Ӱ��� - �� ū ���) < ---- ���� ArrayList(��) .....
 											�������ÿ� -> �������ְ�, �ߺ�����
 									   <- Set(���) (�������̽� ���� ��Ӱ��� - �� ū ���) <---- ���� HashSet, TreeSet ......
 									   		�����ε�!-> ������ ����, �ߺ��Ұ�

Map �������̽� (Key, Value) <---- ���� HashMap(��)
-----------------------------------------------------------------------------------------
List interface = �������ÿ� >> Vector , ArrayList
 : ����(��ȣ)�� �ְ�, �ߺ����� >> ���������� ������(�ڷ�,��ü) �迭�� ����. >> Array[0][1]...
 
 1. Vector (������) - ����� �� ������� ����. -> ����ȭ(��Ƽ������) -> lock (��ȣ) -> ������ ������ �� ���� : �Ѱ�ȭ���
 2. ArrayList (�Ź���) -> ����ȭ(��Ƽ������) -> lock(x) -> �ʿ信 ���� lock ���� -> ���ɰ�� : �����
 
 Array (�迭)
 ���� ������ ����(�ѹ� ���� ũ�⸦ ���ϸ� ���� �Ұ�)
 int [] arr = new int[10]
 int [] arr = {10,20,30}
 
 Array (����)
 1. �迭�� ũ�Ⱑ ���� : Car[] cars = {new Car(), new Car()} : �� 2��
 2. ���ٹ�� : index(÷��) ���� >> cars[0]... cars[0].color = "red";
 3. �ʱ� ������ ũ��� ���� �Ұ�
 
 List �������̽��� ������ Ŭ����
 1. �迭�� ũ�⸦ �������� Ȯ��, ��Ұ� ���� >> �迭�� ���Ҵ�!! ( ���� ���� �̻��Ŵ)
 2. ������ ���� (Array) , ���� (index), �ߺ��� ���
 3. ������ ������� (Array)
 4. List �������̽� �����ϴ� Ŭ������ (new ���ؼ� ��ü ���� ���)
 5. ������ Ŭ������ ������ ���� ������ Ÿ�� : int[] list = new int[10], Emp[] elist = {}
 	 default Type : Object Type >> �ֻ��� Ÿ�� >> ���� : [��� Ÿ��]�� �����ͷ� ��밡��
 	>> Object[] obj = new Object[10]; >> obj[0] = 10, obj[1] = new car() ���..
 	>> ���� : Ÿ��üũ...casting >> �ذ� (Object Ÿ�� �����غ�) - ���ʸ�(generic) Ÿ��
 	>> ���ʸ�(generic) : Ÿ���� �����ؼ� �ϳ��� Ÿ�Ը� �ְ��ϴ� ���

 */
public class Ex01_Vactor {
	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("�ʱ� default �뷮 : "+v.capacity()); // �ʱ� �� 10�� �⺻����
		v.add("AA");
		v.add("BB");
		v.add("AA");
		v.add(100);
		
		System.out.println(v);// toString()���� >> Object >> ������(overrice) toString()
		
		//size -> ���� �ִ� ���� ����.
		for ( int i = 0; i < v.size(); i++) { // �����迭�� length , Vector�� size �� �迭 ����Ȯ��( ���� ����ִ� ���� ���̸�ŭ�� )
			System.out.println(v.get(i)); // get �Լ� -> i �迭�� ���� ���� : return Type = Object
		}
		
		//������ for
		for (Object obj : v)  {
			System.out.println(obj);
		}
		
		//���ʸ� >> Ÿ���� �����ϴ� ��.
		Vector<String> v2 = new Vector<String>(); // <����Ÿ��>
		v2.add("Hello");
		v2.add("World");
		v2.add("King");
		//v2.add(1); String Ÿ���� �ƴϱ� ������ ����
		
		for ( String str : v2) {
			System.out.println(str);
		}
		System.out.println(v2);
		System.out.println(v2.get(2));
		System.out.println("size(�� ������ ����) : " + v2.size());
		System.out.println("capacity(�迭���� ũ��) : " + v2.capacity()); //�⺻ 10��
		
		Vector v3 = new Vector();
		System.out.println(v3.capacity());
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		System.out.println("10�� : " + v3.capacity()); // 10
		
		v3.add("A");
		System.out.println("11�� : " + v3.capacity()); //20
		System.out.println("size : " + v3.size()); //11

	}
}
