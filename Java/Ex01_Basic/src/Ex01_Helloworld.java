import kr.or.bit.Emp;
public class Ex01_Helloworld{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		//kr.or.bit.Emp emp = new kr.or.bit.Emp();
	    //emp.data = 10000;
		//emp.setData(100000);
		//System.out.println(emp.getData());
		
		Emp emp = new Emp(); //사원 한명을 생성합니다
		emp.empNo = 7777;
		emp.eName = "홍길동";
		emp.eJob = "IT";
		
		String str = emp.getEmpInfo();
		System.out.println(str);
		
		Emp emp2 = new  Emp();
		emp2.empNo = 8888;
		emp2.eName = "아무개";
		emp2.eJob = "sales";
		
		String str2 = emp2.getEmpInfo();
		System.out.println(str2);
		
	}

}



