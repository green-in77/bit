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

	// 鯵降切 toString() ... 仙舛税 疏焼敗....せせせせせせせせせ
	// Object 亜走壱 赤澗 toString() 爽社葵聖 窒径
	//爽社葵 窒径 左陥澗 member field 税 汽戚斗 葵 窒径 馬澗 依戚 疏走 省聖��せせせせせせせせせせ
	
	
	
}
