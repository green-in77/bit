import java.util.ArrayList;

//Today Point
//Generic 
// jdk1.5
// C#, Java �ʼ����....

//collection�� ����Ҷ�.
// 1. Object  Ÿ�� ���� > Ÿ�Գ��� >> Ż�� >> ���ʸ�
// 2. Ÿ�� ������ ( Ÿ�� ������ )
// 3. ����ȯ�� ���� �ʾƵ� ��.(casting) (Car)obj (x)

// Generic �� Ŭ���� ����� >> Ÿ���� �����ϰ� �ϴ� ���
// ����..
// ����� ��ü�� ���鶧 Ÿ���� ����... 
class MyGen<T> { // <E> ���� ������.
	T obj;
	
	void add (T obj) {
		this.obj = obj;
	}
	
	T get() {
		return this.obj;
	}
}
/*
class MyGen {
	Person obj;
	void add (Person obj) {
		this.obj = obj;
	}
	
	Person get() {
		return this.obj;
	}
}
*/

class Person { //extends Object
	int age = 100;
}

public class Ex06_Generic {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		//��������� ������� ( Array Ÿ�� => �⺻���� Object )
		
		list.add(10);
		list.add(new Person());
		list.add("ȫ�浿");
		
		for ( Object obj : list) {
			//System.out.println(obj);
			//person ��ü���� �Ǵ��ϰ� age ���� ����ϰ� ����.
			if(obj instanceof Person) {
				System.out.println(((Person) obj).age); // �θ�� �θ��� �͸� �� �� �־ Person ��ü�� �ٿ�ĳ�����ؼ� ������.
			} else {
				System.out.println(obj);
			}
		}
		
		ArrayList<Person> alist = new ArrayList<Person>();
		alist.add(new Person());
		alist.add(new Person());
		
		for ( Person p : alist) {
			System.out.println(p.age);
		}
		
		MyGen<String> my = new MyGen<String>();
		MyGen<Person> myperson = new MyGen<Person>();
		System.out.println(myperson.obj); //null
		myperson.add(new Person()); //��ü�־��ֱ�
		System.out.println(" "+myperson.obj);
		Person p = myperson.get(); // �ּҸ� �����ͼ� p�� ����.
		System.out.println(p.age);

	}

}
