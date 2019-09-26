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

	// ������ toString() ... ������ ������....������������������
	// Object ������ �ִ� toString() �ּҰ��� ���
	//�ּҰ� ��� ���ٴ� member field �� ������ �� ��� �ϴ� ���� ���� ��������������������������
	
	
	
}
