package kr.or.bit;

//Dto, VO, Domain 
public class Emp { //extends Object
	private int empno;
	private String ename;
	
	public Emp(int empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + "]";
	}

	// 개발자 toString() ... 재정의 좋아함....ㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	// Object 가지고 있는 toString() 주소값을 출력
	//주소값 출력 보다는 member field 의 데이터 값 출력 하는 것이 좋지 않을깤ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	
	
	
}
