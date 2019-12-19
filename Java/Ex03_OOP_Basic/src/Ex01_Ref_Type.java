import kr.or.bit.BodyInformation;
import kr.or.bit.Emp;
import kr.or.bit.Person;
import kr.or.bit.Tv;

public class Ex01_Ref_Type {

	public static void main(String[] args) {
		
		Person person; //���� // Ŭ���� Ÿ���� �⺻ 4byte �Ҵ�. = ���� ���� = Null >> stack �̶�� �޸𸮿����� ������ ��������� Null �� �Ҵ�. //��������
		person = null; // �ʱ�ȭ
		System.out.println("person : "+person); // ���������� �ʱ�ȭ ���̴� ����� �� ����.
		
		person = new Person(); // Person ��ü�� �ּҰ� �Ҵ� / ����Ÿ��
											// person Ÿ���� �޸𸮸� ���´�.
		
		System.out.println("Ref person : " + person); //kr.or.bit.Person@15db9742
		
		person.name = "ȫ�浿";
		person.age = 10;
		
		person.print();
		
		// ����� �Ҵ��� ���ÿ�
		
		Person myperson = new Person(); // new = ��ü�� ����� ������. ( +, - ���� �������� ����)
		myperson.name = "�ƹ���";
		myperson.age = 100;
		
		myperson.print(); // myperson �� �Լ� print �� ȣ��.
		
		int num = 100; // local variable (�ݵ�� �ʱ�ȭ(= ó�� ���� �ִ� ����))
		
		Person you; // �������� / Person = Type  �ʱ�ȭ�� �Ǿ����� ����. ���Ұ�.
		//System.out.println(you); 
		//The local variable you may not have been initialized
		
		//1. you ��� ������ �ʱ�ȭ ( ����... ���������� null �Ҵ簡�� , �Ϲ������� �ּҰ��� ���� ������ �ʱ�ȭ��� �Ѵ�.)
		
		you = new Person(); // �ּҰ����� �ʱ�ȭ �ϴ� ���� �Ϲ����� ���.
		
		Person my;
		my=you; // �ʱ�ȭ �Ͽ����ϴ�. you �� �����ִ� �ּҰ�����. //my �� you �� ���Ÿ� ����....���� ���� �ּҸ� ������ �����ϱ�...
		
		System.out.println( my == you ); //true
		System.out.println(my + " : " + you );
		
		// ���α׷��� ����Ǹ� �Ҵ�� �޸𸮰� ���� ������. (�޸𸮰� �������� �ʰ� �Ϸ��� do~while �� �����Լ��� ��� ����ǰ� �־����.
		
		System.out.println();
		// Tv 2�� �����
		
		Tv tv1 = new Tv();
		tv1.brand = "�Ｚ";
		tv1.ch = 40;
		System.out.println("tv1�� �귣�� : " + tv1.brand);
		System.out.println("tv1�� ����ä�� : " + tv1.ch);
	
		/*
		String sign = "+";
		tv1.ch_change(sign);
		System.out.println("tv1�� ���� �� ä�� :"+ tv1.ch);
		*/
		
		tv1.ch_plus();
		System.out.println("tv1�� ����(ch_plus) �� ä�� :"+ tv1.ch);
		
		tv1.ch_minus();
		System.out.println("tv1�� ����(ch_minus) �� ä�� :"+ tv1.ch);
		
		
		System.out.println();
		
		Tv tv2 = new Tv();
		tv2.brand = "����";
		tv2.ch = 20;
		System.out.println("tv2�� �귣�� : "+tv2.brand);
		System.out.println("tv2�� ���� ä�� : " + tv2.ch);
		
		/*
		sign = "-";
		tv2.ch_change(sign);
		System.out.println("tv2�� ���� �� ä�� : " + tv2.ch);
		 */
		
		tv2.ch_minus();
		System.out.println("tv2�� ����(ch_minus) �� ä�� : " + tv2.ch);
		
		tv2.ch_plus();
		System.out.println("tv2�� ����(ch_plus) �� ä�� : " + tv2.ch);
		
		Emp emp = new Emp();
		BodyInformation bodyinfo = new BodyInformation();
		
		emp.empno = 7788;
		emp.ename = "������";
		emp.jobs = "IT";
		emp.sal = 5000;
		emp.bodyinfo = bodyinfo;
		emp.bodyinfo.height = 180;
		emp.bodyinfo.weight = 60;
		
		System.out.println("emp.bodyinfo = "+ emp.bodyinfo.height + " /  "+emp.bodyinfo.weight);
				
		bodyinfo.height = 170;
		bodyinfo.weight = 60;
		
		System.out.println("bodyinfo = "+ bodyinfo.height + " /  "+bodyinfo.weight);
		
	}
}
