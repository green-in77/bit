import kr.or.bit.Emp;

public class Ex05_Array_Object {

	public static void main(String[] args) {
		// 사원 3명을 만드세요. (단 배열을 사용해서)
		
		Emp[] emplist = new Emp[3]; // 방만 만든것.
		
		emplist[0] = new Emp();
		emplist[0].setEmpno(1000);
		emplist[0].setEname("홍길동");
		
		emplist[1] = new Emp();
		emplist[1].setEmpno(2000);
		emplist[1].setEname("김유신");
		
		emplist[2] = new Emp();
		emplist[2].setEmpno(3000);
		emplist[2].setEname("유관순");

		//2. 사원 3명의 사번과 이름을 출력하세요.
		for (int i = 0; i < emplist.length ; i++ ) {
			emplist[i].empInfoPrint();
		}
		
		//int[] emplist2 = new int[] {10.20.30};
		//사원 2명을 만드세요.
		Emp[] emplist2 = new Emp[] {new Emp(1, "이씨"), new Emp(2, "박씨")};
		for (int i = 0; i < emplist2.length ; i++ ) {
			emplist2[i].empInfoPrint();
		}
		
		//int[] emplist3 = {10,20,30}
		Emp[] emplist3 = {new Emp(1,"김씨"), new Emp(2, "홍씨") };
		for (int i = 0; i < emplist3.length ; i++ ) {
			emplist3[i].empInfoPrint();
		}
		
		// OOP_method overloading
		
		
		
	}
}
