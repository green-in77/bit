import java.lang.reflect.Array;
import java.util.ArrayList;

import kr.or.bit.Emp;

public class Ex03_ArrayList_Object_KeyPoiny {
	public static void main(String[] args) {
		//Array
		//���1���� ���弼��.
		
		Emp emp = new Emp(100, "������", "����");
		System.out.println(emp.toString());
		
		Emp[] emplist = {new Emp(111, "�ƹ���", "�л�"), new Emp(222, "�趯��", "IT")};
		
		for (Emp e : emplist) {
			System.out.println(e.toString());
		}
		// Collection
		
		ArrayList elist = new ArrayList();
		
		elist.add(new Emp(1,"��", "IT"));
		elist.add(new Emp(2,"��", "SALES"));
		System.out.println(elist); // toString ���� // xx.toString(), yy����.toString()
		
		// for ���� ����ؼ� ��������͸� ���.  toString ������.
		
		//�� data �� � Ÿ������ �˾ƾ� �ϰ� �ٿ�ĳ������ �ؾ��ϱ⶧���� ¥����...... -> �׷���  ���ʸ�
		
		for ( int i = 0 ; i < elist.size() ; i ++ ) {
			//Object obj = elist.get(i);
			Emp e = (Emp)elist.get(i); // elist.get �� Object Ÿ�� -> �θ�� �θ��� �͸� �� �� ����. getter, setter �� emp�� �ֱ� ������ downcasting.
			
			System.out.printf("�����ȣ : %d, ����� : %s, ���� : %s\n",e.getEmpno(), e.getEname(), e.getJob());
		}
		
		// ������ for
		for ( Object obj : elist) {
			Emp e1 = (Emp)obj;
			System.out.printf("������for\n�����ȣ : %d, ����� : %s, ���� : %s\n",e1.getEmpno(), e1.getEname(), e1.getJob());
		}
		//---------------------------------------
		//Object ������.... ���ʸ�
		ArrayList<Emp> elist2 = new ArrayList<Emp>(); // Emp �� ���� �� �ְ� Ÿ���� ������ = ���ʸ�
		elist2.add(new Emp(1212, "��", "IT"));
		elist2.add(new Emp(2424, "��", "SA"));
		
		for ( Emp e : elist2) { // ���ʸ��ؼ� Emp �� Ÿ���� �����߱� ������ �ٿ�ĳ������ �ʿ� ����.
			System.out.printf("�����ȣ : %d, ����� : %s, ���� : %s\n",e.getEmpno(), e.getEname(), e.getJob());
		}
		
		
	}

}
