import java.lang.reflect.Array;
import java.util.ArrayList;

import kr.or.bit.Emp;

public class Ex03_ArrayList_Object_KeyPoiny {
	public static void main(String[] args) {
		//Array
		//사원1명을 만드세요.
		
		Emp emp = new Emp(100, "김유신", "군인");
		System.out.println(emp.toString());
		
		Emp[] emplist = {new Emp(111, "아무개", "학생"), new Emp(222, "김땡땡", "IT")};
		
		for (Emp e : emplist) {
			System.out.println(e.toString());
		}
		// Collection
		
		ArrayList elist = new ArrayList();
		
		elist.add(new Emp(1,"김", "IT"));
		elist.add(new Emp(2,"박", "SALES"));
		System.out.println(elist); // toString 생략 // xx.toString(), yy번지.toString()
		
		// for 문을 사용해서 사원데이터를 출력.  toString 사용금지.
		
		//들어간 data 가 어떤 타입인지 알아야 하고 다운캐스팅을 해야하기때문제 짜증남...... -> 그래서  제너릭
		
		for ( int i = 0 ; i < elist.size() ; i ++ ) {
			//Object obj = elist.get(i);
			Emp e = (Emp)elist.get(i); // elist.get 은 Object 타입 -> 부모는 부모의 것만 볼 수 있음. getter, setter 는 emp에 있기 때문에 downcasting.
			
			System.out.printf("사원번호 : %d, 사원명 : %s, 직종 : %s\n",e.getEmpno(), e.getEname(), e.getJob());
		}
		
		// 개선된 for
		for ( Object obj : elist) {
			Emp e1 = (Emp)obj;
			System.out.printf("개선된for\n사원번호 : %d, 사원명 : %s, 직종 : %s\n",e1.getEmpno(), e1.getEname(), e1.getJob());
		}
		//---------------------------------------
		//Object 불편해.... 제너릭
		ArrayList<Emp> elist2 = new ArrayList<Emp>(); // Emp 만 받을 수 있게 타입을 제한함 = 제너릭
		elist2.add(new Emp(1212, "이", "IT"));
		elist2.add(new Emp(2424, "권", "SA"));
		
		for ( Emp e : elist2) { // 제너릭해서 Emp 로 타입을 제한했기 때문에 다운캐스팅이 필요 없음.
			System.out.printf("사원번호 : %d, 사원명 : %s, 직종 : %s\n",e.getEmpno(), e.getEname(), e.getJob());
		}
		
		
	}

}
