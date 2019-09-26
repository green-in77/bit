import java.util.ArrayList;

import kr.or.bit.CopyEmp;
import kr.or.bit.Emp;



class Product {
	int price;
	int point;
	
	Product (int price) {
		this.price = price;
		this.point = (int)(this.price*0.1);
	}
}

class E_Tv extends Product {
	E_Tv() {
		super(5000);
		//this.price = 5000;
		//this.point = (int)(this.price *0.1);
	}
	/*
	E_Tv(int price){
		super(price)
	}*/

	@Override
	public String toString() {
		return "Tv";
	}	
}

class E_Audio extends Product {
	E_Audio() {
		super(3000);
	}

	@Override
	public String toString() {
		return "Audio";
	}
}
class E_NoteBook extends Product {
	E_NoteBook() {
		super(10000);
	}

	@Override
	public String toString() {
		return "NoteBook";
	}
}
public class Ex07_Generic_Quiz {
	public static void main(String[] args) {
		//1. Array(�迭) �� ����ؼ� Cart ����� ��ǰ�� ��������.
		Product[] cart = new Product[3]; // ������
		cart[0] = new E_Tv();
		cart[1] = new E_Audio();
		cart[2] = new E_NoteBook();
		
		//2. ArrayList �� ����ؼ� Cart ����� ��ǰ�� ��������.
		
		ArrayList<Product> arrayCart = new ArrayList<Product>();
		arrayCart.add(new E_Tv());
		arrayCart.add(new E_Audio());
		arrayCart.add(new  E_Audio());
		
		for ( Product p : arrayCart) {
			System.out.println(p.toString());
		}
		
		// 1.Emp Ŭ������ ����ؼ� ��� 3���� ���弼��. ArrayList 
		
		ArrayList<Emp> ecom = new ArrayList<Emp>();
		ecom.add(new Emp(111, "�趯��", "IT"));
		ecom.add(new Emp(222, "�ڶ���", "SL"));
		ecom.add(new Emp(333, "�̶���", "IS"));
		
		//2.����� ���� (���, �̸�, ����)�� ������ for���� ����ؼ� ����ϼ���
		//�� toString() ��� ����
		System.out.println("2�� ����");
		for ( Emp e : ecom) {
			System.out.printf("��� : %d, �̸�: %s, ���� : %s\n", e.getEmpno(), e.getEname(), e.getJob());
		}
		
		
		//3.����� ���� (���, �̸�, ����)�� �Ϲ� for���� ����ؼ� ����ϼ���
		//�� toString() ��� ����
		System.out.println();
		System.out.println("3�� ����");
		for ( int i = 0 ; i < ecom.size(); i++) {
			System.out.printf("��� : %d, �̸�: %s, ���� : %s\n", ecom.get(i).getEmpno(), ecom.get(i).getEname(), ecom.get(i).getJob());
		}
		
		
		
		//4.CopyEmp ��� Ŭ������ ���弼��(Emp �� ������)
		//ArrayList<> ���ʸ� ����ؼ� ��� 3�� ���弼��
		//�Ʒ� ������ ���
		//100,"��",1000
		//200,"��",2000
		//300,"��",3000
		System.out.println();
		System.out.println("4�� ����");	
		
		ArrayList<CopyEmp> c_emp = new ArrayList<CopyEmp>();
		c_emp.add(new CopyEmp(100,"��", 1000));
		c_emp.add(new CopyEmp(200,"��", 2000));
		c_emp.add(new CopyEmp(300,"��", 3000));
		
		for (CopyEmp e : c_emp){
			System.out.printf("��� : %d, �̸�: %s, ���� : %s\n", e.getEmpno(), e.getEname(), e.getSal());
		}
		
		//5.200�� ����� �޿��� 5000���� �����ؼ� ����ϼ���(�Ϲ� for�� �ȿ��� ....)
		System.out.println();
		System.out.println("5�� ����");
		
		for ( int i = 0 ; i < c_emp.size(); i++) {
			if ( c_emp.get(i).getEmpno() == 200) {
				c_emp.get(i).setSal(5000);
			}
			System.out.printf("��� : %d, �̸�: %s, ���� : %s\n", c_emp.get(i).getEmpno(), c_emp.get(i).getEname(), c_emp.get(i).getSal());
		}
				
		//6.300�� ����� �̸��� "�ñ���" �� �����ؼ� ����ϼ���(������ for�� �ȿ��� ....)
		System.out.println();
		System.out.println("6�� ����");
		
		for ( CopyEmp e : c_emp) {
			if( e.getEmpno() == 300) {
				e.setEname("�ñ���");
			}
			System.out.printf("��� : %d, �̸�: %s, ���� : %s\n", e.getEmpno(), e.getEname(), e.getSal());
		}
	}
}