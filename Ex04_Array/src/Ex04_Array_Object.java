import java.util.Arrays;

class Person {
	String name;
	int age;
	
}

public class Ex04_Array_Object {

	public static void main(String[] args) {
		int[] intarr = new int[10];
		boolean[] boarr = new boolean[5]; //default false
		System.out.println(Arrays.toString(boarr));
		// �� Ÿ�� �迭
		// �� Ÿ�� �迭�� �� ���� [�⺻��]���� [�ʱ�ȭ]�ȴ�.
		
		// ���� Ÿ�� �迭
		// ���� Ÿ�� �⺻�� = null
		Person[] pobj = new Person[3]; // �游 ����ڴ�.
		// 3���� ����� ����� �ڵ��ϱ�.
		System.out.println("pobj : " + pobj);
		System.out.println("new Person[3] : " + pobj[0]); // null ����Ÿ���� �⺻���� null

		//******************Ŭ����(��ü) �迭�� ���� ����� �۾��� ���� ä��� �۾��� ����.
		// 2�� �۾�
		
		pobj[0] = new Person();
		pobj[0].name = "ȫ�浿";
		pobj[0].age = 100;
		System.out.println("0��° �ּҰ� �־�� : " + pobj[0]);
		System.out.println("after : " + pobj[0].name + ", " + pobj[0].age);
		
		pobj[1] = new Person();		
		pobj[2] = new Person();
		
		System.out.println(Arrays.toString(pobj));
		
		//for �� ���
		for (int i = 0 ; i < pobj.length ; i++) {
			System.out.println(pobj[i].name +" / " +  pobj[i].age);
		}
		
		//��ü �迭  Today Point
		// 1. int[] arr = new int[5];
		Person[] parray = new Person[5];
		for (int i = 0 ; i < parray.length ; i++) {
			parray[i] = new Person(); //������ memory �� ������.
			System.out.println("�ּҰ� : " + parray[i]);
		}
		
		//2, int[] arr2 = new int[] {10,20,30}
		Person[] parray2 = new Person[] { new Person(), new Person(), new Person()};
		
		//3. int[] arr3 = {10,20,30} // �����Ϸ��� �˾Ƽ� new ����
		Person[] parray3 = { new Person(), new Person(), new Person() };
		
	
				
	}

}
