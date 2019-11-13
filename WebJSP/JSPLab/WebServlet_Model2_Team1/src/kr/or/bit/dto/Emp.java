package kr.or.bit.dto;

import java.util.Date;
/*
	CREATE TABLE EMP
		(EMPNO number not null,
		ENAME VARCHAR2(10),
		JOB VARCHAR2(9),
		MGR number ,
		HIREDATE date,
		SAL number ,
		COMM number ,
		DEPTNO number );
	--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
*/
//사원 1명을 담을 객체
public class Emp {
	private int empno; //사번
	private String ename; //이름
	private String job; //직종
	private int mgr; //사수
	private String hiredate; //입사일
	private int sal; //급여
	private int comm; //수당
	private int deptno; //부서번호
	
	public Emp() {}

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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}
	
	public void setHiredate(String hiredate) {
		this.hiredate =  hiredate;
	}
	
	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
}
