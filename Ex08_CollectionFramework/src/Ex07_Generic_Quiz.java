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
		//1. Array(배열) 을 사용해서 Cart 만들고 제품을 담으세요.
		Product[] cart = new Product[3]; // 다형성
		cart[0] = new E_Tv();
		cart[1] = new E_Audio();
		cart[2] = new E_NoteBook();
		
		//2. ArrayList 를 사용해서 Cart 만들고 제품을 담으세요.
		
		ArrayList<Product> arrayCart = new ArrayList<Product>();
		arrayCart.add(new E_Tv());
		arrayCart.add(new E_Audio());
		arrayCart.add(new  E_Audio());
		
		for ( Product p : arrayCart) {
			System.out.println(p.toString());
		}
		
		// 1.Emp 클래스를 사용해서 사원 3명을 만드세요. ArrayList 
		
		ArrayList<Emp> ecom = new ArrayList<Emp>();
		ecom.add(new Emp(111, "김땡땡", "IT"));
		ecom.add(new Emp(222, "박땡땡", "SL"));
		ecom.add(new Emp(333, "이땡땡", "IS"));
		
		//2.사원의 정보 (사번, 이름, 직종)을 개선된 for문을 사용해서 출력하세요
		//단 toString() 사용 금지
		System.out.println("2번 문제");
		for ( Emp e : ecom) {
			System.out.printf("사번 : %d, 이름: %s, 직종 : %s\n", e.getEmpno(), e.getEname(), e.getJob());
		}
		
		
		//3.사원의 정보 (사번, 이름, 직종)을 일반 for문을 사용해서 출력하세요
		//단 toString() 사용 금지
		System.out.println();
		System.out.println("3번 문제");
		for ( int i = 0 ; i < ecom.size(); i++) {
			System.out.printf("사번 : %d, 이름: %s, 직종 : %s\n", ecom.get(i).getEmpno(), ecom.get(i).getEname(), ecom.get(i).getJob());
		}
		
		
		
		//4.CopyEmp 라는 클래스를 만드세요(Emp 와 같은데)
		//ArrayList<> 제너릭 사용해서 사원 3명 만드세요
		//아래 데이터 사용
		//100,"김",1000
		//200,"이",2000
		//300,"박",3000
		System.out.println();
		System.out.println("4번 문제");	
		
		ArrayList<CopyEmp> c_emp = new ArrayList<CopyEmp>();
		c_emp.add(new CopyEmp(100,"김", 1000));
		c_emp.add(new CopyEmp(200,"이", 2000));
		c_emp.add(new CopyEmp(300,"박", 3000));
		
		for (CopyEmp e : c_emp){
			System.out.printf("사번 : %d, 이름: %s, 직종 : %s\n", e.getEmpno(), e.getEname(), e.getSal());
		}
		
		//5.200번 사원의 급여를 5000으로 수정해서 출력하세요(일반 for문 안에서 ....)
		System.out.println();
		System.out.println("5번 문제");
		
		for ( int i = 0 ; i < c_emp.size(); i++) {
			if ( c_emp.get(i).getEmpno() == 200) {
				c_emp.get(i).setSal(5000);
			}
			System.out.printf("사번 : %d, 이름: %s, 직종 : %s\n", c_emp.get(i).getEmpno(), c_emp.get(i).getEname(), c_emp.get(i).getSal());
		}
				
		//6.300번 사원의 이름을 "궁금해" 로 수정해서 출력하세요(개선된 for문 안에서 ....)
		System.out.println();
		System.out.println("6번 문제");
		
		for ( CopyEmp e : c_emp) {
			if( e.getEmpno() == 300) {
				e.setEname("궁금해");
			}
			System.out.printf("사번 : %d, 이름: %s, 직종 : %s\n", e.getEmpno(), e.getEname(), e.getSal());
		}
	}
}