package kr.or.bit.dto;

public class Dept { //dept 저장할 객체
	private int deptno; //부서번호
	private String dname; //부서이름
	private String loc; //근무지
	
	public Dept() {}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
